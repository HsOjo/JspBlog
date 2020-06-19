package entity.setting;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class InfoSetting extends BaseSetting {
    private String blog_title;
    private String blog_description;
    private String about;

    public InfoSetting(String blog_title, String blog_description, String about) {
        this.blog_title = blog_title;
        this.blog_description = blog_description;
        this.about = about;
    }

    public static InfoSetting getInstance(String json) {
        JSONObject object = JSON.parseObject(json);
        return new InfoSetting(
                object.getString("blog_title"),
                object.getString("blog_description"),
                object.getString("about")
        );
    }

    public String getBlogTitle() {
        return blog_title;
    }

    public void setBlogTitle(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlogDescription() {
        return blog_description;
    }

    public void setBlogDescription(String blog_description) {
        this.blog_description = blog_description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return "InfoSetting{" +
                "blog_title='" + blog_title + '\'' +
                ", blog_description='" + blog_description + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
