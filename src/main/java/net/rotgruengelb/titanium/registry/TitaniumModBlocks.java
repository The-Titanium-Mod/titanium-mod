package net.rotgruengelb.titanium.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.rotgruengelb.titanium.TitaniumMod;
import net.rotgruengelb.titanium.block.SodPlantBlock;
import net.rotgruengelb.titanium.block.TallSodPlantBlock;
import net.rotgruengelb.titanium.block.VollonPlantBlock;

import java.util.function.Function;

public class TitaniumModBlocks {

	public static Block CLART = register("clart", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTED_DIRT));

	public static Block SOD = register("sod", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NYLIUM));

	public static Block SOD_BATCH = register("sod_batch", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS));

	public static Block ROTTEN_SOD = register("rotten_sod", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NYLIUM));

	public static Block ROTTEN_SOD_BATCH = register("rotten_sod_batch", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.GRASS));

	public static Block VEINY_CLART = register("veiny_clart", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.ROOTED_DIRT));

	public static Block VEINY_SOD = register("veiny_sod", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NYLIUM));

	public static Block BRAWN = register("brawn", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.MUD));

	public static Block TENDON = register("tendon", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.SHROOMLIGHT));

	public static Block BLUE_VOLLON = register("blue_vollon", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.PACKED_MUD));

	public static Block RED_VOLLON = register("red_vollon", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.PACKED_MUD));

	public static Block SALT = register("salt", Block::new, AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.SAND));

	public static Block WILDWOOD_LOG = register("wildwood_log", settings -> Blocks.createLogBlock(MapColor.DULL_RED, MapColor.DULL_RED), AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.NETHER_WOOD));

    public static Block WILDWOOD_GRASS = register("wildwood_grass", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block WILDWOOD_LUMEN = register("wildwood_lumen", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .luminance(state -> 8)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block WILDWOOD_BLISTER = register("wildwood_blister", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.CORAL)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block BUNNY_CATCHER = register("bunny_catcher", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.ROOTS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block SMALL_TEETH = register("small_teeth", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.ROOTS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block TALL_WILDWOOD_GRASS = register("tall_wildwood_grass", TallSodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block ROTTING_WILDWOOD_GRASS = register("rotting_wildwood_grass", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.WET_GRASS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block ROTTEN_WILDWOOD_GRASS = register("rotten_wildwood_grass", SodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.WET_GRASS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block ROTTEN_TOOTH = register("rotten_tooth", TallSodPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.ROOTS)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block VOLLON_NOODLES = register("vollon_noodles", VollonPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.CORAL)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block VOLLON_BRONCHI = register("vollon_bronchi", VollonPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.CORAL)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));

    public static Block VOLLON_STRINGS = register("vollon_strings", VollonPlantBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.CORAL)
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY));


	protected static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, TitaniumMod.id(name));
		Block block = register(blockKey, factory.apply(settings));
		TitaniumModItems.register(name, new BlockItem.Settings(), itemSettings -> new BlockItem(block, itemSettings));
		return block;
	}

	protected static Block registerWithoutItem(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, Block> factory) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, TitaniumMod.id(name));
		return register(blockKey, factory.apply(settings));
	}

	protected static Block register(RegistryKey<Block> blockRegistryKey, Block block) {
		return Registry.register(Registries.BLOCK, blockRegistryKey, block);
	}

	public static void initialize() { }
}
