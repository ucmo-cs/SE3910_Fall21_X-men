package com.example.commerce.repository;

import com.example.commerce.domain.UserTable;

public interface UserRepository
{
    int setOffline(UserTable user);
    int setOnline(UserTable user);
    UserTable searchUser(String username, String password);
    UserTable setOfflineIfOnline();
}
