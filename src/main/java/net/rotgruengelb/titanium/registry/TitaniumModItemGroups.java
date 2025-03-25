package net.rotgruengelb.titanium.registry;

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
import net.rotgruengelb.titanium.TitaniumMod;

import java.util.Collection;

public class TitaniumModItemGroups {

	public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), TitaniumMod.id("general"));
	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(TitaniumModBlocks.SOD))
			.displayName(Text.translatable("itemGroup.titanium"))
			.build();

	public static void initialize() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP);

		//@formatter:off
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY)
				.register(itemGroup -> itemGroup.addAll(toItemStackCollection(
						TitaniumModBlocks.CLART,
						TitaniumModBlocks.SOD,
						TitaniumModBlocks.SOD_BATCH,
						TitaniumModBlocks.ROTTEN_SOD,
						TitaniumModBlocks.ROTTEN_SOD_BATCH,
						TitaniumModBlocks.VEINY_CLART,
						TitaniumModBlocks.VEINY_SOD,
						TitaniumModBlocks.BRAWN,
						TitaniumModBlocks.TENDON,
						TitaniumModBlocks.BLUE_VOLLON,
						TitaniumModBlocks.RED_VOLLON,
						TitaniumModBlocks.SALT,
						TitaniumModBlocks.WILDWOOD_LOG,
						TitaniumModBlocks.WILDWOOD_GRASS,
						TitaniumModBlocks.WILDWOOD_LUMEN,
						TitaniumModBlocks.WILDWOOD_BLISTER,
						TitaniumModBlocks.BUNNY_CATCHER,
						TitaniumModBlocks.SMALL_TEETH,
						TitaniumModBlocks.TALL_WILDWOOD_GRASS,
						TitaniumModBlocks.ROTTING_WILDWOOD_GRASS,
						TitaniumModBlocks.ROTTEN_WILDWOOD_GRASS,
						TitaniumModBlocks.ROTTEN_TOOTH,
						TitaniumModBlocks.VOLLON_NOODLES,
						TitaniumModBlocks.VOLLON_BRONCHI,
						TitaniumModBlocks.VOLLON_STRINGS,
						TitaniumModBlocks.HANGING_TENDON)));
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
