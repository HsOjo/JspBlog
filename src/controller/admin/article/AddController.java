package controller.admin.article;

import controller.base.AdminBaseController;
import service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/article/add")
public class AddController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        this.fetch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.authentication(req, resp)) return;
        Map<String, String> param = this.param(req);
        int id = ArticleService.getInstance().createArticle(
                param.get("title"),
                param.get("content"),
                Integer.parseInt(param.get("category_id")),
                this.getCurrentUser(req).getId()
        );
        if (id > 0) {
            this.message(req, resp, "添加成功");
        } else {
            this.message(req, resp, "添加失败");
        }
        this.fetch(req, resp);
    }
}
