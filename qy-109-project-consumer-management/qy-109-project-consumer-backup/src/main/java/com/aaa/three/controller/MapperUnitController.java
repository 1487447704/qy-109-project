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

    /**
     * @author: deng
     * @date: 2020/07/16
     * @Description:
     *      查询所有的测绘单位
     *      * @Param: []
     * @return: java.util.List<com.aaa.three.model.MappingUnit>
     */
    @GetMapping("/selectAllUnits")
    public List<MappingUnit> selectAllUnits(){
        return iProjectService.selectAllUnits();
    }
}
