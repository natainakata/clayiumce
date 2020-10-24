package io.github.natainakata.clayium.util;

import io.github.natainakata.clayium.Clayium;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * お借りしました https://github.com/RiSE4/NaturalStyle2/blob/1.12.2/src/main/java/rise/naturalstyle/util/JsonHelper.java
 */
public class JsonHelper {
    private final String basePath;

    private final boolean isDebug = true;
    private final String modID = Clayium.MOD_ID;

    private JsonHelper(String path) {
        this.basePath = path;
    }

    /**
     * Modのリソースファイルのパスをコピペ
     */
    public static final JsonHelper INSTANCE = new JsonHelper("D:\\modding\\clayiumce\\src\\main\\resources");

    /**
     * デバッグ時に限りJsonを自動生成する。各コンテンツのコンストラクタなどで呼び出すと使える。
     *
     * @param target BlockかItem
     * @param type   Jsonの種類
     * @param name   ファイルの名前 わかりやすいようにgetTranslationKey()の使用を推奨
     */
    public void registerJson(Object target, JsonType type, String name) {
        if (this.isDebug) {
            if (target instanceof Block) {
                Block block = (Block) target;
                this.generateJson(type, block, name);
            }

            if (target instanceof Item) {
                Item item = (Item) target;
                this.generateJson(type, item, name);
            }
        }
    }

