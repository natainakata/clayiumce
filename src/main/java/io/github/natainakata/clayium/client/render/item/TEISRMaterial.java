package io.github.natainakata.clayium.client.render.item;

import io.github.natainakata.clayium.base.ItemMaterial;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.pipeline.LightUtil;

import java.util.List;

public class TEISRMaterial extends TileEntityItemStackRenderer {
    public static TEISRMaterial instance = new TEISRMaterial();

    @Override
    public void renderByItem(ItemStack itemStackIn) {
        this.renderByItem(itemStackIn, 1.0F);
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, float partialTicks) {
        IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(itemStackIn, null, null);
        renderModel(model, itemStackIn);
    }

    private void renderModel(IBakedModel model, ItemStack stack) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder renderer = tessellator.getBuffer();
        renderer.begin(7, DefaultVertexFormats.ITEM);
        renderQuads(renderer, model.getQuads(null, null, 0), stack);
        tessellator.draw();
    }

    private void renderQuads(BufferBuilder renderer, List<BakedQuad> quads, ItemStack stack) {
        int color = ItemMaterial.getMatrialTint(stack.getMetadata());
        for (BakedQuad quad : quads) {
            LightUtil.renderQuadColor(renderer, quad, color);
        }
    }
}
