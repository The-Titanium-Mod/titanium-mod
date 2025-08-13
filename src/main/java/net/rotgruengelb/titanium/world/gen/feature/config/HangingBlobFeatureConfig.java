package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public record HangingBlobFeatureConfig(TagKey<Block> targetTag, WeightedBlockStateProvider blockProvider,
                                       WeightedBlockStateProvider topDecorator,
                                       WeightedBlockStateProvider bottomDecorator) implements FeatureConfig {
    public static final Codec<HangingBlobFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BLOCK.getKey()).fieldOf("target_tag").forGetter(HangingBlobFeatureConfig::targetTag),
            WeightedBlockStateProvider.CODEC.fieldOf("block").forGetter(HangingBlobFeatureConfig::blockProvider),
            WeightedBlockStateProvider.CODEC.fieldOf("top_decorator").forGetter(HangingBlobFeatureConfig::topDecorator),
            WeightedBlockStateProvider.CODEC.fieldOf("bottom_decorator").forGetter(HangingBlobFeatureConfig::bottomDecorator)
    ).apply(instance, HangingBlobFeatureConfig::new));
}
