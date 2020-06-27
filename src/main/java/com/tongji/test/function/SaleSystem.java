package com.tongji.test.function;

public class SaleSystem {
    public static float CaculateCommission(float sale, int day, float rate){
        if(sale < 0){
            return -1;
        }
        if(day < 0 || day > 365){
            return -1;
        }
        if(rate < 0 || rate > 1){
            return -1;
        }

        if(sale > 200 && day <= 10){
            if(rate >= 0.6){
                return sale / 7;
            }else{
                return 0;
            }
        }else{
            // Version 1.0 : 双精度运算问题
            // if(rate <= 0.85){
            if(Math.abs(rate - (double)0.85) <= 0.001){
                return sale / 6;
            }else{
                return sale / 5;

            }


        }
    }
}
