package com.codeslinger.validator.controller;

import com.codeslinger.validator.resources.Validation;
import com.codeslinger.validator.strategy.MockFalseValidationStrategy;
import com.codeslinger.validator.strategy.MockTrueValidationStrategy;
import com.codeslinger.validator.strategy.ValidatorStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationControllerTest {

    @Test
    public void badValidator() {
        final String expectedResponse = "NOT OK";
        ValidationController vc = new ValidationController();
        vc.setValidator( new ValidatorStrategy() );
        Validation testValidation = new Validation(null, "NAME", "STUFF");
        String actualResponse = vc.validate(testValidation);
        Assert.assertEquals("assert NOT OK is returned", expectedResponse, actualResponse);
    }

    @Test
    public void validate() {
        final String expectedResponse = "OK";
        ValidationController vc = new ValidationController();
        vc.setValidator( new MockTrueValidationStrategy() );
        Validation testValidation = new Validation("A", "NAME", "STUFF");
        String actualResponse = vc.validate(testValidation);
        Assert.assertEquals("assert OK is returned", expectedResponse, actualResponse);
    }

    @Test
    public void invalidate() {
        final String expectedResponse = "NOT OK";
        ValidationController vc = new ValidationController();
        vc.setValidator( new MockFalseValidationStrategy() );
        Validation testValidation = new Validation("A", "NAME", "STUFF");
        String actualResponse = vc.validate(testValidation);
        Assert.assertEquals("assert NOT OK is returned", expectedResponse, actualResponse);
    }

}
