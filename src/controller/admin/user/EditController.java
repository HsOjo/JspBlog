package controller.admin.user;

import controller.base.AdminBaseController;
import dao.UserDAO;
import dao.base.condition.Column;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/user/edit")
public class EditController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.authentication(req, resp);
        Map<String, String> param = this.param(req);
        int id = Integer.parseInt(param.get("id"));
        User user = UserDAO.getInstance().where(Column.check("id", "=", id)).find();
        HashMap<String, Object> values = new HashMap<>();
        values.put("user", user);
        this.fetch(req, resp, values);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.authentication(req, resp);
        Map<String, Object> param = this.paramAsObject(req);
        int id = Integer.parseInt((String) param.get("id"));
        if (param.containsKey("is_admin"))
            param.replace("is_admin", true);
        else
            param.put("is_admin", false);

        if (param.get("password").equals(""))
            param.remove("password");

        int result = UserDAO.getInstance().data(param).where(Column.check("id", "=", id)).update();
        if (result > 0) {
            this.message(req, resp, "编辑成功");
        } else {
            this.message(req, resp, "编辑失败");
        }
        this.redirect(req, resp, "admin/user/index");
    }
}
