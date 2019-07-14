package com.qiuming.mybatisgenerator.bean.sys;

import lombok.Data;

import java.util.List;

@Data
public class ModelInfo {
    /**表名*/
    private String tableName;

    /**类名*/
    private String className;

    /**模块名*/
    private String moduleName;

    /**包名*/
    private String packageName;

    /**是否有时间戳字段*/
    private boolean hasTimestampField;

    /**是否有Date*/
    private boolean hasDateField;

    /**是否有DateTime字段*/
    private boolean hasDateTimeField;

    /**是否有Decimal字段*/
    private boolean hasDecimalField;

    /**字段属性列表*/
    List<FieldData> fieldDataList ;
}
