package org.szucraft.match.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.szucraft.match.Match;

import java.util.Random;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerInfectionMixin extends LivingEntity {


    protected PlayerInfectionMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At(value = "HEAD"), method = "damage")
    public void onZombieDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.getAttacker() instanceof ZombieEntity) {
            Random random = new Random();
            if (random.nextBoolean()) {
                this.setStatusEffect(new StatusEffectInstance(Match.INFECTION_EFFECT, 200, 0), source.getSource());
            }
        }
    }
}
