package org.szucraft.match.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.szucraft.match.Match;
import org.szucraft.match.entity.ZombiePlayerEntity;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerDeathMixin extends LivingEntity {

    protected PlayerDeathMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract ServerWorld getServerWorld();

    @Inject(at = @At(value = "TAIL"), method = "onDeath")
    public void onPlayerDeath(DamageSource damageSource, CallbackInfo ci) {
        if (this.hasStatusEffect(Match.INFECTION_EFFECT)) {
            ZombiePlayerEntity zombiePlayerEntity = Match.ZOMBIE_PLAYER.create(this.getServerWorld());
            if (zombiePlayerEntity != null) {
                zombiePlayerEntity.setPersistent();
                zombiePlayerEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
                zombiePlayerEntity.setPlayerRefer(this.getEntityName(), this.uuid);
                zombiePlayerEntity.initialize(this.getServerWorld(), this.getServerWorld().getLocalDifficulty(this.getBlockPos()), SpawnReason.TRIGGERED, null, null);
                this.getServerWorld().spawnNewEntityAndPassengers(zombiePlayerEntity);
            }
        }
    }

}
