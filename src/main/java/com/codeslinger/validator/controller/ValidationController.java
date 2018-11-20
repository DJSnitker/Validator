package com.codeslinger.validator.controller;

import com.codeslinger.validator.resources.Validation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    @PostMapping("/validation")
    public String validate(@RequestBody Validation validation){
        System.out.println( validation );
        return "OK";
    }
}
