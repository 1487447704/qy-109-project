package com.aaa.three.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Param
 * @ClassName ResultData
 * @Description 通过接口返回值
 *              也就是说把后端的controller的返回值统一了
 *
 *
 *              T：所谓的泛型就是占位符
 * @Author yk
 * @Date 2020/7/8 0008 17:14
 * @Return
 **/
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;

}
