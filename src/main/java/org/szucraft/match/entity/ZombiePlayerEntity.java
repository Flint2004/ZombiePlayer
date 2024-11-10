package org.szucraft.match.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.szucraft.match.util.PlayerSkinCache;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ZombiePlayerEntity extends ZombieEntity {

    private static final TrackedData<String> PLAYER_NAME;
    private static final TrackedData<Optional<UUID>> PLAYER_UUID;

    public ZombiePlayerEntity(EntityType<? extends ZombiePlayerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("PlayerName", this.getDataTracker().get(PLAYER_NAME));
        nbt.putUuid("PlayerUUID", this.getDataTracker().get(PLAYER_UUID).isEmpty() ? UUID.randomUUID() : this.getDataTracker().get(PLAYER_UUID).get());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (!Objects.equals(nbt.getString("PlayerUUID"), ""))
            this.setPlayerRefer(nbt.getString("PlayerName"), nbt.getUuid("PlayerUUID"));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.getDataTracker().startTracking(PLAYER_NAME, "Steve");
        this.getDataTracker().startTracking(PLAYER_UUID, Optional.of(UUID.randomUUID()));
    }

    static {
        PLAYER_NAME = DataTracker.registerData(ZombiePlayerEntity.class, TrackedDataHandlerRegistry.STRING);
        PLAYER_UUID = DataTracker.registerData(ZombiePlayerEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    }

    public void setPlayerRefer(String playerName, UUID playerUuid) {
        this.getDataTracker().set(PLAYER_NAME, playerName);
        this.getDataTracker().set(PLAYER_UUID, Optional.of(playerUuid));
        this.setCustomName(Text.translatable("info.match.zombie_player", this.getDataTracker().get(PLAYER_NAME)));
    }

    @Environment(EnvType.CLIENT)
    public Identifier getSkin() {
        if (this.getDataTracker().get(PLAYER_UUID).isEmpty())
            return new Identifier("minecraft", "textures/entity/player/wide/steve.png");
        return PlayerSkinCache.getSkin(this.getDataTracker().get(PLAYER_UUID).get(), this.getDataTracker().get(PLAYER_NAME));
    }

    @Environment(EnvType.CLIENT)
    public Boolean isSlim() {
        if (this.getDataTracker().get(PLAYER_UUID).isEmpty())
            return false;
        return PlayerSkinCache.isSlim(this.getDataTracker().get(PLAYER_UUID).get(), this.getDataTracker().get(PLAYER_NAME));
    }

}