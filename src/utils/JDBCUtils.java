package utils;

import common.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
    private static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=%s&useSSL=false&serverTimezone=CTT",
                            Config.DB_HOST, Config.DB_PORT, Config.DB_DATABASE, Config.DB_ENCODING
                    ), Config.DB_USER, Config.DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        return conn;
    }

    /**
     * 填充SQL参数
     */
    private static void formatSql(PreparedStatement ps, Object... params) throws SQLException {
        int count = 1;
        for (Object p : params) {
            if (p instanceof Integer) {
                ps.setInt(count, (Integer) p);
            } else if (p instanceof String) {
                ps.setString(count, (String) p);
            } else if (p instanceof Date) {
                ps.setDate(count, (Date) p);
            }
            count++;
        }
    }

    /**
     * 执行DML
     */
    public static void exec(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            JDBCUtils.formatSql(ps, params);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            // conn.close();
        }
    }

    /**
     * 执行DQL
     */
    public static List<Map<String, Object>> query(String sql, Object... params) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            JDBCUtils.formatSql(ps, params);
            rs = ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                resultList.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                // conn.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return resultList;
    }
}
