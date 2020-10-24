package io.github.natainakata.clayium.item.material;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.base.MetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemDenseClayParts extends MetaItem {
    public static String[] names = {
            "stick",
            "shortstick",
            "disc",
            "smalldisc",
            "ring",
            "smallring",
            "gear",
            "needle",
            "pipe",
            "blade",
            "cylinder",
            "bearing",
            "spindle",
            "waterwheel",
            "cuttinghead",
            "grindinghead"
    };

    private static String name;

    public ItemDenseClayParts(String name){
        super();
        this.name = name;
        setHasSubtypes(true);
        setMaxDamage(0);
        this.setTranslationKey(name);
        this.setRegistryName(Clayium.MOD_ID, name);
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (int counter = 0; counter < names.length; counter++) {
                items.add(new ItemStack(this, 1, counter));
            }
        }
    }

    public int getVariants() {
        return names.length;
    }

    @Override
    public String getTexture(int meta) {
        return "material/parts/" + name + "_" + names[meta];
    }

    @Nonnull
    @Override
    public String getTranslationKey (ItemStack stack) {
        return "item." + name + "_" + names[stack.getItemDamage()].toLowerCase(Locale.ROOT);
    }
}
