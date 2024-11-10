package org.szucraft.match.client;

import net.fabricmc.api.ClientModInitializer;
import org.szucraft.match.registry.RendererRegistry;

public class MatchClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RendererRegistry.registerRenderer();
    }

}
