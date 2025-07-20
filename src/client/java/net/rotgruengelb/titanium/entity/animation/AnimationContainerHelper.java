package net.rotgruengelb.titanium.entity.animation;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.entity.core.AnimationContainerState;
import org.joml.Vector3f;

import java.util.Map;

public class AnimationContainerHelper {

	private static final Vector3f ANIMATION_VEC = new Vector3f();

	/**
	 * Stops the animation if it's not looping and the running time exceeds the animation's length
	 */
	public static void animateEntityModel(SinglePartEntityModel<?> model, net.rotgruengelb.titanium.entity.core.AnimationContainerState containerState, float progress, Map<Identifier, Animation> animationById, LimbData limbData) {
		if (containerState.getCurrentState() == null) return;

		Animation animation = animationById.get(containerState.getCurrentStateId());
		if (animation == null) return;

		model.getPart().traverse().forEach(ModelPart::resetTransform);

		containerState.getCurrentState().update(progress, 1.0f);
		containerState.getCurrentState().run(state -> {
			AnimationHelper.animate(model, animation, state.getTimeRunning(), 1.0f, ANIMATION_VEC);
		});

		// Update movement
		long limbProgress = (long)(limbData.limbAngle * 50.0f);
		float limbSpeedScale = Math.min(limbData.limbDistance, 1.0f);
		AnimationHelper.animate(model, limbData.movementAnimation, limbProgress, limbSpeedScale, ANIMATION_VEC);
	}

	public static void checkFinishedAnimations(AnimationContainerState container, float age, Map<Identifier, Animation> animationById) {
		container.stopRunningOnCondition((id, state) -> {
			Animation animation = animationById.get(id);
			if (animation == null) {
				return false;
			}
			if (!animation.looping() && state.getTimeRunning() >= animation.lengthInSeconds() * 1000.0f) {
				return true;
			}

			return false;
		});
	}

	public record LimbData(Animation movementAnimation, float limbAngle, float limbDistance, float headYaw, float headPitch) {}
}
