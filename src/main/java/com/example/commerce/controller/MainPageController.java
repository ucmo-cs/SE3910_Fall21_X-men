package com.example.commerce.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController
{
    @GetMapping("main")
    public String login(){
        return "commerce/user-main";
    }
}
