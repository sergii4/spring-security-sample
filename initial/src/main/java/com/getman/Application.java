package com.getman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Sergii Getman
 */
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class})
@ComponentScan("com.getman")
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[]{Application.class, MvcConfig.class}, args);
    }
}