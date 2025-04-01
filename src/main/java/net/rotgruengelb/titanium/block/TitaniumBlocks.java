package net.rotgruengelb.titanium.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WoodType;
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

	public static final Block BLOOD = block("blood", settings -> new FluidBlock(TitaniumFluids.BLOOD, settings), AbstractBlock.Settings.create()
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
			.sounds(BlockSoundGroup.BONE)
			.noCollision()
			.offset(AbstractBlock.OffsetType.XZ)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static Block GIANT_TOOTH = blockWithItem("giant_tooth", GiantToothBlock::new,
			AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.BONE)
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
	public static Block WILDWOOD_LOG = blockWithItem("wildwood_log", settings -> Blocks.createLogBlock(MapColor.DULL_RED, MapColor.DULL_RED), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_WOOD = blockWithItem("wildwood_wood", PillarBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block STRIPPED_WILDWOOD_LOG = blockWithItem("stripped_wildwood_log", settings -> Blocks.createLogBlock(MapColor.DULL_RED, MapColor.DULL_RED), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block STRIPPED_WILDWOOD_WOOD = blockWithItem("stripped_wildwood_wood", PillarBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_PLANKS = blockWithItem("wildwood_planks", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_SLAB = blockWithItem("wildwood_slab", SlabBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_STAIRS = blockWithItem("wildwood_stairs", settings -> createStairsBlock(TitaniumBlocks.WILDWOOD_PLANKS), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_BUTTON = blockWithItem("wildwood_button", settings -> Blocks.createWoodenButtonBlock(BlockSetType.OAK), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_PRESSURE_PLATE = blockWithItem("wildwood_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_DOOR = blockWithItem("wildwood_door", settings -> new DoorBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD)
			.nonOpaque());
	public static Block WILDWOOD_TRAPDOOR = blockWithItem("wildwood_trapdoor", settings -> new TrapdoorBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD)
			.allowsSpawning(Blocks::never)
			.nonOpaque());
	public static Block WILDWOOD_FENCE = blockWithItem("wildwood_fence", FenceBlock::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD)
			.solid());
	public static Block WILDWOOD_FENCE_GATE = blockWithItem("wildwood_fence_gate", settings -> new FenceGateBlock(WoodType.OAK, settings), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));
	public static Block WILDWOOD_LEAVES = blockWithItem("wildwood_leaves", settings -> Blocks.createLeavesBlock(BlockSoundGroup.GRASS), AbstractBlock.Settings.create());
	public static Block WILDWOOD_SAPLING = blockWithItem("wildwood_sapling", settings -> new WildwoodSaplingBlock(null, settings), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS)
			.noCollision());


	protected static Block blockWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Titanium.id(name));
		Block block = blockWithItem(blockKey, factory.apply(settings));
		TitaniumItems.item(name, itemSettings -> new BlockItem(block, itemSettings), new BlockItem.Settings());
		return block;
	}

	protected static Block block(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Titanium.id(name));
		return blockWithItem(blockKey, factory.apply(settings));
	}

	protected static Block blockWithItem(RegistryKey<Block> blockRegistryKey, Block block) {
		return Registry.register(Registries.BLOCK, blockRegistryKey, block);
	}

	protected static Block createStairsBlock(Block base) {
		return new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base));
	}

	public static void initialize() {
	}
}
