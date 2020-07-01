package com.tongji.test.util;

import java.io.File;

public class ConstantPath {
    public final static String PathDir = "c:/users/dell/desktop/softwaretesting/SoftwareTesting/src/"+File.separator+"main"+File.separator+"java"+File.separator
                                + "com"+File.separator+"tongji"+File.separator+"test"+File.separator+"usecase";
    // Sale System Path
    public final static String StatementTest = PathDir+File.separator+"SaleStatement.csv";
    public final static String DecisionTest = PathDir+File.separator+"SaleDecision.csv";
    public final static String ConditionTest = PathDir+File.separator+"SaleCondition.csv";
    public final static String DCTest = PathDir+File.separator+"SaleDC.csv";
    public final static String CCTest = PathDir+File.separator+"SaleCC.csv";

    // Calendar Path
    public final static String CalBoundary = PathDir+File.separator+"CalenderBoundary.csv";
    public final static String CalEquivalence = PathDir+File.separator+"CalenderEquivalence.csv";

    //  Phone Bill Path
    public final static String PBBoundary=PathDir+File.separator+"PhoneBillBoundary.csv";
    public final static String PBEC0=PathDir+File.separator+"PhoneBillEC0.csv";
    public final static String PBEC1=PathDir+File.separator+"PhoneBillEC1.csv";
    public final static String PBEC2=PathDir+File.separator+"PhoneBillEC2.csv";
    public final static String PBEC3=PathDir+File.separator+"PhoneBillEC3.csv";
    public final static String PBDT=PathDir+File.separator+"PhoneBillDT.csv";
    public final static String PBCM=PathDir+File.separator+"PhoneBillCom.csv";
    
    //Triangle Path
    public final static String TriBoundary = PathDir+File.separator+"TriangleBoundary.csv";
    public final static String TriEquivalence = PathDir+File.separator+"TriangleEquivalence.csv";
    
    //Comission Path
    public final static String ComBoundary = PathDir+File.separator+"ComissionBoundary.csv";

}
