package com.aaa.three;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Param
 * @ClassName ApplicationRun
 * @Description 启动类
 * @Author yk
 * @Date 2020/7/13 0013 10:25
 * @Return
 **/
@SpringBootApplication/*(
        exclude = {
                DataSourceAutoConfiguration.class,
                RedisRepositoriesAutoConfiguration.class
        }
)*/
@EnableDiscoveryClient
@MapperScan("com.aaa.three.mapper")
public class ApplicationRun8081 {
        public static void main(String[] args) {
                SpringApplication.run(ApplicationRun8081.class,args);
        }
}
