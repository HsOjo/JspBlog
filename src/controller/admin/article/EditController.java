package controller.admin.article;

import controller.base.AdminBaseController;
import dao.ArticleDAO;
import dao.ArticleDAO;
import dao.base.condition.Column;
import entity.Article;
import entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/article/edit")
public class EditController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.authentication(req, resp);
        Map<String, String> param = this.param(req);
        int id = Integer.parseInt(param.get("id"));
        Article article = ArticleDAO.getInstance().where(Column.check("id", "=", id)).find();
        HashMap<String, Object> values = new HashMap<>();
        values.put("article", article);
        this.fetch(req, resp, values);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.authentication(req, resp);
        Map<String, Object> param = this.paramAsObject(req);
        int id = Integer.parseInt((String) param.get("id"));
        int result = ArticleDAO.getInstance().data(param).where(Column.check("id", "=", id)).update();
        if (result > 0) {
            this.message(req, resp, "编辑成功");
        } else {
            this.message(req, resp, "编辑失败");
        }
        this.redirect(req, resp, "admin/article/index");
    }
}
