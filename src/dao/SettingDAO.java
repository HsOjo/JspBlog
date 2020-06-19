package dao;

import com.alibaba.fastjson.JSON;
import dao.base.BaseDAO;
import entity.Setting;

import java.sql.SQLException;
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
}
