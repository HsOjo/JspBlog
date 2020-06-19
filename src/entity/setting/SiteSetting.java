package entity.setting;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class SiteSetting {
    private String site_name;
    private String site_footer;

    public SiteSetting(String site_name, String site_footer) {
        this.site_name = site_name;
        this.site_footer = site_footer;
    }

    public static SiteSetting getInstance(String json) {
        JSONObject object = JSON.parseObject(json);
        return new SiteSetting(
                object.getString("site_name"),
                object.getString("site_footer")
        );
    }

    public String getSiteName() {
        return site_name;
    }

    public void setSiteName(String site_name) {
        this.site_name = site_name;
    }

    public String getSiteFooter() {
        return site_footer;
    }

    public void setSiteFooter(String site_footer) {
        this.site_footer = site_footer;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return "SiteSetting{" +
                "site_name='" + site_name + '\'' +
                ", site_footer='" + site_footer + '\'' +
                '}';
    }
}
