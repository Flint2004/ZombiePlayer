package org.szucraft.zombie_player.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.szucraft.zombie_player.effect.InfectionEffect;

public class EffectRegistry {

    public static StatusEffect registerEffect() {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of("zombie_player", "infection"), new InfectionEffect());
    }

}
