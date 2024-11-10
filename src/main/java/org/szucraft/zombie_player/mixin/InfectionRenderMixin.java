package org.szucraft.zombie_player.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.szucraft.zombie_player.ZombiePlayer;
import org.szucraft.zombie_player.client.gui.HudHandler;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InfectionRenderMixin {

    @Shadow @Final private MinecraftClient client;

    @Shadow protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getFrozenTicks()I"), method = "render")
    private void renderInfection(DrawContext context, float tickDelta, CallbackInfo ci) {
        assert this.client.player != null;
        if (this.client.player.hasStatusEffect(ZombiePlayer.INFECTION_EFFECT)) {
            this.renderOverlay(context, HudHandler.INFECTION_BLUR, 1.0F);
        }
    }

}
