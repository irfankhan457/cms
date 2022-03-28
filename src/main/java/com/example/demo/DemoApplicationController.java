package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApplicationController {

    @GetMapping("/getPage")
    public String homePage() {
        return "this is response you get while get Return\\\\";
    }
}
