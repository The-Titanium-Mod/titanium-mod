package net.rotgruengelb.titanium.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.core.Direction;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItems;

//? if 1.21.8 {

/*import net.minecraft.world.level.block.TintedParticleLeavesBlock;
 *///?}

import java.util.function.Function;

import static net.rotgruengelb.titanium.block.TitaniumBlockTypes.TitaniumBlockSetTypes;
import static net.rotgruengelb.titanium.block.TitaniumBlockTypes.TitaniumWoodTypes;

public class TitaniumBlocks {

    public static final Block BLOOD = block(
            "blood",
            s -> new LiquidBlock(TitaniumFluids.BLOOD, s),
            liquidSettings(MapColor.NETHER));
    public static Block CLART = blockAndItem(
            "clart",
            createSoilSettings(MapColor.TERRACOTTA_BLACK, SoundType.ROOTED_DIRT, false));
    public static Block SOD = blockAndItem(
            "sod",
            SodBlock::new,
            createSoilSettings(MapColor.COLOR_PINK, SoundType.NYLIUM, true)
                    .randomTicks());
    public static Block SOD_BATCH = blockAndItem(
            "sod_batch",
            createSoilSettings(MapColor.COLOR_PINK, SoundType.GRASS, true));
    public static Block ROTTEN_SOD = blockAndItem(
            "rotten_sod",
            RottenSodBlock::new,
            createSoilSettings(MapColor.TERRACOTTA_PURPLE, SoundType.NYLIUM, true)
                    .randomTicks());
    public static Block ROTTEN_SOD_BATCH = blockAndItem(
            "rotten_sod_batch",
            createSoilSettings(MapColor.TERRACOTTA_PURPLE, SoundType.GRASS, true));
    public static Block VEINY_CLART = blockAndItem(
            "veiny_clart",
            createSoilSettings(MapColor.TERRACOTTA_BLACK, SoundType.ROOTED_DIRT, false));
    public static Block VEINY_SOD = blockAndItem(
            "veiny_sod",
            createSoilSettings(MapColor.COLOR_PINK, SoundType.NYLIUM, true));
    public static Block BRAWN = blockAndItem(
            "brawn",
            settings(MapColor.COLOR_BLACK, SoundType.MUD, 1.5F, 6.0F)
                    .requiresCorrectToolForDrops());
    public static Block TENDON = blockAndItem(
            "tendon",
            settings(MapColor.NETHER, SoundType.SHROOMLIGHT, 1.3F, 5.0F));
    public static Block BLUE_VOLLON = blockAndItem(
            "blue_vollon",
            settings(MapColor.DIAMOND, SoundType.PACKED_MUD, 0.95F));
    public static Block RED_VOLLON = blockAndItem(
            "red_vollon",
            settings(MapColor.TERRACOTTA_RED, SoundType.PACKED_MUD, 0.95F));
    public static Block SALT = blockAndItem(
            "salt",
            createSoilSettings(MapColor.QUARTZ, SoundType.SAND, true)
                    .requiresCorrectToolForDrops());
    public static Block SHORT_WILDWOOD_GRASS = blockAndItem(
            "short_wildwood_grass",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.GRASS).replaceable());
    public static Block WILDWOOD_LUMEN = blockAndItem(
            "wildwood_lumen",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.GRASS)
                    .lightLevel(state -> 8));
    public static Block WILDWOOD_BLISTER = blockAndItem(
            "wildwood_blister",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.CORAL_BLOCK));
    public static Block BUNNY_CATCHER = blockAndItem(
            "bunny_catcher",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.ROOTS));
    public static Block SMALL_TEETH = blockAndItem(
            "small_teeth",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.BONE_BLOCK, true));
    public static Block GIANT_TOOTH = blockAndItem(
            "giant_tooth",
            GiantToothBlock::new,
            outgrowthsSettings(SoundType.BONE_BLOCK, true));
    public static Block TALL_WILDWOOD_GRASS = blockAndItem(
            "tall_wildwood_grass",
            TallSodPlantBlock::new,
            outgrowthsSettings(SoundType.GRASS).replaceable());
    public static Block ROTTING_WILDWOOD_GRASS = blockAndItem(
            "rotting_wildwood_grass",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.WET_GRASS).replaceable());
    public static Block ROTTEN_WILDWOOD_GRASS = blockAndItem(
            "rotten_wildwood_grass",
            SodPlantBlock::new,
            outgrowthsSettings(SoundType.WET_GRASS).replaceable());
    public static Block ROTTEN_GIANT_TOOTH = blockAndItem(
            "rotten_giant_tooth",
            TallSodPlantBlock::new,
            outgrowthsSettings(SoundType.ROOTS, true));
    public static Block VOLLON_NOODLES = blockAndItem(
            "vollon_noodles",
            VollonPlantBlock::new,
            outgrowthsSettings(SoundType.CORAL_BLOCK));
    public static Block VOLLON_BRONCHI = blockAndItem(
            "vollon_bronchi",
            VollonPlantBlock::new,
            outgrowthsSettings(SoundType.CORAL_BLOCK));
    public static Block VOLLON_STRINGS = blockAndItem(
            "vollon_strings",
            VollonPlantBlock::new,
            outgrowthsSettings(SoundType.CORAL_BLOCK).replaceable());
    public static Block HANGING_TENDON = blockAndItem(
            "hanging_tendon",
            HangingTendonBlock::new,
            outgrowthsSettings(SoundType.SHROOMLIGHT));
    public static Block WILDWOOD_LOG = blockAndItem(
            "wildwood_log",
            RotatedPillarBlock::new,
            wildwoodLogSettings());
    public static Block WILDWOOD_WOOD = blockAndItem(
            "wildwood_wood",
            RotatedPillarBlock::new,
            wildwoodWoodSettings());
    public static Block STRIPPED_WILDWOOD_LOG = blockAndItem(
            "stripped_wildwood_log",
            RotatedPillarBlock::new,
            wildwoodLogSettings());
    public static Block STRIPPED_WILDWOOD_WOOD = blockAndItem(
            "stripped_wildwood_wood",
            RotatedPillarBlock::new,
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
            s -> new StairBlock(WILDWOOD_PLANKS.defaultBlockState(), s),
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
            s -> new TrapDoorBlock(TitaniumBlockSetTypes.WILDWOOD, s),
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
            leavesSettings(SoundType.GRASS, MapColor.CRIMSON_STEM));
    public static Block WILDWOOD_SAPLING = blockAndItem(
            "wildwood_sapling",
            s -> new WildwoodSaplingBlock(null, s),
            wildwoodSaplingSettings());

    private static Block blockAndItem(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = block(name, factory, settings);
        TitaniumItems.item(name, itemSettings -> new BlockItem(block, itemSettings), TitaniumItems.blockItemSettingFor(block));
        return block;
    }

    private static Block blockAndItem(String name, BlockBehaviour.Properties settings) {
        return blockAndItem(name, Block::new, settings);
    }

    private static Block block(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        //? if 1.21.8 {
        /*settings = settings.setId(key);
         *///?}
        Block block = factory.apply(settings);
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static Block block(ResourceKey<Block> key, BlockBehaviour.Properties settings) {
        return block(key, Block::new, settings);
    }

    private static Block block(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return block(ResourceKey.create(Registries.BLOCK, Titanium.id(name)), factory, settings);
    }

    private static Block block(String name, BlockBehaviour.Properties settings) {
        return block(name, Block::new, settings);
    }

    private static BlockBehaviour.Properties settings(MapColor mapColor, SoundType soundGroup) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .sound(soundGroup);
    }

    private static BlockBehaviour.Properties settings(MapColor mapColor, SoundType soundGroup, float strength) {
        return settings(mapColor, soundGroup)
                .strength(strength);
    }

    private static BlockBehaviour.Properties settings(MapColor mapColor, SoundType soundGroup, float hardness, float resistance) {
        return settings(mapColor, soundGroup)
                .strength(hardness, resistance);
    }

    @SuppressWarnings({"unused", "SameParameterValue"})
    private static LeavesBlock createLeavesBlock(float leafParticleChance, BlockBehaviour.Properties settings) {
        //? if 1.21.8 {
        /*return new TintedParticleLeavesBlock(leafParticleChance, settings);
         *///?} else {
        return new LeavesBlock(settings);
        //?}
    }

    @SuppressWarnings("SameParameterValue")
    private static BlockBehaviour.Properties liquidSettings(MapColor mapColor) {
        return settings(mapColor, SoundType.EMPTY, 100.0F)
                .replaceable()
                .noCollission()
                .pushReaction(PushReaction.DESTROY)
                .noLootTable()
                .liquid();
    }

    public static BlockBehaviour.Properties leavesSettings(SoundType sounds, MapColor mapColor) {
        return settings(mapColor, sounds, 0.2F)
                .randomTicks()
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(Blocks::never)
                .isViewBlocking(Blocks::never)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(Blocks::never);
    }

    private static BlockBehaviour.Properties logSettings(MapColor topMapColor, MapColor sideMapColor, SoundType sounds) {
        return woodenSettings(sounds)
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .strength(2.0F);
    }

    private static BlockBehaviour.Properties woodSettings(SoundType sounds) {
        return woodenSettings(sounds)
                .strength(2.0F);
    }

    private static BlockBehaviour.Properties woodenSettings(SoundType sounds) {
        return settings(MapColor.CRIMSON_NYLIUM, sounds, 2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .ignitedByLava();
    }

    private static BlockBehaviour.Properties outgrowthsSettings(SoundType sounds) {
        return outgrowthsSettings(sounds, false);
    }

    private static BlockBehaviour.Properties outgrowthsSettings(SoundType sounds, boolean isStrong) {
        return settings(MapColor.TERRACOTTA_RED, sounds, isStrong ? 0.45F : 0.0F)
                .noCollission()
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties createSoilSettings(MapColor mapColor, SoundType sounds, boolean isTopSoil) {
        return settings(mapColor, sounds, isTopSoil ? 0.6F : 0.5F);
    }

    private static BlockBehaviour.Properties wildwoodLogSettings() {
        return logSettings(MapColor.CRIMSON_NYLIUM, MapColor.CRIMSON_NYLIUM, SoundType.NETHER_WOOD);
    }

    private static BlockBehaviour.Properties wildwoodWoodSettings() {
        return woodSettings(SoundType.NETHER_WOOD);
    }

    private static BlockBehaviour.Properties wildwoodWoodenSettings() {
        return woodenSettings(SoundType.NETHER_WOOD);
    }

    private static BlockBehaviour.Properties wildwoodFenceSettings() {
        return settings(MapColor.CRIMSON_NYLIUM, SoundType.NETHER_WOOD, 2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .ignitedByLava()
                .forceSolidOn();
    }

    private static BlockBehaviour.Properties wildwoodDoorSettings() {
        return settings(MapColor.CRIMSON_NYLIUM, SoundType.NETHER_WOOD, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .noOcclusion()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties wildwoodTrapdoorSettings() {
        return wildwoodDoorSettings()
                .isValidSpawn(Blocks::never);
    }

    private static BlockBehaviour.Properties wildwoodSaplingSettings() {
        return settings(MapColor.TERRACOTTA_RED, SoundType.GRASS)
                .noCollission()
                .randomTicks()
                .instabreak()
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties wildwoodButtonSettings() {
        return settings(MapColor.NONE, SoundType.NETHER_WOOD, 0.5F)
                .noCollission()
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties wildwoodPressurePlateSettings() {
        return settings(MapColor.NONE, SoundType.NETHER_WOOD, 0.5F)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY);
    }

    public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumBlocks");
    }
}
