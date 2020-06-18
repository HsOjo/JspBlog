package dao;

import com.alibaba.fastjson.JSON;
import dao.base.BaseDAO;
import entity.FriendLink;

import java.sql.SQLException;
import java.util.Map;

public class FriendLinkDAO extends BaseDAO<FriendLink> {
    public static FriendLinkDAO getInstance() {
        return new FriendLinkDAO();
    }

    @Override
    protected FriendLink parseEntity(Map<String, Object> map) {
        return new FriendLink(
                (int) map.get("id"),
                (String) map.get("name"),
                (String) map.get("url")
        );
    }
}
