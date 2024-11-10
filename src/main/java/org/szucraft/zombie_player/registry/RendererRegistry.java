package org.szucraft.zombie_player.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.szucraft.zombie_player.ZombiePlayer;
import org.szucraft.zombie_player.client.render.ZombiePlayerEntityRenderer;

@Environment(EnvType.CLIENT)
public class RendererRegistry {

    public static void registerRenderer() {
        EntityRendererRegistry.register(ZombiePlayer.ZOMBIE_PLAYER, ZombiePlayerEntityRenderer::new);
    }

}
