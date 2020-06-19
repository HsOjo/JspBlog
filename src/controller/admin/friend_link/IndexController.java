package controller.admin.friend_link;

import controller.base.AdminBaseController;
import dao.FriendLinkDAO;
import dao.base.Paginate;
import entity.FriendLink;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/friend_link/index")
public class IndexController extends AdminBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.authentication(req, resp);
        Map<String, String> param = this.param(req);
        int page = Integer.parseInt(param.getOrDefault("page", "1"));

        Paginate<FriendLink> paginate = FriendLinkDAO.getInstance().paginate(page);
        HashMap<String, Object> values = new HashMap<>();
        values.put("paginate", paginate);
        this.fetch(req, resp, values);
    }
}
