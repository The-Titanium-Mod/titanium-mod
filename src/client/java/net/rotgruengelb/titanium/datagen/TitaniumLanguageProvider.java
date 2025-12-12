package net.rotgruengelb.titanium.datagen;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.BLOOD;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.BLUE_VOLLON;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.BRAWN;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.BUNNY_CATCHER;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.CLART;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.GIANT_TOOTH;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.HANGING_TENDON;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.RED_VOLLON;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.ROTTEN_GIANT_TOOTH;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.ROTTEN_SOD;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.ROTTEN_SOD_BATCH;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.ROTTEN_WILDWOOD_GRASS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.ROTTING_WILDWOOD_GRASS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.SALT;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.SHORT_WILDWOOD_GRASS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.SMALL_TEETH;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.SOD;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.SOD_BATCH;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.STRIPPED_WILDWOOD_LOG;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.STRIPPED_WILDWOOD_WOOD;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.TALL_WILDWOOD_GRASS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.TENDON;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.VEINY_CLART;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.VEINY_SOD;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.VOLLON_BRONCHI;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.VOLLON_NOODLES;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.VOLLON_STRINGS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_BLISTER;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_BUTTON;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_DOOR;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_FENCE;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_FENCE_GATE;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_LEAVES;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_LOG;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_LUMEN;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_PLANKS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_PRESSURE_PLATE;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_SAPLING;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_SLAB;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_STAIRS;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_TRAPDOOR;
import static net.rotgruengelb.titanium.block.TitaniumBlocks.WILDWOOD_WOOD;
import static net.rotgruengelb.titanium.item.TitaniumItems.BLOOD_BUCKET;
import static net.rotgruengelb.titanium.item.TitaniumItems.HARLIC;
import static net.rotgruengelb.titanium.item.TitaniumItems.VOLLON_ALVEOLI;
import static net.rotgruengelb.titanium.item.TitaniumItems.VOLLON_LIGAMENTS;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.tag.FabricTagKey;

import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.rotgruengelb.titanium.item.TitaniumItemGroups;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;
import net.rotgruengelb.titanium.registry.tag.TitaniumItemTags;
import net.rotgruengelb.titanium.util.ConventionText;

