package dao.base.condition.base;

import java.util.List;

public interface Condition {
    public List<Object> params();
    public String toSql();
}
