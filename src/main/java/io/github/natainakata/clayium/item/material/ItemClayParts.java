package io.github.natainakata.clayium.item.material;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.ItemInit;
import io.github.natainakata.clayium.base.ItemBase;
import io.github.natainakata.clayium.base.MetaItem;
import io.github.natainakata.clayium.util.JsonHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemClayParts extends MetaItem {


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

    public ItemClayParts(String name) {
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
