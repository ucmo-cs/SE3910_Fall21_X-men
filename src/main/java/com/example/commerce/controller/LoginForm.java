package com.example.commerce.controller;

public class LoginForm
{
    private String userID;
    private String password;

    public LoginForm(String userID, String password)
    {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
