package com.tongji.test.service;

import com.tongji.test.function.PhoneBill;
import com.tongji.test.function.PhoneBillFix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: test
 * @description: boundary value method test
 * @author: Yu Liu
 * @create: 2020/06/28
 **/
public class PhoneBillService implements TestService{
    @Override
    public List<Object> Run(String path){
        String encoding = "utf-8";
        List<Object> last = new ArrayList<>();
        int count = 0;
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return last;
        }

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
                int number = Integer.parseInt(item[1]);
                int time = Integer.parseInt(item[2]);
                String predict= item[3];
                boolean pass = false;
//                PhoneBill pb=new PhoneBill();
                PhoneBillFix pb=new PhoneBillFix();
                String result=pb.init(number,time);

                if(predict.strip().equals(result.strip())) {
                    pass = true;
                }
                Map<String, Object> map = new HashMap<>();
                map.put("case-id",case_id);
                map.put("number",number);
                map.put("time",time);
                map.put("predict",predict);
                map.put("result",result);
                map.put("pass",pass);

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