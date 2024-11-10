package org.szucraft.match.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.szucraft.match.effect.InfectionEffect;

public class EffectRegistry {

    public static StatusEffect registerEffect() {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of("match", "infection"), new InfectionEffect());
    }

}
