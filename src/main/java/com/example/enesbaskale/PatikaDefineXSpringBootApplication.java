package com.example.enesbaskale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Security inactive
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)

public class PatikaDefineXSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatikaDefineXSpringBootApplication.class, args);
    }

}
