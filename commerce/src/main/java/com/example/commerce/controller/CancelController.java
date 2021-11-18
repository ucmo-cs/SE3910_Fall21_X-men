package com.example.commerce.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CancelController
{
    @GetMapping("main/cancel")
    public String login(){
        return "commerce/user-cancel";
    }
}
