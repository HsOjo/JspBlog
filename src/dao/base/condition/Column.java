package dao.base.condition;

import dao.base.FormatUtils;
import dao.base.condition.base.Condition;

import java.util.Collections;
import java.util.List;

public class Column implements Condition {
    public String column;
    public String exp;
    public Object value;

    public Column(String key, String exp, Object value) {
        this.column = key;
        this.exp = exp;
        this.value = value;
    }

    public static Column check(String key, String exp, Object value) {
        return new Column(key, exp, value);
    }

    @Override
    public List<Object> params() {
        return Collections.singletonList(this.value);
    }

    @Override
    public String toSql() {
        String column = FormatUtils.column(this.column);
        return String.format("%s %s ?", column, this.exp);
    }
}
