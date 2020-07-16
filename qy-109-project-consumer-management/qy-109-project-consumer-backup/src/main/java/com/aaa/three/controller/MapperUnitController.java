package com.aaa.three.controller;

import com.aaa.three.model.MappingUnit;
import com.aaa.three.service.IProjectService;
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
public class MapperUnitController {
    @Autowired
    private IProjectService iProjectService;


    @GetMapping("/selectAllUnits")
    public List<MappingUnit> selectAllUnits(){
        return iProjectService.selectAllUnits();
    }
}
