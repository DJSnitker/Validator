package com.codeslinger.validator.strategy;

import com.codeslinger.validator.resources.Validation;

public class MockTrueValidationStrategy implements Validator {

    @Override
    public boolean validate(Validation targetValidation){
        return true;
    }
}
