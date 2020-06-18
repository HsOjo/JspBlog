package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    HttpServletRequest req;
    HttpServletResponse resp;
    int max_age;

    public CookieUtils(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
        this.max_age = 86400;
    }

    public static CookieUtils getInstance(HttpServletRequest req, HttpServletResponse resp) {
        return new CookieUtils(req, resp);
    }

    public void setMaxAge(int age) {
        this.max_age = age;
    }

    public Cookie get(String name) {
        for (Cookie cookie : this.req.getCookies()) {
            if (cookie.getName().equals(name))
                return cookie;
        }
        return null;
    }

    public String getValue(String name, String default_) {
        String str = default_;
        Cookie cookie = this.get(name);
        if (cookie != null)
            str = cookie.getValue();
        return str;
    }

    public void set(String name, Cookie cookie) {
        this.resp.addCookie(cookie);
    }

    public void setValue(String name, String value) {
        Cookie cookie = this.get(name);
        if (cookie == null)
            cookie = new Cookie(name, value);
        else
            cookie.setValue(value);
        cookie.setMaxAge(this.max_age);
        cookie.setPath("/");
        this.set(name, cookie);
    }
}
