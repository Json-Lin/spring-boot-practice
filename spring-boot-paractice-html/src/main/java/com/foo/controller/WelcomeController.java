package com.foo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/11/30
 */
@RestController
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/welcome")
    public Map<String, String> welcome() {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("message", message);
        return ret;
    }

}
