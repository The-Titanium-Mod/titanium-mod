package net.rotgruengelb.titanium.entity;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.task.MoveToTargetTask;
import net.minecraft.entity.ai.brain.task.RandomTask;
import net.minecraft.entity.ai.brain.task.StrollTask;
import net.minecraft.entity.ai.brain.task.WaitTask;

import java.util.List;
import java.util.Set;

public class WaspephantBrain {

	protected static final ImmutableList<SensorType<? extends Sensor<? super WaspephantEntity>>> SENSORS = ImmutableList.of(
			SensorType.NEAREST_LIVING_ENTITIES
	);

	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_MODULES = ImmutableList.of(
			MemoryModuleType.PATH,
			MemoryModuleType.HURT_BY,
			MemoryModuleType.WALK_TARGET,
			MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
			MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.ATTACK_COOLING_DOWN,
			MemoryModuleType.LOOK_TARGET,
			MemoryModuleType.VISIBLE_MOBS
	);

	public static Brain<?> create(WaspephantEntity entity, Brain<WaspephantEntity> brain) {
		brain.setTaskList(Activity.CORE, 0, ImmutableList.of(new MoveToTargetTask()));
		brain.setTaskList(Activity.IDLE, 10,
				ImmutableList.of(
						new RandomTask<>(List.of(
								Pair.of(StrollTask.create(1.2f, false), 0),
								Pair.of(new WaitTask(50, 200), 0)
						))
				));
		brain.setCoreActivities(Set.of(Activity.CORE));
		brain.setDefaultActivity(Activity.IDLE);
		brain.resetPossibleActivities();
		return brain;
	}
}
