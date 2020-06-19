package dao.base;

import dao.base.condition.And;
import dao.base.condition.base.Condition;
import utils.JDBCUtils;

import java.util.*;

public abstract class BaseDAO<Entity> {
    public String table_name;

    protected String query_target;
    protected ArrayList<String> query_columns;
    protected ArrayList<Object> query_params;
    protected Condition query_condition;
    protected int query_limit;
    protected int query_offset;
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
        this.query_offset = -1;
        this.query_data = new HashMap<>();
        this.query_order = new ArrayList<>();
    }

    abstract protected Entity parseEntity(Map<String, Object> map);

    protected Map<String, Object> convertData(Map<String, Object> data) {
        return data;
    }

    protected List<Map<String, Object>> rawQuery(String sql, Object... params) {
        this.reset();
        System.out.println(String.format("query: %s, data: %s", sql, Arrays.asList(params)));
        return JDBCUtils.query(sql, params);
    }

    protected List<Entity> query(String sql, Object... params) {
        List<Entity> entity_list = new ArrayList<>();
        List<Map<String, Object>> result = this.rawQuery(sql, params);
        if (result != null)
            for (Map<String, Object> map : result) {
                entity_list.add(this.parseEntity(map));
            }
        return entity_list;
    }


    protected Map<Integer, Object> execute(String sql, Object... params) {
        this.reset();
        System.out.println(String.format("execute: %s, data: %s", sql, Arrays.asList(params)));
        Map<Integer, Object> result = JDBCUtils.execute(sql, params);
        System.out.println(String.format("executed: %s", result));
        return result;
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

    public BaseDAO<Entity> offset(int offset) {
        this.query_offset = offset;
        return this;
    }

    public BaseDAO<Entity> order(Order... order) {
        this.query_order.addAll(Arrays.asList(order));
        return this;
    }

    public BaseDAO<Entity> data(Map<String, Object> data) {
        data = this.convertData(data);
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

    protected String offsetSql() {
        String sql = "";
        if (this.query_offset != -1)
            sql += String.format("OFFSET %d", this.query_offset);
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
        String sql = String.format("SELECT %s FROM `%s` %s %s %s %s",
                this.columnSql(false), this.table_name,
                this.whereSql(), this.orderSql(), this.limitSql(), this.offsetSql()
        ).trim();
        return this.query(sql, this.query_params.toArray());
    }

    public long count() {
        String sql = String.format("SELECT COUNT(%s) AS `num` FROM `%s` %s %s %s %s",
                this.columnSql(false), this.table_name,
                this.whereSql(), this.orderSql(), this.limitSql(), this.offsetSql()
        ).trim();
        List<Map<String, Object>> result = this.rawQuery(sql, this.query_params.toArray());
        long num = -1;
        if (result != null && result.size() > 0)
            num = (Long) (result.get(0).get("num"));

        return num;
    }

    public int insert() {
        String sql = String.format("INSERT INTO `%s` (%s) %s %s",
                this.table_name, this.columnSql(false), this.valueSql(), this.whereSql()
        ).trim();
        return (int) this.execute(sql, this.query_params.toArray()).get(JDBCUtils.EXEC_LAST_INDEX);
    }

    public int update() {
        String sql = String.format("UPDATE `%s` SET %s %s %s",
                this.table_name, this.columnSql(true), this.whereSql(), this.limitSql()
        ).trim();
        return (int) this.execute(sql, this.query_params.toArray()).get(JDBCUtils.EXEC_AFFECT_ROWS);
    }

    public int delete() {
        String sql = String.format("DELETE FROM `%s` %s %s",
                this.table_name, this.whereSql(), this.limitSql()
        ).trim();
        return (int) this.execute(sql, this.query_params.toArray()).get(JDBCUtils.EXEC_AFFECT_ROWS);
    }

    public Entity find() {
        Entity item = null;
        List<Entity> items = this.limit(1).select();
        if (items.size() > 0)
            item = items.get(0);
        return item;
    }
}
