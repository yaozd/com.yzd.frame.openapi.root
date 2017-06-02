package com.yzd.frame.openapi.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zd.yao on 2017/6/1.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"", "/index"})
    public String index() {
        return "home/index";
    }
}
