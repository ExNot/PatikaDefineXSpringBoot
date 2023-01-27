package com.example.enesbaskale.bean;

import com.example.enesbaskale.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initalBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton") //request, session

    public BeanDto beanDto(){

        return BeanDto
                .builder()
                   .id(0L).beanName("bean Adı").beanData("bean Data")
                .build();
    }
}
