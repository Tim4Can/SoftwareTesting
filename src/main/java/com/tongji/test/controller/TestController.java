package com.tongji.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @program: test
 * @description: controller for test
 * @author: Yu Liu
 * @create: 2020/06/27
 **/
@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestParam(value = "name") String name){
        return "hello "+name;
    }

    @PostMapping("/example")
    public boolean example(){
        System.out.println("hello!");
        return true;
    }

}