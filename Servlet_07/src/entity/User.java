package entity;

/**
 * Created by Administrator on 2014/12/15.
 * 实体类:与t_user表对应
 * 每一个列对应一个属性
 */
public class User {
    private int id;
    private String username;
    private String pwd;
    private String name;
    private String gender;

    public User() {
        super();
    }

    public User(int id, String username, String pwd, String name, String gender) {
        super();
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.id + " " + this.username + " " + this.pwd + " " + this.name + " " + this.gender;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
