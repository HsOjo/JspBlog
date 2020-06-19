package controller.user;

import controller.base.HomeBaseController;
import dao.UserDAO;
import dao.base.condition.Column;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/view")
public class ViewController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> param = this.param(req);
        HashMap<String, Object> values = new HashMap<>();
        String id = param.get("id");
        if (id != null) {
            User user = UserDAO.getInstance().where(Column.check("id", "=", id)).find();
            values.put("item", user);
            this.fetch(req, resp, values);
        } else {
            this.message(req, resp, "用户不存在");
            this.redirect(req, resp, "");
        }
    }
}
