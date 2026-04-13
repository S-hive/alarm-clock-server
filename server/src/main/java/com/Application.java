package com;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication // 启动类核心注解
@EnableTransactionManagement //开启 Spring 事务管理功能
@Slf4j
@EnableCaching //开启 Spring 缓存管理功能
@EnableScheduling //开启 Spring 定时任务功能
@MapperScan("com.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
