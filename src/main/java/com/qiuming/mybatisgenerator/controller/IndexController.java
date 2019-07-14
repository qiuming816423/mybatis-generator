package com.qiuming.mybatisgenerator.controller;


import com.qiuming.mybatisgenerator.service.sys.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private ITableService tableService;



    @GetMapping(value = "/index")
    public String index() throws Exception {
        String tableName = "area_info";
        String className = "Area";
        String moduleName = "area";
        String basePath = "D:\\java\\workSpace\\mybatis-generator\\src\\main";
        String basePackagePath = "com.qiuming.mybatisgenerator";
        tableService.saveMapping(tableName,className,moduleName,basePath,basePackagePath);
        return "";
    }


}


