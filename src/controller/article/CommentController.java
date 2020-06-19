package controller.article;

import controller.base.HomeBaseController;
import dao.CommentDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/article/comment")
public class CommentController extends HomeBaseController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = this.getCurrentUser(req);
        if (user == null) {
            this.message(req, resp, "请先登录");
            this.redirect(req, resp, "user/login");
        } else {
            Map<String, String> param = this.param(req);
            Map<String, Object> data = new HashMap<>();
            data.put("article_id", param.get("id"));
            data.put("user_id", user.getId());
            data.put("content", param.get("content"));
            data.put("create_time", (int) (new Date().getTime() / 1000));
            int index = CommentDAO.getInstance().data(data).insert();
            if (index > 0) {
                this.message(req, resp, "评论成功");
            } else {
                this.message(req, resp, "评论失败");
            }
            this.redirect(req, resp, String.format("article/view?id=%s", param.get("id")));
        }
    }
}
