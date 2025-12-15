package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public record HangingBlobFeatureConfig(TagKey<Block> targetTag, WeightedStateProvider blockProvider,
									   WeightedStateProvider topDecorator,
									   WeightedStateProvider bottomDecorator) implements FeatureConfiguration {
    public static final Codec<HangingBlobFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.hashedCodec(BuiltInRegistries.BLOCK.key()).fieldOf("target_tag").forGetter(HangingBlobFeatureConfig::targetTag),
            WeightedStateProvider.CODEC.fieldOf("block").forGetter(HangingBlobFeatureConfig::blockProvider),
            WeightedStateProvider.CODEC.fieldOf("top_decorator").forGetter(HangingBlobFeatureConfig::topDecorator),
            WeightedStateProvider.CODEC.fieldOf("bottom_decorator").forGetter(HangingBlobFeatureConfig::bottomDecorator)
    ).apply(instance, HangingBlobFeatureConfig::new));
}
