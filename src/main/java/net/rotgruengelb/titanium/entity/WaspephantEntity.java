package net.rotgruengelb.titanium.entity;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.entity.core.AnimationContainerState;

public class WaspephantEntity extends PathAwareEntity {

	public static final Identifier IDLE_STATE = Titanium.id("idle");
	public static final Identifier MOVE_STATE = Titanium.id("move");

	private final AnimationContainerState animationContainer = createAnimationContainer();

	protected WaspephantEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);

		animationContainer.runState(IDLE_STATE, this.age);
	}

	public static DefaultAttributeContainer createAttributes() {
		return PathAwareEntity.createMobAttributes()
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1D)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0D)
				.build();
	}

	public static AnimationContainerState createAnimationContainer() {
		return new AnimationContainerState()
				.addState(IDLE_STATE)
				.addState(MOVE_STATE);
	}

	public AnimationContainerState getAnimationContainer() {
		return animationContainer;
	}

	public Brain<WaspephantEntity> getBrain() {
		return (Brain<WaspephantEntity>) super.getBrain();
	}

	@Override
	protected void mobTick() {
		getBrain().tick((ServerWorld)getWorld(), this);
		getBrain().resetPossibleActivities(ImmutableList.of(Activity.IDLE));
		super.mobTick();
	}

	@Override
	protected void updateLimbs(float posDelta) {
		float f = Math.min(posDelta * 25.0f, 1.0f);
		this.limbAnimator.updateLimbs(f, 0.4f);
	}

	@Override
	protected Brain.Profile<WaspephantEntity> createBrainProfile() {
		return Brain.createProfile(WaspephantBrain.MEMORY_MODULES, WaspephantBrain.SENSORS);
	}

	@Override
	protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
		return WaspephantBrain.create(this, this.createBrainProfile().deserialize(dynamic));
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		MobNavigation navigation = new MobNavigation(this, world);
		navigation.setCanPathThroughDoors(false);
		return navigation;
	}


	@Override
	public void tick() {
		super.tick();

		if (!getWorld().isClient()) return;

		animationContainer.runState(IDLE_STATE, this.age);
	}

	public boolean isMoving() {
		return getVelocity().length() > 0.01D;
	}
}
