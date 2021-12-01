package com.example.commerce.controller;

import com.example.commerce.domain.UserTable;
import com.example.commerce.repository.UserRepository;
import com.example.commerce.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
    private final UserService userService;

    public LoginController(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping("login")
    public String login(){
        return "commerce/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, params = "signin")
    public String validateUser(LoginForm loginForm)
    {
        UserTable user = userService.search(loginForm.getUserID(), loginForm.getPassword());
        if (user == null)
        {
            return "commerce/login";
        }
        else
        {
            return "commerce/user-main";
        }
    }

    @GetMapping(value = "main", params="logout")
    public String logout()
    {
        userService.setOfflineIfOnline();
        return "commerce/login";
    }
}

