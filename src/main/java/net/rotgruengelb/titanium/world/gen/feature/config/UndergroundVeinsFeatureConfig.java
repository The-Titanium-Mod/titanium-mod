package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public record UndergroundVeinsFeatureConfig(TagKey<Block> replaceable, IntProvider maxSteps,
                                            IntProvider downwardStepChance, IntProvider verticalStepChance,
                                            IntProvider maxDistanceFromOrigin,
                                            WeightedBlockStateProvider stateProvider) implements FeatureConfig {
    public static final Codec<UndergroundVeinsFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BLOCK.getKey()).fieldOf("replaceable").forGetter(UndergroundVeinsFeatureConfig::replaceable),
            IntProvider.VALUE_CODEC.fieldOf("max_steps").forGetter(UndergroundVeinsFeatureConfig::maxSteps),
            IntProvider.VALUE_CODEC.fieldOf("downward_step_chance").forGetter(UndergroundVeinsFeatureConfig::downwardStepChance),
            IntProvider.VALUE_CODEC.fieldOf("vertical_step_chance").forGetter(UndergroundVeinsFeatureConfig::verticalStepChance),
            IntProvider.VALUE_CODEC.fieldOf("max_distance_from_origin").forGetter(UndergroundVeinsFeatureConfig::maxDistanceFromOrigin),
            WeightedBlockStateProvider.CODEC.fieldOf("state_provider").forGetter(UndergroundVeinsFeatureConfig::stateProvider)
    ).apply(instance, UndergroundVeinsFeatureConfig::new));
}