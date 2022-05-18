package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class User {
    @Id
    private String username;
    private String password;
    private String role;

    private String list;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.list = "empty";
    }


    public String getList(){
        return this.list.toString();
    }

    public String getListToString(){
        return this.list.toString();
    }

//    public String set

//    public User(String username, String password, String role, String list) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.list = list;
//    }

//    public String getList() {
//        return list;
//    }

    public User() {
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

    public void setList(String list) {
        this.list = list;
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
