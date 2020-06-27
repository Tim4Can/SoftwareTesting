package com.tongji.test.controller;

import com.tongji.test.service.WhiteBoxService;
import com.tongji.test.util.ConstantSalePath;
import com.tongji.test.util.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;
import java.util.List;
import java.io.IOException;


@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class TestController {

    //CalenderBoundary cal;

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
    /*
    @RequestMapping("/cal_boundary")
    public List<Object> cal_boundary() throws IOException {
    	List<Object> last = cal.calender_boundary(ConstantSalePath.CalBoundary);
		return last;
    }
    
    @RequestMapping("/cal_equivalence")
    public List<Object> cal_equivalence() throws IOException {
    	List<Object> last = cal.calender_boundary(ConstantSalePath.CalEquivalence);
		return last;
    }
    */

}


