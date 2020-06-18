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

    public static String table(String dao_name) {
        String name = dao_name.replace("DAO", "");
        StringBuilder name_sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
                if (name_sb.length() > 0)
                    name_sb.append('_');
            }
            name_sb.append(c);
        }

        return name_sb.toString();
    }
}
