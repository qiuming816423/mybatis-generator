package com.qiuming.mybatisgenerator.mapper.sys;

import com.qiuming.mybatisgenerator.bean.sys.TableColumn;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableMapperTest {

    @Autowired
    private TableMapper tableMapper;

    @Test
    public void getTableColumnList() {
        List<TableColumn> tableColumns = tableMapper.getTableColumnList("user_info");
        Assert.assertNotNull(tableColumns);
    }
}
