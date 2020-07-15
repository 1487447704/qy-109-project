package com.aaa.three.controller;

import com.aaa.three.annotation.LoginAnnotation;
import com.aaa.three.base.BaseController;
import com.aaa.three.base.ResultData;
import com.aaa.three.model.User;
import com.aaa.three.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Param
 * @ClassName LoginController
 * @Description 登录
 * @Author yk
 * @Date 2020/7/15 0015 14:51
 * @Return
 **/
@RestController
public class LoginController extends BaseController {

    @Autowired
    private IProjectService projectService;
   /**
    * @Description : 执行登录操作
    * @param user
    * @return : com.aaa.three.base.ResultData
    * @author : yk
    * @date : 2020/07/15 15:03
    */
   @PostMapping("/doLogin")
   @LoginAnnotation(operationType = "登录操作",operationName = "管理员登录")
    public ResultData doLogin(User user){
        return projectService.doLogin(user);
    }
}
