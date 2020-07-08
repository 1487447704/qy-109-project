package com.aaa.three.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Param
 * @ClassName BaseService
 * @Description 通用service
 * @Author yk
 * @Date 2020/7/8 0008 20:22
 * @Return
 **/
public abstract class BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper(){
        return mapper;
    }

    public ResultData insertData(T t){
        int insert = mapper.insert(t);
        if (insert > 0){
            return new ResultData().setCode("300").setMsg("数据插入成功");
        }
        return null;
    }
}
