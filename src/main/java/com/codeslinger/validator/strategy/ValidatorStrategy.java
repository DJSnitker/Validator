package com.codeslinger.validator.strategy;

import com.codeslinger.validator.resources.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

@Service("Strategy")
//@Scope("prototype")
public class ValidatorStrategy implements Validator {

    private ApplicationContext ctx;

    @Autowired
    public void setCtx( ApplicationContext ctx ){
        this.ctx = ctx;
    }

    @Override
    public boolean validate(Validation targetValidation){
        if(!StringUtils.isBlank(targetValidation.getType())) {
            Validator val = (Validator) ctx.getBean(targetValidation.getType());
            return val.validate(targetValidation);
        } else {
            return false;
        }
    }
}
