package com.codeslinger.validator.strategy;


import com.codeslinger.validator.resources.Validation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("A")
//@Scope("prototype")
public class AValidator implements Validator {

    @Override
    public boolean validate(Validation targetValidation){
        return !StringUtils.isEmpty( targetValidation.getStuff() );
    }
}
