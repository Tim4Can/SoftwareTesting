package com.tongji.test.util;

import java.util.HashMap;
import java.util.Map;

public class MappingRelation {
    public final static Map<String, String> classMap = new HashMap();
    public final static Map<String, String> suiteMap = new HashMap();
    static{
        // mapping services
        classMap.put("8", "com.tongji.test.service.WhiteBoxService");
        classMap.put("7","com.tongji.test.service.PhoneBillService");
        classMap.put("2","com.tongji.test.service.CalenderBoundary");

        // mapping suites
        suiteMap.put("8_sts", ConstantPath.StatementTest);
        suiteMap.put("8_cond", ConstantPath.ConditionTest);
        suiteMap.put("8_decis", ConstantPath.DecisionTest);
        suiteMap.put("8_cc", ConstantPath.CCTest);
        suiteMap.put("8_dc", ConstantPath.DCTest);

        suiteMap.put("7_boundary",ConstantPath.PBBoundary);
        suiteMap.put("7_ec0",ConstantPath.PBEC0);
        suiteMap.put("7_ec1",ConstantPath.PBEC1);
        suiteMap.put("7_ec2",ConstantPath.PBEC2);
        suiteMap.put("7_ec3",ConstantPath.PBEC3);
        suiteMap.put("7_dt",ConstantPath.PBDT);
        
        suiteMap.put("2_bd",ConstantPath.CalBoundary);
        suiteMap.put("2_eq",ConstantPath.CalEquivalence);
    }
}
