package net.rotgruengelb.titanium.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItems;

import java.util.function.Function;

import static net.rotgruengelb.titanium.block.TitaniumBlockTypes.TitaniumBlockSetTypes;
import static net.rotgruengelb.titanium.block.TitaniumBlockTypes.TitaniumWoodTypes;

public class TitaniumBlocks {

    public static final Block BLOOD = block(
            "blood",
            s -> new FluidBlock(TitaniumFluids.BLOOD, s),
            liquidSettings(MapColor.DARK_RED));
    public static Block CLART = blockAndItem(
            "clart",
            createSoilSettings(MapColor.TERRACOTTA_BLACK, BlockSoundGroup.ROOTED_DIRT, false));
    public static Block SOD = blockAndItem(
            "sod",
            SodBlock::new,
            createSoilSettings(MapColor.PINK, BlockSoundGroup.NYLIUM, true)
                    .ticksRandomly());
    public static Block SOD_BATCH = blockAndItem(
            "sod_batch",
            createSoilSettings(MapColor.PINK, BlockSoundGroup.GRASS, true));
    public static Block ROTTEN_SOD = blockAndItem(
            "rotten_sod",
            RottenSodBlock::new,
            createSoilSettings(MapColor.TERRACOTTA_PURPLE, BlockSoundGroup.NYLIUM, true)
                    .ticksRandomly());
    public static Block ROTTEN_SOD_BATCH = blockAndItem(
            "rotten_sod_batch",
            createSoilSettings(MapColor.TERRACOTTA_PURPLE, BlockSoundGroup.GRASS, true));
    public static Block VEINY_CLART = blockAndItem(
            "veiny_clart",
            createSoilSettings(MapColor.TERRACOTTA_BLACK, BlockSoundGroup.ROOTED_DIRT, false));
    public static Block VEINY_SOD = blockAndItem(
            "veiny_sod",
            createSoilSettings(MapColor.PINK, BlockSoundGroup.NYLIUM, true));
    public static Block BRAWN = blockAndItem(
            "brawn",
            settings(MapColor.BLACK, BlockSoundGroup.MUD, 1.5F, 6.0F)
                    .requiresTool());
    public static Block TENDON = blockAndItem(
            "tendon",
            settings(MapColor.DARK_RED, BlockSoundGroup.SHROOMLIGHT, 1.3F, 5.0F));
    public static Block BLUE_VOLLON = blockAndItem(
            "blue_vollon",
            settings(MapColor.DIAMOND_BLUE, BlockSoundGroup.PACKED_MUD, 0.95F));
    public static Block RED_VOLLON = blockAndItem(
            "red_vollon",
            settings(MapColor.TERRACOTTA_RED, BlockSoundGroup.PACKED_MUD, 0.95F));
    public static Block SALT = blockAndItem(
            "salt",
            createSoilSettings(MapColor.OFF_WHITE, BlockSoundGroup.SAND, true)
                    .requiresTool());
    public static Block SHORT_WILDWOOD_GRASS = blockAndItem(
            "short_wildwood_grass",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.GRASS).replaceable());
    public static Block WILDWOOD_LUMEN = blockAndItem(
            "wildwood_lumen",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.GRASS)
                    .luminance(state -> 8));
    public static Block WILDWOOD_BLISTER = blockAndItem(
            "wildwood_blister",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.CORAL));
    public static Block BUNNY_CATCHER = blockAndItem(
            "bunny_catcher",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.ROOTS));
    public static Block SMALL_TEETH = blockAndItem(
            "small_teeth",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.BONE, true));
    public static Block GIANT_TOOTH = blockAndItem(
            "giant_tooth",
            GiantToothBlock::new,
            outgrowthsSettings(BlockSoundGroup.BONE, true));
    public static Block TALL_WILDWOOD_GRASS = blockAndItem(
            "tall_wildwood_grass",
            TallSodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.GRASS).replaceable());
    public static Block ROTTING_WILDWOOD_GRASS = blockAndItem(
            "rotting_wildwood_grass",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.WET_GRASS).replaceable());
    public static Block ROTTEN_WILDWOOD_GRASS = blockAndItem(
            "rotten_wildwood_grass",
            SodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.WET_GRASS).replaceable());
    public static Block ROTTEN_GIANT_TOOTH = blockAndItem(
            "rotten_giant_tooth",
            TallSodPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.ROOTS, true));
    public static Block VOLLON_NOODLES = blockAndItem(
            "vollon_noodles",
            VollonPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.CORAL));
    public static Block VOLLON_BRONCHI = blockAndItem(
            "vollon_bronchi",
            VollonPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.CORAL));
    public static Block VOLLON_STRINGS = blockAndItem(
            "vollon_strings",
            VollonPlantBlock::new,
            outgrowthsSettings(BlockSoundGroup.CORAL).replaceable());
    public static Block HANGING_TENDON = blockAndItem(
            "hanging_tendon",
            HangingTendonBlock::new,
            outgrowthsSettings(BlockSoundGroup.SHROOMLIGHT));
    public static Block WILDWOOD_LOG = blockAndItem(
            "wildwood_log",
            PillarBlock::new,
            wildwoodLogSettings());
    public static Block WILDWOOD_WOOD = blockAndItem(
            "wildwood_wood",
            PillarBlock::new,
            wildwoodWoodSettings());
    public static Block STRIPPED_WILDWOOD_LOG = blockAndItem(
            "stripped_wildwood_log",
            PillarBlock::new,
            wildwoodLogSettings());
    public static Block STRIPPED_WILDWOOD_WOOD = blockAndItem(
            "stripped_wildwood_wood",
            PillarBlock::new,
            wildwoodWoodSettings());
    public static Block WILDWOOD_PLANKS = blockAndItem(
            "wildwood_planks",
            wildwoodWoodenSettings());
    public static Block WILDWOOD_SLAB = blockAndItem(
            "wildwood_slab",
            SlabBlock::new,
            wildwoodWoodenSettings());
    public static Block WILDWOOD_STAIRS = blockAndItem(
            "wildwood_stairs",
            s -> new StairsBlock(WILDWOOD_PLANKS.getDefaultState(), s),
            wildwoodWoodenSettings());
    public static Block WILDWOOD_BUTTON = blockAndItem(
            "wildwood_button",
            s -> new ButtonBlock(TitaniumBlockSetTypes.WILDWOOD, 30, s),
            wildwoodButtonSettings());
    public static Block WILDWOOD_PRESSURE_PLATE = blockAndItem(
            "wildwood_pressure_plate",
            s -> new PressurePlateBlock(TitaniumBlockSetTypes.WILDWOOD, s),
            wildwoodPressurePlateSettings());
    public static Block WILDWOOD_DOOR = blockAndItem(
            "wildwood_door",
            s -> new DoorBlock(TitaniumBlockSetTypes.WILDWOOD, s),
            wildwoodDoorSettings());
    public static Block WILDWOOD_TRAPDOOR = blockAndItem(
            "wildwood_trapdoor",
            s -> new TrapdoorBlock(TitaniumBlockSetTypes.WILDWOOD, s),
            wildwoodTrapdoorSettings());
    public static Block WILDWOOD_FENCE = blockAndItem(
            "wildwood_fence",
            FenceBlock::new,
            wildwoodFenceSettings());
    public static Block WILDWOOD_FENCE_GATE = blockAndItem(
            "wildwood_fence_gate",
            s -> new FenceGateBlock(TitaniumWoodTypes.WILDWOOD, s),
            wildwoodFenceSettings());
    public static Block WILDWOOD_LEAVES = blockAndItem(
            "wildwood_leaves",
            s -> createLeavesBlock(0.08F, s),
            leavesSettings(BlockSoundGroup.GRASS, MapColor.DULL_PINK));
    public static Block WILDWOOD_SAPLING = blockAndItem(
            "wildwood_sapling",
            s -> new WildwoodSaplingBlock(null, s),
            wildwoodSaplingSettings());

    protected static Block blockAndItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = block(name, factory, settings);
        TitaniumItems.item(name, itemSettings -> new BlockItem(block, itemSettings), TitaniumItems.createBlockItemSettingFor(block));
        return block;
    }

    protected static Block blockAndItem(String name, AbstractBlock.Settings settings) {
        return blockAndItem(name, Block::new, settings);
    }

    public static Block block(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        //? if 1.21.8 {
        /*settings = settings.registryKey(key);
         *///?}
        Block block = factory.apply(settings);
        return Registry.register(Registries.BLOCK, key, block);
    }

    public static Block block(RegistryKey<Block> key, AbstractBlock.Settings settings) {
        return block(key, Block::new, settings);
    }

    private static Block block(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return block(RegistryKey.of(RegistryKeys.BLOCK, Titanium.id(name)), factory, settings);
    }

    private static Block block(String name, AbstractBlock.Settings settings) {
        return block(name, Block::new, settings);
    }

    private static AbstractBlock.Settings settings(MapColor mapColor, BlockSoundGroup soundGroup) {
        return AbstractBlock.Settings.create()
                .mapColor(mapColor)
                .sounds(soundGroup);
    }

    private static AbstractBlock.Settings settings(MapColor mapColor, BlockSoundGroup soundGroup, float strength) {
        return settings(mapColor, soundGroup)
                .strength(strength);
    }

    private static AbstractBlock.Settings settings(MapColor mapColor, BlockSoundGroup soundGroup, float hardness, float resistance) {
        return settings(mapColor, soundGroup)
                .strength(hardness, resistance);
    }

    @SuppressWarnings({"unused", "SameParameterValue"})
    private static LeavesBlock createLeavesBlock(float leafParticleChance, AbstractBlock.Settings settings) {
        //? if 1.21.8 {
        /*return new TintedParticleLeavesBlock(leafParticleChance, settings);
         *///?} else {
        return new LeavesBlock(settings);
        //?}
    }

    @SuppressWarnings("SameParameterValue")
    private static AbstractBlock.Settings liquidSettings(MapColor mapColor) {
        return settings(mapColor, BlockSoundGroup.INTENTIONALLY_EMPTY, 100.0F)
                .replaceable()
                .noCollision()
                .pistonBehavior(PistonBehavior.DESTROY)
                .dropsNothing()
                .liquid();
    }

    public static AbstractBlock.Settings leavesSettings(BlockSoundGroup sounds, MapColor mapColor) {
        return settings(mapColor, sounds, 0.2F)
                .ticksRandomly()
                .nonOpaque()
                .allowsSpawning(Blocks::canSpawnOnLeaves)
                .suffocates(Blocks::never)
                .blockVision(Blocks::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(Blocks::never);
    }

    public static AbstractBlock.Settings logSettings(MapColor topMapColor, MapColor sideMapColor, BlockSoundGroup sounds) {
        return woodenSettings(sounds)
                .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .strength(2.0F);
    }

    public static AbstractBlock.Settings woodSettings(BlockSoundGroup sounds) {
        return woodenSettings(sounds)
                .strength(2.0F);
    }

    public static AbstractBlock.Settings woodenSettings(BlockSoundGroup sounds) {
        return settings(MapColor.DULL_RED, sounds, 2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .burnable();
    }

    public static AbstractBlock.Settings outgrowthsSettings(BlockSoundGroup sounds) {
        return outgrowthsSettings(sounds, false);
    }

    public static AbstractBlock.Settings outgrowthsSettings(BlockSoundGroup sounds, boolean isStrong) {
        return settings(MapColor.TERRACOTTA_RED, sounds, isStrong ? 0.45F : 0.0F)
                .noCollision()
                .offset(AbstractBlock.OffsetType.XZ)
                .pistonBehavior(PistonBehavior.DESTROY);
    }

    public static AbstractBlock.Settings createSoilSettings(MapColor mapColor, BlockSoundGroup sounds, boolean isTopSoil) {
        return settings(mapColor, sounds, isTopSoil ? 0.6F : 0.5F);
    }

    private static AbstractBlock.Settings wildwoodLogSettings() {
        return logSettings(MapColor.DULL_RED, MapColor.DULL_RED, BlockSoundGroup.NETHER_WOOD);
    }

    private static AbstractBlock.Settings wildwoodWoodSettings() {
        return woodSettings(BlockSoundGroup.NETHER_WOOD);
    }

    private static AbstractBlock.Settings wildwoodWoodenSettings() {
        return woodenSettings(BlockSoundGroup.NETHER_WOOD);
    }

    private static AbstractBlock.Settings wildwoodFenceSettings() {
        return settings(MapColor.DULL_RED, BlockSoundGroup.NETHER_WOOD, 2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .burnable()
                .solid();
    }

    private static AbstractBlock.Settings wildwoodDoorSettings() {
        return settings(MapColor.DULL_RED, BlockSoundGroup.NETHER_WOOD, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .nonOpaque()
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY);
    }

    private static AbstractBlock.Settings wildwoodTrapdoorSettings() {
        return wildwoodDoorSettings()
                .allowsSpawning(Blocks::never);
    }

    private static AbstractBlock.Settings wildwoodSaplingSettings() {
        return settings(MapColor.TERRACOTTA_RED, BlockSoundGroup.GRASS)
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY);
    }

    private static AbstractBlock.Settings wildwoodButtonSettings() {
        return settings(MapColor.CLEAR, BlockSoundGroup.NETHER_WOOD, 0.5F)
                .noCollision()
                .pistonBehavior(PistonBehavior.DESTROY);
    }

    private static AbstractBlock.Settings wildwoodPressurePlateSettings() {
        return settings(MapColor.CLEAR, BlockSoundGroup.NETHER_WOOD, 0.5F)
                .solid()
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY);
    }

    public static void initialize() {
    }
}
