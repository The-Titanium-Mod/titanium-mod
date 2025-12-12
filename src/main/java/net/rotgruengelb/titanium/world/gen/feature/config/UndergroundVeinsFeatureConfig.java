package net.rotgruengelb.titanium.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public record UndergroundVeinsFeatureConfig(TagKey<Block> replaceable, IntProvider maxSteps,
											IntProvider downwardStepChance, IntProvider verticalStepChance,
											IntProvider maxDistanceFromOrigin,
											WeightedStateProvider stateProvider) implements FeatureConfiguration {
    public static final Codec<UndergroundVeinsFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.hashedCodec(BuiltInRegistries.BLOCK.key()).fieldOf("replaceable").forGetter(UndergroundVeinsFeatureConfig::replaceable),
            IntProvider.CODEC.fieldOf("max_steps").forGetter(UndergroundVeinsFeatureConfig::maxSteps),
            IntProvider.CODEC.fieldOf("downward_step_chance").forGetter(UndergroundVeinsFeatureConfig::downwardStepChance),
            IntProvider.CODEC.fieldOf("vertical_step_chance").forGetter(UndergroundVeinsFeatureConfig::verticalStepChance),
            IntProvider.CODEC.fieldOf("max_distance_from_origin").forGetter(UndergroundVeinsFeatureConfig::maxDistanceFromOrigin),
            WeightedStateProvider.CODEC.fieldOf("state_provider").forGetter(UndergroundVeinsFeatureConfig::stateProvider)
    ).apply(instance, UndergroundVeinsFeatureConfig::new));
}
