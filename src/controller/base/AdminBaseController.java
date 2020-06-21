package controller.base;

import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminBaseController extends HomeBaseController {
    public String getTemplatePath() {
        String path = this.getServletPath();
        String[] item = path.split("/");
        String module = item.length > 2 ? item[2] : "index";
        String action = item.length > 3 ? item[3] : "index";
        return String.format("/templates/admin/%s/%s.jsp", module, action);
    }

    public boolean authentication(HttpServletRequest req, HttpServletResponse resp) {
        User user = this.getCurrentUser(req);
        if (user == null || !user.getIsAdmin()) {
            this.message(req, resp, "拒绝访问");
            this.redirect(req, resp, "user/login");
            return false;
        }
        return true;
    }
}
