package dao.base;

public class FormatUtils {
    public static String column(String column) {
        column = column.trim();
        boolean is_custom = false;
        for (String feature : new String[]{"`", " ", "'", "\"", "(", ")",}) {
            if (column.contains(feature)) {
                is_custom = true;
                break;
            }
        }

        if (!is_custom)
            column = String.format("`%s`", column);

        return column;
    }
}
