package org.szucraft.match.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.szucraft.match.Match;
import org.szucraft.match.client.render.ZombiePlayerEntityRenderer;

@Environment(EnvType.CLIENT)
public class RendererRegistry {

    public static void registerRenderer() {
        EntityRendererRegistry.register(Match.ZOMBIE_PLAYER, ZombiePlayerEntityRenderer::new);
    }

}