public class TitaniumLanguageProvider extends FabricLanguageProvider {
	protected TitaniumLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	protected TitaniumLanguageProvider(FabricDataOutput dataOutput, String languageCode, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, languageCode, registryLookup);
	}

	@Override
	public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
		TitaniumTranslationBuilder builder = TitaniumTranslationBuilder.start(translationBuilder);

		builder.forBlocks().auto(
				CLART, SOD, SHORT_WILDWOOD_GRASS, WILDWOOD_LUMEN, WILDWOOD_BLISTER, SMALL_TEETH,
				GIANT_TOOTH, TALL_WILDWOOD_GRASS, ROTTEN_SOD, ROTTING_WILDWOOD_GRASS, ROTTEN_WILDWOOD_GRASS,
				ROTTEN_GIANT_TOOTH, VEINY_CLART, VEINY_SOD, BLUE_VOLLON, RED_VOLLON, BUNNY_CATCHER,
				VOLLON_NOODLES, VOLLON_BRONCHI, VOLLON_STRINGS, TENDON, HANGING_TENDON, BRAWN, SALT,
				BLOOD, WILDWOOD_LOG, WILDWOOD_WOOD, STRIPPED_WILDWOOD_LOG, STRIPPED_WILDWOOD_WOOD,
				WILDWOOD_PLANKS, WILDWOOD_STAIRS, WILDWOOD_SLAB, WILDWOOD_FENCE, WILDWOOD_FENCE_GATE,
				WILDWOOD_DOOR, WILDWOOD_TRAPDOOR, WILDWOOD_PRESSURE_PLATE, WILDWOOD_BUTTON,
				WILDWOOD_LEAVES, WILDWOOD_SAPLING
		).autoWith(ConventionText::titleCaseWithOfNotation, SOD_BATCH, ROTTEN_SOD_BATCH);

		builder.forItems().auto(BLOOD_BUCKET, HARLIC, VOLLON_ALVEOLI, VOLLON_LIGAMENTS);

		builder.forTags().auto(
				TitaniumBlockTags.CLART_SOIL, TitaniumBlockTags.VOLLON, TitaniumBlockTags.SOD,
				TitaniumBlockTags.SOD_BATCH, TitaniumBlockTags.TEETH, TitaniumBlockTags.VOLLON_OUTGROWTHS,
				TitaniumBlockTags.WILDWOOD_LOGS, TitaniumBlockTags.WILDWOOD_TERRAIN, TitaniumBlockTags.WILDWOOD_OUTGROWTHS,
				TitaniumItemTags.CLART_SOIL, TitaniumItemTags.VOLLON, TitaniumItemTags.SOD,
				TitaniumItemTags.SOD_BATCH, TitaniumItemTags.TEETH, TitaniumItemTags.VOLLON_OUTGROWTHS,
				TitaniumItemTags.WILDWOOD_LOGS, TitaniumItemTags.WILDWOOD_TERRAIN, TitaniumItemTags.WILDWOOD_OUTGROWTHS,
				TitaniumFluidTags.BLOOD
		);

		builder.forCreativeTabs().auto(TitaniumItemGroups.ITEM_GROUP_KEY);

		builder.customPair(TitaniumAdvancementProvider.DRINK_BLOOD, "That's not cherry juice!", "I hope you're not a vampire...");
	}

	static class TitaniumTranslationBuilder {

		private final TranslationBuilder translationBuilder;
		private Function<Object, String> keyFunction;

		private TitaniumTranslationBuilder(TranslationBuilder translationBuilder) {
			this.translationBuilder = translationBuilder;
		}

		static TitaniumTranslationBuilder start(TranslationBuilder translationBuilder) {
			return new TitaniumTranslationBuilder(translationBuilder);
		}

		public TitaniumTranslationBuilder forBlocks() {
			this.keyFunction = o -> ((Block) o).getDescriptionId();
			return this;
		}

		public TitaniumTranslationBuilder forItems() {
			this.keyFunction = o -> ((Item) o).getDescriptionId();
			return this;
		}

		public TitaniumTranslationBuilder forTags() {
			this.keyFunction = o -> ((FabricTagKey) o).getTranslationKey();
			return this;
		}

		public TitaniumTranslationBuilder forCreativeTabs() {
			this.keyFunction = o -> "itemGroup." + ((ResourceKey<?>) o).location().getPath();
			return this;
		}

		public TitaniumTranslationBuilder custom(String key, String value) {
			translationBuilder.add(key, value);
			return this;
		}

		public TitaniumTranslationBuilder customPair(Tuple<MutableComponent, MutableComponent> pair, String left, String right) {
			translationBuilder.add(((TranslatableContents) pair.getA().getContents()).getKey(), left);
			translationBuilder.add(((TranslatableContents) pair.getB().getContents()).getKey(), right);
			return this;
		}

		private String lastSegment(String key) {
			int idx = key.lastIndexOf('.');
			return (idx == -1) ? key : key.substring(idx + 1);
		}

		private void addAuto(Object obj, Function<String, String> transform) {
			String key = keyFunction.apply(obj);
			String base = lastSegment(key);
			translationBuilder.add(key, transform.apply(ConventionText.snakeCaseToTitleCase(base)));
		}

		@SafeVarargs
		public final <T> TitaniumTranslationBuilder auto(T... objects) {
			return auto(s -> s, objects);
		}

		@SafeVarargs
		public final <T> TitaniumTranslationBuilder auto(Function<String, String> transform, T... objects) {
			for (var o : objects) {
				addAuto(o, transform);
			}
			return this;
		}

		@SafeVarargs
		public final <T> TitaniumTranslationBuilder autoWith(Function<String, String> transform, T... objects) {
			return auto(transform, objects);
		}
	}
}
