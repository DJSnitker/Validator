package com.codeslinger.validator.strategy;

import com.codeslinger.validator.resources.Validation;

public class MockFalseValidationStrategy implements Validator {

    @Override
    public boolean validate(Validation targetValidation){
        return false;
    }
}
