package net.rotgruengelb.titanium.world.biome;

import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumBiomes {
    public static final ResourceKey<Biome> WILDWOOD_FOREST = biome("wildwood_forest");
    public static final ResourceKey<Biome> WILDWOOD_WASTES = biome("wildwood_wastes");

    private static ResourceKey<Biome> biome(String name) {
        return ResourceKey.create(Registries.BIOME, Titanium.id(name));
    }

    public static void bootstrap(BootstrapContext<Biome> registerable) {
        HolderGetter<PlacedFeature> featureLookup = registerable.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carverLookup = registerable.lookup(Registries.CONFIGURED_CARVER);

        registerable.register(WILDWOOD_FOREST, WildwoodBiomeFamily.forest(featureLookup, carverLookup));
        registerable.register(WILDWOOD_WASTES, WildwoodBiomeFamily.wastes(featureLookup, carverLookup));
    }

    protected static Biome createEndBiome(BiomeGenerationSettings.Builder generationSettingsBuilder) {
        MobSpawnSettings.Builder spawnSettingsBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.endSpawns(spawnSettingsBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.5F)
                .downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(10518688)
                        .skyColor(0)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .mobSpawnSettings(spawnSettingsBuilder.build())
                .generationSettings(generationSettingsBuilder.build())
                .build();
    }

    private static void addEndBiomeToVanilla(ResourceKey<Biome> key, double weight) {
        TheEndBiomes.addHighlandsBiome(key, weight);
        TheEndBiomes.addMidlandsBiome(key, key, weight);
        TheEndBiomes.addBarrensBiome(key, key, weight);
    }

    public static void initialize() {
        addEndBiomeToVanilla(WILDWOOD_FOREST, 1.25);
        addEndBiomeToVanilla(WILDWOOD_WASTES, 0.95);

        Titanium.LOGGER.debug("Initialized TitaniumBiomes");
    }
}
