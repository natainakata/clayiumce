package io.github.natainakata.clayium.base;

public abstract class MetaItem extends ItemBase {

    public String[] names;


    public abstract String getTexture(int meta);

    public abstract int getVariants();

}

