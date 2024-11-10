package org.szucraft.zombie_player.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.szucraft.zombie_player.entity.ZombiePlayerEntity;

public class ZombieEntityRenderImpl extends ZombieBaseEntityRenderer<ZombiePlayerEntity, ZombiePlayerEntityModel<ZombiePlayerEntity>> {

    protected ZombieEntityRenderImpl(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx,
                new ZombiePlayerEntityModel<>(ctx.getPart(layer)),
                new ZombiePlayerEntityModel<>(ctx.getPart(legsArmorLayer)),
                new ZombiePlayerEntityModel<>(ctx.getPart(bodyArmorLayer)));
    }

    @Override
    public Identifier getTexture(ZombiePlayerEntity zombiePlayerEntity) {
        return zombiePlayerEntity.getSkin();
    }

}
