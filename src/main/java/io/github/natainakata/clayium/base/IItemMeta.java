package io.github.natainakata.clayium.base;

import io.github.natainakata.clayium.Clayium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Locale;

public interface IItemMeta {

    String getTexture(int meta);

    int getVariants();


}

