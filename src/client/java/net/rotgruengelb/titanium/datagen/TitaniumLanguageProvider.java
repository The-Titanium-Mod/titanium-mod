package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.tag.FabricTagKey;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.rotgruengelb.titanium.item.TitaniumItemGroups;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;
import net.rotgruengelb.titanium.util.Util;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.BLOOD_BUCKET;

public class TitaniumLanguageProvider extends FabricLanguageProvider {
	protected TitaniumLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	protected TitaniumLanguageProvider(FabricDataOutput dataOutput, String languageCode, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, languageCode, registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder baseTranslationBuilder) {
		//@formatter:off
		TitaniumTranslationBuilder.<Block>translation(baseTranslationBuilder).auto(
				CLART, SOD, WILDWOOD_GRASS, WILDWOOD_LUMEN, WILDWOOD_BLISTER, SMALL_TEETH, GIANT_TOOTH,
				TALL_WILDWOOD_GRASS, ROTTEN_SOD, ROTTING_WILDWOOD_GRASS, ROTTEN_WILDWOOD_GRASS, ROTTEN_TOOTH,
				VEINY_CLART, VEINY_SOD, BLUE_VOLLON, RED_VOLLON, BUNNY_CATCHER, VOLLON_NOODLES, VOLLON_BRONCHI,
				VOLLON_STRINGS, TENDON, HANGING_TENDON, BRAWN, SALT, BLOOD, WILDWOOD_LOG, WILDWOOD_WOOD,
				STRIPPED_WILDWOOD_LOG, STRIPPED_WILDWOOD_WOOD, WILDWOOD_PLANKS, WILDWOOD_STAIRS, WILDWOOD_SLAB,
				WILDWOOD_FENCE, WILDWOOD_FENCE_GATE, WILDWOOD_DOOR, WILDWOOD_TRAPDOOR, WILDWOOD_PRESSURE_PLATE,
				WILDWOOD_BUTTON, WILDWOOD_LEAVES, WILDWOOD_SAPLING
		).autoWithOfNotation(
				SOD_BATCH, ROTTEN_SOD_BATCH
		).<Item>translation().auto(
				BLOOD_BUCKET
		).<FabricTagKey>translation().auto(
				TitaniumBlockTags.CLART, TitaniumBlockTags.VOLLON,
				TitaniumFluidTags.BLOOD
		).<RegistryKey<ItemGroup>>translation(t -> "itemGroup." + t.getValue().getPath()).auto(
				TitaniumItemGroups.ITEM_GROUP_KEY
		);
		//@formatter:on
	}

	static class TitaniumTranslationBuilder<T> {

		private final TranslationBuilder translationBuilder;
		private final Function<T, String> tranlationKeyFunction;

		public TitaniumTranslationBuilder(TranslationBuilder translationBuilder, Function<T, String> tranlationKeyFunction) {
			this.translationBuilder = translationBuilder;
			this.tranlationKeyFunction = tranlationKeyFunction;
		}

        static public <T> @NotNull TitaniumTranslationBuilder<T> translation(TranslationBuilder translationBuilder) {
			return new TitaniumTranslationBuilder<>(translationBuilder, Util::tryGetTranslationKey);
		}

        public <Z> TitaniumTranslationBuilder<Z> translation() {
			return new TitaniumTranslationBuilder<>(this.translationBuilder, Util::tryGetTranslationKey);
		}

        public <Z> TitaniumTranslationBuilder<Z> translation(Function<Z, String> tranlationKeyFunction) {
			return new TitaniumTranslationBuilder<>(this.translationBuilder, tranlationKeyFunction);
		}

		public TitaniumTranslationBuilder<T> auto(String translationKey, String string, @NotNull Function<String, String> transformationFunction) {
			translationBuilder.add(translationKey, transformationFunction.apply(Util.snakeCaseToTitleCase(string)));
			return this;
		}

		public TitaniumTranslationBuilder<T> auto(T object, Function<String, String> transformationFunction) {
			String translationKey = tranlationKeyFunction.apply(object);
			return this.auto(translationKey, Arrays.stream(translationKey.split("\\."))
					.toList()
					.getLast(), transformationFunction);
		}

		@SafeVarargs
		public final TitaniumTranslationBuilder<T> auto(T... objects) {
			Arrays.stream(objects)
					.forEach(o -> this.auto(o, string -> string));
			return this;
		}

		@SafeVarargs
		public final TitaniumTranslationBuilder<T> autoWithOfNotation(T... objects) {
			Arrays.stream(objects)
					.forEach(o -> this.auto(o, Util::titleCaseWithOfNotation));
			return this;
		}
	}
}
