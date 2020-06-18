package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Config {
    private static final String CFG_FILE = "config.json";
    private static final String CFG_ENCODING = "UTF-8";

    public static String DB_HOST;
    public static int DB_PORT;
    public static String DB_USER;
    public static String DB_PASSWORD;
    public static String DB_DATABASE;
    public static String DB_ENCODING;

    static {
        try {
            String config_str = FileUtils.readFileToString(new File(CFG_FILE), CFG_ENCODING);
            JSONObject config = JSON.parseObject(config_str);
            DB_HOST = config.getString("DB_HOST");
            DB_PORT = config.getInteger("DB_PORT");
            DB_USER = config.getString("DB_USER");
            DB_PASSWORD = config.getString("DB_PASSWORD");
            DB_DATABASE = config.getString("DB_DATABASE");
            DB_ENCODING = config.getString("DB_ENCODING");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
