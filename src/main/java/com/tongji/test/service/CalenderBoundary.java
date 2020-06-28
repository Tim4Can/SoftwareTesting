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

	 public static List<Object> calender_boundary(String path){
		 List<Object> last = new ArrayList<>();
		 int count = 0;
       try {
    	   
    	   BufferedReader reader = new BufferedReader(new FileReader(path));
           String line = reader.readLine();
           String predict_result = "wrong";
           boolean pass = false;
           Map<String, Object> map = new HashMap<>();
           if(line != null){
               line = reader.readLine();
           }           
           while(line !=null) {
        	   count ++;
               String item[] = line.split(",");
        	   String case_id = item[0];
               int year = Integer.parseInt(item[1]);
               int month = Integer.parseInt(item[2]);
               int day = Integer.parseInt(item[3]);
               String fact_result = item[4];
               String result = Calender.TheNextDay(year,month,day);
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
	           line = reader.readLine();
	           System.out.println("count:"+count);
           
           }
           reader.close();
       }catch(Exception e){
           e.printStackTrace();
       }
          
		return last;
    
   }
}
