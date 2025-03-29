package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;

import java.util.concurrent.CompletableFuture;

public class TitaniumFluidTagProvider extends FabricTagProvider.FluidTagProvider {

	public TitaniumFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
		getOrCreateTagBuilder(TitaniumFluidTags.BLOOD).add(
				TitaniumFluids.BLOOD,
				TitaniumFluids.FLOWING_BLOOD
		);

		// FluidTags.WATER controls the entity physics.
		getOrCreateTagBuilder(FluidTags.WATER).add(
				TitaniumFluids.BLOOD,
				TitaniumFluids.FLOWING_BLOOD
		);
		//@formatter:on
	}
}
