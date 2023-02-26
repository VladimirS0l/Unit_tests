package seminars.third.tdd.model;

public class User {
    private int id;
    private String login;
    private String password;

    private Enum Admin;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public Enum getAdmin() {
        return Admin;
    }

    public void setAdmin(Enum admin) {
        Admin = admin;
    }

    public User(int id, String login, String password, Enum admin) {
        this.id = id;
        this.login = login;
        this.password = password;
        Admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", Admin=" + Admin +
                '}';
    }
}
