package com.qiuming.mybatisgenerator.bean.sys;

import lombok.Data;

@Data
public class FieldData {

    /**字段名*/
    private String columnName;

    /**属性名*/
    private String fieldName;

    /**是否为空*/
    private boolean nullable;

    /**主键*/
    private String primary;

    /**java类型*/
    private String javaType;

    /**db类型*/
    private String dbType;

    /**jdbc类型*/
    private String jdbcType;

    /**字段长度*/
    private String dataLength;

    /***/
    private String scale;

    /**默认值*/
    private String defaultValue;

    /**注释*/
    private String comment;

}
