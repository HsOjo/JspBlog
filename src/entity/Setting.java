package entity;

public class Setting {
    private int id;
    private String key;
    private String data;

    public Setting(int id, String key, String data) {
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

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
