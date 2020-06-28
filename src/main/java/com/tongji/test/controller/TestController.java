package com.tongji.test.controller;

import com.tongji.test.util.ConstantSalePath;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Method;
import java.util.List;


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
    public List<Object> cal_boundary() {
    	List<Object> last = cal.calender_boundary(ConstantSalePath.CalBoundary);
		return last;
    }
    
    @RequestMapping("/cal_equivalence")
    public List<Object> cal_equivalence()  {
    	List<Object> last = cal.calender_boundary(ConstantSalePath.CalEquivalence);
		return last;
    }
    */

}


