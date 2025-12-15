package net.rotgruengelb.titanium.registry.tag;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.rotgruengelb.titanium.Titanium;

public final class TitaniumFluidTags {

	public static final TagKey<Fluid> BLOOD = tag("blood");

	private static TagKey<Fluid> tag(String id) {
		return TagKey.create(Registries.FLUID, Titanium.id(id));
	}
}
