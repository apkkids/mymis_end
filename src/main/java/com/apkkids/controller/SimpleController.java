package com.apkkids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wxb on 2019/1/28 0028.
 * 用来测试的Controller类
 */
@RestController
public class SimpleController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("get the url /hello, print hello.");
        return "Hello, MyMIS!";
    }
}
