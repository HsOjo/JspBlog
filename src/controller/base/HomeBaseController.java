package controller.base;

import dao.CategoryDAO;
import dao.FriendLinkDAO;
import entity.Category;
import entity.FriendLink;
import service.ArticleService;
import service.CategoryService;
import service.SettingService;
import service.UserService;
import utils.ConvertUtils;
import utils.HashUtils;
import utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class HomeBaseController extends UserBaseController {
    public static final String CAPTCHA = "captcha";

    @Override
    public void fetch(HttpServletRequest req, HttpServletResponse resp, String path, HashMap<String, Object> values) {
        if (values == null)
            values = new HashMap<>();

        List<Category> categories = CategoryDAO.getInstance().select();
        List<FriendLink> friend_links = FriendLinkDAO.getInstance().select();
        SettingService settings = SettingService.getInstance();
        UserService user_service = UserService.getInstance();
        ArticleService article_service = ArticleService.getInstance();
        CategoryService category_service = CategoryService.getInstance();
        ConvertUtils convert_utils = ConvertUtils.getInstance();

        values.put("current_user", this.getCurrentUser(req));
        values.put("site_setting", settings.getSiteSetting());
        values.put("info_setting", settings.getInfoSetting());
        values.put("categories", categories);
        values.put("friend_links", friend_links);
        values.put("user_service", user_service);
        values.put("article_service", article_service);
        values.put("category_service", category_service);
        values.put("convert_utils", convert_utils);

        super.fetch(req, resp, path, values);
    }

    public void refreshCaptcha(HttpServletRequest req) {
        String captcha = HashUtils.md5(
                String.valueOf((int) (new Date().getTime() / 1000)))
                .substring(0, 4).toUpperCase();
        SessionUtils.getInstance(req).set(CAPTCHA, captcha);
    }

    public String getCaptcha(HttpServletRequest req) {
        return (String) SessionUtils.getInstance(req).get(CAPTCHA);
    }

    public boolean checkCaptcha(HttpServletRequest req, HttpServletResponse resp) {
        if (!this.param(req).get(CAPTCHA).toUpperCase().equals(this.getCaptcha(req))) {
            this.message(req, resp, "验证码错误");
            this.redirect(req, resp, req.getHeader("Referer"));
            return false;
        }
        return true;
    }
}
