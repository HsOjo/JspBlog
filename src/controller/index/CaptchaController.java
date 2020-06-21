package controller.index;

import controller.base.HomeBaseController;
import utils.CaptchaUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/index/captcha")
public class CaptchaController extends HomeBaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.refreshCaptcha(req);

        resp.setDateHeader("Expires", 0);
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
        resp.setHeader("Pragma", "no-cache");
        resp.setContentType("image/jpeg");

        OutputStream os = resp.getOutputStream();
        BufferedImage image = CaptchaUtils.getImageCode(this.getCaptcha(req), 96, 32);
        try {
            ImageIO.write(image, "jpg", os);
        } finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
    }
}
