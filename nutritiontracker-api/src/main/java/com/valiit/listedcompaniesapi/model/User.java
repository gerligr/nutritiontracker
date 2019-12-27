package com.valiit.listedcompaniesapi.model;

public class User {

    private int id;
    private String username;
    private String name;
    private String password;
    private String email;

    public User(int id, String username, String name, String password, String email) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public User(String username, String name, String password, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
