package com.aaa.three.service;

import com.aaa.three.base.BaseService;
import com.aaa.three.mapper.MappingUnitMapper;
import com.aaa.three.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author deng
 * @Date 2020/07/16
 * @Description
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    public List<MappingUnit> selectAllUnits(){
        return mappingUnitMapper.selectAllUnits();
    }
}
