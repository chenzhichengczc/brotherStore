package com.brother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@MapperScan("com.brother.mapper")
public class BrotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrotherApplication.class, args);
    }


}
