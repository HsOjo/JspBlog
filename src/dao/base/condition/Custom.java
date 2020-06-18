package dao.base.condition;

import dao.base.condition.base.Condition;

import java.util.Arrays;
import java.util.List;

public class Custom implements Condition {
    public String content;
    public Object[] params;

    public Custom(String content, Object... params) {
        this.content = content;
        this.params = params;
    }

    public static Custom check(String content, Object... params) {
        return new Custom(content, params);
    }

    @Override
    public List<Object> params() {
        return Arrays.asList(this.params);
    }

    @Override
    public String toSql() {
        return this.content;
    }
}
