package com.example.enesbaskale.bean;

import com.example.enesbaskale.audity.AuiditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {


    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuiditorAwareImpl();
    }

}
