package com.aaa.three.base;

import java.util.Map;

/**
 * @Param
 * @ClassName CommonController
 * @Description abstract:想实现的方法实现，不想实现的方法不实现
 * @Author yk
 * @Date 2020/7/8 0008 20:16
 * @Return
 **/
public abstract class CommonController<T> extends BaseController {
    public abstract BaseService<T> getBaseService();

    public ResultData add(Map map){
        return new ResultData();
    }
}
