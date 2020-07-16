package com.aaa.three.controller;

import com.aaa.three.base.BaseService;
import com.aaa.three.base.CommonController;
import com.aaa.three.model.MappingUnit;
import com.aaa.three.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author deng
 * @Date 2020/07/16
 * @Description
 */
@RestController
public class MappingUnitController extends CommonController<MappingUnit> {
    @Autowired
    private MappingUnitService mappingUnitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }
    @GetMapping("/selectAllUnits")
    public List<MappingUnit> selectAllUnits(){
        return mappingUnitService.selectAllUnits();
    }
}
