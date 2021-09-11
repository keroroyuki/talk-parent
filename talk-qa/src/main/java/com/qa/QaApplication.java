package com.qa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author 谭嘉乐
 */
@SpringBootApplication
@MapperScan("com.qa.dao")
public class QaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
