package org.szucraft.zombie_player.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import org.szucraft.zombie_player.entity.ZombiePlayerEntity;

public class ZombiePlayerEntityRenderer extends ZombieEntityRenderImpl {

    public static ZombieEntityRenderImpl ZOMBIE;
    public static ZombieEntityRenderImpl ZOMBIE_SLIM;

    public ZombiePlayerEntityRenderer(EntityRendererFactory.Context ctx) {
        this(ctx, EntityModelLayers.PLAYER, EntityModelLayers.PLAYER_INNER_ARMOR, EntityModelLayers.PLAYER_OUTER_ARMOR);
        ZOMBIE = new ZombieEntityRenderImpl(ctx, EntityModelLayers.PLAYER, EntityModelLayers.PLAYER_INNER_ARMOR, EntityModelLayers.PLAYER_OUTER_ARMOR);
        ZOMBIE_SLIM = new ZombieEntityRenderImpl(ctx, EntityModelLayers.PLAYER_SLIM, EntityModelLayers.PLAYER_SLIM_INNER_ARMOR, EntityModelLayers.PLAYER_SLIM_OUTER_ARMOR);
    }
    protected ZombiePlayerEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, layer, legsArmorLayer, bodyArmorLayer);
    }

    @Override
    public void render(ZombiePlayerEntity zombiePlayer, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (!zombiePlayer.isSlim())
            ZOMBIE.render(zombiePlayer, f, g, matrixStack, vertexConsumerProvider, i);
        else
            ZOMBIE_SLIM.render(zombiePlayer, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
