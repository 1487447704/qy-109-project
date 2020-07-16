package com.aaa.three.service;

import com.aaa.three.base.BaseService;
import com.aaa.three.mapper.UserMapper;
import com.aaa.three.model.User;
import com.aaa.three.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Param
 * @ClassName LoginService
 * @Description
 * @Author yk
 * @Date 2020/7/15 0015 15:15
 * @Return
 **/
@Service
public class LoginService extends BaseService<User> {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description : 执行登录操作
     *      pojo:实体类
     *      povo：封装类型（当在实际开发中，会有很多情况导致多表联查的时候无法装载数据---->就可以根据返回前端的数据
     *              自己去封装一个对象出来----->view object）
     * @param user
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/15 15:17
     */
    public TokenVo doLogin(User user){
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        /*1.判断User是否为null*/
        if (null != user){
            //说明不为空
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
//            2.判断user2是否为null
            if (null == user2){
//                说明user2为null
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            }else {
//                说明user2不为null，用户名OK，查询密码
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
//                3.判断user3是否为空
                if (null == user3){
//                    说明user3为空
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                }else {
//                    说明user3不为空，登录成功
                    /**
                     * !!!!mybatis是无法检测连接符的，他会把连接符进行转译(//-)
                     * 需要把连接符替换掉
                     */
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
//                    将token存到数据库中
                    user3.setToken(token);
                    Integer updateResult = super.update(user3);
//                    判断是否存储成功
                    if (updateResult > 0){
//                        存储成功
                        tokenVo.setIfSuccess(true).setToken(token);

                    }else {
//                        存储失败
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }

                }

            }
        }else {
//            说明user为空
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }
}
