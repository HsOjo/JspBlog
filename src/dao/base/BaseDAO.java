package dao.base;

import dao.base.condition.And;
import dao.base.condition.base.Condition;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseDAO<Entity> {
    protected String TABLE_NAME;

    protected ArrayList<String> query_columns = null;
    protected Condition query_condition = null;

    abstract protected Entity parseEntity(Map<String, Object> map) throws SQLException;

    protected List<Entity> query(String sql, Object... params) {
        List<Entity> entity_list = new ArrayList<>();
        List<Map<String, Object>> result = JDBCUtils.query(sql, params);
        try {
            for (Map<String, Object> map : result) {
                entity_list.add(this.parseEntity(map));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return entity_list;
    }

    protected void execute(String sql, Object... params) {
        try {
            JDBCUtils.exec(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public BaseDAO<Entity> column(String column) {
        this.query_columns.add(column);
        return this;
    }

    public BaseDAO<Entity> column(String... columns) {
        for (String column : columns) {
            this.column(column);
        }
        return this;
    }

    public BaseDAO<Entity> where(Condition condition) {
        this.query_condition = condition;
        return this;
    }

    public BaseDAO<Entity> where(Condition... conditions) {
        this.where(new And(conditions));
        return this;
    }

    protected String columnsToSql(List<String> columns) {
        StringBuilder columns_sb = new StringBuilder();
        for (String column : columns) {
            column = FormatUtils.column(column);
            if (columns_sb.length() > 0)
                columns_sb.append(",");
            columns_sb.append(column);
        }

        String columns_str = columns_sb.toString();
        columns_str = columns_str.length() == 0 ? "*" : columns_str;
        return columns_str;
    }

    public List<Entity> select() {
        String sql = String.format("SELECT %s FROM %s", this.columnsToSql(this.query_columns), this.TABLE_NAME);
        List<Object> params = new ArrayList<>();

        if (this.query_condition != null) {
            sql += " WHERE " + this.query_condition.toSql();
            params.addAll(this.query_condition.params());
        }

        System.out.println(sql);

        return this.query(sql, params.toArray());
    }
}
