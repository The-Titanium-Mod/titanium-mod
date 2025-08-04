package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumFeatures {
    public static final Feature<NaturalArchFeatureConfig> NATURAL_ARCH = feature("natural_arch", new NaturalArchFeature(NaturalArchFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F feature(String name, F feature) {
        return Registry.register(Registries.FEATURE, Titanium.id(name), feature);
    }

    public static void initialize() { }
}
