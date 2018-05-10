package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * Author: GuiqiHu
 * Created in: 2018/5/2 11:08
 */

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test() {
        return "hello thymeleaf!";
    }

}