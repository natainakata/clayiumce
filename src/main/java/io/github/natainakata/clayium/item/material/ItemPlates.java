package io.github.natainakata.clayium.item.material;

import io.github.natainakata.clayium.Clayium;
import io.github.natainakata.clayium.Materials;
import io.github.natainakata.clayium.base.ItemMaterial;
import io.github.natainakata.clayium.util.ClayiumUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Locale;

public class ItemPlates extends ItemMaterial {
           /* "aluminium",
            "silicon",
            "impure_aluminium",
            "impure_silicon",
            "claysteel",
            "clayium",
            "ultimate",
            "industrial_clay",
            "a_industrial_clay",
            "oec",
            "antimatter",
            "p_antimatter",
            "opa",
            "silicone" */

    private static String name;

    public ItemPlates(String name) {
        ItemPlates.name = name;
        setHasSubtypes(true);
        setMaxDamage(0);
        setTranslationKey(name);
        setRegistryName(Clayium.MOD_ID, name);
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (int counter = 0; counter < Materials.values().length; counter++) {
                items.add(new ItemStack(this, 1, counter));
            }
        }
    }

    public String getTexture() {
        return "material/" +  name;
    }

    public static ModelResourceLocation getModelLocation() {
        return ClayiumUtils.getInventoryML("material/" + name);
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        if (stack.getItemDamage() <= Materials.values().length - 1) {
            return "item." + Clayium.MOD_ID + "." + name + "." + Materials.values()[stack.getItemDamage()].getName().toLowerCase(Locale.ROOT);
        }

        return Clayium.MOD_ID + ".invaild";
    }
}
