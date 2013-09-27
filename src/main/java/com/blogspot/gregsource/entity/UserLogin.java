package com.blogspot.gregsource.entity;

/**
 * Created with IntelliJ IDEA.
 * User: grega
 * Date: 25/9/13
 * Time: 7:00 PM
 */
public class UserLogin {
    String username;
    String password;

    public UserLogin() {
        super();
    }

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "username: " + username + " password: " + password;
    }

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
}