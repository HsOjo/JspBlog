package controller.base;

import entity.User;
import utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;

public class UserBaseController extends BaseController {
    private static final String CURRENT_USER = "current_user";

    public User getCurrentUser(HttpServletRequest req) {
        return (User) SessionUtils.getInstance(req).get(CURRENT_USER);
    }

    public void setCurrentUser(HttpServletRequest req, User user) {
        SessionUtils.getInstance(req).set(CURRENT_USER, user);
    }
}
