package controller.base;

import utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeBaseController extends BaseController {
    public void message(HttpServletRequest req, HttpServletResponse resp, String msg) {
        System.out.println(String.format("message: %s", msg));
        CookieUtils.getInstance(req, resp).setValue("_blog_msg", msg);
    }
}
