package net.rotgruengelb.titanium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;

public class TitaniumClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		//@formatter:off
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
				TitaniumBlocks.WILDWOOD_GRASS,
				TitaniumBlocks.WILDWOOD_LUMEN,
				TitaniumBlocks.WILDWOOD_BLISTER,
				TitaniumBlocks.BUNNY_CATCHER,
				TitaniumBlocks.SMALL_TEETH,
				TitaniumBlocks.TALL_WILDWOOD_GRASS,
				TitaniumBlocks.ROTTING_WILDWOOD_GRASS,
				TitaniumBlocks.ROTTEN_WILDWOOD_GRASS,
				TitaniumBlocks.GIANT_TOOTH,
				TitaniumBlocks.ROTTEN_TOOTH,
				TitaniumBlocks.VOLLON_NOODLES,
				TitaniumBlocks.VOLLON_BRONCHI,
				TitaniumBlocks.VOLLON_STRINGS,
				TitaniumBlocks.HANGING_TENDON,
				TitaniumBlocks.WILDWOOD_DOOR,
				TitaniumBlocks.WILDWOOD_TRAPDOOR,
				TitaniumBlocks.WILDWOOD_SAPLING
		);

		FluidRenderHandlerRegistry.INSTANCE.register(
				TitaniumFluids.BLOOD,
				TitaniumFluids.FLOWING_BLOOD,
				new SimpleFluidRenderHandler(
						Titanium.id("block/blood_still"),
						Titanium.id("block/blood_flow"),
						null
				)
		);
		//@formatter:on
	}
}