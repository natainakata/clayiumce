package io.github.natainakata.clayium.client.render;

import io.github.natainakata.clayium.Materials;
import io.github.natainakata.clayium.base.IItemMeta;
import io.github.natainakata.clayium.base.ItemBase;
import io.github.natainakata.clayium.base.ItemMaterial;
import io.github.natainakata.clayium.client.JsonHelper;
import io.github.natainakata.clayium.util.ClayiumUtils;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClayiumRenderer {

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new ClayiumRenderer());
    }

    public static void registerItemRender(ItemBase item) {
        if (item instanceof IItemMeta) {
            IItemMeta metaItem = (IItemMeta) item;
            for (int i = 0; i < metaItem.getVariants(); i++) {
                if (metaItem.getTexture(i) == null) continue;
                String texture = metaItem.getTexture(i);

                ResourceLocation resource = ClayiumUtils.getLocation(texture);
                ModelResourceLocation loc = ClayiumUtils.getInventoryML(texture);
                JsonHelper.INSTANCE.registerJson(item, JsonHelper.JsonType.SIMPLE_ITEM, texture);
                ModelLoader.setCustomModelResourceLocation(item, i, loc);
                ModelBakery.registerItemVariants(item, resource);
            }

            return;
        } else if (item instanceof ItemMaterial) {
            String texture = item.getTexture();
            ModelResourceLocation loc = ClayiumUtils.getInventoryML(texture);
            JsonHelper.INSTANCE.registerJson(item, JsonHelper.JsonType.SIMPLE_ITEM, texture);
            for (int i = 0; i < Materials.values().length; i++) {
                ModelLoader.setCustomModelResourceLocation(item, i, loc);
                ModelBakery.registerItemVariants(item, ClayiumUtils.getLocation(texture));
            }
            return;
        }

        JsonHelper.INSTANCE.registerJson(item, JsonHelper.JsonType.SIMPLE_ITEM, item.getTexture());
        ModelLoader.setCustomModelResourceLocation(item, 0, ClayiumUtils.getInventoryML(item.getTexture()));
    }


}
