package com.qiuming.mybatisgenerator.service.area.impl;

import com.qiuming.mybatisgenerator.mapper.area.AreaMapper;
import com.qiuming.mybatisgenerator.service.area.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
@Service
public class AreaServiceImpl implements IAreaService {
@Autowired
private AreaMapper areaMapper;
}
