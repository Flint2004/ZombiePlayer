package org.szucraft.zombie_player;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import org.szucraft.zombie_player.entity.ZombiePlayerEntity;
import org.szucraft.zombie_player.registry.EffectRegistry;
import org.szucraft.zombie_player.registry.EntityRegistry;

public class ZombiePlayer implements ModInitializer {

    public static final EntityType<ZombiePlayerEntity> ZOMBIE_PLAYER = EntityRegistry.registerEntity("zombie_player");
    public static final StatusEffect INFECTION_EFFECT = EffectRegistry.registerEffect();

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ZOMBIE_PLAYER, ZombiePlayerEntity.createZombieAttributes());
    }

}
