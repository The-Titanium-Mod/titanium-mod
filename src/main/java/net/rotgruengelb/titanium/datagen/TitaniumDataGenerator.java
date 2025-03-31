package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.rotgruengelb.titanium.item.TitaniumItems;

public class TitaniumDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TitaniumModelProvider::new);
		pack.addProvider(TitaniumBlockTagProvider::new);
		pack.addProvider(TitaniumFluidTagProvider::new);
		pack.addProvider(TitaniumItemTagProvider::new);
	}
}
