package com.example.enesbaskale.tutorials.controller;

import com.example.enesbaskale.tutorials.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {


    //Optional: root{}
    //http://localhost:8080
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //@ResponseBody yapısı
    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1() {

        return "thymeleaf1";
    }


    //model yapısı
    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        model.addAttribute("key_model2", "Ben modelden geldim-2");
        return "thymeleaf1";
    }

    // birden fazla model gönderme
    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        model.addAttribute("key_model2", "Ben modelden geldim-2");
        return "tymeleaf_file/thymeleaf3";
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-4");
        return "thymeleaf4";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Model Object göndermek
    //http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "text");
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("Ürün adı")
                .productPrice(2500)
                .build();
        model.addAttribute("key_model2", productDto);

        return "thymeleaf5";
    }

    //Model Object list göndermek
    //http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model) {
        model.addAttribute("key_model1", "text");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productId(1L).productName("Ürün adı1").productPrice(1500).build());
        listem.add(ProductDto.builder().productId(2L).productName("Ürün adı2").productPrice(2500).build());
        listem.add(ProductDto.builder().productId(3L).productName("Ürün adı3").productPrice(3500).build());
        listem.add(ProductDto.builder().productId(4L).productName("Ürün adı4").productPrice(4500).build());

        model.addAttribute("productList", listem);

        return "thymeleaf6";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@PathVariable
    //Model Object göndermek
    //http://localhost:8080/thymeleaf7/78
    //http://localhost:8080/thymeleaf7/
    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("key_model1", "id: " + id);

        } else {
            model.addAttribute("key_model1", "id bulunamadı");
        }
        return "thymeleaf7";
    }


    //@RequestParam
    //http://localhost:8080/thymeleaf8?id=4&name=EnesBaskale
    @GetMapping({"/thymeleaf8"})
    public String getThymeleaf8ModelObject(Model model,
                                           @RequestParam(name = "id", required = false, defaultValue = "0") Long id,
                                           @RequestParam(name = "name") String name) {
        if (id != null) {
            model.addAttribute("key_model1", "id: " + id + "name surname: " + name);

        } else {
            model.addAttribute("key_model1", "id bulunamadı");
        }
        return "thymeleaf8";
    }


}
