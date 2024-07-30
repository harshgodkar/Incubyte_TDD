package com.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest 
{
     @Test
    public void testAdd_EmptyString_ReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAdd_SingleNumber_ReturnsValue() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testAdd_TwoNumbers_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
        assertEquals(9, calculator.add("4,5"));
    }

    @Test
    public void testAdd_MultipleNumbers_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(10, calculator.add("1,2,3,4"));
        assertEquals(15, calculator.add("5,5,5"));
    }

    @Test
    public void testAdd_NewLineDelimiter_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("2,3\n5"));
    }

    @Test
    public void testAdd_CustomDelimiter_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(6, calculator.add("//:\n2:2:2"));
    }

    @Test
    public void testAdd_NegativeNumbers_ThrowsException() {
        StringCalculator calculator = new StringCalculator();
        
        try {
            calculator.add("-1,2,-3");
            fail("Exception not thrown for negative numbers");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: -1, -3", e.getMessage());
        }
    }
}
