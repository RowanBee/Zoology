
package net.mcreator.zoology.entity.render;

import net.minecraft.util.Identifier;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.model.ModelPart;

import net.mcreator.zoology.entity.OpossumEntity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class OpossumEntityRenderer extends MobEntityRenderer<OpossumEntity, OpossumEntityRenderer.Modelopossum> {
	public OpossumEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
		super(entityRenderDispatcher, new Modelopossum(), 0.25f);
	}

	public static void clientInit() {
		EntityRendererRegistry.INSTANCE.register(OpossumEntity.ENTITY, (dispatcher, context) -> new OpossumEntityRenderer(dispatcher));
	}

	@Override
	public Identifier getTexture(OpossumEntity entity) {
		return new Identifier("zoology:textures/opossum.png");
	}
	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelopossum extends EntityModel<OpossumEntity> {
		private final ModelPart head;
		private final ModelPart body;
		private final ModelPart Tail;
		public Modelopossum() {
			textureWidth = 32;
			textureHeight = 32;
			head = new ModelPart(this);
			head.setPivot(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(0, 0).addCuboid(1.1667F, -5.9667F, -5.3333F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(0, 1).addCuboid(-1.8333F, -5.9667F, -5.3333F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addCuboid(-1.8333F, -4.9667F, -8.3333F, 4.0F, 3.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(14, 0).addCuboid(-1.3333F, -3.9667F, -11.3333F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(14, 4).addCuboid(-1.3333F, -2.9667F, -11.3333F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(12, 1).addCuboid(-0.3333F, -3.9667F, -12.3333F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body = new ModelPart(this);
			body.setPivot(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 8).addCuboid(-2.8333F, -4.9667F, -5.3333F, 6.0F, 3.0F, 11.0F, 0.0F, false);
			body.setTextureOffset(28, 5).addCuboid(1.6667F, -1.9667F, -5.3333F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(28, 5).addCuboid(1.6667F, -1.9667F, 4.6667F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(28, 5).addCuboid(-2.3333F, -1.9667F, 4.6667F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(28, 5).addCuboid(-2.3333F, -1.9667F, -5.3333F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Tail = new ModelPart(this);
			Tail.setPivot(0.0F, 24.0F, 0.0F);
			Tail.setTextureOffset(0, 22).addCuboid(-0.3333F, -4.9667F, 5.6667F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Tail.setTextureOffset(8, 22).addCuboid(-0.3333F, -4.9667F, 8.6667F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Tail.setTextureOffset(8, 22).addCuboid(-0.3333F, -4.9667F, 11.6667F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			Tail.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelPart bone, float x, float y, float z) {
			bone.pitch = x;
			bone.yaw = y;
			bone.roll = z;
		}

		public void setAngles(OpossumEntity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
