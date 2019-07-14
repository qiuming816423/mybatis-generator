package com.qiuming.mybatisgenerator.common.enums;

public enum MysqlDbTypeJavaTypeEnum {
    VARCHAR("VARCHAR","String"),
    CHAR("CHAR","String"),
    BLOB("BLOB","byte[]"),
    TEXT("TEXT","String"),
    INT("INT","Integer"),
    TINYINT("TINYINT","Integer"),
    INTEGER("INTEGER","Integer"),
    SMALLINT("SMALLINT","Integer"),
    MEDIUMINT("MEDIUMINT","Integer"),
    BIGINT("BIGINT","Integer"),
    FLOAT("FLOAT","Float"),
    DOUBLE("DOUBLE","String"),
    DECIMAL("DECIMAL","BigDecimal"),
    DATE("DATE","Date"),
    DATETIME("DATETIME","Date"),
    TIMESTAMP("TIMESTAMP","Timestamp");
    private String mysqlDbType;
    private String javaType;
    MysqlDbTypeJavaTypeEnum(String jdbcType, String javaType){
        this.mysqlDbType = jdbcType;
        this.javaType = javaType;
    }
    public static String getJavaTypeByJdbcType(String jdbcType){
        for(MysqlDbTypeJavaTypeEnum t : MysqlDbTypeJavaTypeEnum.values()){
            if (t.mysqlDbType.equals(jdbcType)) {
                return t.javaType;
            }
        }
        return null;
    }

    public String getJavaType() {
        return javaType;
    }
}
