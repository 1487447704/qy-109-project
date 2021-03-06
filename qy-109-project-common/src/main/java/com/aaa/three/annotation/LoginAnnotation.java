package com.aaa.three.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Param
 * @ClassName LoginAnnotation
 * @Description @Target():标识了自己所自定义注解的使用范围(也就是说标识了自定义使用于方法，类，属性...)
 *              @Retention():
 *                      标识了自定义注解的生效时间
 *                      RUNTIME：项目运行时该自定义注解生效
 *                      TEST：在有Junit的时候生效
 *              @Inherited:
 *                      继承(当使用该注解的时候，自定义的作用范围必须是类)
 *
 *              所有的注解时没有任何实际意义的，只是起到了一个标识的作用，真正有意义的代码在于实现了这个注解的业务逻辑
 *              自定义注解+AOP实现自动日志，真正实现的地方在于AOP，自定义注解只是做了一个标识
 * @Author yk
 * @Date 2020/7/15 0015 16:36
 * @Return
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {
    /**
     * 要执行的操作类型
     *      eg：delete操作 update操作 insert操作...
     * @return
     */
    String operationType();

    /**
     * 所要执行的具体操作内容
     *  eg:删除用户 删除菜单 删除部门...
     * @return
     */
    String operationName();
}
