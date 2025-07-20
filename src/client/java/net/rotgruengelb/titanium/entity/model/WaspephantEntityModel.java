package net.rotgruengelb.titanium.entity.model;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.rotgruengelb.titanium.entity.WaspephantEntity;
import net.rotgruengelb.titanium.entity.animation.AnimationContainerHelper;
import net.rotgruengelb.titanium.entity.animation.WaspephantAnimations;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class WaspephantEntityModel extends SinglePartEntityModel<WaspephantEntity> {

	private final ModelPart Body;
	private final ModelPart body2;
	private final ModelPart Head;
	private final ModelPart eye;
	private final ModelPart RightMandible;
	private final ModelPart LeftMandible;
	private final ModelPart Wings;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart Chest;
	private final ModelPart Spine;
	private final ModelPart Abdomen;
	private final ModelPart RightFrontLeg;
	private final ModelPart RightTopFront;
	private final ModelPart RightBottomFront;
	private final ModelPart RightBackLeg;
	private final ModelPart RightTopBack;
	private final ModelPart RightBottomBack;
	private final ModelPart LeftBackLeg;
	private final ModelPart LeftTopBack;
	private final ModelPart LeftBottomBack;
	private final ModelPart LeftFrontLeg;
	private final ModelPart LeftBottomFront;
	private final ModelPart LeftTopFront;

	public WaspephantEntityModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.body2 = this.Body.getChild("body2");
		this.Head = this.body2.getChild("Head");
		this.eye = this.Head.getChild("eye");
		this.RightMandible = this.Head.getChild("RightMandible");
		this.LeftMandible = this.Head.getChild("LeftMandible");
		this.Wings = this.body2.getChild("Wings");
		this.RightWing = this.Wings.getChild("RightWing");
		this.LeftWing = this.Wings.getChild("LeftWing");
		this.Chest = this.body2.getChild("Chest");
		this.Spine = this.body2.getChild("Spine");
		this.Abdomen = this.body2.getChild("Abdomen");
		this.RightFrontLeg = this.Body.getChild("RightFrontLeg");
		this.RightTopFront = this.RightFrontLeg.getChild("RightTopFront");
		this.RightBottomFront = this.RightFrontLeg.getChild("RightBottomFront");
		this.RightBackLeg = this.Body.getChild("RightBackLeg");
		this.RightTopBack = this.RightBackLeg.getChild("RightTopBack");
		this.RightBottomBack = this.RightBackLeg.getChild("RightBottomBack");
		this.LeftBackLeg = this.Body.getChild("LeftBackLeg");
		this.LeftTopBack = this.LeftBackLeg.getChild("LeftTopBack");
		this.LeftBottomBack = this.LeftBackLeg.getChild("LeftBottomBack");
		this.LeftFrontLeg = this.Body.getChild("LeftFrontLeg");
		this.LeftBottomFront = this.LeftFrontLeg.getChild("LeftBottomFront");
		this.LeftTopFront = this.LeftFrontLeg.getChild("LeftTopFront");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData body2 = Body.addChild("body2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Head = body2.addChild("Head", ModelPartBuilder.create().uv(48, 0).cuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -33.0F));

		ModelPartData eye = Head.addChild("eye", ModelPartBuilder.create().uv(100, 20).cuboid(-6.0F, -7.0F, -6.0F, 12.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData RightMandible = Head.addChild("RightMandible", ModelPartBuilder.create().uv(112, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 8.0F, -6.0F));

		ModelPartData rightteeth_r1 = RightMandible.addChild("rightteeth_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -7.0F, -1.0F, 3.0F, 14.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, 7.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		ModelPartData LeftMandible = Head.addChild("LeftMandible", ModelPartBuilder.create().uv(112, 68).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 8.0F, -6.0F));

		ModelPartData leftteeth_r1 = LeftMandible.addChild("leftteeth_r1", ModelPartBuilder.create().uv(30, 0).cuboid(-2.5F, -7.0F, -1.0F, 3.0F, 14.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData Wings = body2.addChild("Wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 30.0F, 0.0F));

		ModelPartData RightWing = Wings.addChild("RightWing", ModelPartBuilder.create().uv(0, 0).cuboid(-0.0459F, -23.9543F, -12.0F, 0.0F, 24.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -37.0F, -2.0F));

		ModelPartData LeftWing = Wings.addChild("LeftWing", ModelPartBuilder.create().uv(0, 24).cuboid(0.0F, -24.0F, -12.0F, 0.0F, 24.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -37.0F, -2.0F));

		ModelPartData Chest = body2.addChild("Chest", ModelPartBuilder.create().uv(32, 62).cuboid(-6.0F, -6.5F, -8.0F, 12.0F, 13.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, -17.0F));

		ModelPartData Spine = body2.addChild("Spine", ModelPartBuilder.create().uv(72, 75).cuboid(-6.0F, -6.5F, -8.0F, 12.0F, 13.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, -1.0F));

		ModelPartData Abdomen = body2.addChild("Abdomen", ModelPartBuilder.create().uv(48, 32).cuboid(-7.0F, -7.0F, -8.0F, 14.0F, 14.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 15.0F));

		ModelPartData RightFrontLeg = Body.addChild("RightFrontLeg", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -3.0F, -18.0F));

		ModelPartData RightTopFront = RightFrontLeg.addChild("RightTopFront", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData RTFL_r1 = RightTopFront.addChild("RTFL_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData RightBottomFront = RightFrontLeg.addChild("RightBottomFront", ModelPartBuilder.create().uv(0, 97).cuboid(-3.0F, 3.0F, -3.0F, 6.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-15.0F, 0.0F, 0.0F));

		ModelPartData RightBackLeg = Body.addChild("RightBackLeg", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, -3.0F, 19.0F));

		ModelPartData RightTopBack = RightBackLeg.addChild("RightTopBack", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData RTBL_r1 = RightTopBack.addChild("RTBL_r1", ModelPartBuilder.create().uv(0, 73).cuboid(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData RightBottomBack = RightBackLeg.addChild("RightBottomBack", ModelPartBuilder.create().uv(78, 104).cuboid(-3.0F, 3.0F, -3.0F, 6.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-15.0F, 0.0F, 0.0F));

		ModelPartData LeftBackLeg = Body.addChild("LeftBackLeg", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -3.0F, 19.0F));

		ModelPartData LeftTopBack = LeftBackLeg.addChild("LeftTopBack", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData LTBL_r1 = LeftTopBack.addChild("LTBL_r1", ModelPartBuilder.create().uv(30, 91).cuboid(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData LeftBottomBack = LeftBackLeg.addChild("LeftBottomBack", ModelPartBuilder.create().uv(24, 115).cuboid(-3.0F, 3.0F, -3.0F, 6.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0F, 0.0F, 0.0F));

		ModelPartData LeftFrontLeg = Body.addChild("LeftFrontLeg", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, -3.0F, -18.0F));

		ModelPartData LeftBottomFront = LeftFrontLeg.addChild("LeftBottomFront", ModelPartBuilder.create().uv(102, 104).cuboid(-3.0F, 3.0F, -3.0F, 6.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0F, 0.0F, 0.0F));

		ModelPartData LeftTopFront = LeftFrontLeg.addChild("LeftTopFront", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData LTFL_r1 = LeftTopFront.addChild("LTFL_r1", ModelPartBuilder.create().uv(90, 44).cuboid(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	@Override
	public ModelPart getPart() {
		return Body;
	}

	@Override
	public void setAngles(WaspephantEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		AnimationContainerHelper.LimbData limbData = new AnimationContainerHelper.LimbData(WaspephantAnimations.WALKING, limbAngle, limbDistance, headYaw, headPitch);
		AnimationContainerHelper.animateEntityModel(this, entity.getAnimationContainer(), animationProgress, WaspephantAnimations.ANIMATIONS, limbData);
	}
}