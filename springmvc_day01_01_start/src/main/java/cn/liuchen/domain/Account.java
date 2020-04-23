package cn.liuchen.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 账号实体类
 */
public class Account implements Serializable {
    private String username;
    private String password;
    private Double money;

    private List<User> users;

    private Map<String, User> userMap;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", users=" + users +
                ", userMap=" + userMap +
                '}';
    }
}
