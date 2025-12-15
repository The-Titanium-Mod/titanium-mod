package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public record TerrainDecorationFeatureConfig(IntProvider spreadWidth, IntProvider spreadHeight,
											 WeightedStateProvider decorator,
											 BlockPredicate predicate) implements FeatureConfiguration {
    public static final Codec<TerrainDecorationFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.POSITIVE_CODEC.fieldOf("spread_width").forGetter(TerrainDecorationFeatureConfig::spreadWidth),
            IntProvider.POSITIVE_CODEC.fieldOf("spread_height").forGetter(TerrainDecorationFeatureConfig::spreadHeight),
            WeightedStateProvider.CODEC.fieldOf("decorator").forGetter(TerrainDecorationFeatureConfig::decorator),
            BlockPredicate.CODEC.fieldOf("predicate").forGetter(TerrainDecorationFeatureConfig::predicate)
    ).apply(instance, TerrainDecorationFeatureConfig::new));
}
