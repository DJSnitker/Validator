package com.codeslinger.validator.strategy;

import com.codeslinger.validator.resources.Validation;

public interface Validator {
    public boolean validate(Validation validationTarget);
}
