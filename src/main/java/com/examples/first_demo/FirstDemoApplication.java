package com.examples.first_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.examples.first_demo.mapper")
public class FirstDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);
    }

}
