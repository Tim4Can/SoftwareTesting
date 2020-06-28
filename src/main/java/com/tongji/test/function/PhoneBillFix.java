package com.tongji.test.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description: fix some bugs
 * @author: Yu Liu
 * @create: 2020/06/28
 **/
public class PhoneBillFix {
    private int arrearNum;
    private int time;
    private static final double basePrice = 25.00;
    public static final double perPrice=0.15;
    private Map discount;
    private double discounts[]={0.00,0.01,0.015,0.02,0.025,0.03};
    private int arrears[]={0,1,2,3,3,6};
    public PhoneBillFix(){
        this.discount= new HashMap();
        this.discount.put(0, discounts[0]);
        this.discount.put(1, discounts[1]);
        this.discount.put(2, discounts[2]);
        this.discount.put(3, discounts[3]);
        this.discount.put(4, discounts[4]);
        this.discount.put(5, discounts[5]);


    }
    public String init(int arrearNum,int time){
        this.arrearNum=arrearNum;
        this.time=time;
        return this.compute();
    }
    private int assort(){
        if(this.arrearNum<0||this.arrearNum>12){
            System.out.println("N值输入错误");
            return -1;
        }
        if(this.time<0||this.time>44640){
            System.out.println("T值输入错误");
            return -2;
        }
        if(this.time<=60){
            if(this.arrearNum>this.arrears[1])
                return 0;
            else
                return 1;
        }
        else if(this.time<=120){
            if(this.arrearNum>this.arrears[2])
                return 0;
            else
                return 2;

        }
        else if(this.time<=180){
            if(this.arrearNum>this.arrears[3])
                return 0;
            else
                return 3;

        }
        else if(this.time<=300){
            if(this.arrearNum>this.arrears[4])
                return 0;
            else
                return 4;

        }
        else {
            if(this.arrearNum>this.arrears[5])
                return 0;
            else
                return 5;
        }

    }
    private String compute() {
        double bill = 0.0;
        int level = assort();
        if (level < 0) {
            if (level == -1) {
                return "N值输入错误";
            } else  {
                return "T值输入错误";
            }
        } else {
            bill = basePrice + this.time * (1 - (double) discount.get(level)) * this.perPrice;
            System.out.println(bill);
            DecimalFormat df   = new DecimalFormat("######0.00");
            String st=df.format(bill);
            System.out.println(st);
            return "话费为" +st ;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入通话时间段的不按时缴费次数：");
        int an=Integer.parseInt(in.readLine());
        System.out.println("请输入本月通话的分钟数： ");
        int time=Integer.parseInt(in.readLine());
        PhoneBill pb=new PhoneBill();
        pb.init(an,time);
    }
}