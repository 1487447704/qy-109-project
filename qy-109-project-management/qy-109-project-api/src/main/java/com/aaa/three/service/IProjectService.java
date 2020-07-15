package com.aaa.three.service;

import com.aaa.three.base.ResultData;
import com.aaa.three.model.LoginLog;
import com.aaa.three.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Param
 * @ClassName IProjectService
 * @Description TODO:spring.application.name的值未写
 * @Author yk
 * @Date 2020/7/15 0015 15:08
 * @Return
 **/
@FeignClient(value = "")
public interface IProjectService {
    /**
     * @Description :执行登录操作
     * @param user
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/15 15:11
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);
    /**
     * @Description : 新增日志
     * @param loginLog
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/15 20:27
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);
}
