package controller.user;

import controller.base.HomeBaseController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/logout")
public class LogoutController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.setCurrentUser(req, null);
        this.message(req, resp, "注销成功");
        this.redirect(req, resp, "user/login");
    }
}
