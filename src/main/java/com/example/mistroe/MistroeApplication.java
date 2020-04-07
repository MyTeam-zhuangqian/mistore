package com.example.mistroe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.mistroe.mapper")
public class MistroeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MistroeApplication.class, args);
    }

}
