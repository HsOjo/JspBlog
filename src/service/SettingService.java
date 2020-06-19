package service;

import com.alibaba.fastjson.JSON;
import dao.SettingDAO;
import dao.base.condition.Column;
import entity.Setting;
import entity.setting.InfoSetting;
import entity.setting.SiteSetting;

import java.util.HashMap;
import java.util.Map;

public class SettingService {
    private static final String SITE_SETTING = "site_setting";
    private static final String INFO_SETTING = "info_setting";

    private final SettingDAO dao;

    public SettingService() {
        this.dao = new SettingDAO();
    }

    public static SettingService getInstance() {
        return new SettingService();
    }

    public SiteSetting getSiteSetting() {
        Setting site_setting = this.dao.where(Column.check("key", "=", SITE_SETTING)).find();
        return SiteSetting.getInstance(site_setting.getData());
    }

    public InfoSetting getInfoSetting() {
        Setting info_setting = this.dao.where(Column.check("key", "=", INFO_SETTING)).find();
        return InfoSetting.getInstance(info_setting.getData());
    }

    public void saveSiteSetting(Map<String, String> site_setting) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", JSON.toJSONString(site_setting));
        this.dao.data(data).where(Column.check("key", "=", SITE_SETTING)).update();
    }

    public void saveInfoSetting(Map<String, String> info_setting) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", JSON.toJSONString(info_setting));
        this.dao.data(data).where(Column.check("key", "=", INFO_SETTING)).update();
    }
}
