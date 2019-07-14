package com.qiuming.mybatisgenerator;

import org.apache.ibatis.type.JdbcType;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        String basePath = "D:\\java\\workSpace\\mybatis-generator\\src\\main\\java";
        String mapper = "com.citiccard.mybatisgenerator.mapper";
        String resource = "D:\\java\\workSpace\\mybatis-generator\\src\\main\\resources\\mapper";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.citiccard.mybatisgenerator.user").append(";\n\n");
        stringBuilder.append("com.citiccard.mybatisgenerator.user").append(";\n");
        stringBuilder.append("com.citiccard.mybatisgenerator.user").append(";\n");
        System.out.println(File.separator);
        String s = "  ";
        System.out.println(s.trim().length());

    }

    private String fmtField(String fieldName) {
        StringBuffer fmt = new StringBuffer("");
        String[] arr = fieldName.toLowerCase().split("_");
        fmt.append(arr[0]);
        for(int i = 1; i < arr.length; ++i) {
            fmt.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
        }
        return fmt.toString();
    }
}
