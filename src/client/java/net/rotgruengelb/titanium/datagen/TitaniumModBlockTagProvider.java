package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rotgruengelb.titanium.registry.TitaniumModBlockTags;
import net.rotgruengelb.titanium.registry.TitaniumModBlocks;

import java.util.concurrent.CompletableFuture;

public class TitaniumModBlockTagProvider extends FabricTagProvider<Block> {

	public TitaniumModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.BLOCK, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
        getOrCreateTagBuilder(TitaniumModBlockTags.CLART).add(
                TitaniumModBlocks.CLART,
                TitaniumModBlocks.VEINY_CLART,
                TitaniumModBlocks.SOD,
                TitaniumModBlocks.VEINY_SOD,
                TitaniumModBlocks.SOD_BATCH,
                TitaniumModBlocks.ROTTEN_SOD,
                TitaniumModBlocks.ROTTEN_SOD_BATCH
        );

        getOrCreateTagBuilder(TitaniumModBlockTags.VOLLON).add(
                TitaniumModBlocks.BLUE_VOLLON,
                TitaniumModBlocks.RED_VOLLON
        );
        //@formatter:on
	}
}
