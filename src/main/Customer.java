package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String login;
    private String password;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }


}
