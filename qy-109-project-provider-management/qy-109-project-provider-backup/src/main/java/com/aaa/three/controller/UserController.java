package com.aaa.three.controller;

import com.aaa.three.base.BaseService;
import com.aaa.three.base.CommonController;
import com.aaa.three.base.ResultData;
import com.aaa.three.model.User;
import com.aaa.three.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Param
 * @ClassName UserController
 * @Description TODO
 * @Author yk
 * @Date 2020/7/8 0008 20:37
 * @Return
 **/
@RestController
public class UserController extends CommonController<User> {

    @Autowired
    private UserService userService;

    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }

    @PostMapping("/add")
    public ResultData add(User user){
        return userService.insertData(user);
    }

    @PostMapping("/select")
    public Object selectAllRoles(){
        return userService.selectAllRoles();
    }
}
