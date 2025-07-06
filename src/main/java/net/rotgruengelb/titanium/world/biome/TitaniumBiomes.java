package net.rotgruengelb.titanium.world.biome;

import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumBiomes {
    public static final RegistryKey<Biome> WILDWOOD_WASTES = biome("wildwood_wastes");

    private static RegistryKey<Biome> biome(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Titanium.id(name));
    }

    public static void bootstrap(Registerable<Biome> registerable) {
        RegistryEntryLookup<PlacedFeature> featureLookup = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> carverLookup = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        registerable.register(WILDWOOD_WASTES, WildwoodWastesBiome.create(featureLookup, carverLookup));
    }

    protected static Biome createEndBiome(GenerationSettings.LookupBackedBuilder builder) {
        SpawnSettings.Builder builder2 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addEndMobs(builder2);
        return new Biome.Builder().precipitation(false).temperature(0.5F).downfall(0.5F).effects(new BiomeEffects.Builder().waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(builder2.build()).generationSettings(builder.build()).build();
    }

    private static void addEndBiomeToVanilla(RegistryKey<Biome> key, double weight) {
        TheEndBiomes.addHighlandsBiome(key, weight);
        TheEndBiomes.addMidlandsBiome(key, key, weight);
        TheEndBiomes.addBarrensBiome(key, key, weight);
    }

    public static void initialize() {
        addEndBiomeToVanilla(WILDWOOD_WASTES, 1.2);
    }
}
