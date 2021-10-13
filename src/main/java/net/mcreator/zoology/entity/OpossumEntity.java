
package net.mcreator.zoology.entity;

import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.Entity;

import net.mcreator.zoology.procedures.CadaverEffectStartedappliedProcedure;
import net.mcreator.zoology.ZoologyMod;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("deprecation")
public class OpossumEntity extends AnimalEntity {
	public static final EntityType<OpossumEntity> ENTITY = Registry.register(Registry.ENTITY_TYPE, ZoologyMod.id("opossum"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OpossumEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.3f))
					.trackRangeBlocks(64).forceTrackedVelocityUpdates(true).trackedUpdateRate(3).build());
	protected OpossumEntity(EntityType<? extends OpossumEntity> entityType, World world) {
		super(entityType, world);
		this.setAiDisabled(false);
		this.experiencePoints = 2;
	}

	public static void init() {
		FabricDefaultAttributeRegistry.register(ENTITY,
				OpossumEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 7).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
						.add(EntityAttributes.GENERIC_ARMOR, 0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0));
		Registry.register(Registry.ITEM, ZoologyMod.id("opossum_spawn_egg"),
				new SpawnEggItem(ENTITY, -10066330, -1460277, new FabricItemSettings().group(ItemGroup.MISC)));
		BiomeModifications.create(new Identifier("zoology", "opossum_entity_spawn")).add(ModificationPhase.ADDITIONS, BiomeSelectors.all(),
				ctx -> ctx.getSpawnSettings().addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ENTITY, 20, 4, 4)));
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new AnimalMateGoal(this, 1));
		this.goalSelector.add(2, new LookAroundGoal(this));
		this.goalSelector.add(3, new FleeEntityGoal(this, CatEntity.class, (float) 6, 1.2, 1));
		this.goalSelector.add(4, new FleeEntityGoal(this, WolfEntity.class, (float) 6, 1.2, 1));
		this.goalSelector.add(5, new FleeEntityGoal(this, FoxEntity.class, (float) 6, 1.2, 1));
		this.goalSelector.add(6, new FollowMobGoal(this, (float) 1, 5, 10));
		this.targetSelector.add(7, new FollowTargetGoal(this, ChickenEntity.class, false, true));
		this.targetSelector.add(8, new FollowTargetGoal(this, SilverfishEntity.class, false, true));
		this.targetSelector.add(9, new FollowTargetGoal(this, EndermiteEntity.class, false, true));
		this.targetSelector.add(10, new FollowTargetGoal(this, EndermiteEntity.class, false, true));
		this.goalSelector.add(11, new WanderAroundGoal(this, 1));
		this.goalSelector.add(12, new SwimGoal(this));
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return new SoundEvent(new Identifier("entity.generic.hurt"));
	}

	@Override
	protected SoundEvent getDeathSound() {
		return new SoundEvent(new Identifier("entity.generic.death"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Entity sourceentity = source.getAttacker();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			CadaverEffectStartedappliedProcedure.executeProcedure($_dependencies);
		}
		if (source == DamageSource.FALL)
			return false;
		return super.damage(source, amount);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		if (stack == null)
			return false;
		if (Items.EGG == stack.getItem())
			return true;
		return false;
	}

	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ENTITY.create(world);
	}
}
