package com.qiuming.mybatisgenerator.service.sys;

import com.qiuming.mybatisgenerator.bean.sys.TableColumn;

import java.util.List;

public interface ITableService {

    /**
     * 根据表名获取所有字段列表
     * @author QM
     * @param tableName
     * @return
     */
    List<TableColumn> getTableColumnList(String tableName);

    /**
     * 表映射实体类、mapper、mapperXml、service
     * @author QM
     * @param tableName  表名
     * @param className  类名
     * @param moduleName 模块名
     * @param basePath   基础路径(相对路径)
     * @param basePackagePath 基础包路径
     * @throws Exception
     */
    void saveMapping(String tableName,String className,String moduleName,
                     String basePath,String basePackagePath) throws Exception;

}
