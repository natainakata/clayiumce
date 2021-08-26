package io.github.natainakata.clayium;

import java.awt.*;

public enum Materials {
    IMPURE_SILICON("impure_silicon", new Color(83, 55, 100).getRGB() |  0xFF000000),
    SILICON("silicon", new Color(40, 28, 40).getRGB() |  0xFF000000),
    IRON("iron", new Color(216, 216, 216).getRGB() |  0xFF000000),
    GOLD("gold", new Color(255, 255, 10).getRGB() |  0xFF000000),
    ALUMINIUM("aluminium", new Color(190, 200, 202).getRGB() |  0xFF000000);

    private String name;
    private int tint;

    Materials(String name, int tint) {
        this.name = name;
        this.tint = tint;
    }

    public String getName() {
        return name;
    }

    public int getTint() {
        return tint;
    }


}
