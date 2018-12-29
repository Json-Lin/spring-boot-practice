package com.foo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

//    @RequestMapping("/homeAction")
//    public ModelAndView home() {
//        return new ModelAndView("home");
//    }
}
