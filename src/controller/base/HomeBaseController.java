package controller.base;

import entity.User;
import utils.CookieUtils;
import utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class HomeBaseController extends BaseController {
    private static final String BLOG_MSG = "_blog_msg";
    private static final String CURRENT_USER = "current_user";

    public void message(HttpServletRequest req, HttpServletResponse resp, String msg) {
        System.out.println(String.format("message: %s", msg));
        CookieUtils.getInstance(req, resp).set(BLOG_MSG, msg);
    }

    public User getCurrentUser(HttpServletRequest req) {
        return (User) SessionUtils.getInstance(req).get(CURRENT_USER);
    }

    public void setCurrentUser(HttpServletRequest req, User user) {
        SessionUtils.getInstance(req).set(CURRENT_USER, user);
    }

    @Override
    public void fetch(HttpServletRequest req, HttpServletResponse resp, String path, HashMap<String, Object> values) {
        if (values != null)
            values.put("current_user", this.getCurrentUser(req));
        super.fetch(req, resp, path, values);
    }
}
