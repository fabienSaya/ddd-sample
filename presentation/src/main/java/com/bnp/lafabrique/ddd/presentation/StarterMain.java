package com.bnp.lafabrique.ddd.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.bnp.lafabrique.ddd.presentation"},lazyInit = true)
public class StarterMain {
    public static void main(String[] args) {
        SpringApplication.run(StarterMain.class,args);
    }
}
