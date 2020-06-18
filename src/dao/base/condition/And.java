package dao.base.condition;

import dao.base.condition.base.Condition;
import dao.base.condition.base.MergeCondtion;

public class And extends MergeCondtion {
    private static final String exp = "AND";

    public And(Condition... conditions) {
        super(And.exp, conditions);
    }

    public static And check(Condition... conditions) {
        return new And(conditions);
    }
}
