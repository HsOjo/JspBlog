package controller.base;

import dao.CategoryDAO;
import dao.FriendLinkDAO;
import dao.SettingDAO;
import dao.base.condition.Column;
import entity.Category;
import entity.FriendLink;
import entity.Setting;
import entity.User;
import entity.setting.InfoSetting;
import entity.setting.SiteSetting;
import utils.CookieUtils;
import utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

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
        if (values != null) {
            List<Category> categories = CategoryDAO.getInstance().select();
            List<FriendLink> friend_links = FriendLinkDAO.getInstance().select();
            Setting site_setting = SettingDAO.getInstance().where(Column.check("key", "=", "site_setting")).find();
            Setting info_setting = SettingDAO.getInstance().where(Column.check("key", "=", "info_setting")).find();

            values.put("current_user", this.getCurrentUser(req));
            values.put("site_setting", SiteSetting.getInstance(site_setting.getData()));
            values.put("info_setting", InfoSetting.getInstance(info_setting.getData()));
            values.put("categories", categories);
            values.put("friend_links", friend_links);
        }
        super.fetch(req, resp, path, values);
    }
}
