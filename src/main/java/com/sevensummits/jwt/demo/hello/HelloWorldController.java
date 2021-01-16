package com.sevensummits.jwt.demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    String hello(@RequestParam(required = false, name = "name", defaultValue = "World") final String name) {
        return "Hello " + name + "!";
    }
}
