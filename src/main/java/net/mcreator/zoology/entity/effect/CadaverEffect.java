
package net.mcreator.zoology.entity.effect;

import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zoology.procedures.CadaverEffectStartedappliedProcedure;
import net.mcreator.zoology.procedures.CadaverEffectExpiresProcedure;

import java.util.Map;
import java.util.HashMap;

public class CadaverEffect extends StatusEffect {
	public CadaverEffect() {
		super(StatusEffectType.NEUTRAL, -1460277);
	}

	@Override
	public boolean isInstant() {
		return true;
	}

	@Override
	public void applyInstantEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			CadaverEffectStartedappliedProcedure.executeProcedure($_dependencies);
		}
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributeMapIn, int amplifier) {
		super.onRemoved(entity, attributeMapIn, amplifier);
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			CadaverEffectExpiresProcedure.executeProcedure($_dependencies);
		}
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
