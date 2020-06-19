package dao;

import dao.base.BaseDAO;
import entity.User;

import java.util.Map;

public class UserDAO extends BaseDAO<User> {
    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    protected User parseEntity(Map<String, Object> map) {
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

    @Override
    protected Map<String, Object> convertData(Map<String, Object> data) {
        System.out.println("testtest:" + data);
        data.replace("is_admin", ((boolean) data.getOrDefault("is_admin", false)) ? 1 : 0);
        return data;
    }

    @Override
    public String[] fields() {
        return new String[]{"id", "username", "password", "is_admin", "email", "phone", "introduce"};
    }
}
