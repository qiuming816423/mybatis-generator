package com.qiuming.mybatisgenerator.service.sys.impl;

import com.qiuming.mybatisgenerator.bean.sys.FieldData;
import com.qiuming.mybatisgenerator.bean.sys.ModelInfo;
import com.qiuming.mybatisgenerator.bean.sys.TableColumn;
import com.qiuming.mybatisgenerator.common.enums.MysqlDbTypeJavaTypeEnum;
import com.qiuming.mybatisgenerator.common.enums.MysqlJdbcTypeEnum;
import com.qiuming.mybatisgenerator.common.util.StringUtil;
import com.qiuming.mybatisgenerator.mapper.sys.TableMapper;
import com.qiuming.mybatisgenerator.service.sys.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired
    private TableMapper tableMapper;
//    @Override
//    public List<TableColumn> getTableColumnList(String tableName) {
//        return tableMapper.getTableColumnList(tableName);
//    }
//
//    @Override
//    public void saveMapping(String tableName,String className,String moduleName,
//                            String basePath,String basePackagePath){
//        String baseJavaPath = basePath+"\\java";
//        String bathPackageFilePath = basePackagePath.replaceAll("\\.", "\\\\");
//        ModelInfo modelInfo = new ModelInfo();
//        modelInfo.setTableName(tableName);
//        modelInfo.setClassName(className);
//        modelInfo.setModuleName(moduleName);
//        //生成实体类
//        String beanDirPath = baseJavaPath + "\\" + bathPackageFilePath + "\\bean\\"+modelInfo.getModuleName();
//        processBean(modelInfo,beanDirPath,basePackagePath);
//
//        //生成mapper文件
//        String mapperDirPath = baseJavaPath + "\\" + bathPackageFilePath + "\\mapper\\"+modelInfo.getModuleName();
//        processMapper(modelInfo,mapperDirPath,basePackagePath);
//
//        //生成mapperXml
//        String mapperXmlDirPath = basePath+"\\resources\\mapper"+File.separator+modelInfo.getModuleName();
//        processMapperXml(modelInfo, mapperXmlDirPath, basePackagePath);
//
//        //生成service文件
//        String serviceDirPath = baseJavaPath + "\\" + bathPackageFilePath + "\\service\\"+modelInfo.getModuleName();
//        processService(modelInfo,serviceDirPath,basePackagePath);
//
//    }
//
//    /**
//     * 处理生成service和serviceImpl
//     * @param modelInfo
//     * @param serviceDirPath
//     * @param basePackagePath
//     * @throws Exception
//     */
//    private void processService(ModelInfo modelInfo, String serviceDirPath,String basePackagePath) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("package ").append(basePackagePath).append(".service.").append(modelInfo.getModuleName()).append(";\n\n");
//        stringBuilder.append("import java.util.List;\n");
//        stringBuilder.append("import ").append(basePackagePath).append(".bean.").append(modelInfo.getModuleName()).append(".").append(modelInfo.getClassName()).append(";\n");
//        stringBuilder.append("public interface I").append(modelInfo.getClassName()).append("Service {\n\n");
//        stringBuilder.append("}");
//
//        File fileDir = new File(serviceDirPath);
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//        String fileName = "\\I"+modelInfo.getClassName()+"Service.java";
//        File file = new File(serviceDirPath+fileName);
//        if (file.exists()) {
//            fileName ="\\I"+modelInfo.getClassName()+"Service_bak.java";
//            file = new File(serviceDirPath+fileName);
//        }
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//            }
//        }
//        StringBuilder serviceImpBuilder = new StringBuilder();
//        serviceImpBuilder.append("package ").append(basePackagePath).append(".service.").append(modelInfo.getModuleName()).append(".impl;\n\n");
//        serviceImpBuilder.append("import ").append(basePackagePath).append(".bean.").append(modelInfo.getModuleName()).append(".").append(modelInfo.getClassName()).append(";\n");
//        serviceImpBuilder.append("import ").append(basePackagePath).append(".mapper.").append(modelInfo.getModuleName()).append(".").append(modelInfo.getClassName()).append("Mapper;\n");
//        serviceImpBuilder.append("import org.springframework.beans.factory.annotation.Autowired;\n");
//        serviceImpBuilder.append("import org.springframework.stereotype.Service;\n");
//        serviceImpBuilder.append("import ").append(basePackagePath).append(".service.").append(modelInfo.getModuleName()).append(".I").append(modelInfo.getClassName()).append("Service;;\n");
//        serviceImpBuilder.append("@Service\n");
//        serviceImpBuilder.append("public class ").append(modelInfo.getClassName()).append("ServiceImpl implements I").append(modelInfo.getClassName()).append("Service {\n");
//        serviceImpBuilder.append("@Autowired\n");
//        serviceImpBuilder.append("private ").append(modelInfo.getClassName()).append("Mapper ").append(modelInfo.getModuleName()).append("Mapper;\n");
//        serviceImpBuilder.append("}\n");
//        String serviceImpDirPath = serviceDirPath + "\\impl";
//        File fileImplDir = new File(serviceImpDirPath);
//        if (!fileImplDir.exists()) {
//            fileImplDir.mkdir();
//        }
//        String fileImplName = "\\"+modelInfo.getClassName()+"ServiceImpl.java";
//        File fileImpl = new File(serviceImpDirPath+fileImplName);
//        if (fileImpl.exists()) {
//            fileImplName ="\\"+modelInfo.getClassName()+"ServiceImpl_bak.java";
//            fileImpl = new File(serviceImpDirPath+fileImplName);
//        }
//        FileOutputStream implFileOutputStream = null;
//        try {
//            implFileOutputStream = new FileOutputStream(fileImpl);
//            implFileOutputStream.write(serviceImpBuilder.toString().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                implFileOutputStream.close();
//            } catch (IOException e) {
//            }
//        }
//    }
//
//    /**
//     * 处理生成mapperXml文件
//     * @author QM
//     * @param modelInfo         //基础数据
//     * @param mapperXmlDirPath  //mapperXml对应的的文件夹路径
//     * @param basePackagePath   //基础包路径
//     * @throws Exception
//     */
//    private void processMapperXml(ModelInfo modelInfo, String mapperXmlDirPath, String basePackagePath){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
//        stringBuilder.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n");
//        stringBuilder.append("<mapper namespace=\"").append(basePackagePath).append(".mapper.").append(modelInfo.getModuleName())
//                .append(".").append(modelInfo.getClassName()).append("Mapper\" >\n");
//        stringBuilder.append(" <resultMap id=\"").append(modelInfo.getModuleName()).append("Map\" type=\"").
//                append(basePackagePath).append(".bean.").append(modelInfo.getModuleName()).append(".").append(modelInfo.getClassName()).append("\" >\n");
//        for (FieldData fieldData : modelInfo.getFieldDataList()) {
//            stringBuilder.append(" <id column=\"").append(fieldData.getColumnName()).append("\" property=\"").append(fieldData.getFieldName())
//                    .append("\" jdbcType=\"").append(fieldData.getJdbcType()).append("\" />\n");
//        }
//        stringBuilder.append("</resultMap>\n");
//
//        stringBuilder.append(" <select id=\"get").append(modelInfo.getClassName()).append("List\" resultMap=\"").append(modelInfo.
//                getModuleName()).append("Map\">\n");
//        stringBuilder.append("SELECT * from ").append(modelInfo.getTableName()).append("\n");
//        stringBuilder.append(" </select>\n");
//
//        stringBuilder.append("<delete id=\"delete"+modelInfo.getClassName()+"\">").append("\n").append("delete from ")
//                .append(modelInfo.getTableName()).append(";\n").append("</delete>");
//
//        stringBuilder.append("<insert id=\"insert").append(modelInfo.getClassName())
//                .append("paramType= \"").append(basePackagePath).append(".bean.").append(modelInfo.getModuleName()).append(".").append(modelInfo.getClassName()).append("\"").append("\">\n")
//                .append("insert into ").append(modelInfo.getTableName()).append("(");
//
//        for (int i = 0; i < modelInfo.getFieldDataList().size(); i++) {
//            FieldData fieldData = modelInfo.getFieldDataList().get(i);
//            if (modelInfo.getFieldDataList().size() == (i + 1)) {
//                stringBuilder.append(fieldData.getColumnName());
//            } else {
//                stringBuilder.append(fieldData.getColumnName()).append(",").append("\n");
//            }
//        }
//        stringBuilder.append(")").append("\n");
//        stringBuilder.append("values").append("\n");
//        stringBuilder.append("(");
//        for (int i = 0; i < modelInfo.getFieldDataList().size(); i++) {
//            FieldData fieldData = modelInfo.getFieldDataList().get(i);
//            if (modelInfo.getFieldDataList().size() == (i + 1)) {
//                stringBuilder.append(fieldData.getFieldName());
//            } else {
//                stringBuilder.append(fieldData.getFieldName()).append(",").append("\n");
//            }
//        }
//        stringBuilder.append(")");
//        stringBuilder.append("</insert>");
//
//        stringBuilder.append("<insert id=\"batchInsert").append(modelInfo.getClassName())
//                .append("paramType= \"java.util.List\"").append("\">")
//                .append("insert into ").append(modelInfo.getTableName()).append("(");
//        for (int i = 0; i < modelInfo.getFieldDataList().size(); i++) {
//            FieldData fieldData = modelInfo.getFieldDataList().get(i);
//            if (modelInfo.getFieldDataList().size() == (i + 1)) {
//                stringBuilder.append(fieldData.getColumnName());
//            } else {
//                stringBuilder.append(fieldData.getColumnName()).append(",").append("\n");
//            }
//        }
//        stringBuilder.append(")").append("\n");
//        stringBuilder.append("values").append("\n");
//        stringBuilder.append("<forEach item=\"").append(modelInfo.getModuleName()).append("\" collection=\"list\" index=\"index\" separator=\",\">");
//        stringBuilder.append("(");
//        for (int i = 0; i < modelInfo.getFieldDataList().size(); i++) {
//            FieldData fieldData = modelInfo.getFieldDataList().get(i);
//            if (modelInfo.getFieldDataList().size() == (i + 1)) {
//                stringBuilder.append(modelInfo.getModuleName()).append(".").append(fieldData.getFieldName());
//            } else {
//                stringBuilder.append(modelInfo.getModuleName()).append(".").append(fieldData.getFieldName()).append(",").append("\n");
//            }
//        }
//        stringBuilder.append(")");
//        stringBuilder.append("</forEach>");
//        stringBuilder.append("</insert>");
//        stringBuilder.append("</mapper>\n");
//        File fileDir = new File(mapperXmlDirPath);
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//        String fileName = "\\"+modelInfo.getModuleName()+"Mapper.xml";
//        File file = new File(mapperXmlDirPath+fileName);
//        if (file.exists()) {
//            fileName ="\\"+modelInfo.getClassName()+"Mapper_bak.xml";
//            file = new File(mapperXmlDirPath+fileName);
//        }
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//            }
//        }
//    }
//
//    /**
//     *  //处理生成mybatisMapper接口
//     * @author QM
//     * @param modelInfo       //基础信息
//     * @param mapperDirPath   //mapper对应的文件夹路径
//     * @param basePackagePath //基础包路径
//     * @throws Exception
//     */
//    private void processMapper(ModelInfo modelInfo, String mapperDirPath, String basePackagePath){
//        String mapperFileName = modelInfo.getClassName()+"Mapper.java";
//        String packageName = basePackagePath+".mapper."+modelInfo.getModuleName();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("package ").append(packageName).append(";\n\n");
//        stringBuilder.append("import org.apache.ibatis.annotations.Mapper;\n");
//        stringBuilder.append("import ").append(basePackagePath).append(".bean.").append(modelInfo.getModuleName()).append(".")
//                .append(modelInfo.getClassName()).append(";\n");
//        stringBuilder.append("import java.util.List;\n\n");
//        stringBuilder.append("@Mapper\n");
//        stringBuilder.append("public interface ").append(modelInfo.getClassName()).append("Mapper {\n\n");
//        stringBuilder.append("List<").append(modelInfo.getClassName()).append("> get").append(modelInfo.getClassName()).append("List();\n");
//        stringBuilder.append("}");
//        File fileDir = new File(mapperDirPath);
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//        String fileName = "\\"+modelInfo.getClassName()+"Mapper.java";
//        File file = new File(mapperDirPath+fileName);
//        if (file.exists()) {
//            fileName = "\\"+modelInfo.getClassName()+"Mapper_bak.java";
//            file = new File(mapperDirPath+fileName);
//        }
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//            }
//        }
//    }
//
//    /**
//     *  //处理生成实体类
//     * @author QM
//     * @param modelInfo        //基础信息
//     * @param baseBeanDirPath  //实体类对应的文件夹类型
//     * @param basePackagePath  //基础包路径
//     * @throws Exception
//     */
//    private void processBean(ModelInfo modelInfo,String baseBeanDirPath, String basePackagePath) {
//        modelInfo.setPackageName("package "+basePackagePath+".bean."+modelInfo.getModuleName());
//        this.processField(modelInfo);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(modelInfo.getPackageName()).append(";\n\n");
//        if(modelInfo.isHasDecimalField()){
//            stringBuilder.append("import java.math.BigDecimal;\n");
//        }
//        if(modelInfo.isHasTimestampField() ||modelInfo.isHasDateField() || modelInfo.isHasDateField() ){
//            stringBuilder.append("import com.fasterxml.jackson.annotation.JsonFormat;\n");
//        }
//        if (modelInfo.isHasTimestampField()) {
//            stringBuilder.append("import java.sql.Timestamp;\n");
//        }
//        if (modelInfo.isHasDateField() || modelInfo.isHasDateField()) {
//            stringBuilder.append("import java.util.Date;\n");
//        }
//        stringBuilder.append("import lombok.Data;\n\n");
//        stringBuilder.append("@Data\n");
//        stringBuilder.append("public class ").append(modelInfo.getClassName()).append("{").append("\n\n");
//        for (FieldData fieldData : modelInfo.getFieldDataList()) {
//            if (StringUtil.isNotEmpty(fieldData.getComment())) {
//                stringBuilder.append("/**").append(fieldData.getComment()).append("*/").append("\n");
//            }
//            if ("DATE".equals(fieldData.getDbType())) {
//                stringBuilder.append("@JsonFormat(pattern = \"yyyy-MM-dd\",timezone = \"GMT+8\")").append("\n");
//            }
//            if ("DATETIME".equals(fieldData.getDbType())) {
//                stringBuilder.append("@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\",timezone = \"GMT+8\")").append("\n");
//            }
//            if ("TIMESTAMP".equals(fieldData.getDbType())) {
//                stringBuilder.append("@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\",timezone = \"GMT+8\")").append("\n");
//            }
//            stringBuilder.append("private ").append(fieldData.getJavaType()).append(" ").append(fieldData.getFieldName()).append(";").append("\n\n");
//        }
//        stringBuilder.append("}");
//
//        File fileDir = new File(baseBeanDirPath);
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//        String fileName =File.separator+modelInfo.getClassName()+".java";
//        File file = new File(baseBeanDirPath+File.separator+fileName);
//        if (file.exists()) {
//            fileName = File.separator+modelInfo.getClassName() + "_bak.java";
//            file = new File(baseBeanDirPath+File.separator+fileName);
//        }
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//            }
//        }
//    }
//
//    /**
//     * 根据表名获取表字段列表封装成modelInfo（基础数据）
//     * @author QM
//     * @param modelInfo
//     */
//    private void processField(ModelInfo modelInfo) {
//        //根据表名查询出所有字段信息
//        List<TableColumn> tableColumnList = this.getTableColumnList(modelInfo.getTableName());
//        List<FieldData> fieldDataList = new ArrayList<>(20);
//        for(TableColumn tableColumn : tableColumnList){
//            FieldData fieldData = new FieldData();
//            fieldData.setColumnName(tableColumn.getColumnName());
//            String field = this.fmtField(fieldData.getColumnName());
//            fieldData.setFieldName(field);
//            String dataTypeStr = tableColumn.getDataType();
//            //获取字段的数据类型
//            if(dataTypeStr.contains("(")){
//                dataTypeStr = dataTypeStr.substring(0,dataTypeStr.indexOf("("));
//            }
//            dataTypeStr = dataTypeStr.toUpperCase();
//            //是否包含DATETIME日期日期类型
//            if (!modelInfo.isHasDateTimeField()) {
//                if("DATETIME".equals(dataTypeStr)){
//                    modelInfo.setHasDateTimeField(true);
//                }
//            }
//            //是否包含DATE日期日期类型
//            if (!modelInfo.isHasDateField()) {
//                if ("DATE".equals(dataTypeStr)) {
//                    modelInfo.setHasDateField(true);
//                }
//            }
//            //是否包含时间戳日期类型
//            if (!modelInfo.isHasTimestampField()) {
//                if("TIMESTAMP".equals(dataTypeStr)){
//                    modelInfo.setHasTimestampField(true);
//                }
//            }
//            //是否包含DECIMAL数据类型
//            if (!modelInfo.isHasDecimalField()) {
//                if("DECIMAL".equals(dataTypeStr)){
//                    modelInfo.setHasDecimalField(true);
//                }
//            }
//            fieldData.setDbType(dataTypeStr);
//            //根据dbType获取对应的javaType
//            String javaType = MysqlDbTypeJavaTypeEnum.getJavaTypeByJdbcType(dataTypeStr);
//            //为空，默认String
//            if (javaType == null) {
//                javaType = MysqlDbTypeJavaTypeEnum.VARCHAR.getJavaType();
//            }
//            fieldData.setJavaType(javaType);
//            //根据dbType获取mybatisXml对应的jdbcType
//            fieldData.setJdbcType(MysqlJdbcTypeEnum.getJdbcTypeByMysqlDbType(fieldData.getDbType()));
//            fieldData.setNullable("NO".equals(tableColumn.getNullable()) ? false : true);
//            fieldData.setDefaultValue(tableColumn.getDefaultValue());
//            fieldData.setComment(tableColumn.getComment());
//            fieldDataList.add(fieldData);
//        }
//        modelInfo.setFieldDataList(fieldDataList);
//    }
//
//    /**
//     * 将数据库字段名格式化成java属性名
//     * @author QM
//     * @param fieldName  //数据库字段名
//     * @return
//     *
//     */
//    private String fmtField(String fieldName) {
//        StringBuffer fmt = new StringBuffer("");
//        String[] arr = fieldName.toLowerCase().split("_");
//        fmt.append(arr[0]);
//        for(int i = 1; i < arr.length; ++i) {
//            fmt.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
//        }
//        return fmt.toString();
//    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int dec(int a, int b) {
        if (a == 3) {
            return a - b;
        } else {
            return a + b;
        }
    }
}
