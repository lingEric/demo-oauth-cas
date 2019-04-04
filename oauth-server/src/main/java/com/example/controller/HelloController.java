package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    //受保护资源
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }




}
