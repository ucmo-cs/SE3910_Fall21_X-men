package com.example.commerce.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("main/view")
    public String login(){
        return "commerce/user-view";
    }
}

