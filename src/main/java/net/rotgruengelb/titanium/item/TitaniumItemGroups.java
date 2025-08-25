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

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.*;

public class TitaniumItemGroups {

	public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Titanium.id("titanium"));
	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(TitaniumBlocks.SOD.asItem()::getDefaultStack)
			.displayName(Text.translatable("itemGroup.titanium"))
			.build();

	public static void initialize() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP);

		//@formatter:off
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY)
				.register(itemGroup -> itemGroup.addAll(toItemStackCollection(
						CLART, SOD, SOD_BATCH,
						SHORT_WILDWOOD_GRASS, WILDWOOD_LUMEN, WILDWOOD_BLISTER,
						SMALL_TEETH, GIANT_TOOTH, TALL_WILDWOOD_GRASS,
						ROTTEN_SOD, ROTTEN_SOD_BATCH, ROTTING_WILDWOOD_GRASS,
						ROTTEN_WILDWOOD_GRASS, ROTTEN_GIANT_TOOTH, VEINY_CLART,
						VEINY_SOD, BLUE_VOLLON, RED_VOLLON, BUNNY_CATCHER,
						VOLLON_NOODLES, VOLLON_BRONCHI, VOLLON_STRINGS,
						TENDON, HANGING_TENDON, BRAWN, SALT, BLOOD_BUCKET,
						WILDWOOD_LOG, WILDWOOD_WOOD, STRIPPED_WILDWOOD_LOG,
						STRIPPED_WILDWOOD_WOOD, WILDWOOD_PLANKS, WILDWOOD_STAIRS,
						WILDWOOD_SLAB, WILDWOOD_FENCE, WILDWOOD_FENCE_GATE,
						WILDWOOD_DOOR, WILDWOOD_TRAPDOOR, WILDWOOD_PRESSURE_PLATE,
						WILDWOOD_BUTTON, WILDWOOD_LEAVES, WILDWOOD_SAPLING, HARLIC
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
