package com.tongji.test.util;

import java.util.HashMap;
import java.util.Map;

public class MappingRelation {
    public final static Map<String, String> classMap = new HashMap();
    public final static Map<String, String> suiteMap = new HashMap();
    static{
        // mapping services
        classMap.put("8", "com.tongji.test.service.WhiteBoxService");

        // mapping suites
        suiteMap.put("8_sts", ConstantPath.StatementTest);
        suiteMap.put("8_cond", ConstantPath.ConditionTest);
        suiteMap.put("8_decis", ConstantPath.DecisionTest);
        suiteMap.put("8_cc", ConstantPath.CCTest);
        suiteMap.put("8_dc", ConstantPath.DCTest);
    }
}
