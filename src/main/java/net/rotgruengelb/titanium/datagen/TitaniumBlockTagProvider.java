package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

import java.util.concurrent.CompletableFuture;

public class TitaniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public TitaniumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) { super(output, registriesFuture); }

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

		getOrCreateTagBuilder(BlockTags.PLANKS).add(
				TitaniumBlocks.WILDWOOD_PLANKS
		);

		getOrCreateTagBuilder(BlockTags.LOGS).add(
				TitaniumBlocks.WILDWOOD_LOG,
				TitaniumBlocks.STRIPPED_WILDWOOD_LOG
		);

		getOrCreateTagBuilder(BlockTags.LEAVES).add(
				TitaniumBlocks.WILDWOOD_LEAVES
		);

		getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(
				TitaniumBlocks.WILDWOOD_FENCE_GATE
		);

		getOrCreateTagBuilder(BlockTags.DOORS).add(
				TitaniumBlocks.WILDWOOD_DOOR
		);

		getOrCreateTagBuilder(BlockTags.BUTTONS).add(
				TitaniumBlocks.WILDWOOD_BUTTON
		);

		getOrCreateTagBuilder(BlockTags.FENCES).add(
				TitaniumBlocks.WILDWOOD_FENCE
		);

		getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(
				TitaniumBlocks.WILDWOOD_BUTTON
		);

		getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(
				TitaniumBlocks.WILDWOOD_FENCE
		);

		getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(
				TitaniumBlocks.WILDWOOD_DOOR
		);

		getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(
				TitaniumBlocks.WILDWOOD_SLAB
		);

		getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(
				TitaniumBlocks.WILDWOOD_STAIRS
		);

		getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(
				TitaniumBlocks.WILDWOOD_TRAPDOOR
		);
        //@formatter:on
	}
}
