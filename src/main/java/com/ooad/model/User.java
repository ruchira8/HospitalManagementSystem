package com.ooad.model;

import javax.persistence.*;


@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USERTYPE", nullable = false)
    private String userType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

