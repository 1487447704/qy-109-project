package com.aaa.three.controller;

import com.aaa.three.base.BaseService;
import com.aaa.three.base.CommonController;
import com.aaa.three.model.LoginLog;
import com.aaa.three.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Param
 * @ClassName LoginLogController
 * @Description TODO
 * @Author yk
 * @Date 2020/7/15 0015 20:30
 * @Return
 **/
@RestController
public class LoginLogController extends CommonController<LoginLog> {


    @Autowired
    private LoginLogService loginLogService;

    @Override
    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }
    /**
     * @Description : 保存日志
     * @param loginLog
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/15 20:30
     */
    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody LoginLog loginLog){
        return getBaseService().add(loginLog);
    }


}
