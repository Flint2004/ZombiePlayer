package org.szucraft.zombie_player.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.szucraft.zombie_player.entity.ZombiePlayerEntity;

public class EntityRegistry {
    public static EntityType<ZombiePlayerEntity> registerEntity(String path) {
        return Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier("zombie_player", path),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ZombiePlayerEntity::new).dimensions(EntityDimensions.changing(0.6F, 1.95F)).trackRangeBlocks(8).build()
        );
    }

}
