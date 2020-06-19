package dao.base.condition.base;

import java.util.List;

public interface Condition {
    List<Object> params();

    String toSql();
}
