package com.tongji.test.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tongji.test.function.Comission;



public class ComissionBoundary implements TestService {

	 public  List<Object> Run(String path){
		 List<Object> last = new ArrayList<>();
		 int count = 0;
       try {
    	   
    	   BufferedReader reader = new BufferedReader(new FileReader(path));
           String line = reader.readLine();

           if(line != null){
               line = reader.readLine();
           }           
           while(line !=null) {
        	   count ++;
               String item[] = line.split(",");
        	   String case_id = item[0];
        	   String host = item[1];
               String monitor = item[2];
               String peripheral = item[3];
               double fact_result = Double.parseDouble(item[6]);
               Comission test = new Comission();
               test.host = Integer.parseInt(host);
               test.monitor = Integer.parseInt(monitor);
               test.peripheral = Integer.parseInt(peripheral);
               double result = test.CalculateCommision();
               boolean pass = false;
               double predict_result = result;
               
	       	   if(Math.abs(predict_result - fact_result) <= 0.001) {
	    			pass = true;
	    		}
               Map<String, Object> map = new HashMap<>();
	    	   map.put("case-id",case_id);
	           map.put("host",host);
	           map.put("monitor",monitor);
	           map.put("peripheral",peripheral);
	           map.put("pass",pass);
	           map.put("predict",predict_result);
	           map.put("result",fact_result);
	           
	           last.add(map);
	           line = reader.readLine();
//	           System.out.println("count:"+count);
           
           }
           reader.close();
       }catch(Exception e){
           e.printStackTrace();
       }
          
		return last;
    
   }
}
