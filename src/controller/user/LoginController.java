package controller.user;

import controller.base.HomeBaseController;
import entity.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet("/user/login")
public class LoginController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (this.getCurrentUser(req) == null)
            this.fetch(req, resp);
        else
            this.redirect(req, resp, "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if (!this.checkCaptcha(req, resp)) return;
        Map<String, String> param = this.param(req);
        User user = UserService.getInstance().login(
                param.get("username"),
                param.get("password")
        );
        if (user != null) {
            this.setCurrentUser(req, user);
            this.message(req, resp, "登录成功");
            this.redirect(req, resp, "");
        } else {
            this.message(req, resp, "登录失败");
            this.fetch(req, resp);
        }
    }
}
