package net.mcreator.zoology.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

public class CadaverEffectExpiresProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CadaverEffectExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isClient()) {
				_ent.world.getServer().getCommandManager().execute(_ent.getCommandSource().withSilent().withLevel(4),
						"execute as @e[tag=cadaver] run data merge entity @s {Attributes:[{Name:generic.follow_range,Base:16}]}");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isClient()) {
				_ent.world.getServer().getCommandManager().execute(_ent.getCommandSource().withSilent().withLevel(4), "tag @e remove cadvaer");
			}
		}
	}
}
