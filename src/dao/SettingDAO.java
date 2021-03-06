package dao;

import dao.base.BaseDAO;
import entity.Setting;

import java.util.Map;

public class SettingDAO extends BaseDAO<Setting> {
    public static SettingDAO getInstance() {
        return new SettingDAO();
    }

    @Override
    protected Setting parseEntity(Map<String, Object> map) {
        return new Setting(
                (int) map.get("id"),
                (String) map.get("key"),
                (String) map.get("data")
        );
    }

    @Override
    public String[] fields() {
        return new String[]{"id", "key", "data"};
    }
}
