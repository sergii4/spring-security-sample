package com.getman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sergii Getman
 */
@Configuration
@ComponentScan(value = {"com.getman"})
public class TestBeanConfig {
    @Bean
    public ServletContext servletContext() {
        return new MockServletContext();
    }
}
