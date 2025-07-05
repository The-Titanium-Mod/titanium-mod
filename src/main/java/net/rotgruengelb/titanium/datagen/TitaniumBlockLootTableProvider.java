package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.rotgruengelb.titanium.block.TitaniumBlocks;

import java.util.concurrent.CompletableFuture;

public class TitaniumBlockLootTableProvider extends FabricBlockLootTableProvider {

    protected TitaniumBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(TitaniumBlocks.CLART);
        addClartDrop(TitaniumBlocks.SOD);
        addClartDrop(TitaniumBlocks.VEINY_SOD);
        addClartDrop(TitaniumBlocks.ROTTEN_SOD);
        addClartDrop(TitaniumBlocks.VEINY_CLART);
    }

    public void addClartDrop(Block block) {
        this.addDrop(block, block1 -> this.drops(block1, TitaniumBlocks.CLART));
    }
}
