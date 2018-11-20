package com.codeslinger.validator.resources;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationTest {

    @Test
    public void constructAndGet() {

        final String testType = "TYPE";
        final String testName = "NAME";
        final String testStuff = "STUFF";

        Validation validation = new Validation("TYPE", "NAME", "STUFF");

        Assert.assertEquals("Types are equal", testType, validation.getType() );
        Assert.assertEquals("Names are equal", testName, validation.getName() );
        Assert.assertEquals("Stuff is equal", testStuff, validation.getStuff() );
    }

    @Test
    public void testEqualTrue(){
        Validation validationOne = new Validation("TYPE", "NAME", "STUFF");
        Validation validationTwo = new Validation("TYPE", "NAME", "STUFF");
        Assert.assertEquals("Validation Objects are equal with the same content", validationOne, validationTwo);
    }

    @Test
    public void testEqualFalseOnType(){
        Validation validationOne = new Validation("EPYT", "NAME", "STUFF");
        Validation validationTwo = new Validation("TYPE", "NAME", "STUFF");
        Assert.assertNotEquals("Validation Objects are equal with the same content", validationOne, validationTwo);
    }

    @Test
    public void testEqualFalseOnName(){
        Validation validationOne = new Validation("TYPE", "EMAN", "STUFF");
        Validation validationTwo = new Validation("TYPE", "NAME", "STUFF");
        Assert.assertNotEquals("Validation Objects are equal with the same content", validationOne, validationTwo);
    }

    @Test
    public void testEqualFalseOnStuff(){
        Validation validationOne = new Validation("TYPE", "NAME", "FFUTS");
        Validation validationTwo = new Validation("TYPE", "NAME", "STUFF");
        Assert.assertNotEquals("Validation Objects are equal with the same content", validationOne, validationTwo);
    }

    @Test
    public void testEqualFalseOnCase(){
        Validation validationOne = new Validation("Type", "Name", "Stuff");
        Validation validationTwo = new Validation("TYPE", "NAME", "STUFF");
        Assert.assertNotEquals("Validation Objects are equal with the same content", validationOne, validationTwo);
    }

}
