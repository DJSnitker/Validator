package com.codeslinger.validator.controller;

import com.codeslinger.validator.resources.Validation;
import com.codeslinger.validator.strategy.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    private Validator validator;

    @Autowired
    @Qualifier("Strategy")
    public void setValidator( Validator val ){
        this.validator = val;
    }

    @PostMapping("/validation")
    public String validate(@RequestBody Validation validation){
        boolean valid = this.validator.validate(validation);
        if( valid ){
            return "OK";
        }
        else {
            return "NOT OK";
        }
    }
}
