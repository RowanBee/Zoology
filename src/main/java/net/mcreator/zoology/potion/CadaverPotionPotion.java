
package net.mcreator.zoology.potion;

import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffectInstance;

import net.mcreator.zoology.ZoologyMod;

public class CadaverPotionPotion extends Potion {
	public CadaverPotionPotion() {
		super(new StatusEffectInstance(ZoologyMod.Cadaver_STATUS_EFFECT, 600, 0, false, true));
	}
}
