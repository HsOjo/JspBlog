package dao;

import dao.base.BaseDAO;
import entity.FriendLink;

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
                (String) map.get("name")
        );
    }

    @Override
    public String[] fields() {
        return new String[]{"id", "name", "name"};
    }
}
