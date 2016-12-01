package com.griddynamics.integration.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.*;

@EnableAutoConfiguration
@IntegrationComponentScan
@ComponentScan
public class SiserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiserverApplication.class, args);
    }
}
