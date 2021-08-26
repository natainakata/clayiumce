package io.github.natainakata.clayium.util;

import io.github.natainakata.clayium.Clayium;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class ClayiumUtils {
    public static ResourceLocation getLocation(String key) {
        return new ResourceLocation(Clayium.MOD_ID, key);
    }

    public static ModelResourceLocation getMLocation(String key, String variant) {
        return new ModelResourceLocation(getLocation(key), variant);
    }

    public static ModelResourceLocation getInventoryML(String key) {
        return new ModelResourceLocation(getLocation(key), "#inventory");
    }

    public static ModelResourceLocation getInventoryML(ResourceLocation loc) {
        return new ModelResourceLocation(loc, "#inventory");
    }
}
