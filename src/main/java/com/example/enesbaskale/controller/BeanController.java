package com.example.enesbaskale.controller;

import com.example.enesbaskale.bean.BeanConfig;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BeanController {

    @Autowired
    BeanConfig beanConfig;




    //http://localhost:8080/bean/beanDto
    @GetMapping("/bean/beanDto") //url
    @ResponseBody //html olmadan direkt ekranda göster
    public String getBeanDto(){
        return beanConfig.beanDto()+ "";
    }




}
