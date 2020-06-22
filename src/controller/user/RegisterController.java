package controller.user;

import controller.base.HomeBaseController;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/register")
public class RegisterController extends HomeBaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.fetch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if (!this.checkCaptcha(req, resp, true)) {
            this.jsonResponse(resp, 0, "验证码错误");
            return;
        }

        Map<String, String> param = this.param(req);
        int user_id = UserService.getInstance().register(
                param.get("username"),
                param.get("password"),
                false,
                param.get("email"),
                param.get("phone"),
                param.get("introduce")
        );
        if (user_id != -1) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("url", this.url(req, "user/login"));
            this.jsonResponse(resp, 1, "注册成功", data);
        } else {
            this.jsonResponse(resp, 0, "注册失败，请检查用户信息");
        }
    }
}
