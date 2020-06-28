package com.tongji.test.controller;

import com.tongji.test.util.MappingRelation;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Method;
import java.util.List;


@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public List<Object> Test(@RequestParam("service")String service, @RequestParam("type")String type) {
        List<Object> result = null;
        String className = MappingRelation.classMap.get(service);
        String path = service + "_" + type;
        path = MappingRelation.suiteMap.get(path);


        try{
            Class<?> cls = Class.forName(className);
            Method method = cls.getMethod("Run", String.class);
            result = (List<Object>)method.invoke(cls.getDeclaredConstructor().newInstance(), path);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    } 

}


