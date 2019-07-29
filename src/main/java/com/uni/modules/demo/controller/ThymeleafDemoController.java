package com.uni.modules.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description thymeleaf demo
*
* @author Created by zc on 2019/7/29
*/
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafDemoController {
    @RequestMapping("/demo")
    public String demo() {
        return "thymeleafDemo";
    }
}
