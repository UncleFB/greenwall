package com.lq.greenwall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lq.greenwall.mapper")
public class GreenwallApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenwallApplication.class, args);
    }

}
