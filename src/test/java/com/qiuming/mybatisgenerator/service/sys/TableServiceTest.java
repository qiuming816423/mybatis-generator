package com.qiuming.mybatisgenerator.service.sys;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableServiceTest {

    @Autowired
    private ITableService tableService;

    @Test
    public void add() {
        int expect = 5;
        int actual = tableService.add(2, 3);
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void dec() {
        int expect = 1;
        int actual = tableService.dec(3, 2);
        Assert.assertEquals(expect,actual);
    }
}
