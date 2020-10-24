package io.github.natainakata.clayium;

import io.github.natainakata.clayium.base.ItemBase;
import io.github.natainakata.clayium.item.material.ItemClayParts;
import io.github.natainakata.clayium.item.material.ItemDenseClayParts;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@GameRegistry.ObjectHolder(Clayium.MOD_ID)
public class ItemInit {

    public static final ItemClayParts CLAYPARTS = new ItemClayParts("clayparts");
    public static final ItemDenseClayParts DENSECLAYPARTS = new ItemDenseClayParts("denseclayparts");

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.register(CLAYPARTS);
        registry.register(DENSECLAYPARTS);
    }

}
