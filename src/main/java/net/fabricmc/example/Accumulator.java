package net.fabricmc.example;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.HashMap;

public class Accumulator {
    HashMap<BlockPos, BlockEntry> observedBlocks = new HashMap<>();
    public long blockObservationStaleTime = 1000;
    public double FoV = Math.toRadians(180);
    public void observeBlock(BlockPos pos) {
        if (!FoVCheck(pos)) {
            return;
        }
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.world != null) {
            World world = player.world;
            Vec3d start = player.getPos().add(0,player.getEyeHeight(player.getPose()),0);
            boolean visible = false;
            for (Direction d : Direction.values()) {
                if (world.getBlockState(pos.offset(d)).isAir()) {
                    Vec3d end = Vec3d.of(d.getVector()).multiply(0.5).add(Vec3d.of(pos).add(0.5,0.5,0.5));

                    RaycastContext context = new RaycastContext(start, end, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, player);
                    BlockHitResult output = player.world.raycast(context);
                    if (output.getBlockPos().equals(pos)) {
                        visible = true;
                        break;
                    }
                }
            }
            if (visible) {
                registerBlock(pos);
            }
        }
    }
    public boolean FoVCheck(BlockPos pos) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.world != null) {
            Vec3d offset = Vec3d.of(pos).add(0.5, 0.5, 0.5).subtract(player.getPos());
            Vec3d look = Vec3d.fromPolar(player.getPitch(0),player.getHeadYaw());
            double angle = Math.acos(look.dotProduct(offset.normalize()));
            if (angle < FoV * 0.5) {
                return true;
            }
        }
        return false;
    }
    public void registerBlock(BlockPos pos) {
        assert MinecraftClient.getInstance().player != null;
        World world = MinecraftClient.getInstance().player.world;
        BlockPos key = pos.toImmutable();
        long timestamp = world.getTime();
        BlockState state = world.getBlockState(pos);
        if (observedBlocks.containsKey(key)) {
            if (state.isAir()) {
                observedBlocks.remove(key);
            } else {
                BlockEntry entry = observedBlocks.get(key);
                entry.setBlockState(state);
                entry.setTimestamp(timestamp);
            }
        } else {
            if (!state.isAir()) {
                observedBlocks.put(key, new BlockEntry(state, timestamp));
            }
        }
    }

    public static class BlockEntry {
        long lastObserved;
        BlockState state;
        float focus;
        public BlockEntry (BlockState state, long timestamp) {
            this.state = state;
            this.lastObserved = timestamp;
        }
        public void setBlockState(BlockState state) {
            this.state = state;
        }
        public void setTimestamp(long timestamp) {
            this.lastObserved = timestamp;
        }
    }
}
