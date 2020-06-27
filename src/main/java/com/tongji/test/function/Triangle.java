package com.tongji.test.function;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Triangle {
    public String side1;
    public String side2;
    public String side3;

    private boolean CheckEquicrural(float e1, float e2, float e3) {
        return e1 == e2 && e2 == e3;
    }

    private boolean CheckEquilateral(float e1, float e2, float e3) {
        return e1 == e2 || e2 == e3 || e3 == e1;
    }

    private boolean CheckTriangle(float edge1, float edge2, float edge3) {
        float[] edges = new float[]{edge1, edge2, edge3};
        float sum = edges[0] + edges[1] + edges[2];
        int succFlag = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] < sum - edges[i]) {
                succFlag++;
            }
        }
        return succFlag == 3;
    }

    private boolean CheckInput(String edge1, String edge2, String edge3) {
        boolean result = false;
        String reg = "^[0-9].*$";
        if (Pattern.matches(reg, edge1) && Pattern.matches(reg, edge2) && Pattern.matches(reg, edge3)) {
            try {
                if (Float.parseFloat(edge1) > 0 && Float.parseFloat(edge2) > 0 && Float.parseFloat(edge3) > 0 &&
                        Float.parseFloat(edge1) <= 100 && Float.parseFloat(edge2) <= 100 && Float.parseFloat(edge3) <= 100) {
                    result = true;
                } else {
                    result = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                result = false;
            }
        }
        return result;
    }

    public String CheckTriangle() {
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("等腰", 0);
        result.put("等边", 0);
        if (CheckInput(side1, side2, side3)) {
            float edge1 = Float.parseFloat(side1);
            float edge2 = Float.parseFloat(side2);
            float edge3 = Float.parseFloat(side3);
            float[] Numbers = new float[]{edge1, edge2, edge3};
            Arrays.sort(Numbers);
            float max = Numbers[Numbers.length - 1];
            if (CheckTriangle(edge1, edge2, edge3)) {
                // 三角形
                result.put("等边", CheckEquicrural(edge1, edge2, edge3) ? 1 : 0);
                result.put("等腰", CheckEquilateral(edge1, edge2, edge3) ? 1 : 0);
                String resultTip = (result.get("等腰") == 1 && result.get("等边") == 0) ? "等腰" : "";
                resultTip += result.get("等边") == 1 ? "等边" : "";
                resultTip += (result.get("等腰") == 0 && result.get("等边") == 0) ? "普通" : "";
                resultTip += "三角形";
                return resultTip;
            }
            else {
                // 构不成三角形
                return "您输入的三边构不成三角形!";
            }
        }
        else {
            // 边长信息有误
            return "您输入的边长信息有误!";
        }
    }

    public static void main(String[] args) {
        Triangle test = new Triangle();
        test.side1 = "4";
        test.side2 = "4";
        test.side3 = "4";
        String result = test.CheckTriangle();
        System.out.println(result);
    }
}
