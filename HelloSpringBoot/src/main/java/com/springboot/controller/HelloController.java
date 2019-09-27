package com.springboot.controller;

//import javafx.scene.input.DataFormat;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.text.DateFormat;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloController {
    //@Value("${name}")
    //private String name;
    //
    //@Value("${age}")
    //private String age;

    //@Autowired
    //private StudentProperties studentProperties;

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}
