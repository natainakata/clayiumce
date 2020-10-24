package io.github.natainakata.clayium.client.render;

import io.github.natainakata.clayium.base.ItemBase;
import io.github.natainakata.clayium.base.MetaItem;
import io.github.natainakata.clayium.util.JsonHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
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

    public static void registerItemRender(String domain, ItemBase item) {
        if (item instanceof MetaItem) {
            MetaItem metaItem = (MetaItem) item;
            for (int i = 0; i < metaItem.getVariants(); i++) {
                if (metaItem.getTexture(i) == null) continue;

                ResourceLocation resource = new ResourceLocation(domain, metaItem.getTexture(i));
                JsonHelper.INSTANCE.registerJson(item, JsonHelper.JsonType.SIMPLE_ITEM, metaItem.getTexture(i));
                ModelResourceLocation loc = new ModelResourceLocation(resource, "inventory");
                ModelLoader.setCustomModelResourceLocation(item, i, loc);
                ModelBakery.registerItemVariants(item, resource);
            }

            return;
        }
        JsonHelper.INSTANCE.registerJson(item, JsonHelper.JsonType.SIMPLE_ITEM, item.getTexture());
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
