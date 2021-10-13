package net.mcreator.zoology.procedures;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zoology.ZoologyMod;

import java.util.Map;

public class OpossumEntityIsHurtProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OpossumEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(ZoologyMod.Cadaver_STATUS_EFFECT, (int) 600, (int) 1));
	}
}
