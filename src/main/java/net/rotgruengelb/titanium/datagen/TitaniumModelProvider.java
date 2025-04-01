package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.state.property.TitaniumProperties;

public class TitaniumModelProvider extends FabricModelProvider {

	public TitaniumModelProvider(FabricDataOutput output) { super(output); }

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
				.log(TitaniumBlocks.WILDWOOD_LOG)
				.wood(TitaniumBlocks.WILDWOOD_WOOD);
		generator.registerLog(TitaniumBlocks.STRIPPED_WILDWOOD_LOG)
				.log(TitaniumBlocks.STRIPPED_WILDWOOD_LOG)
				.wood(TitaniumBlocks.STRIPPED_WILDWOOD_WOOD);

		generator.registerCubeAllModelTexturePool(TitaniumBlocks.WILDWOOD_PLANKS)
				.button(TitaniumBlocks.WILDWOOD_BUTTON)
				.fence(TitaniumBlocks.WILDWOOD_FENCE)
				.fenceGate(TitaniumBlocks.WILDWOOD_FENCE_GATE)
				.pressurePlate(TitaniumBlocks.WILDWOOD_PRESSURE_PLATE)
				.slab(TitaniumBlocks.WILDWOOD_SLAB)
				.stairs(TitaniumBlocks.WILDWOOD_STAIRS);
		generator.registerDoor(TitaniumBlocks.WILDWOOD_DOOR);
		generator.registerTrapdoor(TitaniumBlocks.WILDWOOD_TRAPDOOR);
		generator.registerSimpleCubeAll(TitaniumBlocks.WILDWOOD_LEAVES);
		generator.registerTintableCross(TitaniumBlocks.WILDWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

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

		generator.registerGiantTooth(TitaniumBlocks.GIANT_TOOTH);

		generator.registerSimpleFluid(TitaniumBlocks.BLOOD);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
		generator.register(TitaniumItems.BLOOD_BUCKET, Models.GENERATED);
		generator.register(TitaniumBlocks.GIANT_TOOTH.asItem(), Models.GENERATED);
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

		public void registerSimpleFluid(Block block) {
			this.registerSingleton(block, TextureMap.particle(TextureMap.getSubId(block, "_still")), Models.PARTICLE);
		}

		public void registerGiantTooth(Block block) {
			Identifier topModelId = this.createSubModel(block, "_top", BlockStateModelGenerator.TintType.NOT_TINTED.getCrossModel(), TextureMap::cross);
			Identifier bottomFleshlessModel = this.createSubModel(block, "_bottom_fleshless", BlockStateModelGenerator.TintType.NOT_TINTED.getCrossModel(), TextureMap::cross);
			Identifier bottomFleshyModel = this.createSubModel(block, "_bottom", BlockStateModelGenerator.TintType.NOT_TINTED.getCrossModel(), TextureMap::cross);
			this.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
					.coordinate(BlockStateVariantMap.create(Properties.DOUBLE_BLOCK_HALF, TitaniumProperties.FLESHY)
							.register((half, fleshy) -> switch (half) {
								case UPPER -> BlockStateVariant.create()
										.put(VariantSettings.MODEL, topModelId);
								case LOWER -> fleshy ? //@formatter:off
										BlockStateVariant.create()
												.put(VariantSettings.MODEL, bottomFleshyModel) :
										BlockStateVariant.create()
												.put(VariantSettings.MODEL, bottomFleshlessModel); //@formatter:on
							})));
		}
	}
}


