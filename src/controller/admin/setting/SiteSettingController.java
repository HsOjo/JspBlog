package controller.admin.setting;


import controller.base.AdminBaseController;
import service.SettingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/setting/site_setting")
public class SiteSettingController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (!this.authentication(req, resp)) return;
        this.fetch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        Map<String, String> param = this.param(req);
        SettingService.getInstance().saveSiteSetting(param);
        this.fetch(req, resp);
    }
}
