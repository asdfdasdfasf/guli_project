package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/6 21:50
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.atguigu.*")
public class OssApplication{
    public static void main(String[] args) {
       SpringApplication.run(OssApplication.class, args);
    }
}

