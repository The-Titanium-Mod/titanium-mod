package net.rotgruengelb.titanium.entity.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.TitaniumRenderer;
import net.rotgruengelb.titanium.entity.WaspephantEntity;
import net.rotgruengelb.titanium.entity.model.WaspephantEntityModel;

public class WaspephantEntityRenderer extends LivingEntityRenderer<WaspephantEntity, WaspephantEntityModel> {

	public static final Identifier TEXTURE = Titanium.id("textures/entity/waspephant.png");

	public WaspephantEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new WaspephantEntityModel(context.getPart(TitaniumRenderer.WASPEPHANT)), 0.0f);
	}

	@Override
	public Identifier getTexture(WaspephantEntity entity) {
		return TEXTURE;
	}
}
