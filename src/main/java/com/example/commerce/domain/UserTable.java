package com.example.commerce.domain;

import javax.persistence.*;

public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userid;

    @Column(name = "name")
    private String name;

    @Column (name = "password")
    private String password;

    public String getId() {
        return userid;
    }

    public void setId(String userid) {
        this.userid = userid;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {this.password = password; }
}
