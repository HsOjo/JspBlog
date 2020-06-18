package entity;

import java.util.Map;

public class Setting {
    private int id;
    private String key;
    private Map<String, Object> data;

    public Setting(int id, String key, Map<String, Object> data) {
        this.id = id;
        this.key = key;
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
