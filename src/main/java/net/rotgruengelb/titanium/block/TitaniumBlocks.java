package net.rotgruengelb.titanium.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static net.rotgruengelb.titanium.block.TitaniumBlockTypes.TitaniumBlockSetTypes;
import static net.rotgruengelb.titanium.block.TitaniumBlockTypes.TitaniumWoodTypes;

public class TitaniumBlocks {

    public static final Block BLOOD = block(
            "blood",
            s -> new FluidBlock(TitaniumFluids.BLOOD, s),
            createSettings()
                    .mapColor(MapColor.DARK_RED)
                    .replaceable()
                    .noCollision()
                    .strength(100.0F)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .dropsNothing()
                    .liquid()
                    .sounds(BlockSoundGroup.INTENTIONALLY_EMPTY));
    public static Block CLART = blockAndItem(
            "clart", Block::new, createSettings().sounds(BlockSoundGroup.ROOTED_DIRT));
    public static Block SOD = blockAndItem(
            "sod", Block::new, createSettings().sounds(BlockSoundGroup.NYLIUM));
    public static Block SOD_BATCH = blockAndItem(
            "sod_batch", Block::new, createSettings().sounds(BlockSoundGroup.GRASS));
    public static Block ROTTEN_SOD = blockAndItem(
            "rotten_sod", Block::new, createSettings().sounds(BlockSoundGroup.NYLIUM));
    public static Block ROTTEN_SOD_BATCH = blockAndItem(
            "rotten_sod_batch", Block::new, createSettings().sounds(BlockSoundGroup.GRASS));
    public static Block VEINY_CLART = blockAndItem(
            "veiny_clart", Block::new, createSettings().sounds(BlockSoundGroup.ROOTED_DIRT));
    public static Block VEINY_SOD = blockAndItem(
            "veiny_sod", Block::new, createSettings().sounds(BlockSoundGroup.NYLIUM));
    public static Block BRAWN = blockAndItem(
            "brawn", Block::new, createSettings().sounds(BlockSoundGroup.MUD));
    public static Block TENDON = blockAndItem(
            "tendon", Block::new, createSettings().sounds(BlockSoundGroup.SHROOMLIGHT));
    public static Block BLUE_VOLLON = blockAndItem(
            "blue_vollon", Block::new, createSettings().sounds(BlockSoundGroup.PACKED_MUD));
    public static Block RED_VOLLON = blockAndItem(
            "red_vollon", Block::new, createSettings().sounds(BlockSoundGroup.PACKED_MUD));
    public static Block SALT = blockAndItem(
            "salt", Block::new, createSettings().sounds(BlockSoundGroup.SAND));
    public static Block WILDWOOD_GRASS = blockAndItem(
            "wildwood_grass",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.GRASS));
    public static Block WILDWOOD_LUMEN = blockAndItem(
            "wildwood_lumen",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.GRASS)
                    .luminance(state -> 8));
    public static Block WILDWOOD_BLISTER = blockAndItem(
            "wildwood_blister",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.CORAL));
    public static Block BUNNY_CATCHER = blockAndItem(
            "bunny_catcher",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.ROOTS));
    public static Block SMALL_TEETH = blockAndItem(
            "small_teeth",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.BONE));
    public static Block GIANT_TOOTH = blockAndItem(
            "giant_tooth",
            GiantToothBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.BONE));
    public static Block TALL_WILDWOOD_GRASS = blockAndItem(
            "tall_wildwood_grass",
            TallSodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.GRASS));
    public static Block ROTTING_WILDWOOD_GRASS = blockAndItem(
            "rotting_wildwood_grass",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.WET_GRASS));
    public static Block ROTTEN_WILDWOOD_GRASS = blockAndItem(
            "rotten_wildwood_grass",
            SodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.WET_GRASS));
    public static Block ROTTEN_TOOTH = blockAndItem(
            "rotten_tooth",
            TallSodPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.ROOTS));
    public static Block VOLLON_NOODLES = blockAndItem(
            "vollon_noodles",
            VollonPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.CORAL));

    public static Block VOLLON_BRONCHI = blockAndItem(
            "vollon_bronchi",
            VollonPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.CORAL));
    public static Block VOLLON_STRINGS = blockAndItem(
            "vollon_strings",
            VollonPlantBlock::new,
            createOutgrowthsSettings(BlockSoundGroup.CORAL));
    public static Block HANGING_TENDON = blockAndItem(
            "hanging_tendon", HangingTendonBlock::new, createSettings().sounds(BlockSoundGroup.SHROOMLIGHT));
    public static Block WILDWOOD_LOG = blockAndItem(
            "wildwood_log",
            PillarBlock::new,
            createLogSettings(MapColor.DULL_RED, MapColor.DULL_RED, BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_WOOD = blockAndItem(
            "wildwood_wood", PillarBlock::new, createSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block STRIPPED_WILDWOOD_LOG = blockAndItem(
            "stripped_wildwood_log",
            PillarBlock::new,
            createLogSettings(MapColor.DULL_RED, MapColor.DULL_RED, BlockSoundGroup.NETHER_WOOD));
    public static Block STRIPPED_WILDWOOD_WOOD = blockAndItem(
            "stripped_wildwood_wood", PillarBlock::new, createSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_PLANKS = blockAndItem(
            "wildwood_planks", Block::new, createSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_SLAB = blockAndItem(
            "wildwood_slab", SlabBlock::new, createSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_STAIRS = blockAndItem(
            "wildwood_stairs",
            s -> new StairsBlock(WILDWOOD_PLANKS.getDefaultState(), s),
            AbstractBlock.Settings.copyShallow(WILDWOOD_PLANKS));
    public static Block WILDWOOD_BUTTON = blockAndItem(
            "wildwood_button",
            s -> new ButtonBlock(TitaniumBlockSetTypes.WILDWOOD, 30, s),
            createButtonSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_PRESSURE_PLATE = blockAndItem(
            "wildwood_pressure_plate",
            s -> new PressurePlateBlock(TitaniumBlockSetTypes.WILDWOOD, s),
            createSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_DOOR = blockAndItem(
            "wildwood_door",
            s -> new DoorBlock(TitaniumBlockSetTypes.WILDWOOD, s),
            createSettings().sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque());
    public static Block WILDWOOD_TRAPDOOR = blockAndItem(
            "wildwood_trapdoor",
            s -> new TrapdoorBlock(TitaniumBlockSetTypes.WILDWOOD, s),
            createSettings()
                    .sounds(BlockSoundGroup.NETHER_WOOD)
                    .allowsSpawning(Blocks::never)
                    .nonOpaque());
    public static Block WILDWOOD_FENCE = blockAndItem(
            "wildwood_fence",
            FenceBlock::new,
            createSettings().sounds(BlockSoundGroup.NETHER_WOOD).solid());
    public static Block WILDWOOD_FENCE_GATE = blockAndItem(
            "wildwood_fence_gate",
            s -> new FenceGateBlock(TitaniumWoodTypes.WILDWOOD, s),
            createSettings().sounds(BlockSoundGroup.NETHER_WOOD));
    public static Block WILDWOOD_LEAVES = blockAndItem(
            "wildwood_leaves",
            s -> createLeavesBlock(0.005F, s),
            createLeavesSettings(BlockSoundGroup.GRASS, MapColor.DULL_PINK));
    public static Block WILDWOOD_SAPLING = blockAndItem(
            "wildwood_sapling",
            s -> new WildwoodSaplingBlock(null, s),
            createSettings().sounds(BlockSoundGroup.GRASS).noCollision());

    protected static Block blockAndItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = block(name, factory, settings);
        TitaniumItems.item(name, itemSettings -> new BlockItem(block, itemSettings), TitaniumItems.createBlockItemSettingFor(block));
        return block;
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

    private static AbstractBlock.@NotNull Settings createSettings() {
        return AbstractBlock.Settings.create();
    }

    @SuppressWarnings("unused")
    private static LeavesBlock createLeavesBlock(float leafParticleChance, AbstractBlock.Settings settings) {
        //? if 1.21.8 {
        /*return new TintedParticleLeavesBlock(leafParticleChance, settings);
        *///?} else {
        return new LeavesBlock(settings);
        //?}
    }

    public static AbstractBlock.Settings createLeavesSettings(BlockSoundGroup sounds, MapColor mapColor) {
        return createSettings()
                .mapColor(mapColor)
                .strength(0.2F)
                .ticksRandomly()
                .sounds(sounds)
                .nonOpaque()
                .allowsSpawning(Blocks::canSpawnOnLeaves)
                .suffocates(Blocks::never)
                .blockVision(Blocks::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(Blocks::never);
    }

    public static AbstractBlock.Settings createLogSettings(MapColor topMapColor, MapColor sideMapColor, BlockSoundGroup sounds) {
        return AbstractBlock.Settings.create()
                .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(sounds)
                .burnable();
    }

    public static AbstractBlock.Settings createOutgrowthsSettings(BlockSoundGroup sounds) {
        return createSettings()
                .sounds(sounds)
                .noCollision()
                .offset(AbstractBlock.OffsetType.XZ)
                .pistonBehavior(PistonBehavior.DESTROY);
    }

    public static AbstractBlock.Settings createButtonSettings() {
        return createSettings().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY);
    }

	public static void initialize() { }
}
