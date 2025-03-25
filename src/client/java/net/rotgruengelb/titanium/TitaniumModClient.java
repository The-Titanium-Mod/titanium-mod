package net.rotgruengelb.titanium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.rotgruengelb.titanium.registry.TitaniumModBlocks;

public class TitaniumModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
				TitaniumModBlocks.WILDWOOD_GRASS,
				TitaniumModBlocks.WILDWOOD_LUMEN,
				TitaniumModBlocks.WILDWOOD_BLISTER,
				TitaniumModBlocks.BUNNY_CATCHER,
				TitaniumModBlocks.SMALL_TEETH,
				TitaniumModBlocks.TALL_WILDWOOD_GRASS,
				TitaniumModBlocks.ROTTING_WILDWOOD_GRASS,
				TitaniumModBlocks.ROTTEN_WILDWOOD_GRASS,
				TitaniumModBlocks.ROTTEN_TOOTH,
				TitaniumModBlocks.VOLLON_NOODLES,
				TitaniumModBlocks.VOLLON_BRONCHI,
				TitaniumModBlocks.VOLLON_STRINGS
				);
	}
}