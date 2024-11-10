package org.szucraft.match;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import org.szucraft.match.entity.ZombiePlayerEntity;
import org.szucraft.match.registry.EffectRegistry;
import org.szucraft.match.registry.EntityRegistry;

public class Match implements ModInitializer {

    public static final EntityType<ZombiePlayerEntity> ZOMBIE_PLAYER = EntityRegistry.registerEntity("zombie_player");
    public static final StatusEffect INFECTION_EFFECT = EffectRegistry.registerEffect();

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ZOMBIE_PLAYER, ZombiePlayerEntity.createZombieAttributes());
    }

}
