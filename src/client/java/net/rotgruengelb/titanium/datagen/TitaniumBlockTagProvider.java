package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

//? if 1.21.8 {
/*import net.minecraft.data.tag.ProvidedTagBuilder;
*///?}

import java.util.concurrent.CompletableFuture;

public class TitaniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public TitaniumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
        tagBuilder(TitaniumBlockTags.CLART).add(
                TitaniumBlocks.CLART,
                TitaniumBlocks.VEINY_CLART,
                TitaniumBlocks.SOD,
                TitaniumBlocks.VEINY_SOD,
                TitaniumBlocks.SOD_BATCH,
                TitaniumBlocks.ROTTEN_SOD,
                TitaniumBlocks.ROTTEN_SOD_BATCH
        );

        tagBuilder(TitaniumBlockTags.VOLLON).add(
                TitaniumBlocks.BLUE_VOLLON,
                TitaniumBlocks.RED_VOLLON
        );

		tagBuilder(BlockTags.PLANKS).add(
				TitaniumBlocks.WILDWOOD_PLANKS
		);

		tagBuilder(BlockTags.LOGS).add(
				TitaniumBlocks.WILDWOOD_LOG,
				TitaniumBlocks.STRIPPED_WILDWOOD_LOG
		);

		tagBuilder(BlockTags.LEAVES).add(
				TitaniumBlocks.WILDWOOD_LEAVES
		);

		tagBuilder(BlockTags.FENCE_GATES).add(
				TitaniumBlocks.WILDWOOD_FENCE_GATE
		);

		tagBuilder(BlockTags.DOORS).add(
				TitaniumBlocks.WILDWOOD_DOOR
		);

		tagBuilder(BlockTags.BUTTONS).add(
				TitaniumBlocks.WILDWOOD_BUTTON
		);

		tagBuilder(BlockTags.FENCES).add(
				TitaniumBlocks.WILDWOOD_FENCE
		);

		tagBuilder(BlockTags.WOODEN_BUTTONS).add(
				TitaniumBlocks.WILDWOOD_BUTTON
		);

		tagBuilder(BlockTags.WOODEN_FENCES).add(
				TitaniumBlocks.WILDWOOD_FENCE
		);

		tagBuilder(BlockTags.WOODEN_DOORS).add(
                TitaniumBlocks.WILDWOOD_DOOR
        );

		tagBuilder(BlockTags.WOODEN_SLABS).add(
				TitaniumBlocks.WILDWOOD_SLAB
		);

		tagBuilder(BlockTags.WOODEN_STAIRS).add(
				TitaniumBlocks.WILDWOOD_STAIRS
		);

		tagBuilder(BlockTags.WOODEN_TRAPDOORS).add(
				TitaniumBlocks.WILDWOOD_TRAPDOOR
		);
        //@formatter:on
	}

    //? if 1.21.1 {
    protected FabricTagProvider<Block>.FabricTagBuilder tagBuilder(TagKey<Block> tag) {
        return getOrCreateTagBuilder(tag);
    }
    //?} else {
    /*protected ProvidedTagBuilder<Block, Block> tagBuilder(TagKey<Block> tag) {
        return super.valueLookupBuilder(tag);
    }
    *///?}
}
