package dao;

import dao.base.BaseDAO;
import entity.User;

import java.sql.SQLException;
import java.util.Map;

public class UserDAO extends BaseDAO<User> {
    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    protected User parseEntity(Map<String, Object> map) throws SQLException {
        return new User(
                (int) map.get("id"),
                (String) map.get("username"),
                (String) map.get("password"),
                ((int) map.get("is_admin")) == 1,
                (String) map.get("email"),
                (String) map.get("phone"),
                (String) map.get("introduce")
        );
    }
}
