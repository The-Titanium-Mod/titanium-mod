package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.rotgruengelb.titanium.block.TitaniumBlocks;

public class TitaniumModelProvider extends FabricModelProvider {

	public TitaniumModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator baseGenerator) {
		TitaniumBlockStateModelGenerator generator = new TitaniumBlockStateModelGenerator(baseGenerator);

		generator.registerSimpleCubeAll(TitaniumBlocks.CLART);
		generator.registerSimpleCubeAll(TitaniumBlocks.VEINY_CLART);

		generator.registerSod(TitaniumBlocks.SOD, TitaniumBlocks.CLART);
		generator.registerSod(TitaniumBlocks.ROTTEN_SOD, TitaniumBlocks.CLART);
		generator.registerSod(TitaniumBlocks.VEINY_SOD, TitaniumBlocks.VEINY_CLART);

		generator.registerSodBatch(TitaniumBlocks.SOD_BATCH, TitaniumBlocks.SOD);
		generator.registerSodBatch(TitaniumBlocks.ROTTEN_SOD_BATCH, TitaniumBlocks.ROTTEN_SOD);

		generator.registerSimpleCubeAll(TitaniumBlocks.BRAWN);
		generator.registerSimpleCubeAll(TitaniumBlocks.TENDON);
		generator.registerSimpleCubeAll(TitaniumBlocks.SALT);
		generator.registerSimpleCubeAll(TitaniumBlocks.BLUE_VOLLON);
		generator.registerSimpleCubeAll(TitaniumBlocks.RED_VOLLON);

		generator.registerLog(TitaniumBlocks.WILDWOOD_LOG)
				.log(TitaniumBlocks.WILDWOOD_LOG);

		generator.registerTintableCross(TitaniumBlocks.WILDWOOD_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.WILDWOOD_LUMEN, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.WILDWOOD_BLISTER, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.BUNNY_CATCHER, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.SMALL_TEETH, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.ROTTING_WILDWOOD_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.ROTTEN_WILDWOOD_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);

		generator.registerTintableCross(TitaniumBlocks.VOLLON_NOODLES, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.VOLLON_BRONCHI, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerTintableCross(TitaniumBlocks.VOLLON_STRINGS, BlockStateModelGenerator.TintType.NOT_TINTED);

		generator.registerTintableCross(TitaniumBlocks.HANGING_TENDON, BlockStateModelGenerator.TintType.NOT_TINTED);

		generator.registerDoubleBlock(TitaniumBlocks.TALL_WILDWOOD_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
		generator.registerDoubleBlock(TitaniumBlocks.ROTTEN_TOOTH, BlockStateModelGenerator.TintType.NOT_TINTED);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {

	}

	private static class TitaniumBlockStateModelGenerator extends BlockStateModelGenerator {

		public TitaniumBlockStateModelGenerator(BlockStateModelGenerator blockStateModelGenerator) {
			super(blockStateModelGenerator.blockStateCollector, blockStateModelGenerator.modelCollector, blockStateModelGenerator.simpleItemModelExemptionCollector);
		}

		public void registerSod(Block block, Block from) {
			this.registerSingleton(block, TextureMap.sideAndTop(block)
					.put(TextureKey.BOTTOM, TextureMap.getId(from)), Models.CUBE_BOTTOM_TOP);
		}

		public void registerSodBatch(Block block, Block from) {
			this.registerSingleton(block, TextureMap.all(TextureMap.getSubId(from, "_top")), Models.CUBE_ALL);
		}
	}
}
