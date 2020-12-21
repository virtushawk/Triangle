package edu.epam.triangle.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InputValidatorTest {

    @Test
    public void validateInputTrue() {
        String line =  "1 3 2 -5 -8 4";
        InputValidator inputValidator = new InputValidator();
        boolean actual = inputValidator.validateInput(line);
        Assert.assertTrue(actual);
    }

    @Test
    public void validateInputFalse() {
        String line = "1a 1 2 2 3 3.0";
        InputValidator inputValidator = new InputValidator();
        boolean actual = inputValidator.validateInput(line);
        Assert.assertFalse(actual);
    }

    @Test
    public void isNumberTrue() {
        String number = "-14.11";
        InputValidator inputValidator = new InputValidator();
        boolean actual = inputValidator.isNumber(number);
        Assert.assertTrue(actual);
    }

    @Test
    public void isNumberFalse() {
        String number = "-%14/11";
        InputValidator inputValidator = new InputValidator();
        boolean actual = inputValidator.isNumber(number);
        Assert.assertFalse(actual);
    }
}
