package com.caveman.springboot101.course.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by petro on 7/19/17.
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}
