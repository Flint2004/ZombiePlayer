package org.szucraft.zombie_player.client.render;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.szucraft.zombie_player.entity.ZombiePlayerEntity;

public class ZombiePlayerEntityModel<T extends ZombiePlayerEntity> extends ZombieEntityModel<T> {

    public ZombiePlayerEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        super.render(matrices, vertices, light, overlay, 0.24F, 0.4F, 0.16F, 0.2F);
    }

}
