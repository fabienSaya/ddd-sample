package com.bnp.lafabrique.ddd.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bnp.lafabrique.ddd"},lazyInit = true) //j'ai besoin de cette ligne parce que mes services sont pas tous dans les meme sous package. notamment package presentation.
public class StarterMain {
    public static void main(String[] args) {
        SpringApplication.run(StarterMain.class,args);
    }
}
