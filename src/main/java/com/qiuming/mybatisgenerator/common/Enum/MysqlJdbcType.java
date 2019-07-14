package com.qiuming.mybatisgenerator.common.Enum;

public enum MysqlJdbcType {
    VARCHAR("VARCHAR","VARCHAR"),
    CHAR("CHAR","CHAR"),
    BLOB("BLOB","BLOB"),
    TEXT("TEXT","VARCHAR"),
    INT("INT","INTEGER"),
    TINYINT("TINYINT","TINYINT"),
    INTEGER("INTEGER","INTEGER"),
    SMALLINT("SMALLINT","SMALLINT"),
    MEDIUMINT("MEDIUMINT","INTEGER"),
    BIGINT("BIGINT","BIGINT"),
    FLOAT("FLOAT","FLOAT"),
    DOUBLE("DOUBLE","DOUBLE"),
    DECIMAL("DECIMAL","DECIMAL"),
    DATE("DATE","DATE"),
    DATETIME("DATETIME","TIMESTAMP"),
    TIMESTAMP("TIMESTAMP","TIMESTAMP");
    private String mysqlDbType;

    private String jdbcType;

    MysqlJdbcType(String mysqlDbType, String jdbcType) {
        this.mysqlDbType = mysqlDbType;
        this.jdbcType = jdbcType;
    }

    public static String getJdbcTypeByMysqlDbType(String mysqlDbType){
        for(MysqlJdbcType t : MysqlJdbcType.values()){
            if (t.mysqlDbType.equals(mysqlDbType)) {
                return t.jdbcType;
            }
        }
        return null;
    }
}
