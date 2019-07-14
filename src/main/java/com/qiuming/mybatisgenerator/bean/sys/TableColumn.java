package com.qiuming.mybatisgenerator.bean.sys;

import lombok.Data;

@Data
public class TableColumn {
    /**字段名*/
    private String columnName;

    /**数据类型*/
    private String dataType;

    /**为空*/
    private String nullable;

    /**主键*/
    private String  key;

    /**默认值*/
    private String defaultValue;

    /**注释*/
    private String comment;

}
