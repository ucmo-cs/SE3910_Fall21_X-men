package com.example.commerce.service;

import com.example.commerce.domain.UserTable;
import com.example.commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserTable search(String username, String password)
    {
        return userRepository.searchUser(username, password);
    }

    public int setOfflineIfOnline()
    {
        userRepository.setOfflineIfOnline();
        return 1;
    }
}
