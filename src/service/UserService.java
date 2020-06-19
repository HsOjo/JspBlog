package service;

import dao.UserDAO;
import dao.base.condition.Column;
import entity.User;

import java.util.HashMap;

public class UserService {
    private final UserDAO dao;
    private HashMap<Integer, User> user_buffer;

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

    public User getUserById(int user_id) {
        if (this.user_buffer == null)
            this.user_buffer = new HashMap<>();
        User user;
        if (user_buffer.containsKey(user_id)) {
            user = user_buffer.get(user_id);
        } else {
            user = this.dao.where(Column.check("id", "=", user_id)).find();
            this.user_buffer.put(user_id, user);
        }
        return user;
    }
}
