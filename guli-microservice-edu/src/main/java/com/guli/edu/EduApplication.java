package com.guli.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/4 15:07
 */
@ComponentScan(basePackages ={"com.guli.edu","com.guli.common"})
@SpringBootApplication
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
