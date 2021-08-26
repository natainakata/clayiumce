package io.github.natainakata.clayium.item;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.base.IItemMeta;
import io.github.natainakata.clayium.base.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemDenseClayParts extends ItemBase implements IItemMeta {
    private static final String[] names = {
            "plate",
            "stick",
            "short_stick",
            "ring",
            "small_ring",
            "gear",
            "blade",
            "needle",
            "disc",
            "small_disc",
            "cylinder",
            "pipe",
            "large_plate",
            "grinding_head",
            "bearing",
            "spindle",
            "cutting_head",
            "water_wheel",
            "dust"
    };

    private static String name;

    public ItemDenseClayParts(String name){
        super();
        ItemDenseClayParts.name = name;
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


    public int getVariants() {
        return names.length;
    }

    @Override
    public String getTexture(int meta) {
        return "parts/" + name + "_" + names[meta];
    }
    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        return "item." + Clayium.MOD_ID + "." + name + "." + names[stack.getItemDamage()].toLowerCase(Locale.ROOT);

    }

}
