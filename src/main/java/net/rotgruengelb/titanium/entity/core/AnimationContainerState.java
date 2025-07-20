package net.rotgruengelb.titanium.entity.core;

import net.minecraft.entity.AnimationState;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Animation state controller used for EntityRenderStates to hold multiple AnimationStates.
 */
public class AnimationContainerState {

	private final Map<Identifier, AnimationState> states = new HashMap<>();

	private Identifier currentState = null;
	private boolean canOverrideCurrentState = true;
	private boolean useLimbSwing = false;

	public AnimationContainerState addState(Identifier name) {
		states.put(name, new AnimationState());
		return this;
	}

	public void runOverrideState(Identifier animationId, int startTick) {
		runOverrideState(animationId, startTick, false);
	}

	public void runOverrideState(Identifier animationId, int startTick, boolean useLimbSwing) {
		stopRunningExcept(animationId);

		if (!states.containsKey(animationId)) return;
		currentState = animationId;
		canOverrideCurrentState = false;
		this.useLimbSwing = useLimbSwing;

		states.get(currentState).startIfNotRunning(startTick);
	}

	public void runState(Identifier animationId, int startTick) {
		runState(animationId, startTick, false);
	}

	public void runState(Identifier animationId, int startTick, boolean useLimbSwing) {
		if (currentState != null && !animationId.equals(currentState) && !canOverrideCurrentState) return;

		runOverrideState(animationId, startTick, useLimbSwing);
		canOverrideCurrentState = true;
	}

	public void stopRunningExcept(Identifier animationId) {
		if (animationId.equals(currentState)) return;

		stopRunning();
	};

	public void stopRunning() {
		if (currentState == null) return;

		AnimationState state = states.get(currentState);
		if (state == null) return;

		state.stop();
		currentState = null;
		canOverrideCurrentState = true;
	};

//	public void copyFrom(AnimationContainerState other) {
//		for (Identifier id : other.states.keySet()) {
//			AnimationState state = states.get(id);
//			if (state == null) continue;
//
//			state.copyFrom(other.states.get(id));
//		}
//		currentState = other.currentState;
//		canOverrideCurrentState = other.canOverrideCurrentState;
//	}

	public @Nullable AnimationState getCurrentState() {
		if (!states.containsKey(currentState)) return null;

		return states.get(currentState);
	}

	public @Nullable Identifier getCurrentStateId() {
		return currentState;
	}

	public void forEachState(BiConsumer<Identifier, AnimationState> action) {
		for (Identifier id : states.keySet()) {
			AnimationState state = states.get(id);
			action.accept(id, state);
		}
	}

	public void stopRunningOnCondition(BiFunction<Identifier, AnimationState, Boolean> condition) {
		AnimationState state = states.get(currentState);
		if (state == null) return;

		if (condition.apply(currentState, state)) {
			stopRunning();
		}
	}
}
