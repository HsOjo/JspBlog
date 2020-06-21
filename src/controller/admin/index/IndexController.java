package controller.admin.index;


import controller.base.AdminBaseController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class IndexController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (!this.authentication(req, resp)) return;
        this.fetch(req, resp);
    }
}
