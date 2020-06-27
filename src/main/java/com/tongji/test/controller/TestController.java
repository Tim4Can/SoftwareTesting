package com.tongji.test.controller;

import com.tongji.test.service.WhiteBoxService;
import com.tongji.test.util.ConstantSalePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;


@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class TestController {
    @Autowired
    WhiteBoxService whiteBoxService;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestParam(value = "name") String name){
        return "hello "+name;
    }

    @PostMapping("/test")
    public List<Object> example(){
        List<Object> result = whiteBoxService.Run(ConstantSalePath.StatementTest);
        return result;
    } 

}


