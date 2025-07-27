package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;

import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.state.property.TitaniumProperties;

//? if 1.21.1 {
import net.minecraft.data.client.*;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import static net.minecraft.data.client.BlockStateModelGenerator.TintType.NOT_TINTED;
import static net.minecraft.data.client.TexturedModel.makeFactory;
//?} else 1.21.8 {
/*import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.tint.GrassTintSource;
import static net.minecraft.client.data.BlockStateModelGenerator.CrossType.NOT_TINTED;
import static net.minecraft.client.data.TexturedModel.makeFactory;
 *///?}

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.*;

public class TitaniumModelProvider extends FabricModelProvider {

	public TitaniumModelProvider(FabricDataOutput output) { super(output); }

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator baseGenerator) {
		TitaniumBlockStateModelGenerator generator = new TitaniumBlockStateModelGenerator(baseGenerator);

		generator.registerSimpleCubeAll(CLART);
		generator.registerSimpleCubeAll(VEINY_CLART);

		generator.registerSod(SOD, CLART);
		generator.registerSod(ROTTEN_SOD, CLART);
		generator.registerSod(VEINY_SOD, VEINY_CLART);

		generator.registerSodBatch(SOD_BATCH, SOD);
		generator.registerSodBatch(ROTTEN_SOD_BATCH, ROTTEN_SOD);

		generator.registerSimpleCubeAll(BRAWN);
		generator.registerSimpleCubeAll(TENDON);
		generator.registerSimpleCubeAll(SALT);
		generator.registerSimpleCubeAll(BLUE_VOLLON);
		generator.registerSimpleCubeAll(RED_VOLLON);

		generator.registerLogPool(WILDWOOD_LOG)
				.log(WILDWOOD_LOG)
				.wood(WILDWOOD_WOOD);
		generator.registerLogPool(STRIPPED_WILDWOOD_LOG)
				.log(STRIPPED_WILDWOOD_LOG)
				.wood(STRIPPED_WILDWOOD_WOOD);

		generator.registerCubeAllModelTexturePool(WILDWOOD_PLANKS)
				.button(WILDWOOD_BUTTON)
				.fence(WILDWOOD_FENCE)
				.fenceGate(WILDWOOD_FENCE_GATE)
				.pressurePlate(WILDWOOD_PRESSURE_PLATE)
				.slab(WILDWOOD_SLAB)
				.stairs(WILDWOOD_STAIRS);
		generator.registerDoor(WILDWOOD_DOOR);
		generator.registerTrapdoor(WILDWOOD_TRAPDOOR);
		generator.registerSimpleCubeAll(WILDWOOD_LEAVES);
		generator.registerCross(WILDWOOD_SAPLING);

		generator.registerCross(WILDWOOD_GRASS);
		generator.registerCross(WILDWOOD_LUMEN);
		generator.registerCross(WILDWOOD_BLISTER);
		generator.registerCross(BUNNY_CATCHER);
		generator.registerCross(SMALL_TEETH);
		generator.registerCross(ROTTING_WILDWOOD_GRASS);
		generator.registerCross(ROTTEN_WILDWOOD_GRASS);

		generator.registerCross(VOLLON_NOODLES);
		generator.registerCross(VOLLON_BRONCHI);
		generator.registerCross(VOLLON_STRINGS);

		generator.registerCross(HANGING_TENDON);

		generator.registerSimpleDoubleBlock(TALL_WILDWOOD_GRASS);
		generator.registerSimpleDoubleBlock(ROTTEN_TOOTH);

		generator.registerGiantTooth(GIANT_TOOTH);

		generator.registerSimpleFluid(BLOOD);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
		generator.register(BLOOD_BUCKET, Models.GENERATED);
		generator.register(GIANT_TOOTH.asItem(), Models.GENERATED);
	}

	private static class TitaniumBlockStateModelGenerator extends BlockStateModelGenerator {

		public TitaniumBlockStateModelGenerator(BlockStateModelGenerator blockStateModelGenerator) {
            //? if 1.21.1 {
			super(blockStateModelGenerator.blockStateCollector, blockStateModelGenerator.modelCollector, blockStateModelGenerator.simpleItemModelExemptionCollector);
             //?} else {
            /*super(blockStateModelGenerator.blockStateCollector, blockStateModelGenerator.itemModelOutput, blockStateModelGenerator.modelCollector);
            *///?}
        }


        public final void registerSod(Block block, Block from) {
            TextureMap textureMap = new TextureMap()
                    .put(TextureKey.BOTTOM, TextureMap.getId(from))
                    .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                    .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"));
            this.blockStateCollector
            //? if 1.21.1 {
            .accept(createSingletonBlockState(block, Models.CUBE_BOTTOM_TOP.upload(block, textureMap, this.modelCollector)));
            //?} else {
            /*.accept(createSingletonBlockState(block, createWeightedVariant(Models.CUBE_BOTTOM_TOP.upload(block, textureMap, this.modelCollector))));
             *///?}
        }

        public final void registerSimpleDoubleBlock(Block block) {
            //? if 1.21.1 {
            this.registerDoubleBlock(block, NOT_TINTED);
            //?} else {
            /*this.registerDoubleBlockAndItem(block, NOT_TINTED);
             *///?}
        }

		public void registerCross(Block block) {
			this.registerTintableCross(block, NOT_TINTED);
		}

        public LogTexturePool registerLogPool(Block block) {
            //? if 1.21.1 {
            return this.registerLog(block);
             //?} else {
            /*return super.createLogTexturePool(block);
            *///?}
        }

		public void registerSodBatch(Block block, Block from) {
			this.registerSingleton(block, makeFactory(b -> TextureMap.all(TextureMap.getSubId(from, "_top")), Models.CUBE_ALL));
		}

		public void registerSimpleFluid(Block block) {
            this.registerSingleton(block, makeFactory(b -> TextureMap.particle(TextureMap.getSubId(block, "_still")), Models.PARTICLE));
		}

		public void registerGiantTooth(Block block) {
            Identifier topModelId = this.createSubModel(block, "_top", NOT_TINTED.getCrossModel(), TextureMap::cross);
            Identifier bottomFleshlessModel =
                    this.createSubModel(block, "_bottom_fleshless", NOT_TINTED.getCrossModel(), TextureMap::cross);
            Identifier bottomFleshyModel =
                    this.createSubModel(block, "_bottom", NOT_TINTED.getCrossModel(), TextureMap::cross);
            var supplier = //? if 1.21.1 {
                    VariantsBlockStateSupplier.create(block)
                                    .coordinate(BlockStateVariantMap.create(
                                                    Properties.DOUBLE_BLOCK_HALF, TitaniumProperties.FLESHY)
                                            .register((half, fleshy) -> switch (half) {
                                                case UPPER -> BlockStateVariant.create().put(VariantSettings.MODEL, topModelId);
                                                case LOWER ->
                                                    fleshy
                                                            ? BlockStateVariant.create()
                                                                    .put(VariantSettings.MODEL, bottomFleshyModel)
                                                            : BlockStateVariant.create()
                                                                    .put(VariantSettings.MODEL, bottomFleshlessModel);
                                            }));
                    
                //?} else {
                    /*VariantsBlockModelDefinitionCreator.of(block)
                            .with(BlockStateVariantMap.models(Properties.DOUBLE_BLOCK_HALF, TitaniumProperties.FLESHY)
                                    .generate((half, fleshy) -> switch (half) {
                                        case UPPER -> createWeightedVariant(topModelId);
                                        case LOWER ->
                                            fleshy
                                                    ? createWeightedVariant(bottomFleshyModel)
                                                    : createWeightedVariant(bottomFleshlessModel);
                                    }));

                *///?}
            this.blockStateCollector.accept(supplier);
		}
	}
}

