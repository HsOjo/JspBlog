package dao.base.condition;

import dao.base.condition.base.Condition;
import dao.base.condition.base.MergeCondtion;

public class Or extends MergeCondtion {
    private static final String exp = "OR";

    public Or(Condition... conditions) {
        super(Or.exp, conditions);
    }
}
