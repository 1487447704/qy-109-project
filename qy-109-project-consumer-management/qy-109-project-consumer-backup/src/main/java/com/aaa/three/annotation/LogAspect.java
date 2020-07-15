package com.aaa.three.annotation;

import com.aaa.three.model.LoginLog;
import com.aaa.three.model.User;
import com.aaa.three.service.IProjectService;
import com.aaa.three.utils.AddressUtils;
import com.aaa.three.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.util.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import static com.aaa.three.staticproperties.TimeFormatProperties.TIME_FORMAT;

/**
 * @Param
 * @ClassName LogAspect
 * @Description AOP
 *          @Slf4j:  simple log for java
 * @Author yk
 * @Date 2020/7/15 0015 17:03
 * @Return
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private IProjectService projectService;
    /**
     * @Description :
        定义切点信息
        这个时候就不能按照常规的切点(service/controller)
        直接去切自定义的注解
        也就是说当检测自定义注解存在的时候，切面触发，也就是说AOP才会被触发
     * @return : void
     * @author : yk
     * @date : 2020/07/15 17:06
     */
    @Pointcut("@annotation(com.aaa.three.annotation.LoginAnnotation)")
    public void pointcut(){
        //TODO nothing to do
    }

    /**
     * @Description : 定义环形切面（就是具体来实现业务逻辑的方法）
     *      ProceedingJoinPoint:封装了目标路径中所用到的所有参数
     *                  这里会用到大量的反射
     * @param proceedingJoinPoint
     * @return : java.lang.Object
     * @author : yk
     * @date : 2020/07/15 18:41
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws ClassNotFoundException {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
//        获取Request对象
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
//        1.获取ip地址
//        需要一个HttpServletRequest对象
        String ipAddr = IPUtils.getIpAddr(request);
//        2.获取地理位置
        Map<String, Object> addresses = AddressUtils.getAddresses(ipAddr, "UTF-8");
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(ipAddr);
//        地址
        loginLog.setLocation(addresses.get("province")+"|"+addresses.get("city"));
//        登陆时间
        loginLog.setLoginTime(DateUtil.formatDate(new Date(),TIME_FORMAT));

//        3.获取UserName---->想要获取到Username，必须要获取到目标方法的参数值
//        args：目标方法的参数值
        Object[] args = proceedingJoinPoint.getArgs();
        User user = (User) args[0];
/*        User user1 = null;
        for (Object arg : args){
            user1 = (User) arg;
        }*/
        loginLog.setUsername(user.getUsername());
        /*
        * 4.获取操作的类型以及具体操作的内容(反射)
        * 4.1.获取目标类名(全限定名)
        * tarClassName:完全限定类名
        * */
        String tarClassName = proceedingJoinPoint.getTarget().getClass().getName();

//        tarMethodName：目标方法名
        String tarMethodName = proceedingJoinPoint.getSignature().getName();

//        4.2.获取类对象
//        tarClass：类对象
        Class tarClass = Class.forName(tarClassName);

//        4.3.获取目标类中的所有方法
//        methods：目标类所有方法
        Method[] methods = tarClass.getMethods();

        String operationType = "";
        String operationName = "";


        for (Method method : methods){
//            methodName:目标方法名
            String methodName = method.getName();
            if (tarMethodName.equals(methodName)){
                /*
                * 这个时候虽然已经确定了目标方法没有问题，但是可能会出现方法的重载
                * 还需要进一步加载
                * 4.4.获取目标方法的参数
                * parameterTypes：目标方法的参数
                * */
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length){
//                    获取目标方法
                    operationType = method.getAnnotation(LoginAnnotation.class).operationType();
                    operationName = method.getAnnotation(LoginAnnotation.class).operationName();
                }
            }
        }
        loginLog.setOperationType(operationType);
        loginLog.setOperationName(operationName);

        projectService.addLoginLog(loginLog);
        return result;
    }
}
