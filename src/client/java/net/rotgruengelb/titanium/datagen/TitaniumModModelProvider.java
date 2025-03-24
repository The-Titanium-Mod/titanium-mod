package net.rotgruengelb.titanium.datagen;

import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.registry.TitaniumModBlocks;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TitaniumModModelProvider extends FabricModelProvider {
	public TitaniumModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator baseGenerator) {
		TitaniumBlockStateModelGenerator generator = (TitaniumBlockStateModelGenerator) baseGenerator;
		generator.registerSimpleCubeAll(TitaniumModBlocks.CLART);
		generator.registerSimpleCubeAll(TitaniumModBlocks.BRAWN);
		generator.registerSimpleCubeAll(TitaniumModBlocks.TENDON);
		generator.registerSimpleCubeAll(TitaniumModBlocks.SALT);
		generator.registerSimpleCubeAll(TitaniumModBlocks.BLUE_VOLLON);
		generator.registerSimpleCubeAll(TitaniumModBlocks.RED_VOLLON);

		generator.registerSod(TitaniumModBlocks.SOD, TitaniumModBlocks.CLART);
		generator.registerSodBatch(TitaniumModBlocks.SOD_BATCH, TitaniumModBlocks.SOD);
		generator.registerSimpleCubeAll(TitaniumModBlocks.VEINY_CLART);
		generator.registerSod(TitaniumModBlocks.VEINY_SOD, TitaniumModBlocks.VEINY_CLART);
		generator.registerSod(TitaniumModBlocks.ROTTEN_SOD, TitaniumModBlocks.CLART);
		generator.registerSodBatch(TitaniumModBlocks.ROTTEN_SOD_BATCH, TitaniumModBlocks.ROTTEN_SOD);

		generator.registerLog(TitaniumModBlocks.WILDWOOD_LOG).log(TitaniumModBlocks.WILDWOOD_LOG);
    }

	@Override
	public void generateItemModels(ItemModelGenerator generator) {

	}

	private static class TitaniumBlockStateModelGenerator extends BlockStateModelGenerator {
		public TitaniumBlockStateModelGenerator(Consumer<BlockStateSupplier> blockStateCollector, BiConsumer<Identifier, Supplier<JsonElement>> modelCollector, Consumer<Item> simpleItemModelExemptionCollector) {
			super(blockStateCollector, modelCollector, simpleItemModelExemptionCollector);
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
