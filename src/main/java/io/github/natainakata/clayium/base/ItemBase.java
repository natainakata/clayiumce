package io.github.natainakata.clayium.base;

import io.github.natainakata.clayium.Clayium;
import net.minecraft.item.Item;

public abstract class ItemBase extends Item {

    public ItemBase() {
        this.setCreativeTab(Clayium.creativetab);

    }

    public String getTexture() {
        return getTranslationKey().substring(5);
    }
}
