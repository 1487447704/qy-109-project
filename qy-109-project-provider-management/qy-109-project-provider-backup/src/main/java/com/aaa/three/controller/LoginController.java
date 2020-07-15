package com.aaa.three.controller;

import com.aaa.three.base.BaseService;
import com.aaa.three.base.CommonController;
import com.aaa.three.base.ResultData;
import com.aaa.three.model.LoginLog;
import com.aaa.three.model.User;
import com.aaa.three.service.LoginService;
import com.aaa.three.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.three.status.LoginStatus.*;

/**
 * @Param
 * @ClassName LoginController
 * @Description TODO
 * @Author yk
 * @Date 2020/7/15 0015 15:13
 * @Return
 **/
@RestController
public class LoginController extends CommonController<User> {

    @Autowired
    private LoginService loginService;

    @Override
    public BaseService<User> getBaseService() {
        return loginService;
    }
    /**
     * @Description :执行登录操作
     * @param user
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/15 15:14
     */
    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = loginService.doLogin(user);

        if (tokenVo.getIfSuccess()){
            return super.loginSuccess(tokenVo.getToken());
        }else if (tokenVo.getType() == 1){
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        }else if (tokenVo.getType() == 2){
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        }else {
            return super.loginFailed().setMsg(SYSTEM_EXCEPTION.getMsg());
        }
    }




}
