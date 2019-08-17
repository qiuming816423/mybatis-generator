package com.qiuming.mybatisgenerator.controller;


import com.qiuming.mybatisgenerator.bean.sys.FieldData;
import com.qiuming.mybatisgenerator.service.sys.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private ITableService tableService;



    @GetMapping(value = "/index")
    public String index() throws Exception {
        //表名
        String tableName = "user_info";
        //类名
        String className = "User";
        //模块名称
        String moduleName = "user";
        //基础路径(绝对路径)
        String basePath = "D:\\java\\workSpace\\mybatis-generator\\src\\main";
        //基础包路径
        String basePackagePath = "com.qiuming.mybatisgenerator";
        tableService.saveMapping(tableName,className,moduleName,basePath,basePackagePath);
        return "";
    }

    @GetMapping(value = "/index1")
    @ResponseBody
    public FieldData index1(){
        FieldData fieldData = new FieldData();
        fieldData.setColumnName("123");
        return fieldData ;
    }

}


