package io.github.natainakata.clayium.client.render;

import io.github.natainakata.clayium.client.render.item.ClayiumItemOverrideList;
import io.github.natainakata.clayium.client.render.item.ItemLayerWrapper;
import io.github.natainakata.clayium.item.material.ItemPlates;
import io.github.natainakata.clayium.util.ClayiumUtils;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class ModelBakeEventHandler {
    public static final ModelBakeEventHandler instance = new ModelBakeEventHandler();

    private ModelBakeEventHandler() {}

    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event) {
        IBakedModel modelPlate = event.getModelRegistry().getObject(ItemPlates.getModelLocation());
        ItemLayerWrapper plateWrapper = new ItemLayerWrapper(modelPlate, new ClayiumItemOverrideList(new ArrayList<>()));
        event.getModelRegistry().putObject(ItemPlates.getModelLocation(), plateWrapper);
    }

}
