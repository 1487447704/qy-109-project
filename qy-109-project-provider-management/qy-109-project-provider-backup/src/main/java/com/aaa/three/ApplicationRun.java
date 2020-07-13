package com.aaa.three;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Param
 * @ClassName ApplicationRun
 * @Description 启动类
 * @Author yk
 * @Date 2020/7/13 0013 10:25
 * @Return
 **/
@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
public class ApplicationRun {

}
