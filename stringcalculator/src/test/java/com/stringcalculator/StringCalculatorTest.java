package com.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();
    
    //for empty string
    @Test
    public void testAdd_EmptyString_ReturnsZero() {
        
        assertEquals(0, calculator.add(""));
    }

    //for single value
    @Test
    public void testAdd_SingleNumber_ReturnsValue() {
        
        assertEquals(1, calculator.add("1"));
        assertEquals(12, calculator.add("12"));
    }

    //for two values with comma separated
    @Test
    public void testAdd_TwoNumbers_ReturnsSum() {
        
        assertEquals(6, calculator.add("1,5"));
        assertEquals(9, calculator.add("4,5"));
    }

    //to handle any amount of numbers
    @Test
    public void testAdd_MultipleNumbers_ReturnsSum() {
        
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(10, calculator.add("1,2,3,4"));
        assertEquals(15, calculator.add("5,5,5"));
    }

    //to handle new lines between numbers
    @Test
    public void testAdd_NewLineDelimiter_ReturnsSum() {
        
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("2,3\n5"));
    }

    //to support different delimiters
    @Test
    public void testAdd_CustomDelimiter_ReturnsSum() {
        
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(6, calculator.add("//***\\n1***2***3"));
        assertEquals(24, calculator.add("//-\n7-8-9"));
    }

    //to handle negative values
    @Test
    public void testAdd_NegativeNumbers_ThrowsException() {
        
        
        try {
            calculator.add("-1,2,-3");
            fail("Exception not thrown for negative numbers");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: -1, -3", e.getMessage());
        }
    }
}
