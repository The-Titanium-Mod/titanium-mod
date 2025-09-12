package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.tag.FabricTagKey;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Pair;
import net.rotgruengelb.titanium.item.TitaniumItemGroups;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;
import net.rotgruengelb.titanium.registry.tag.TitaniumItemTags;
import net.rotgruengelb.titanium.util.Util;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.*;

public class TitaniumLanguageProvider extends FabricLanguageProvider {
	protected TitaniumLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	protected TitaniumLanguageProvider(FabricDataOutput dataOutput, String languageCode, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, languageCode, registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
		//@formatter:off
		TitaniumTranslationBuilder.<Block>translation(translationBuilder).auto(
				CLART, SOD, SHORT_WILDWOOD_GRASS, WILDWOOD_LUMEN, WILDWOOD_BLISTER, SMALL_TEETH, GIANT_TOOTH,
				TALL_WILDWOOD_GRASS, ROTTEN_SOD, ROTTING_WILDWOOD_GRASS, ROTTEN_WILDWOOD_GRASS, ROTTEN_GIANT_TOOTH,
				VEINY_CLART, VEINY_SOD, BLUE_VOLLON, RED_VOLLON, BUNNY_CATCHER, VOLLON_NOODLES, VOLLON_BRONCHI,
				VOLLON_STRINGS, TENDON, HANGING_TENDON, BRAWN, SALT, BLOOD, WILDWOOD_LOG, WILDWOOD_WOOD,
				STRIPPED_WILDWOOD_LOG, STRIPPED_WILDWOOD_WOOD, WILDWOOD_PLANKS, WILDWOOD_STAIRS, WILDWOOD_SLAB,
				WILDWOOD_FENCE, WILDWOOD_FENCE_GATE, WILDWOOD_DOOR, WILDWOOD_TRAPDOOR, WILDWOOD_PRESSURE_PLATE,
				WILDWOOD_BUTTON, WILDWOOD_LEAVES, WILDWOOD_SAPLING
		).autoWithOfNotation(
				SOD_BATCH, ROTTEN_SOD_BATCH
		).<Item>translation().auto(
				BLOOD_BUCKET, HARLIC, VOLLON_ALVEOLI, VOLLON_LIGAMENTS
		).<FabricTagKey>translation().auto(
				TitaniumBlockTags.CLART_SOIL, TitaniumBlockTags.VOLLON, TitaniumBlockTags.SOD, TitaniumBlockTags.SOD_BATCH, TitaniumBlockTags.TEETH,
                TitaniumBlockTags.VOLLON_OUTGROWTHS, TitaniumBlockTags.WILDWOOD_LOGS, TitaniumBlockTags.WILDWOOD_TERRAIN, TitaniumBlockTags.WILDWOOD_OUTGROWTHS,
                TitaniumItemTags.CLART_SOIL, TitaniumItemTags.VOLLON, TitaniumItemTags.SOD, TitaniumItemTags.SOD_BATCH, TitaniumItemTags.TEETH,
                TitaniumItemTags.VOLLON_OUTGROWTHS, TitaniumItemTags.WILDWOOD_LOGS, TitaniumItemTags.WILDWOOD_TERRAIN, TitaniumItemTags.WILDWOOD_OUTGROWTHS,
				TitaniumFluidTags.BLOOD
		).<RegistryKey<ItemGroup>>translation(t -> "itemGroup." + t.getValue().getPath()).auto(
				TitaniumItemGroups.ITEM_GROUP_KEY
		).customPair(TitaniumAdvancementProvider.DRINK_BLOOD, "That's not cherry juice!", "I hope you're not a vampire...");
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

        public TitaniumTranslationBuilder<T > custom(String translationKey, String string) {
            translationBuilder.add(translationKey, string);
            return this;
        }

        public TitaniumTranslationBuilder<?> customPair(Pair<MutableText, MutableText> pair, String stringL, String stringR) {
            translationBuilder.add(((TranslatableTextContent) pair.getLeft().getContent()).getKey(), stringL);
            translationBuilder.add(((TranslatableTextContent) pair.getRight().getContent()).getKey(), stringR);
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
