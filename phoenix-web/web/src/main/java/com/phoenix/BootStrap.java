package com.phoenix;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jims Wang
 * @date 2019-06-27 21:32
 */
@SpringBootApplication
@EnableDubbo
public class BootStrap {

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class);
    }

}
