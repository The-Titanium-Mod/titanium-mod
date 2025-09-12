package net.rotgruengelb.titanium.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumFluids {
	public static final FlowableFluid FLOWING_BLOOD = fluid("flowing_blood", new BloodFluid.Flowing());
	public static final FlowableFluid BLOOD = fluid("blood", new BloodFluid.Still());

	private static <T extends Fluid> T fluid(String id, T value) {
		return Registry.register(Registries.FLUID, Titanium.id(id), value);
	}

	public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumFluids");
    }
}
