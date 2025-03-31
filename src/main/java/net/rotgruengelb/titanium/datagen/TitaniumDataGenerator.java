package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class TitaniumDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TitaniumModelProvider::new);
		pack.addProvider(TitaniumBlockTagProvider::new);
		pack.addProvider(TitaniumFluidTagProvider::new);
		pack.addProvider((dataOutput, wrapperLookup) -> new TitaniumItemTagProvider(dataOutput, wrapperLookup, null));
	}
}
