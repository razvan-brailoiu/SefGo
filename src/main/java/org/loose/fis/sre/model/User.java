package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class User {
    @Id
    private String username;
    private String password;
    private String role;
    private static String last_username;
    private static String last_password;


    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public static void setLast_username(String username)
    {
        last_username = username;
    }

    public static void setLast_pasword(String password)
    {
        last_password = password;
    }

    public static String getLast_pasword() {
        return last_password;
    }

    public static String getLast_username() {
        return last_username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        String buletin = "";
        buletin += this.username + " " + this.role;
        return buletin;
    }
}
