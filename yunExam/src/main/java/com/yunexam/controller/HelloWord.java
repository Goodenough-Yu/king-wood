package com.yunexam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {

    @RequestMapping(path = "/HelloWord")
    public void PrintHelloWord(){
        System.out.println("成了!");
    }
}
