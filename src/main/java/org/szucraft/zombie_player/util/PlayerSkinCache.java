package org.szucraft.zombie_player.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Environment(EnvType.CLIENT)
public class PlayerSkinCache {
    public static HashMap<UUID, Identifier> PLAYER_SKIN_CACHE = new HashMap<>();
    public static HashMap<UUID, Boolean> SLIM_CACHE = new HashMap<>();

    public static Identifier getSkin(UUID uuid, String name) {
        if (uuid == null)
            return new Identifier("minecraft", "textures/entity/player/wide/steve.png");
        if (PLAYER_SKIN_CACHE.get(uuid) != null)
            return PLAYER_SKIN_CACHE.get(uuid);
        Identifier cache = MinecraftClient.getInstance().getSkinProvider().loadSkin(new GameProfile(uuid, name));
        PLAYER_SKIN_CACHE.put(uuid, cache);
        return cache;
    }

    public static Boolean isSlim(UUID uuid, String name) {
        if (uuid == null)
            return false;
        if (SLIM_CACHE.get(uuid) != null)
            return SLIM_CACHE.get(uuid);
        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> cache = MinecraftClient.getInstance().getSkinProvider().getTextures(new GameProfile(uuid, name));
        if (cache.containsKey(MinecraftProfileTexture.Type.SKIN)) {
            MinecraftProfileTexture cache1 = cache.get(MinecraftProfileTexture.Type.SKIN);
            if (cache1 != null) {
                boolean cache2 = Objects.equals(cache1.getMetadata("model"), "slim");
                SLIM_CACHE.put(uuid, cache2);
                return cache2;
            }
        }
        return false;
    }
}
