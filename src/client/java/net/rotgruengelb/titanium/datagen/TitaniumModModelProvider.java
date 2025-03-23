package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.rotgruengelb.titanium.registry.TitaniumModBlocks;

public class TitaniumModModelProvider extends FabricModelProvider
{
    public TitaniumModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(TitaniumModBlocks.CLART);
        generator.registerSingleton(TitaniumModBlocks.SOD,
                TextureMap.sideAndTop(TitaniumModBlocks.SOD).put(TextureKey.BOTTOM, TextureMap.getId(TitaniumModBlocks.CLART)),
                Models.CUBE_BOTTOM_TOP);
        generator.registerSingleton(TitaniumModBlocks.SOD_BATCH,
                TextureMap.all(TextureMap.getSubId(TitaniumModBlocks.SOD, "_top")),
                Models.CUBE_ALL);

        generator.registerSimpleCubeAll(TitaniumModBlocks.VEINY_CLART);
        generator.registerSingleton(TitaniumModBlocks.VEINY_SOD,
                TextureMap.sideAndTop(TitaniumModBlocks.VEINY_SOD).put(TextureKey.BOTTOM, TextureMap.getId(TitaniumModBlocks.VEINY_CLART)),
                Models.CUBE_BOTTOM_TOP);

        generator.registerSingleton(TitaniumModBlocks.ROTTEN_SOD,
                TextureMap.sideAndTop(TitaniumModBlocks.ROTTEN_SOD).put(TextureKey.BOTTOM, TextureMap.getId(TitaniumModBlocks.CLART)),
                Models.CUBE_BOTTOM_TOP);
        generator.registerSingleton(TitaniumModBlocks.ROTTEN_SOD_BATCH,
                TextureMap.all(TextureMap.getSubId(TitaniumModBlocks.ROTTEN_SOD, "_top")),
                Models.CUBE_ALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {

    }
}
