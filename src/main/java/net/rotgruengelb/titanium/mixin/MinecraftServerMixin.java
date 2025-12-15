package net.rotgruengelb.titanium.mixin;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.world.gen.surfacebuilder.TitaniumSurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
@MixinEnvironment(type = MixinEnvironment.Env.MAIN)
public abstract class MinecraftServerMixin {
    @Shadow
    public abstract RegistryAccess.Frozen registryAccess();

    @Inject(at = @At("TAIL"), method = "createLevels")
    private void addSurfaceRules(ChunkProgressListener worldGenerationProgressListener, CallbackInfo ci) {
        Titanium.LOGGER.debug("Adding Surface Rules");
		LevelStem dimensionOptions =
                //? if 1.21.1 {
                /*registryAccess().registryOrThrow(Registries.LEVEL_STEM).get(LevelStem.END);
                 *///?} else {
                registryAccess().lookupOrThrow(Registries.LEVEL_STEM).getValue(LevelStem.END);
                //?}
        if (dimensionOptions != null && dimensionOptions.generator() instanceof NoiseBasedChunkGenerator generator) {
            NoiseGeneratorSettings settings = generator.generatorSettings().value();
            ChunkGeneratorSettingsAccessor accessor = (ChunkGeneratorSettingsAccessor) (Object) settings;

            if (accessor == null) return;
            accessor.setSurfaceRule(SurfaceRules.sequence(TitaniumSurfaceRules.createTitaniumEndSurfaceRule(), settings.surfaceRule()));
        }
    }

}
