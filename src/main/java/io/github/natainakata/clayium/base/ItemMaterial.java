package io.github.natainakata.clayium.base;

import io.github.natainakata.clayium.Materials;

import java.awt.*;

public abstract class ItemMaterial extends ItemBase {


    public static String getMaterialName(int meta) {
        return Materials.values()[meta].getName();
    }

    public static int getMatrialTint(int meta) {
        return Materials.values()[meta].getTint();
    }

    public int getVariants() {
        return Materials.values().length;
    }
}
