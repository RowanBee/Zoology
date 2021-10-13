/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and the proxy files
 *    and they won't get overwritten. If you change your mod package or modid, you
 *    need to apply these changes to this file MANUALLY.
 *
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.zoology;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.potion.Potion;
import net.minecraft.item.Item;
import net.minecraft.entity.effect.StatusEffect;

import net.mcreator.zoology.procedures.OpossumEntityIsHurtProcedure;
import net.mcreator.zoology.procedures.CadaverEffectStartedappliedProcedure;
import net.mcreator.zoology.procedures.CadaverEffectExpiresProcedure;
import net.mcreator.zoology.potion.CadaverPotionPotion;
import net.mcreator.zoology.item.OpossumTailItem;
import net.mcreator.zoology.entity.effect.CadaverEffect;
import net.mcreator.zoology.entity.OpossumEntity;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.api.ModInitializer;

public class ZoologyMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Item OpossumTail_ITEM = Registry.register(Registry.ITEM, id("opossum_tail"), new OpossumTailItem());
	public static final StatusEffect Cadaver_STATUS_EFFECT = Registry.register(Registry.STATUS_EFFECT, id("cadaver"), new CadaverEffect());
	public static final Potion CadaverPotion_POTION = Registry.register(Registry.POTION, id("cadaver_potion_potion"), new CadaverPotionPotion());
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing ZoologyMod");
		new CadaverEffectStartedappliedProcedure();
		new CadaverEffectExpiresProcedure();
		new OpossumEntityIsHurtProcedure();
		OpossumEntity.init();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
		});
	}

	public static final Identifier id(String s) {
		return new Identifier("zoology", s);
	}
}
