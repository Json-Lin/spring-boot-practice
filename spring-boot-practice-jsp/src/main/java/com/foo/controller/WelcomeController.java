package com.foo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/11/30
 */
@Controller
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("/welcome");
        modelAndView.addObject("message", this.message);
        modelAndView.addObject("time",  new Date());
        return modelAndView;
    }

}
