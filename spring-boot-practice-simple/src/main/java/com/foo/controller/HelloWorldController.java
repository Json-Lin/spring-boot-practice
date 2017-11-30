package com.foo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/11/30
 */
@RestController
public class HelloWorldController {

    @Value("${message:hello world!}")
    private String message;

    @RequestMapping("/")
    public String helloWorld(){
        return message;
    }
}
