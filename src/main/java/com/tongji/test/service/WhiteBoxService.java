package com.tongji.test.service;


import com.tongji.test.function.SaleSystem;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("WhiteBox")
public class WhiteBoxService {
    public static List<Object> Run(String path) {
        String encoding = "utf-8";
        int count = 0;
        List<Object> result = new ArrayList<Object>();
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return result;
        }

        try{
            // reader读取csv
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = reader.readLine();
            if(line != null){
                line = reader.readLine();
            }

            // 遍历用例集
            while(line != null){
                count ++;
                String[] test_case = line.split(",");
                if(test_case.length == 5){
                    float volume = Float.parseFloat(test_case[1]);
                    int day = Integer.parseInt(test_case[2]);
                    float rate = Float.parseFloat(test_case[3]);
                    float actual = Float.parseFloat(test_case[4]);
                    float predict = SaleSystem.CaculateCommission(volume, day, rate);
                    boolean pass = false;
                    if(Math.abs(actual - predict) <= 0.001){
                        pass = true;
                    }

                    // 测试用例结果
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("case-id", test_case[0]);
                    map.put("predict", predict);
                    map.put("result", actual);
                    map.put("pass", pass);

                    result.add(map);
                    line = reader.readLine();
                }
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

}
