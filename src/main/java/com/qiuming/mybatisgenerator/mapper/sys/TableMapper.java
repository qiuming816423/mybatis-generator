package com.qiuming.mybatisgenerator.mapper.sys;

import com.qiuming.mybatisgenerator.bean.sys.TableColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TableMapper {

    /**
     * 根据表名获取表的字段列表
     * @author QM
     * @param tableName
     * @return
     */
    List<TableColumn> getTableColumnList(@Param("tableName") String tableName);
}
