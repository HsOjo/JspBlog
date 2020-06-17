package util;

public class BlockUtil {
    public static String BLOCK = "__override__";

    public static String getOverrideVariableName(String name) {
        return BLOCK + name;
    }
}