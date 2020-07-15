package com.aaa.three.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Param
 * @ClassName TokenVo
 * @Description
 * @Author yk
 * @Date 2020/7/15 0015 15:37
 * @Return
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TokenVo implements Serializable {
    private String token;
    private Boolean ifSuccess;
    /**
     * 1.账号不存在
     * 2.密码错误
     * 3.账号被锁定
     * 4.系统异常
     */
    private Integer type;
}
