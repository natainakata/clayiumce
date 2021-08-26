package io.github.natainakata.clayium.client.render.item;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverride;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ClayiumItemOverrideList extends ItemOverrideList {
    public ClayiumItemOverrideList(List<ItemOverride> overrideList) {
        super(overrideList);
    }

    @Override
    public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
        return new ItemLayerWrapper(originalModel, ItemOverrideList.NONE);
    }
}
