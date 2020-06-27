package com.tongji.test.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tongji.test.function.Calender;

public class CalenderBoundary {

	 public static List<Object> calender_boundary(String path) throws IOException {
       
		BufferedReader reader = new BufferedReader(new FileReader(path));

           String line = reader.readLine();
           String year = "wrong";
           String month = "wrong";
           String day = "wrong";
           String predict_result = "wrong";
           String fact_result = "wrong";
           String case_id = "wrong";
           boolean pass = false;
           Map<String, Object> map = new HashMap<>();
    	   List<Object> last = new ArrayList<>();
           
           while((line = reader.readLine())!=null) {
        	  
               String item[] = line.split(",");
               case_id = item[0];
               year = item[1];
               month = item[2];
               day = item[3];
               fact_result = item[4];
               Calender test = new Calender();
               test.year = Integer.parseInt(year);
               test.month = Integer.parseInt(month);
               test.day = Integer.parseInt(day);
               String result = test.TheNextDay();
               predict_result = result;
               
	       	   if(predict_result.strip()==fact_result.strip()) {
	    			pass = true;
	    		}
	    	   map.put("case-id",case_id);
	           map.put("year",year);
	           map.put("month",month);
	           map.put("day",day);
	           map.put("pass",pass);
	           map.put("predict",predict_result);
	           map.put("result",fact_result);
	           
	           last.add(map);
              
           }
          
		return last;
    
   }
}
