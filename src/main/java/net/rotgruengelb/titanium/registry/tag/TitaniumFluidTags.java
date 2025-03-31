package net.rotgruengelb.titanium.registry.tag;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.Titanium;

public final class TitaniumFluidTags {

	public static final TagKey<Fluid> BLOOD = tag("blood");

	private static TagKey<Fluid> tag(String id) {
		return TagKey.of(RegistryKeys.FLUID, Titanium.id(id));
	}
}
