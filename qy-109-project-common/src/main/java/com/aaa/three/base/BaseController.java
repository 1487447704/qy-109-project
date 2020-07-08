package com.aaa.three.base;

import static com.aaa.three.status.LoginStatus.*;

/**
 * @Param
 * @ClassName BaseController
 * @Description 统一controller
 *              也就是说所有controller都要继承这个controller，进行统一返回
 *
 *              eg：登录成功和失败
 *                  code:200 msg:登录成功
 *                  code:400 msg:登录失败，系统异常
 *
 *              失败不能用系统异常：如使用404，相当于覆盖了系统自带的状态码，系统消息也会覆盖，
 *              那么异常就不会明确
 * @Author yk
 * @Date 2020/7/8 0008 18:41
 * @Return
 **/
public class BaseController {

    /**
     * @Description :
        登录成功
        使用系统消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 18:55
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description :
    登录成功
    自定义返回消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 18:55
     */
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description :
    登录成功
   返回数据信息，使用系统消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 18:55
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description :
    登录成功
    返回数据信息，自定义消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 18:55
     */
    protected ResultData loginSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description :
        登录失败，使用系统消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:46
     */
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description :
    登录失败，使用系统消息,详细解释说明
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:46
     */
    protected ResultData loginFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @Description :
     用户名已存在，使用系统消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:50
     */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description :
    用户名已存在，使用自定义消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:50
     */
    protected ResultData userExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description :
    用户名已存在，使用自定义消息,返回数据信息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:50
     */
    protected ResultData userExist(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description :
    用户名已存在，使用系统信息，返回数据信息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:50
     */
    protected ResultData userExist(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description :
     用户名不存在，使用系统消息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:56
     */
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setData(USER_NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description :
    用户名不存在，使用系统消息,详细解释说明
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:56
     */
    protected ResultData userNotExist(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setData(USER_NOT_EXIST.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @Description :
     密码错误，使用系统信息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:59
     */
    protected ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(resultData.getCode());
        resultData.setMsg(resultData.getMsg());
        return resultData;
    }

    /**
     * @Description :
    密码错误，使用系统信息,详细解释说明
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 19:59
     */
    protected ResultData passwordWrong(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(resultData.getCode());
        resultData.setMsg(resultData.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @Description :
        用户退出异常，使用系统信息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 20:01
     */
    protected ResultData logoutWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(resultData.getCode());
        resultData.setMsg(resultData.getMsg());
        return resultData;
    }

    /**
     * @Description :
    用户退出异常，使用系统信息，详细解释说明
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 20:01
     */
    protected ResultData logoutWrong(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(resultData.getCode());
        resultData.setMsg(resultData.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @Description :
        其他异常，使用自定义状态码、自定义信息
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/08 20:01
     */
    protected ResultData otherWrong(String code,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }
}
