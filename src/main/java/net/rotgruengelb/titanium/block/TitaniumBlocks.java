package net.rotgruengelb.titanium.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItems;

import java.util.function.Function;

public class TitaniumBlocks {

	public static final Block BLOOD = block("blood",
			(settings) -> new FluidBlock(TitaniumFluids.BLOOD, settings), AbstractBlock.Settings.create()
			.mapColor(MapColor.DARK_RED)
			.replaceable()
			.noCollision()
			.strength(100.0F)
			.pistonBehavior(PistonBehavior.DESTROY)
			.dropsNothing()
			.liquid()
			.sounds(BlockSoundGroup.INTENTIONALLY_EMPTY));
	public static Block CLART = blockWithItem("clart", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTED_DIRT));
	public static Block SOD = blockWithItem("sod", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NYLIUM));
	public static Block SOD_BATCH = blockWithItem("sod_batch", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS));
	public static Block ROTTEN_SOD = blockWithItem("rotten_sod", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NYLIUM));
	public static Block ROTTEN_SOD_BATCH = blockWithItem("rotten_sod_batch", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS));
	public static Block VEINY_CLART = blockWithItem("veiny_clart", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTED_DIRT));
	public static Block VEINY_SOD = blockWithItem("veiny_sod", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NYLIUM));
	public static Block BRAWN = blockWithItem("brawn", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.MUD));
	public static Block TENDON = blockWithItem("tendon", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.SHROOMLIGHT));
	public static Block BLUE_VOLLON = blockWithItem("blue_vollon", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.PACKED_MUD));
	public static Block RED_VOLLON = blockWithItem("red_vollon", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.PACKED_MUD));
	public static Block SALT = blockWithItem("salt", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.SAND));
	public static Block WILDWOOD_LOG = blockWithItem("wildwood_log", settings -> Blocks.createLogBlock(MapColor.DULL_RED, MapColor.DULL_RED), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_GRASS = blockWithItem("wildwood_grass", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block WILDWOOD_LUMEN = blockWithItem("wildwood_lumen", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.luminance(state -> 8)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block WILDWOOD_BLISTER = blockWithItem("wildwood_blister", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.CORAL)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block BUNNY_CATCHER = blockWithItem("bunny_catcher", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block SMALL_TEETH = blockWithItem("small_teeth", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block TALL_WILDWOOD_GRASS = blockWithItem("tall_wildwood_grass", TallSodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block ROTTING_WILDWOOD_GRASS = blockWithItem("rotting_wildwood_grass", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.WET_GRASS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block ROTTEN_WILDWOOD_GRASS = blockWithItem("rotten_wildwood_grass", SodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.WET_GRASS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block ROTTEN_TOOTH = blockWithItem("rotten_tooth", TallSodPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTS)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block VOLLON_NOODLES = blockWithItem("vollon_noodles", VollonPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.CORAL)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block VOLLON_BRONCHI = blockWithItem("vollon_bronchi", VollonPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.CORAL)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block VOLLON_STRINGS = blockWithItem("vollon_strings", VollonPlantBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.CORAL)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block HANGING_TENDON = blockWithItem("hanging_tendon", HangingTendonBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.SHROOMLIGHT));

	protected static Block blockWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Titanium.id(name));
		Block block = blockWithItem(blockKey, factory.apply(settings));
		TitaniumItems.item(name, new BlockItem.Settings(), itemSettings -> new BlockItem(block, itemSettings));
		return block;
	}

	protected static Block block(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Titanium.id(name));
		return blockWithItem(blockKey, factory.apply(settings));
	}

	protected static Block blockWithItem(RegistryKey<Block> blockRegistryKey, Block block) {
		return Registry.register(Registries.BLOCK, blockRegistryKey, block);
	}

	public static void initialize() { }
}
