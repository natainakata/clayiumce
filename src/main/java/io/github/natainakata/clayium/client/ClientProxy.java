package io.github.natainakata.clayium.client;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.CommonProxy;
import io.github.natainakata.clayium.ItemInit;
import io.github.natainakata.clayium.base.ItemBase;
import io.github.natainakata.clayium.client.render.ModelBakeEventHandler;
import io.github.natainakata.clayium.client.render.item.TEISRMaterial;
import io.github.natainakata.clayium.util.ClayiumUtils;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import io.github.natainakata.clayium.client.render.ClayiumRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenders() {
        registerItemRender(ItemInit.CIRCUITS);
        registerItemRender(ItemInit.CLAYPARTS);
        registerItemRender(ItemInit.DENSECLAYPARTS);
        registerItemRender(ItemInit.MISCITEM);
        registerItemRender(ItemInit.PLATES);

    }

    public void registerItemRender(ItemBase item) {
        ClayiumRenderer.registerItemRender(item);
    }



    @Override
    public void init() {
        ItemInit.PLATES.setTileEntityItemStackRenderer(TEISRMaterial.instance);
        ClayiumRenderer.init();
    }


    @Override
    public void registerEventHandlers() {
        MinecraftForge.EVENT_BUS.register(ModelBakeEventHandler.instance);
    }
}
