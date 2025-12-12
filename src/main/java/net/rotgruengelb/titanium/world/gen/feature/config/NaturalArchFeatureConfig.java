package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public record NaturalArchFeatureConfig(TagKey<Block> targetTag, IntProvider horizontalDistance,
									   IntProvider verticalDistance, IntProvider thickness,
									   BlockStateProvider block, WeightedStateProvider topDecorator) implements FeatureConfiguration {
    public static final Codec<NaturalArchFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.hashedCodec(BuiltInRegistries.BLOCK.key()).fieldOf("target_tag").forGetter(NaturalArchFeatureConfig::targetTag),
            IntProvider.CODEC.fieldOf("horizontal_distance").forGetter(NaturalArchFeatureConfig::horizontalDistance),
            IntProvider.CODEC.fieldOf("vertical_distance").forGetter(NaturalArchFeatureConfig::verticalDistance),
            IntProvider.CODEC.fieldOf("thickness").forGetter(NaturalArchFeatureConfig::thickness),
            BlockStateProvider.CODEC.fieldOf("block").forGetter(NaturalArchFeatureConfig::block),
            WeightedStateProvider.CODEC.fieldOf("top_decorator").forGetter(NaturalArchFeatureConfig::topDecorator)
    ).apply(instance, NaturalArchFeatureConfig::new));
}
