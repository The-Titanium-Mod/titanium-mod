package net.rotgruengelb.titanium.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumFluids {
	public static final FlowingFluid FLOWING_BLOOD = fluid("flowing_blood", new BloodFluid.Flowing());
	public static final FlowingFluid BLOOD = fluid("blood", new BloodFluid.Still());

	private static <T extends Fluid> T fluid(String id, T value) {
		return Registry.register(BuiltInRegistries.FLUID, Titanium.id(id), value);
	}

	public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumFluids");
    }
}
