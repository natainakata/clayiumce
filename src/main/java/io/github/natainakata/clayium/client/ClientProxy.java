package io.github.natainakata.clayium.client;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.CommonProxy;
import io.github.natainakata.clayium.ItemInit;
import io.github.natainakata.clayium.base.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import io.github.natainakata.clayium.client.render.ClayiumRenderer;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenders() {
        registerItemRender(ItemInit.CLAYPARTS);
    }

    public void registerItemRender(ItemBase item) {
        ClayiumRenderer.registerItemRender(Clayium.MOD_ID, item);
    }

    @Override
    public void init() {
        ClayiumRenderer.init();
    }
}
