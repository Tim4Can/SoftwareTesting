package com.tongji.test.controller;

import com.tongji.test.service.WhiteBoxService;
import com.tongji.test.util.ConstantSalePath;
import com.tongji.test.util.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;
import java.util.List;


@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class TestController {

    @PostMapping("/test")
    public List<Object> Test() {
        List<Object> result = null;

        try{
            Class<?> cls = Class.forName("com.tongji.test.service.WhiteBoxService");
            Method method = cls.getMethod("Run", String.class);
            result = (List<Object>)method.invoke(cls.getDeclaredConstructor().newInstance(), ConstantSalePath.DCTest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    } 

}


