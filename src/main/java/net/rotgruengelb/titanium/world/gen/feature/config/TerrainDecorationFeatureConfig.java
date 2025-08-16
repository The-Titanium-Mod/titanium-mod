package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public record TerrainDecorationFeatureConfig(IntProvider spreadWidth, IntProvider spreadHeight,
                                             WeightedBlockStateProvider decorator,
                                             BlockPredicate predicate) implements FeatureConfig {
    public static final Codec<TerrainDecorationFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.POSITIVE_CODEC.fieldOf("spread_width").forGetter(TerrainDecorationFeatureConfig::spreadWidth),
            IntProvider.POSITIVE_CODEC.fieldOf("spread_height").forGetter(TerrainDecorationFeatureConfig::spreadHeight),
            WeightedBlockStateProvider.CODEC.fieldOf("decorator").forGetter(TerrainDecorationFeatureConfig::decorator),
            BlockPredicate.BASE_CODEC.fieldOf("predicate").forGetter(TerrainDecorationFeatureConfig::predicate)
    ).apply(instance, TerrainDecorationFeatureConfig::new));
}
