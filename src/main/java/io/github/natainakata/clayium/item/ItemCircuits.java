package io.github.natainakata.clayium.item;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.base.IItemMeta;
import io.github.natainakata.clayium.base.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemCircuits extends ItemBase implements IItemMeta {
    private static final String[] names = {
            "clay",
            "simple",
            "basic",
            "advanced",
            "precision",
            "integrated",
            "clay_core",
            "clay_brain",
            "clay_spirit",
            "clay_soul",
            "clay_anima",
            "clay_psyche"
    };

    private static String name;

    public ItemCircuits(String name) {
        ItemCircuits.name = name;
        setHasSubtypes(true);
        setMaxDamage(0);
        this.setTranslationKey(name);
        this.setRegistryName(Clayium.MOD_ID, name);
    }
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (int counter = 0; counter < getVariants(); counter++) {
                items.add(new ItemStack(this, 1, counter));
            }
        }
    }


    @Override
    public String getTexture(int meta) {
        return "circuits/" + name + "_" + names[meta];
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
