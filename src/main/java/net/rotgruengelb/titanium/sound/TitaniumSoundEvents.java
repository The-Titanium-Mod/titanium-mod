package net.rotgruengelb.titanium.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumSoundEvents {

    public static final SoundEvent BLOCK_CLART_BREAK = soundEvent("block.clart.break");
    public static final SoundEvent BLOCK_CLART_STEP = soundEvent("block.clart.step");
    public static final SoundEvent BLOCK_CLART_PLACE = soundEvent("block.clart.place");
    public static final SoundEvent BLOCK_CLART_HIT = soundEvent("block.clart.hit");
    public static final SoundEvent BLOCK_CLART_FALL = soundEvent("block.clart.fall");

    public static final SoundEvent BLOCK_SOD_BREAK = soundEvent("block.sod.break");
    public static final SoundEvent BLOCK_SOD_STEP = soundEvent("block.sod.step");
    public static final SoundEvent BLOCK_SOD_PLACE = soundEvent("block.sod.place");
    public static final SoundEvent BLOCK_SOD_HIT = soundEvent("block.sod.hit");
    public static final SoundEvent BLOCK_SOD_FALL = soundEvent("block.sod.fall");

    public static final SoundEvent BLOCK_SOD_BATCH_BREAK = soundEvent("block.sod_batch.break");
    public static final SoundEvent BLOCK_SOD_BATCH_STEP = soundEvent("block.sod_batch.step");
    public static final SoundEvent BLOCK_SOD_BATCH_PLACE = soundEvent("block.sod_batch.place");
    public static final SoundEvent BLOCK_SOD_BATCH_HIT = soundEvent("block.sod_batch.hit");
    public static final SoundEvent BLOCK_SOD_BATCH_FALL = soundEvent("block.sod_batch.fall");

    public static final SoundEvent BLOCK_ROTTEN_SOD_BREAK = soundEvent("block.rotten_sod.break");
    public static final SoundEvent BLOCK_ROTTEN_SOD_STEP = soundEvent("block.rotten_sod.step");
    public static final SoundEvent BLOCK_ROTTEN_SOD_PLACE = soundEvent("block.rotten_sod.place");
    public static final SoundEvent BLOCK_ROTTEN_SOD_HIT = soundEvent("block.rotten_sod.hit");
    public static final SoundEvent BLOCK_ROTTEN_SOD_FALL = soundEvent("block.rotten_sod.fall");

    public static final SoundEvent BLOCK_ROTTEN_SOD_BATCH_BREAK = soundEvent("block.rotten_sod_batch.break");
    public static final SoundEvent BLOCK_ROTTEN_SOD_BATCH_STEP = soundEvent("block.rotten_sod_batch.step");
    public static final SoundEvent BLOCK_ROTTEN_SOD_BATCH_PLACE = soundEvent("block.rotten_sod_batch.place");
    public static final SoundEvent BLOCK_ROTTEN_SOD_BATCH_HIT = soundEvent("block.rotten_sod_batch.hit");
    public static final SoundEvent BLOCK_ROTTEN_SOD_BATCH_FALL = soundEvent("block.rotten_sod_batch.fall");

    public static final SoundEvent BLOCK_VEINY_CLART_BREAK = soundEvent("block.veiny_clart.break");
    public static final SoundEvent BLOCK_VEINY_CLART_STEP = soundEvent("block.veiny_clart.step");
    public static final SoundEvent BLOCK_VEINY_CLART_PLACE = soundEvent("block.veiny_clart.place");
    public static final SoundEvent BLOCK_VEINY_CLART_HIT = soundEvent("block.veiny_clart.hit");
    public static final SoundEvent BLOCK_VEINY_CLART_FALL = soundEvent("block.veiny_clart.fall");

    public static final SoundEvent BLOCK_VEINY_SOD_BREAK = soundEvent("block.veiny_sod.break");
    public static final SoundEvent BLOCK_VEINY_SOD_STEP = soundEvent("block.veiny_sod.step");
    public static final SoundEvent BLOCK_VEINY_SOD_PLACE = soundEvent("block.veiny_sod.place");
    public static final SoundEvent BLOCK_VEINY_SOD_HIT = soundEvent("block.veiny_sod.hit");
    public static final SoundEvent BLOCK_VEINY_SOD_FALL = soundEvent("block.veiny_sod.fall");

    public static final SoundEvent BLOCK_BRAWN_BREAK = soundEvent("block.brawn.break");
    public static final SoundEvent BLOCK_BRAWN_STEP = soundEvent("block.brawn.step");
    public static final SoundEvent BLOCK_BRAWN_PLACE = soundEvent("block.brawn.place");
    public static final SoundEvent BLOCK_BRAWN_HIT = soundEvent("block.brawn.hit");
    public static final SoundEvent BLOCK_BRAWN_FALL = soundEvent("block.brawn.fall");

    public static final SoundEvent BLOCK_TENDON_BREAK = soundEvent("block.tendon.break");
    public static final SoundEvent BLOCK_TENDON_STEP = soundEvent("block.tendon.step");
    public static final SoundEvent BLOCK_TENDON_PLACE = soundEvent("block.tendon.place");
    public static final SoundEvent BLOCK_TENDON_HIT = soundEvent("block.tendon.hit");
    public static final SoundEvent BLOCK_TENDON_FALL = soundEvent("block.tendon.fall");

    public static final SoundEvent BLOCK_BLUE_VOLLON_BREAK = soundEvent("block.blue_vollon.break");
    public static final SoundEvent BLOCK_BLUE_VOLLON_STEP = soundEvent("block.blue_vollon.step");
    public static final SoundEvent BLOCK_BLUE_VOLLON_PLACE = soundEvent("block.blue_vollon.place");
    public static final SoundEvent BLOCK_BLUE_VOLLON_HIT = soundEvent("block.blue_vollon.hit");
    public static final SoundEvent BLOCK_BLUE_VOLLON_FALL = soundEvent("block.blue_vollon.fall");

    public static final SoundEvent BLOCK_RED_VOLLON_BREAK = soundEvent("block.red_vollon.break");
    public static final SoundEvent BLOCK_RED_VOLLON_STEP = soundEvent("block.red_vollon.step");
    public static final SoundEvent BLOCK_RED_VOLLON_PLACE = soundEvent("block.red_vollon.place");
    public static final SoundEvent BLOCK_RED_VOLLON_HIT = soundEvent("block.red_vollon.hit");
    public static final SoundEvent BLOCK_RED_VOLLON_FALL = soundEvent("block.red_vollon.fall");

    public static final SoundEvent BLOCK_SALT_BREAK = soundEvent("block.salt.break");
    public static final SoundEvent BLOCK_SALT_STEP = soundEvent("block.salt.step");
    public static final SoundEvent BLOCK_SALT_PLACE = soundEvent("block.salt.place");
    public static final SoundEvent BLOCK_SALT_HIT = soundEvent("block.salt.hit");
    public static final SoundEvent BLOCK_SALT_FALL = soundEvent("block.salt.fall");

    public static final SoundEvent BLOCK_SHORT_WILDWOOD_GRASS_BREAK = soundEvent("block.short_wildwood_grass.break");
    public static final SoundEvent BLOCK_SHORT_WILDWOOD_GRASS_STEP = soundEvent("block.short_wildwood_grass.step");
    public static final SoundEvent BLOCK_SHORT_WILDWOOD_GRASS_PLACE = soundEvent("block.short_wildwood_grass.place");
    public static final SoundEvent BLOCK_SHORT_WILDWOOD_GRASS_HIT = soundEvent("block.short_wildwood_grass.hit");
    public static final SoundEvent BLOCK_SHORT_WILDWOOD_GRASS_FALL = soundEvent("block.short_wildwood_grass.fall");

    public static final SoundEvent BLOCK_WILDWOOD_LUMEN_BREAK = soundEvent("block.wildwood_lumen.break");
    public static final SoundEvent BLOCK_WILDWOOD_LUMEN_STEP = soundEvent("block.wildwood_lumen.step");
    public static final SoundEvent BLOCK_WILDWOOD_LUMEN_PLACE = soundEvent("block.wildwood_lumen.place");
    public static final SoundEvent BLOCK_WILDWOOD_LUMEN_HIT = soundEvent("block.wildwood_lumen.hit");
    public static final SoundEvent BLOCK_WILDWOOD_LUMEN_FALL = soundEvent("block.wildwood_lumen.fall");

    public static final SoundEvent BLOCK_WILDWOOD_BLISTER_BREAK = soundEvent("block.wildwood_blister.break");
    public static final SoundEvent BLOCK_WILDWOOD_BLISTER_STEP = soundEvent("block.wildwood_blister.step");
    public static final SoundEvent BLOCK_WILDWOOD_BLISTER_PLACE = soundEvent("block.wildwood_blister.place");
    public static final SoundEvent BLOCK_WILDWOOD_BLISTER_HIT = soundEvent("block.wildwood_blister.hit");
    public static final SoundEvent BLOCK_WILDWOOD_BLISTER_FALL = soundEvent("block.wildwood_blister.fall");

    public static final SoundEvent BLOCK_BUNNY_CATCHER_BREAK = soundEvent("block.bunny_catcher.break");
    public static final SoundEvent BLOCK_BUNNY_CATCHER_STEP = soundEvent("block.bunny_catcher.step");
    public static final SoundEvent BLOCK_BUNNY_CATCHER_PLACE = soundEvent("block.bunny_catcher.place");
    public static final SoundEvent BLOCK_BUNNY_CATCHER_HIT = soundEvent("block.bunny_catcher.hit");
    public static final SoundEvent BLOCK_BUNNY_CATCHER_FALL = soundEvent("block.bunny_catcher.fall");

    public static final SoundEvent BLOCK_SMALL_TEETH_BREAK = soundEvent("block.small_teeth.break");
    public static final SoundEvent BLOCK_SMALL_TEETH_STEP = soundEvent("block.small_teeth.step");
    public static final SoundEvent BLOCK_SMALL_TEETH_PLACE = soundEvent("block.small_teeth.place");
    public static final SoundEvent BLOCK_SMALL_TEETH_HIT = soundEvent("block.small_teeth.hit");
    public static final SoundEvent BLOCK_SMALL_TEETH_FALL = soundEvent("block.small_teeth.fall");

    public static final SoundEvent BLOCK_GIANT_TOOTH_BREAK = soundEvent("block.giant_tooth.break");
    public static final SoundEvent BLOCK_GIANT_TOOTH_STEP = soundEvent("block.giant_tooth.step");
    public static final SoundEvent BLOCK_GIANT_TOOTH_PLACE = soundEvent("block.giant_tooth.place");
    public static final SoundEvent BLOCK_GIANT_TOOTH_HIT = soundEvent("block.giant_tooth.hit");
    public static final SoundEvent BLOCK_GIANT_TOOTH_FALL = soundEvent("block.giant_tooth.fall");

    public static final SoundEvent BLOCK_TALL_WILDWOOD_GRASS_BREAK = soundEvent("block.tall_wildwood_grass.break");
    public static final SoundEvent BLOCK_TALL_WILDWOOD_GRASS_STEP = soundEvent("block.tall_wildwood_grass.step");
    public static final SoundEvent BLOCK_TALL_WILDWOOD_GRASS_PLACE = soundEvent("block.tall_wildwood_grass.place");
    public static final SoundEvent BLOCK_TALL_WILDWOOD_GRASS_HIT = soundEvent("block.tall_wildwood_grass.hit");
    public static final SoundEvent BLOCK_TALL_WILDWOOD_GRASS_FALL = soundEvent("block.tall_wildwood_grass.fall");

    public static final SoundEvent BLOCK_ROTTING_WILDWOOD_GRASS_BREAK = soundEvent("block.rotting_wildwood_grass.break");
    public static final SoundEvent BLOCK_ROTTING_WILDWOOD_GRASS_STEP = soundEvent("block.rotting_wildwood_grass.step");
    public static final SoundEvent BLOCK_ROTTING_WILDWOOD_GRASS_PLACE = soundEvent("block.rotting_wildwood_grass.place");
    public static final SoundEvent BLOCK_ROTTING_WILDWOOD_GRASS_HIT = soundEvent("block.rotting_wildwood_grass.hit");
    public static final SoundEvent BLOCK_ROTTING_WILDWOOD_GRASS_FALL = soundEvent("block.rotting_wildwood_grass.fall");

    public static final SoundEvent BLOCK_ROTTEN_WILDWOOD_GRASS_BREAK = soundEvent("block.rotten_wildwood_grass.break");
    public static final SoundEvent BLOCK_ROTTEN_WILDWOOD_GRASS_STEP = soundEvent("block.rotten_wildwood_grass.step");
    public static final SoundEvent BLOCK_ROTTEN_WILDWOOD_GRASS_PLACE = soundEvent("block.rotten_wildwood_grass.place");
    public static final SoundEvent BLOCK_ROTTEN_WILDWOOD_GRASS_HIT = soundEvent("block.rotten_wildwood_grass.hit");
    public static final SoundEvent BLOCK_ROTTEN_WILDWOOD_GRASS_FALL = soundEvent("block.rotten_wildwood_grass.fall");

    public static final SoundEvent BLOCK_ROTTEN_GIANT_TOOTH_BREAK = soundEvent("block.rotten_giant_tooth.break");
    public static final SoundEvent BLOCK_ROTTEN_GIANT_TOOTH_STEP = soundEvent("block.rotten_giant_tooth.step");
    public static final SoundEvent BLOCK_ROTTEN_GIANT_TOOTH_PLACE = soundEvent("block.rotten_giant_tooth.place");
    public static final SoundEvent BLOCK_ROTTEN_GIANT_TOOTH_HIT = soundEvent("block.rotten_giant_tooth.hit");
    public static final SoundEvent BLOCK_ROTTEN_GIANT_TOOTH_FALL = soundEvent("block.rotten_giant_tooth.fall");

    public static final SoundEvent BLOCK_VOLLON_NOODLES_BREAK = soundEvent("block.vollon_noodles.break");
    public static final SoundEvent BLOCK_VOLLON_NOODLES_STEP = soundEvent("block.vollon_noodles.step");
    public static final SoundEvent BLOCK_VOLLON_NOODLES_PLACE = soundEvent("block.vollon_noodles.place");
    public static final SoundEvent BLOCK_VOLLON_NOODLES_HIT = soundEvent("block.vollon_noodles.hit");
    public static final SoundEvent BLOCK_VOLLON_NOODLES_FALL = soundEvent("block.vollon_noodles.fall");

    public static final SoundEvent BLOCK_VOLLON_BRONCHI_BREAK = soundEvent("block.vollon_bronchi.break");
    public static final SoundEvent BLOCK_VOLLON_BRONCHI_STEP = soundEvent("block.vollon_bronchi.step");
    public static final SoundEvent BLOCK_VOLLON_BRONCHI_PLACE = soundEvent("block.vollon_bronchi.place");
    public static final SoundEvent BLOCK_VOLLON_BRONCHI_HIT = soundEvent("block.vollon_bronchi.hit");
    public static final SoundEvent BLOCK_VOLLON_BRONCHI_FALL = soundEvent("block.vollon_bronchi.fall");

    public static final SoundEvent BLOCK_VOLLON_STRINGS_BREAK = soundEvent("block.vollon_strings.break");
    public static final SoundEvent BLOCK_VOLLON_STRINGS_STEP = soundEvent("block.vollon_strings.step");
    public static final SoundEvent BLOCK_VOLLON_STRINGS_PLACE = soundEvent("block.vollon_strings.place");
    public static final SoundEvent BLOCK_VOLLON_STRINGS_HIT = soundEvent("block.vollon_strings.hit");
    public static final SoundEvent BLOCK_VOLLON_STRINGS_FALL = soundEvent("block.vollon_strings.fall");

    public static final SoundEvent BLOCK_HANGING_TENDON_BREAK = soundEvent("block.hanging_tendon.break");
    public static final SoundEvent BLOCK_HANGING_TENDON_STEP = soundEvent("block.hanging_tendon.step");
    public static final SoundEvent BLOCK_HANGING_TENDON_PLACE = soundEvent("block.hanging_tendon.place");
    public static final SoundEvent BLOCK_HANGING_TENDON_HIT = soundEvent("block.hanging_tendon.hit");
    public static final SoundEvent BLOCK_HANGING_TENDON_FALL = soundEvent("block.hanging_tendon.fall");

    public static final SoundEvent BLOCK_WILDWOOD_LOG_BREAK = soundEvent("block.wildwood_log.break");
    public static final SoundEvent BLOCK_WILDWOOD_LOG_STEP = soundEvent("block.wildwood_log.step");
    public static final SoundEvent BLOCK_WILDWOOD_LOG_PLACE = soundEvent("block.wildwood_log.place");
    public static final SoundEvent BLOCK_WILDWOOD_LOG_HIT = soundEvent("block.wildwood_log.hit");
    public static final SoundEvent BLOCK_WILDWOOD_LOG_FALL = soundEvent("block.wildwood_log.fall");

    public static final SoundEvent BLOCK_WILDWOOD_WOOD_BREAK = soundEvent("block.wildwood_wood.break");
    public static final SoundEvent BLOCK_WILDWOOD_WOOD_STEP = soundEvent("block.wildwood_wood.step");
    public static final SoundEvent BLOCK_WILDWOOD_WOOD_PLACE = soundEvent("block.wildwood_wood.place");
    public static final SoundEvent BLOCK_WILDWOOD_WOOD_HIT = soundEvent("block.wildwood_wood.hit");
    public static final SoundEvent BLOCK_WILDWOOD_WOOD_FALL = soundEvent("block.wildwood_wood.fall");

    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_LOG_BREAK = soundEvent("block.stripped_wildwood_log.break");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_LOG_STEP = soundEvent("block.stripped_wildwood_log.step");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_LOG_PLACE = soundEvent("block.stripped_wildwood_log.place");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_LOG_HIT = soundEvent("block.stripped_wildwood_log.hit");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_LOG_FALL = soundEvent("block.stripped_wildwood_log.fall");

    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_WOOD_BREAK = soundEvent("block.stripped_wildwood_wood.break");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_WOOD_STEP = soundEvent("block.stripped_wildwood_wood.step");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_WOOD_PLACE = soundEvent("block.stripped_wildwood_wood.place");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_WOOD_HIT = soundEvent("block.stripped_wildwood_wood.hit");
    public static final SoundEvent BLOCK_STRIPPED_WILDWOOD_WOOD_FALL = soundEvent("block.stripped_wildwood_wood.fall");

    public static final SoundEvent BLOCK_WILDWOOD_PLANKS_BREAK = soundEvent("block.wildwood_planks.break");
    public static final SoundEvent BLOCK_WILDWOOD_PLANKS_STEP = soundEvent("block.wildwood_planks.step");
    public static final SoundEvent BLOCK_WILDWOOD_PLANKS_PLACE = soundEvent("block.wildwood_planks.place");
    public static final SoundEvent BLOCK_WILDWOOD_PLANKS_HIT = soundEvent("block.wildwood_planks.hit");
    public static final SoundEvent BLOCK_WILDWOOD_PLANKS_FALL = soundEvent("block.wildwood_planks.fall");

    public static final SoundEvent BLOCK_WILDWOOD_SLAB_BREAK = soundEvent("block.wildwood_slab.break");
    public static final SoundEvent BLOCK_WILDWOOD_SLAB_STEP = soundEvent("block.wildwood_slab.step");
    public static final SoundEvent BLOCK_WILDWOOD_SLAB_PLACE = soundEvent("block.wildwood_slab.place");
    public static final SoundEvent BLOCK_WILDWOOD_SLAB_HIT = soundEvent("block.wildwood_slab.hit");
    public static final SoundEvent BLOCK_WILDWOOD_SLAB_FALL = soundEvent("block.wildwood_slab.fall");

    public static final SoundEvent BLOCK_WILDWOOD_STAIRS_BREAK = soundEvent("block.wildwood_stairs.break");
    public static final SoundEvent BLOCK_WILDWOOD_STAIRS_STEP = soundEvent("block.wildwood_stairs.step");
    public static final SoundEvent BLOCK_WILDWOOD_STAIRS_PLACE = soundEvent("block.wildwood_stairs.place");
    public static final SoundEvent BLOCK_WILDWOOD_STAIRS_HIT = soundEvent("block.wildwood_stairs.hit");
    public static final SoundEvent BLOCK_WILDWOOD_STAIRS_FALL = soundEvent("block.wildwood_stairs.fall");

    public static final SoundEvent BLOCK_WILDWOOD_BUTTON_BREAK = soundEvent("block.wildwood_button.break");
    public static final SoundEvent BLOCK_WILDWOOD_BUTTON_STEP = soundEvent("block.wildwood_button.step");
    public static final SoundEvent BLOCK_WILDWOOD_BUTTON_PLACE = soundEvent("block.wildwood_button.place");
    public static final SoundEvent BLOCK_WILDWOOD_BUTTON_HIT = soundEvent("block.wildwood_button.hit");
    public static final SoundEvent BLOCK_WILDWOOD_BUTTON_FALL = soundEvent("block.wildwood_button.fall");

    public static final SoundEvent BLOCK_WILDWOOD_PRESSURE_PLATE_BREAK = soundEvent("block.wildwood_pressure_plate.break");
    public static final SoundEvent BLOCK_WILDWOOD_PRESSURE_PLATE_STEP = soundEvent("block.wildwood_pressure_plate.step");
    public static final SoundEvent BLOCK_WILDWOOD_PRESSURE_PLATE_PLACE = soundEvent("block.wildwood_pressure_plate.place");
    public static final SoundEvent BLOCK_WILDWOOD_PRESSURE_PLATE_HIT = soundEvent("block.wildwood_pressure_plate.hit");
    public static final SoundEvent BLOCK_WILDWOOD_PRESSURE_PLATE_FALL = soundEvent("block.wildwood_pressure_plate.fall");

    public static final SoundEvent BLOCK_WILDWOOD_DOOR_BREAK = soundEvent("block.wildwood_door.break");
    public static final SoundEvent BLOCK_WILDWOOD_DOOR_STEP = soundEvent("block.wildwood_door.step");
    public static final SoundEvent BLOCK_WILDWOOD_DOOR_PLACE = soundEvent("block.wildwood_door.place");
    public static final SoundEvent BLOCK_WILDWOOD_DOOR_HIT = soundEvent("block.wildwood_door.hit");
    public static final SoundEvent BLOCK_WILDWOOD_DOOR_FALL = soundEvent("block.wildwood_door.fall");

    public static final SoundEvent BLOCK_WILDWOOD_TRAPDOOR_BREAK = soundEvent("block.wildwood_trapdoor.break");
    public static final SoundEvent BLOCK_WILDWOOD_TRAPDOOR_STEP = soundEvent("block.wildwood_trapdoor.step");
    public static final SoundEvent BLOCK_WILDWOOD_TRAPDOOR_PLACE = soundEvent("block.wildwood_trapdoor.place");
    public static final SoundEvent BLOCK_WILDWOOD_TRAPDOOR_HIT = soundEvent("block.wildwood_trapdoor.hit");
    public static final SoundEvent BLOCK_WILDWOOD_TRAPDOOR_FALL = soundEvent("block.wildwood_trapdoor.fall");

    public static final SoundEvent BLOCK_WILDWOOD_FENCE_BREAK = soundEvent("block.wildwood_fence.break");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_STEP = soundEvent("block.wildwood_fence.step");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_PLACE = soundEvent("block.wildwood_fence.place");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_HIT = soundEvent("block.wildwood_fence.hit");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_FALL = soundEvent("block.wildwood_fence.fall");

    public static final SoundEvent BLOCK_WILDWOOD_FENCE_GATE_BREAK = soundEvent("block.wildwood_fence_gate.break");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_GATE_STEP = soundEvent("block.wildwood_fence_gate.step");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_GATE_PLACE = soundEvent("block.wildwood_fence_gate.place");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_GATE_HIT = soundEvent("block.wildwood_fence_gate.hit");
    public static final SoundEvent BLOCK_WILDWOOD_FENCE_GATE_FALL = soundEvent("block.wildwood_fence_gate.fall");

    public static final SoundEvent BLOCK_WILDWOOD_LEAVES_BREAK = soundEvent("block.wildwood_leaves.break");
    public static final SoundEvent BLOCK_WILDWOOD_LEAVES_STEP = soundEvent("block.wildwood_leaves.step");
    public static final SoundEvent BLOCK_WILDWOOD_LEAVES_PLACE = soundEvent("block.wildwood_leaves.place");
    public static final SoundEvent BLOCK_WILDWOOD_LEAVES_HIT = soundEvent("block.wildwood_leaves.hit");
    public static final SoundEvent BLOCK_WILDWOOD_LEAVES_FALL = soundEvent("block.wildwood_leaves.fall");

    public static final SoundEvent BLOCK_WILDWOOD_SAPLING_BREAK = soundEvent("block.wildwood_sapling.break");
    public static final SoundEvent BLOCK_WILDWOOD_SAPLING_STEP = soundEvent("block.wildwood_sapling.step");
    public static final SoundEvent BLOCK_WILDWOOD_SAPLING_PLACE = soundEvent("block.wildwood_sapling.place");
    public static final SoundEvent BLOCK_WILDWOOD_SAPLING_HIT = soundEvent("block.wildwood_sapling.hit");
    public static final SoundEvent BLOCK_WILDWOOD_SAPLING_FALL = soundEvent("block.wildwood_sapling.fall");

    private static RegistryEntry<SoundEvent> soundEvent(Identifier id, Identifier soundId, float distanceToTravel) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId, distanceToTravel));
    }

    private static SoundEvent soundEvent(String path) {
        return soundEvent(Titanium.id(path));
    }

    private static SoundEvent soundEvent(Identifier id) {
        return soundEvent(id, id);
    }

    private static RegistryEntry.Reference<SoundEvent> soundEventReference(String path) {
        return soundEventReference(Titanium.id(path));
    }

    private static RegistryEntry.Reference<SoundEvent> soundEventReference(Identifier id) {
        return soundEventReference(id, id);
    }

    private static SoundEvent soundEvent(Identifier id, Identifier soundId) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }

    private static RegistryEntry.Reference<SoundEvent> soundEventReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
}
