package net.rotgruengelb.titanium.world.gen.densityfunction;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumDensityFunctionTypes {
    public static final MapCodec<?> DISTANCE_FROM_CENTER_GRADIENT = densityFunctionType("distance_from_center_gradient", DistanceFromCenterGradient.CODEC);

    private static MapCodec<? extends DensityFunction> densityFunctionType(String path, CodecHolder<? extends DensityFunction> dispatch) {
        return Registry.register(Registries.DENSITY_FUNCTION_TYPE, Titanium.id(path), dispatch.codec());
    }

    public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumDensityFunctionTypes");
    }

    record DistanceFromCenterGradient(int minDistance, int maxDistance, double fromValue,
                                      double toValue) implements DensityFunction.Base {
        static final Codec<Double> NOISE_VALUE_CODEC = Codec.doubleRange(-1000000.0, 1000000.0);

        private static final MapCodec<DistanceFromCenterGradient> DATA_CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance
                        .group(Codec.INT.fieldOf("min_distance").forGetter(DistanceFromCenterGradient::minDistance),
                                Codec.INT.fieldOf("max_distance").forGetter(DistanceFromCenterGradient::maxDistance),
                                NOISE_VALUE_CODEC.fieldOf("from_value").forGetter(DistanceFromCenterGradient::fromValue),
                                NOISE_VALUE_CODEC.fieldOf("to_value").forGetter(DistanceFromCenterGradient::toValue))
                        .apply(instance, DistanceFromCenterGradient::new));

        public static final CodecHolder<DistanceFromCenterGradient> CODEC = CodecHolder.of(DATA_CODEC);

        @Override
        public double sample(DensityFunction.NoisePos context) {
            float f = (float) context.blockX();
            float h = (float) context.blockZ();

            float distance = MathHelper.sqrt(f * f + h * h);

            return MathHelper.clampedMap(distance, minDistance, maxDistance, fromValue, toValue);
        }

        @Override
        public double minValue() {
            return Math.min(fromValue, toValue);
        }

        @Override
        public double maxValue() {
            return Math.max(fromValue, toValue);
        }

        @Override
        public CodecHolder<? extends DensityFunction> getCodecHolder() {
            return CODEC;
        }
    }
}