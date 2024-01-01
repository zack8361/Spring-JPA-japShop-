package jpabook.jpashop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Controller
public class MainController {

    @PostMapping("/testKong")
    public String kong(@RequestParam("file") MultipartFile file){

        return null;
    }

    @GetMapping("/")
    public String loginForm(){

        return "hello";
    }
}
