package org.szucraft.zombie_player.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class InfectionEffect extends StatusEffect {

    public InfectionEffect() {
        super(StatusEffectCategory.HARMFUL, 0xffff33);
    }

}
