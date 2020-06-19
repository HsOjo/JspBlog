package controller.base;

import dao.CategoryDAO;
import dao.FriendLinkDAO;
import entity.Category;
import entity.FriendLink;
import service.SettingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class HomeBaseController extends UserBaseController {
    @Override
    public void fetch(HttpServletRequest req, HttpServletResponse resp, String path, HashMap<String, Object> values) {
        if (values == null)
            values = new HashMap<>();

        List<Category> categories = CategoryDAO.getInstance().select();
        List<FriendLink> friend_links = FriendLinkDAO.getInstance().select();
        SettingService settings = SettingService.getInstance();

        values.put("current_user", this.getCurrentUser(req));
        values.put("site_setting", settings.getSiteSetting());
        values.put("info_setting", settings.getInfoSetting());
        values.put("categories", categories);
        values.put("friend_links", friend_links);

        super.fetch(req, resp, path, values);
    }
}
