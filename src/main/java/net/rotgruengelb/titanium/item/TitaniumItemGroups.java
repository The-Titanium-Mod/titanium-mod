package net.rotgruengelb.titanium.item;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;

import java.util.Collection;

public class TitaniumItemGroups {

	public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Titanium.id("general"));
	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(TitaniumBlocks.SOD))
			.displayName(Text.translatable("itemGroup.titanium"))
			.build();

	public static void initialize() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP);

		//@formatter:off
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY)
				.register(itemGroup -> itemGroup.addAll(toItemStackCollection(
						TitaniumBlocks.CLART,
						TitaniumBlocks.SOD,
						TitaniumBlocks.SOD_BATCH,
						TitaniumBlocks.WILDWOOD_GRASS,
						TitaniumBlocks.WILDWOOD_LUMEN,
						TitaniumBlocks.WILDWOOD_BLISTER,
						TitaniumBlocks.SMALL_TEETH,
						TitaniumBlocks.GIANT_TOOTH,
						TitaniumBlocks.TALL_WILDWOOD_GRASS,
						TitaniumBlocks.ROTTEN_SOD,
						TitaniumBlocks.ROTTEN_SOD_BATCH,
						TitaniumBlocks.ROTTING_WILDWOOD_GRASS,
						TitaniumBlocks.ROTTEN_WILDWOOD_GRASS,
						TitaniumBlocks.ROTTEN_TOOTH,
						TitaniumBlocks.VEINY_CLART,
						TitaniumBlocks.VEINY_SOD,
						TitaniumBlocks.BLUE_VOLLON,
						TitaniumBlocks.RED_VOLLON,
						TitaniumBlocks.BUNNY_CATCHER,
						TitaniumBlocks.VOLLON_NOODLES,
						TitaniumBlocks.VOLLON_BRONCHI,
						TitaniumBlocks.VOLLON_STRINGS,
						TitaniumBlocks.TENDON,
						TitaniumBlocks.HANGING_TENDON,
						TitaniumBlocks.BRAWN,
						TitaniumBlocks.SALT,
						TitaniumBlocks.WILDWOOD_LOG,
						TitaniumBlocks.WILDWOOD_WOOD,
						TitaniumBlocks.STRIPPED_WILDWOOD_LOG,
						TitaniumBlocks.STRIPPED_WILDWOOD_WOOD,
						TitaniumBlocks.WILDWOOD_PLANKS,
						TitaniumBlocks.WILDWOOD_STAIRS,
						TitaniumBlocks.WILDWOOD_SLAB,
						TitaniumBlocks.WILDWOOD_FENCE,
						TitaniumBlocks.WILDWOOD_FENCE_GATE,
						TitaniumBlocks.WILDWOOD_DOOR,
						TitaniumBlocks.WILDWOOD_TRAPDOOR,
						TitaniumBlocks.WILDWOOD_PRESSURE_PLATE,
						TitaniumBlocks.WILDWOOD_BUTTON,
						TitaniumBlocks.WILDWOOD_LEAVES,
						TitaniumBlocks.WILDWOOD_SAPLING,
						TitaniumItems.BLOOD_BUCKET
				)));
		//@formatter:on
	}

	private static Collection<ItemStack> toItemStackCollection(ItemConvertible... itemConvertibles) {
		Collection<ItemStack> itemStacks = Lists.newArrayList();
		for (ItemConvertible itemConvertible : itemConvertibles) {
			itemStacks.add(new ItemStack(itemConvertible));
		}
		return itemStacks;
	}
}
