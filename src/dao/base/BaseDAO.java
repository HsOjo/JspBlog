package dao.base;

import dao.base.condition.And;
import dao.base.condition.base.Condition;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.*;

public abstract class BaseDAO<Entity> {
    public String table_name;

    protected String query_target;
    protected ArrayList<String> query_columns;
    protected ArrayList<Object> query_params;
    protected Condition query_condition;
    protected int query_limit;
    protected Map<String, Object> query_data;
    protected ArrayList<Order> query_order;

    public BaseDAO() {
        this.table_name = FormatUtils.table(this.getClass().getSimpleName());
        this.reset();
    }

    public BaseDAO(String table_name) {
        this.table_name = table_name;
        this.reset();
    }

    private void reset() {
        this.query_target = this.table_name;
        this.query_columns = new ArrayList<>();
        this.query_params = new ArrayList<>();
        this.query_condition = null;
        this.query_limit = 0;
        this.query_data = new HashMap<>();
        this.query_order = new ArrayList<>();
    }

    abstract protected Entity parseEntity(Map<String, Object> map) throws SQLException;

    protected List<Entity> query(String sql, Object... params) {
        System.out.println(String.format("query: %s", sql));
        this.reset();
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
        System.out.println(String.format("execute: %s", sql));
        this.reset();
        try {
            JDBCUtils.exec(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public BaseDAO<Entity> column(String... columns) {
        this.query_columns.addAll(Arrays.asList(columns));
        return this;
    }

    public BaseDAO<Entity> where(Condition... conditions) {
        this.query_condition = new And(conditions);
        return this;
    }

    public BaseDAO<Entity> limit(int limit) {
        this.query_limit = limit;
        return this;
    }

    public BaseDAO<Entity> order(Order... order) {
        this.query_order.addAll(Arrays.asList(order));
        return this;
    }

    public BaseDAO<Entity> data(Map<String, Object> data) {
        this.query_columns.addAll(data.keySet());
        this.query_params.addAll(data.values());
        return this;
    }

    protected String columnSql(boolean set) {
        List<String> columns = this.query_columns;
        StringBuilder sql_sb = new StringBuilder();
        if (columns != null)
            for (String column : columns) {
                column = FormatUtils.column(column);
                if (sql_sb.length() > 0)
                    sql_sb.append(",");
                sql_sb.append(column);
                if (set)
                    sql_sb.append("=?");
            }

        String sql = sql_sb.toString();
        sql = sql.length() == 0 ? "*" : sql;
        return sql;
    }

    protected String valueSql() {
        StringBuilder sql_sb = new StringBuilder();
        for (int i = 0; i < this.query_columns.size(); i++) {
            if (sql_sb.length() > 0)
                sql_sb.append(",");
            sql_sb.append("?");
        }

        return String.format("VALUES(%s)", sql_sb.toString());
    }

    protected String whereSql() {
        String sql = "";
        Condition condition = this.query_condition;
        if (condition != null) {
            sql = String.format("WHERE %s", condition.toSql());
            this.query_params.addAll(condition.params());
        }
        return sql;
    }

    protected String limitSql() {
        String sql = "";
        if (this.query_limit > 0)
            sql += String.format("LIMIT %d", this.query_limit);
        return sql;
    }

    protected String orderSql() {
        StringBuilder sql_sb = new StringBuilder();
        if (this.query_order.size() > 0)
            for (Order order : this.query_order) {
                if (sql_sb.length() > 0)
                    sql_sb.append(",");
                sql_sb.append(String.format("%s %s", order.column, order.order));
            }

        String sql = sql_sb.toString();
        if (sql.length() > 0)
            sql = String.format("ORDER BY %s", sql);
        return sql;
    }

    public List<Entity> select() {
        String sql = String.format("SELECT %s FROM `%s` %s %s %s",
                this.columnSql(false), this.table_name, this.whereSql(), this.orderSql(), this.limitSql()
        ).trim();
        return this.query(sql, this.query_params.toArray());
    }

    public void insert() {
        String sql = String.format("INSERT INTO `%s` (%s) %s %s",
                this.table_name, this.columnSql(false), this.valueSql(), this.whereSql()
        ).trim();
        this.execute(sql, this.query_params.toArray());
    }

    public void update() {
        String sql = String.format("UPDATE `%s` SET %s %s %s",
                this.table_name, this.columnSql(true), this.whereSql(), this.limitSql()
        ).trim();
        this.execute(sql, this.query_params.toArray());
    }

    public void delete() {
        String sql = String.format("DELETE FROM `%s` %s %s",
                this.table_name, this.whereSql(), this.limitSql()
        ).trim();
        this.execute(sql, this.query_params.toArray());
    }

    public Entity find() {
        Entity item = null;
        List<Entity> items = this.select();
        if (items.size() > 0)
            item = items.get(0);
        return item;
    }
}
