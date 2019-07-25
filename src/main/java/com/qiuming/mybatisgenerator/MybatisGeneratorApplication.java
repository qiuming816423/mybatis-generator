package com.qiuming.mybatisgenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qiuming.mybatisgenerator.mapper.*")
public class MybatisGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorApplication.class, args);
    }

}
