package com.yzd.frame.openapi.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zd.yao on 2017/6/1.
 */
@Controller
@RequestMapping("demo")
public class DemoController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(String v) {
        return "demo/hello-param:v="+v;
    }
}
