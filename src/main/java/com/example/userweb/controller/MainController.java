package com.example.userweb.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public  String main(){
        return "login";
    }

    @Secured("ROLE_USER")
    @GetMapping(value = "/index")
    public  String index(){
        return "index";
    }
}