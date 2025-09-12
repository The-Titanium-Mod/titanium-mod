package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.world.gen.feature.config.HangingBlobFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.NaturalArchFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.TerrainDecorationFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.UndergroundVeinsFeatureConfig;

public class TitaniumFeatures {
    public static final Feature<NaturalArchFeatureConfig> NATURAL_ARCH = feature("natural_arch", new NaturalArchFeature(NaturalArchFeatureConfig.CODEC));
    public static final Feature<UndergroundVeinsFeatureConfig> UNDERGROUND_VEINS = feature("underground_veins", new UndergroundVeinsFeature(UndergroundVeinsFeatureConfig.CODEC));
    public static final Feature<HangingBlobFeatureConfig> HANGING_BLOB = feature("hanging_blob", new HangingBlobFeature(HangingBlobFeatureConfig.CODEC));
    public static final Feature<TerrainDecorationFeatureConfig> TERRAIN_DECORATION = feature("terrain_decoration", new TerrainDecorationFeature(TerrainDecorationFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F feature(String name, F feature) {
        return Registry.register(Registries.FEATURE, Titanium.id(name), feature);
    }

    public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumFeatures");
    }
}
