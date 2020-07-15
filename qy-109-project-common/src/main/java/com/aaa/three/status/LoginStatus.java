package com.aaa.three.status;



/**
 * @Param
 * @ClassName LoginStatus
 * @Description 枚举类
 * @Author yk
 * @Date 2020/7/8 0008 18:44
 * @Return
 **/
public enum LoginStatus {
    LOGIN_SUCCESS("200","登录成功"),
    LOGIN_FAILED("400","登陆失败，系统异常"),
    USER_EXIST("201","用户已经存在"),
    USER_NOT_EXIST("401","用户不存在"),
    PASSWORD_WRONG("402","密码错误"),
    LOGOUT_WRONG("405","用户退出异常"),
    SYSTEM_EXCEPTION("406","系统异常");

    LoginStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
