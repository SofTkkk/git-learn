package com.it.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//加上RestController就是当前的请求处理类
@RestController

public class k {
    //说明处理的请求地址
    @RequestMapping("/hello")
    public String hello() {

        System.out.println("Hello World");
        return "hello World";

    }
}
