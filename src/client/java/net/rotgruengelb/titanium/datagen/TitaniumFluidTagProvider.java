package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;

//? if 1.21.8 {
/*import net.minecraft.data.tag.ProvidedTagBuilder;
*///?}

import java.util.concurrent.CompletableFuture;

public class TitaniumFluidTagProvider extends FabricTagProvider.FluidTagProvider {

	public TitaniumFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
        tagBuilder(TitaniumFluidTags.BLOOD).add(
				TitaniumFluids.BLOOD,
				TitaniumFluids.FLOWING_BLOOD
		);

		// FluidTags.WATER controls the entity physics.
		tagBuilder(FluidTags.WATER).add(
				TitaniumFluids.BLOOD,
				TitaniumFluids.FLOWING_BLOOD
		);
		//@formatter:on
	}

    //? if 1.21.1 {
    protected FabricTagProvider<Fluid>.FabricTagBuilder tagBuilder(TagKey<Fluid> tag) {
        return getOrCreateTagBuilder(tag);
    }
    //?} else {
    /*protected ProvidedTagBuilder<Fluid, Fluid> tagBuilder(TagKey<Fluid> tag) {
        return super.valueLookupBuilder(tag);
    }
    *///?}
}