    /**
     * BlockStateまたはModelのJsonを自動生成する。
     * テキストでゴリ押しで書いているのでもっといい方法があるかも。
     *
     * @param type     Jsonの種類
     * @param target   BlockかItem
     * @param fileName ファイル名
     */
    private void generateJson(JsonType type, Object target, String fileName) {
        String filePath = null;
        File json = null;
        boolean find = false;

        try {
            Path path = Paths.get(basePath);
            path.normalize();

            if (target != null) {
                String rePath = path.toString() + "\\assets\\" + this.modID;

                if (type == JsonType.SIMPLE_BLOCK_STATE || type == JsonType.FACING_BLOCK_STATE)
                    filePath = rePath + "\\blockstates\\";

                if (type == JsonType.SIMPLE_BLOCK || type == JsonType.AXIS_BLOCK || type == JsonType.TOP_BOTTOM_BLOCK || type == JsonType.FACING_BLOCK)
                    filePath = rePath + "\\models\\block\\";

                if (type == JsonType.SIMPLE_ITEM || type == JsonType.TOOL_ITEM || type == JsonType.ITEM_BLOCK)
                    filePath = rePath + "\\models\\item\\";

                json = new File(filePath + Paths.get(fileName).normalize().toString() + ".json");

                if (json.exists()) {
                    find = true;
                    LogHelper.debugInfoLog(type.getLogName() + " file is found. :: " + json.getName());
                }
            }
        } catch (Exception e) {
            LogHelper.debugTrace(e.toString());
        }

        if (!find && target != null) {
            try {
                assert json != null;
                if (json.getParentFile() != null) {
                    json.getParentFile().mkdirs();
                }

                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(json.getPath())));

                String output = "";

                if (type == JsonType.SIMPLE_BLOCK_STATE)
                    output = "{\n" +
                            "    \"variants\": {\n" +
                            "        \"normal\": { \"model\": \"" + this.modID + ":" + fileName + "\" }\n" +
                            "    }\n" +
                            "}";

                if (type == JsonType.FACING_BLOCK_STATE)
                    output = "{\n" +
                            "    \"variants\": {\n" +
                            "        \"facing=north\": { \"model\": \"" + this.modID + ":" + fileName + "\" },\n" +
                            "        \"facing=south\": { \"model\": \"" + this.modID + ":" + fileName + "\", \"y\": 180 },\n" +
                            "        \"facing=west\":  { \"model\": \"" + this.modID + ":" + fileName + "\", \"y\": 270 },\n" +
                            "        \"facing=east\":  { \"model\": \"" + this.modID + ":" + fileName + "\", \"y\": 90 }\n" +
                            "    }\n" +
                            "}\n";

                if (type == JsonType.ITEM_BLOCK)
                    output = "{\n" +
                            "    \"parent\": \"" + this.modID + ":" + "block/" + fileName + "\"\n" +
                            "}\n";

                if (type == JsonType.SIMPLE_ITEM)
                    output = this.getParentText("item/generated", "layer0", "items/" + fileName);

                if (type == JsonType.TOOL_ITEM)
                    output = this.getParentText("item/handheld", "layer0", "items/tool" + fileName);

                if (type == JsonType.SIMPLE_BLOCK)
                    output = this.getParentText("block/cube_all", "all", "blocks" + fileName);

                if (type == JsonType.AXIS_BLOCK)
                    output = "{\n" +
                            "    \"parent\": \"block/cube_column\",\n" +
                            "    \"textures\": {\n" +
                            "        \"end\":\"" + this.modID + ":" + "blocks" + fileName + "_top" + "\",\n" +
                            "        \"side\":\"" + this.modID + ":" + "blocks" + fileName + "_side" + "\"\n" +
                            "    }\n" +
                            "}\n";

                if (type == JsonType.TOP_BOTTOM_BLOCK)
                    output = "{\n" +
                            "    \"parent\": \"block/cube_bottom_top\",\n" +
                            "    \"textures\": {\n" +
                            "        \"top\":\"" + this.modID + ":" + "blocks" + fileName + "_top" + "\",\n" +
                            "        \"side\":\"" + this.modID + ":" + "blocks" + fileName + "_side" + "\",\n" +
                            "        \"bottom\":\"" + this.modID + ":" + "blocks" + fileName + "_bottom" + "\"\n" +
                            "    }\n" +
                            "}\n";

                if (type == JsonType.FACING_BLOCK)
                    output = "{\n" +
                            "    \"parent\": \"block/orientable\",\n" +
                            "    \"textures\": {\n" +
                            "        \"top\": \"" + this.modID + ":" + "blocks" + fileName + "_top" + "\",\n" +
                            "        \"front\": \"" + this.modID + ":" + "blocks" + fileName + "_front" + "\",\n" +
                            "        \"side\": \"" + this.modID + ":" + "blocks" + fileName + "_side" + "\"\n" +
                            "    }\n" +
                            "}\n";

                pw.println(output);
                pw.close();

                LogHelper.debugInfoLog("Successful wrote of " + type.getLogName() + ". Please restart client. :: " + json.getPath());
            } catch (IOException e) {
                LogHelper.warnLog("Failed to register " + type.getLogName() + ". :: " + json.getName());
            }
        }
    }

    private String getParentText(String parentName, String layerName, String fileName) {
        return "{\n" +
                "    \"parent\": \"" + parentName + "\",\n" +
                "    \"textures\": {\n" +
                "        \"" + layerName + "\": \"" + this.modID + ":" + fileName + "\"\n" +
                "    }\n" +
                "}";
    }


    /**
     * Jsonの種類 引数はログを表示する際にのみ使用し、enumごとの処理は generateJson(...)でやっている。
     */
    public enum JsonType {
        SIMPLE_BLOCK_STATE("Simple Block State"),
        FACING_BLOCK_STATE("Facing Block State"),
        ITEM_BLOCK("Item Block Model"),
        SIMPLE_ITEM("Simple Item Model"),
        TOOL_ITEM("Tool Item Model"),
        SIMPLE_BLOCK("Simple Block Model"),
        AXIS_BLOCK("Axis Block Model"),
        TOP_BOTTOM_BLOCK("Top Bottom Block Model"),
        FACING_BLOCK("Facing Block Model");

        private final String logName;

        JsonType(String logName) {
            this.logName = logName;
        }

        public String getLogName() {
            return this.logName;
        }
    }
}
