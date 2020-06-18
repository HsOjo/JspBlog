package entity;

public class User {
    private int id;
    private String username;
    private String password;
    private boolean is_admin;
    private String email;
    private String phone;
    private String introduce;

    public User(int id, String username, String password, boolean is_admin, String email, String phone, String introduce) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.is_admin = is_admin;
        this.email = email;
        this.phone = phone;
        this.introduce = introduce;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return this.is_admin;
    }

    public void setIsAdmin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
