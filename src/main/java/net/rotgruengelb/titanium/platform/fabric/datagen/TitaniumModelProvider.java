package net.rotgruengelb.titanium.platform.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.resources.ResourceLocation;
import net.rotgruengelb.titanium.state.property.TitaniumProperties;

//? if 1.21.1 {
/*import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import static net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED;
import static net.minecraft.data.models.model.TexturedModel.createDefault;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
*///?} else 1.21.8 {
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.*;
import static net.minecraft.client.data.models.BlockModelGenerators.PlantType.NOT_TINTED;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import static net.minecraft.client.data.models.model.TexturedModel.createDefault;
 //?}

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.*;

public class TitaniumModelProvider extends FabricModelProvider {

	public TitaniumModelProvider(FabricDataOutput output) { super(output); }

	@Override
	public void generateBlockStateModels(BlockModelGenerators baseGenerator) {
		TitaniumBlockStateModelGenerator generator = new TitaniumBlockStateModelGenerator(baseGenerator);

		generator.createTrivialCube(CLART);
		generator.createTrivialCube(VEINY_CLART);

		generator.registerSod(SOD, CLART);
		generator.registerSod(ROTTEN_SOD, CLART);
		generator.registerSod(VEINY_SOD, VEINY_CLART);

		generator.registerSodBatch(SOD_BATCH, SOD);
		generator.registerSodBatch(ROTTEN_SOD_BATCH, ROTTEN_SOD);

		generator.createTrivialCube(BRAWN);
		generator.createTrivialCube(TENDON);
		generator.createTrivialCube(SALT);
		generator.createTrivialCube(BLUE_VOLLON);
		generator.createTrivialCube(RED_VOLLON);

		generator.registerLogPool(WILDWOOD_LOG)
				.logWithHorizontal(WILDWOOD_LOG)
				.wood(WILDWOOD_WOOD);
		generator.registerLogPool(STRIPPED_WILDWOOD_LOG)
				.logWithHorizontal(STRIPPED_WILDWOOD_LOG)
				.wood(STRIPPED_WILDWOOD_WOOD);

		generator.family(WILDWOOD_PLANKS)
				.button(WILDWOOD_BUTTON)
				.fence(WILDWOOD_FENCE)
				.fenceGate(WILDWOOD_FENCE_GATE)
				.pressurePlate(WILDWOOD_PRESSURE_PLATE)
				.slab(WILDWOOD_SLAB)
				.stairs(WILDWOOD_STAIRS);
		generator.createDoor(WILDWOOD_DOOR);
		generator.createTrapdoor(WILDWOOD_TRAPDOOR);
		generator.createTrivialCube(WILDWOOD_LEAVES);
		generator.registerCross(WILDWOOD_SAPLING);

		generator.registerCross(SHORT_WILDWOOD_GRASS);
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
		generator.registerSimpleDoubleBlock(ROTTEN_GIANT_TOOTH);

		generator.registerGiantTooth(GIANT_TOOTH);

		generator.registerSimpleFluid(BLOOD);
	}

	@Override
	public void generateItemModels(ItemModelGenerators generator) {
		generator.generateFlatItem(BLOOD_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(GIANT_TOOTH.asItem(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(HARLIC, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(VOLLON_ALVEOLI, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(VOLLON_LIGAMENTS, ModelTemplates.FLAT_ITEM);
	}

	private static class TitaniumBlockStateModelGenerator extends BlockModelGenerators {

		public TitaniumBlockStateModelGenerator(BlockModelGenerators blockStateModelGenerator) {
            //? if 1.21.1 {
			/*super(blockStateModelGenerator.blockStateOutput, blockStateModelGenerator.modelOutput, blockStateModelGenerator.skippedAutoModelsOutput);
             *///?} else {
            super(blockStateModelGenerator.blockStateOutput, blockStateModelGenerator.itemModelOutput, blockStateModelGenerator.modelOutput);
            //?}
        }


        public final void registerSod(Block block, Block from) {

            TextureMapping textureMap = new TextureMapping()
                    .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(from))
                    .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                    .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
            this.blockStateOutput
            //? if 1.21.1 {
            /*.accept(createRotatedVariant(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, textureMap, this.modelOutput)));
            *///?} else {
            .accept(createSimpleBlock(block, createRotatedVariants(plainModel(ModelTemplates.CUBE_BOTTOM_TOP.create(block, textureMap, this.modelOutput)))));
            //?}
        }

        public final void registerSimpleDoubleBlock(Block block) {
            //? if 1.21.1 {
            /*this.createDoublePlant(block, NOT_TINTED);
            *///?} else {
            this.createDoublePlant(block, NOT_TINTED);
             //?}
        }

		public void registerCross(Block block) {
			this.createCrossBlockWithDefaultItem(block, NOT_TINTED);
		}

        public WoodProvider registerLogPool(Block block) {
            //? if 1.21.1 {
            /*return this.woodProvider(block);
             *///?} else {
            return super.woodProvider(block);
            //?}
        }

		public void registerSodBatch(Block block, Block from) {
			this.createTrivialBlock(block, createDefault(b -> TextureMapping.cube(TextureMapping.getBlockTexture(from, "_top")), ModelTemplates.CUBE_ALL));
		}

		public void registerSimpleFluid(Block block) {
            this.createTrivialBlock(block, createDefault(b -> TextureMapping.particle(TextureMapping.getBlockTexture(block, "_still")), ModelTemplates.PARTICLE_ONLY));
		}

		public void registerGiantTooth(Block block) {
            ResourceLocation topModelId = this.createSuffixedVariant(block, "_top", NOT_TINTED.getCross(), TextureMapping::cross);
            ResourceLocation bottomFleshlessModel =
                    this.createSuffixedVariant(block, "_bottom_fleshless", NOT_TINTED.getCross(), TextureMapping::cross);
            ResourceLocation bottomFleshyModel =
                    this.createSuffixedVariant(block, "_bottom", NOT_TINTED.getCross(), TextureMapping::cross);
            var supplier = //? if 1.21.1 {
                    /*MultiVariantGenerator.multiVariant(block)
                                    .with(PropertyDispatch.properties(
                                                    BlockStateProperties.DOUBLE_BLOCK_HALF, TitaniumProperties.FLESHY)
                                            .generate((half, fleshy) -> switch (half) {
                                                case UPPER -> Variant.variant().with(VariantProperties.MODEL, topModelId);
                                                case LOWER ->
                                                    fleshy
                                                            ? Variant.variant()
                                                                    .with(VariantProperties.MODEL, bottomFleshyModel)
                                                            : Variant.variant()
                                                                    .with(VariantProperties.MODEL, bottomFleshlessModel);
                                            }));

                *///?} else {
					MultiVariantGenerator.dispatch(block)
                            .with(PropertyDispatch.initial(BlockStateProperties.DOUBLE_BLOCK_HALF, TitaniumProperties.FLESHY)
                                    .generate((half, fleshy) -> switch (half) {
                                        case UPPER -> plainVariant(topModelId);
                                        case LOWER -> fleshy ? plainVariant(bottomFleshyModel) : plainVariant(bottomFleshlessModel);
                                    }));

                //?}
            this.blockStateOutput.accept(supplier);
		}
	}
}

