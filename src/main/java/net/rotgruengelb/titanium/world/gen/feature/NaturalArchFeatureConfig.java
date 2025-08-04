package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record NaturalArchFeatureConfig(BlockStateProvider archBlockProvider, TagKey<Block> targetBlocks,
                                       IntProvider archThickness, IntProvider maxRange, IntProvider archRadius,
                                       IntProvider minVerticalDelta, IntProvider maxVerticalDelta,
                                       BlockPredicate placementPredicate) implements FeatureConfig {
    public static final Codec<NaturalArchFeatureConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    BlockStateProvider.TYPE_CODEC.fieldOf("arch_block_provider").forGetter(config -> config.archBlockProvider),
                    TagKey.codec(RegistryKeys.BLOCK).fieldOf("target_blocks").forGetter(config -> config.targetBlocks),
                    IntProvider.createValidatingCodec(1, 16).fieldOf("arch_thickness").forGetter(config -> config.archThickness),
                    IntProvider.createValidatingCodec(1, 64).fieldOf("max_range").forGetter(config -> config.maxRange),
                    IntProvider.createValidatingCodec(1, 16).fieldOf("arch_radius").forGetter(config -> config.archRadius),
                    IntProvider.createValidatingCodec(-64, 64).fieldOf("min_vertical_delta").forGetter(config -> config.minVerticalDelta),
                    IntProvider.createValidatingCodec(-64, 64).fieldOf("max_vertical_delta").forGetter(config -> config.maxVerticalDelta),
                    BlockPredicate.BASE_CODEC.fieldOf("placement_predicate").forGetter(config -> config.placementPredicate)
            ).apply(instance, NaturalArchFeatureConfig::new)
    );
}
