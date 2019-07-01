package com.phoenix;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jims Wang
 * @date 2019-06-09 13:40
 */
@SpringBootApplication
@EnableDubbo
@MapperScan("com.phoenix.mapper")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class);
    }
}
