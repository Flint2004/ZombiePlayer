package org.szucraft.zombie_player.client;

import net.fabricmc.api.ClientModInitializer;
import org.szucraft.zombie_player.registry.RendererRegistry;

public class ZombiePlayerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RendererRegistry.registerRenderer();
    }

}
