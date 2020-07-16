package com.aaa.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Param
 * @ClassName ApplicationRun6083
 * @Description TODO
 * @Author yk
 * @Date 2020/7/16 0016 9:15
 * @Return
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun6083 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6083.class,args);
    }
}
