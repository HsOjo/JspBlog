package controller.admin.user;

import controller.base.AdminBaseController;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/user/add")
public class AddController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        this.fetch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        Map<String, String> param = this.param(req);
        int id = UserService.getInstance().register(
                param.get("username"),
                param.get("password"),
                !param.getOrDefault("is_admin", "").equals(""),
                param.get("email"),
                param.get("phone"),
                param.get("introduce")
        );
        if (id > 0) {
            this.message(req, resp, "添加成功");
        } else {
            this.message(req, resp, "添加失败");
        }
        this.fetch(req, resp);
    }
}
