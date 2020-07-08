package com.aaa.three.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Param
 * @ClassName User
 * @Description TODO
 * @Author yk
 * @Date 2020/7/8 0008 20:32
 * @Return
 **/
@Data
public class User implements Serializable {

    private String id;
    private String username;
    private String password;
}
