package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class ClientEntrypoint implements ClientModInitializer {
    public static Accumulator accumulator;
    @Override
    public void onInitializeClient() {
        accumulator = new Accumulator();
    }
}
