package net.rotgruengelb.titanium.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class TitaniumFluids {
	public static final FlowableFluid FLOWING_BLOOD = register("flowing_blood", new BloodFluid.Flowing());
	public static final FlowableFluid BLOOD = register("blood", new BloodFluid.Still());

	private static <T extends Fluid> T register(String id, T value) {
		return Registry.register(Registries.FLUID, id, value);
	}

	public static void initialize() { }
}
