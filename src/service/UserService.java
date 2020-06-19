package service;

import dao.UserDAO;
import dao.base.condition.Column;
import entity.User;

import java.util.HashMap;

public class UserService {
    private final UserDAO dao;

    public UserService() {
        this.dao = new UserDAO();
    }

    public static UserService getInstance() {
        return new UserService();
    }

    public int register(String username, String password, boolean is_admin, String email, String phone, String introduce) {
        User user = this.dao.where(Column.check("username", "=", username)).find();
        if (user != null)
            return -1;
        HashMap<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);
        data.put("is_admin", is_admin);
        data.put("email", email);
        data.put("phone", phone);
        data.put("introduce", introduce);
        return this.dao.data(data).insert();
    }

    public User login(String username, String password) {
        return this.dao.where(
                Column.check("username", "=", username),
                Column.check("password", "=", password)
        ).find();
    }
}
