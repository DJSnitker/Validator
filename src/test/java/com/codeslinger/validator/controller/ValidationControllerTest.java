package com.codeslinger.validator.controller;

import com.codeslinger.validator.resources.Validation;
import com.codeslinger.validator.strategy.MockFalseValidationStrategy;
import com.codeslinger.validator.strategy.MockTrueValidationStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationControllerTest {

    @Test
    public void validate() {
        final String expectedResponse = "OK";
        ValidationController vc = new ValidationController();
        vc.setValidator( new MockTrueValidationStrategy() );
        Validation testValidation = new Validation("TYPE", "NAME", "STUFF");
        String actualResponse = vc.validate(testValidation);
        Assert.assertEquals("assert OK is returned", expectedResponse, actualResponse);
    }

    @Test
    public void invalidate() {
        final String expectedResponse = "NOT OK";
        ValidationController vc = new ValidationController();
        vc.setValidator( new MockFalseValidationStrategy() );
        Validation testValidation = new Validation("TYPE", "NAME", "STUFF");
        String actualResponse = vc.validate(testValidation);
        Assert.assertEquals("assert NOT OK is returned", expectedResponse, actualResponse);
    }

}
