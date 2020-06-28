package com.tongji.test.controller;

import com.tongji.test.service.WhiteBoxService;
import com.tongji.test.util.ConstantSalePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tongji.test.service.CalenderBoundary;
import java.util.List;
import java.io.IOException;


@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class TestController {
    @Autowired
    WhiteBoxService whiteBoxService;
    CalenderBoundary cal;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestParam(value = "name") String name){
        return "hello "+name;
    }

    @PostMapping("/test")
    public List<Object> example(){
        List<Object> result = whiteBoxService.Run(ConstantSalePath.DCTest);
        return result;
    } 
    
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


}


