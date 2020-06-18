package utils;

public class BlockUtils {
    public static String BLOCK = "__override__";

    public static String getOverrideVariableName(String name) {
        return BLOCK + name;
    }
}