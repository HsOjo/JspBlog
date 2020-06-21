package dao.base.condition.base;

import java.util.ArrayList;
import java.util.List;

public class MergeCondtion implements Condition {
    private final String exp;
    private final Condition[] conditions;

    public MergeCondtion(String exp, Condition... conditions) {
        this.exp = exp;
        this.conditions = conditions;
    }

    @Override
    public List<Object> params() {
        ArrayList<Object> params = new ArrayList<>();
        for (Condition condition : this.conditions) {
            params.addAll(condition.params());
        }
        return params;
    }

    @Override
    public String toSql() {
        StringBuilder sql_sb = new StringBuilder();
        for (Condition condition : this.conditions) {
            if (sql_sb.length() != 0)
                sql_sb.append(String.format(" %s ", this.exp));
            sql_sb.append(condition.toSql());
        }

        String sql = sql_sb.toString();
        if (this.conditions.length > 1)
            sql = String.format("(%s)", sql);

        return sql;
    }
}
