package com.atguigu.serviceedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/5/19 14:42
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.serviceedu.mapper")
@ComponentScan(basePackages = "com.atguigu.*")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
