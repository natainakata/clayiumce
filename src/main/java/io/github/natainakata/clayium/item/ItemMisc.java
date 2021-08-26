package io.github.natainakata.clayium.item;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.base.IItemMeta;
import io.github.natainakata.clayium.base.ItemBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemMisc extends ItemBase implements IItemMeta {
    private static final String[] names = {
            "circuit_board",
            "cee_board",
            "cee_circuit",
            "cee",
            "laser_parts",
            "antimatter_seed",
            "synchronous_parts"
    };

    private static String name;

    public ItemMisc(String name) {
        ItemMisc.name = name;
        setHasSubtypes(true);
        setMaxDamage(0);
        this.setTranslationKey(name);
        this.setRegistryName(Clayium.MOD_ID, name);
    }



    @Override
    public String getTexture(int meta) {
        return "misc/" + names[meta];
    }

    public int getVariants() {
        return names.length;
    }
    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        return "item." + Clayium.MOD_ID + "." + name + "." + names[stack.getItemDamage()].toLowerCase(Locale.ROOT);

    }



}

