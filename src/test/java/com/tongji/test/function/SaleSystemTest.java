package com.tongji.test.function;

import com.tongji.test.util.ConstantPath;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SaleSystemTest {

    @Test
    void CCTest() {
        String path = ConstantPath.CCTest;
        String encoding = "utf-8";
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return;
        }
        int count = 0;

        try{
            // reader读取csv
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = reader.readLine();
            if(line != null){
                line = reader.readLine();
            }

            // 遍历用例集
            while(line != null){
                String[] test_case = line.split(",");
                if(test_case.length == 5){
                    float volume = Float.parseFloat(test_case[1]);
                    int day = Integer.parseInt(test_case[2]);
                    float rate = Float.parseFloat(test_case[3]);
                    float actual = Float.parseFloat(test_case[4]);
                    float predict = SaleSystem.CaculateCommission(volume, day, rate);

                    assertEquals(actual, predict, 0.0000001);

                    line = reader.readLine();
                }
                System.out.println(count);
                count++;
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void DCTest() {
        String path = ConstantPath.DCTest;
        String encoding = "utf-8";
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return;
        }
        int count = 0;

        try{
            // reader读取csv
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = reader.readLine();
            if(line != null){
                line = reader.readLine();
            }

            // 遍历用例集
            while(line != null){
                String[] test_case = line.split(",");
                if(test_case.length == 5){
                    float volume = Float.parseFloat(test_case[1]);
                    int day = Integer.parseInt(test_case[2]);
                    float rate = Float.parseFloat(test_case[3]);
                    float actual = Float.parseFloat(test_case[4]);
                    float predict = SaleSystem.CaculateCommission(volume, day, rate);

                    assertEquals(actual, predict, 0.0000001);

                    line = reader.readLine();
                }
                System.out.println(count);
                count++;
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void DecisionTest() {
        String path = ConstantPath.DecisionTest;
        String encoding = "utf-8";
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return;
        }
        int count = 0;

        try{
            // reader读取csv
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = reader.readLine();
            if(line != null){
                line = reader.readLine();
            }

            // 遍历用例集
            while(line != null){
                String[] test_case = line.split(",");
                if(test_case.length == 5){
                    float volume = Float.parseFloat(test_case[1]);
                    int day = Integer.parseInt(test_case[2]);
                    float rate = Float.parseFloat(test_case[3]);
                    float actual = Float.parseFloat(test_case[4]);
                    float predict = SaleSystem.CaculateCommission(volume, day, rate);

                    assertEquals(actual, predict, 0.0000001);

                    line = reader.readLine();
                }
                System.out.println(count);
                count++;
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void StatementTest() {
        String path = ConstantPath.StatementTest;
        String encoding = "utf-8";
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return;
        }
        int count = 0;

        try{
            // reader读取csv
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = reader.readLine();
            if(line != null){
                line = reader.readLine();
            }

            // 遍历用例集
            while(line != null){
                String[] test_case = line.split(",");
                if(test_case.length == 5){
                    float volume = Float.parseFloat(test_case[1]);
                    int day = Integer.parseInt(test_case[2]);
                    float rate = Float.parseFloat(test_case[3]);
                    float actual = Float.parseFloat(test_case[4]);
                    float predict = SaleSystem.CaculateCommission(volume, day, rate);

                    assertEquals(actual, predict, 0.0000001);

                    line = reader.readLine();
                }
                System.out.println(count);
                count++;
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void ConditionTest() {
        String path = ConstantPath.ConditionTest;
        String encoding = "utf-8";
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在！");
            return;
        }
        int count = 0;

        try{
            // reader读取csv
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = reader.readLine();
            if(line != null){
                line = reader.readLine();
            }

            // 遍历用例集
            while(line != null){
                String[] test_case = line.split(",");
                if(test_case.length == 5){
                    float volume = Float.parseFloat(test_case[1]);
                    int day = Integer.parseInt(test_case[2]);
                    float rate = Float.parseFloat(test_case[3]);
                    float actual = Float.parseFloat(test_case[4]);
                    float predict = SaleSystem.CaculateCommission(volume, day, rate);

                    assertEquals(actual, predict, 0.0000001);

                    line = reader.readLine();
                }
                System.out.println(count);
                count++;
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}