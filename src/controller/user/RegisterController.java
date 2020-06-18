package controller.user;

import controller.base.HomeBaseController;
import dao.UserDAO;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/register")
public class RegisterController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.fetch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int user_id = UserService.getInstance(UserDAO.getInstance()).register(
                req.getParameter("username"),
                req.getParameter("password"),
                false,
                req.getParameter("email"),
                req.getParameter("phone"),
                req.getParameter("introduce")
        );
        if (user_id != -1) {
            this.message(req, resp, "注册成功！");
            this.redirect(req, resp, "user/login");
        } else {
            this.message(req, resp, "注册失败！");
            this.fetch(req, resp);
        }
    }
}
