package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;
import net.rotgruengelb.titanium.block.TitaniumBlocks;

import java.util.concurrent.CompletableFuture;

public class TitaniumBlockTagProvider extends FabricTagProvider<Block> {

	public TitaniumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.BLOCK, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
        getOrCreateTagBuilder(TitaniumBlockTags.CLART).add(
                TitaniumBlocks.CLART,
                TitaniumBlocks.VEINY_CLART,
                TitaniumBlocks.SOD,
                TitaniumBlocks.VEINY_SOD,
                TitaniumBlocks.SOD_BATCH,
                TitaniumBlocks.ROTTEN_SOD,
                TitaniumBlocks.ROTTEN_SOD_BATCH
        );

        getOrCreateTagBuilder(TitaniumBlockTags.VOLLON).add(
                TitaniumBlocks.BLUE_VOLLON,
                TitaniumBlocks.RED_VOLLON
        );
        //@formatter:on
	}
}
