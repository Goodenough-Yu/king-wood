package com.yunexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class helloworld {


    @RequestMapping(path = "/hello")
    public String print() {
        System.out.println("111");
        return "/hello";
    }
}
