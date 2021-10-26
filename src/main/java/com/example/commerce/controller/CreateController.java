package com.example.commerce.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateController
{
    @GetMapping("main/create")
    public String login(){
        return "commerce/user-create";
    }
}
