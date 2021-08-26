package io.github.natainakata.clayium;

import io.github.natainakata.clayium.item.ItemCircuits;
import io.github.natainakata.clayium.item.ItemDenseClayParts;
import io.github.natainakata.clayium.item.material.*;
import io.github.natainakata.clayium.item.ItemMisc;
import io.github.natainakata.clayium.item.ItemClayParts;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(Clayium.MOD_ID)
public class ItemInit {
    public static final ItemCircuits CIRCUITS = new ItemCircuits("circuits");
    public static final ItemClayParts CLAYPARTS = new ItemClayParts("clayparts");
    public static final ItemDenseClayParts DENSECLAYPARTS = new ItemDenseClayParts("denseclayparts");
    public static final ItemMisc MISCITEM = new ItemMisc("misc_item");
    public static final ItemPlates PLATES = new ItemPlates("plate");

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.register(CIRCUITS);
        registry.register(CLAYPARTS);
        registry.register(DENSECLAYPARTS);
        registry.register(MISCITEM);
        registry.register(PLATES);
    }

}
