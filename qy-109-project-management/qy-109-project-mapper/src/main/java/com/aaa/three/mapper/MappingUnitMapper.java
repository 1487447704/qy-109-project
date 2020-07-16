package com.aaa.three.mapper;

import com.aaa.three.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MappingUnitMapper extends Mapper<MappingUnit> {

    List<MappingUnit> selectAllUnits();
}