package net.rotgruengelb.titanium.mixin;

import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.world.gen.surfacebuilder.TitaniumSurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow
    public abstract DynamicRegistryManager.Immutable getRegistryManager();

    @Inject(at = @At("TAIL"), method = "createWorlds")
    private void addSurfaceRules(WorldGenerationProgressListener worldGenerationProgressListener, CallbackInfo ci) {
        Titanium.LOGGER.debug("Adding Surface Rules");
        Registry<DimensionOptions> value =
                //? if 1.21.1 {
                getRegistryManager().get(RegistryKeys.DIMENSION);
                 //?} else {
                /*getRegistryManager().getOrThrow(RegistryKeys.DIMENSION);
                *///?}
        DimensionOptions dimensionOptions = value.get(DimensionOptions.END);

        if (dimensionOptions != null && dimensionOptions.chunkGenerator() instanceof NoiseChunkGenerator generator) {
            ChunkGeneratorSettings settings = generator.getSettings().value();
            ChunkGeneratorSettingsAccessor accessor = (ChunkGeneratorSettingsAccessor) (Object) settings;

            if (accessor == null) return;
            accessor.setSurfaceRule(MaterialRules.sequence(TitaniumSurfaceRules.createTitaniumEndSurfaceRule(), settings.surfaceRule()));
        }
    }

}