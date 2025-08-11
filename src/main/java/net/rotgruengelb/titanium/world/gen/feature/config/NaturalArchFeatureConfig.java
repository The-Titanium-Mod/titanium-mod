package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public record NaturalArchFeatureConfig(TagKey<Block> targetTag, IntProvider horizontalDistance,
                                       IntProvider verticalDistance, IntProvider thickness,
                                       BlockStateProvider block, WeightedBlockStateProvider topDecorator) implements FeatureConfig {
    public static final Codec<NaturalArchFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BLOCK.getKey()).fieldOf("target_tag").forGetter(NaturalArchFeatureConfig::targetTag),
            IntProvider.VALUE_CODEC.fieldOf("horizontal_distance").forGetter(NaturalArchFeatureConfig::horizontalDistance),
            IntProvider.VALUE_CODEC.fieldOf("vertical_distance").forGetter(NaturalArchFeatureConfig::verticalDistance),
            IntProvider.VALUE_CODEC.fieldOf("thickness").forGetter(NaturalArchFeatureConfig::thickness),
            BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(NaturalArchFeatureConfig::block),
            WeightedBlockStateProvider.CODEC.fieldOf("top_decorator").forGetter(NaturalArchFeatureConfig::topDecorator)
    ).apply(instance, NaturalArchFeatureConfig::new));
}
