package org.matt.calculatorapp.Model.Converter;

import org.junit.Test;
import org.matt.calculatorapp.Model.Evaluator.Infix;

import static org.junit.Assert.assertEquals;

public class InfixConverterTest {

    @Test
    public void InfixToPostfixTest() {
        assertEquals("2 2 +", Infix.convertToPostfix("2 + 2"));
        assertEquals("2 2 +", Infix.convertToPostfix("(2 + 2)"));
        assertEquals("5.5 2 +", Infix.convertToPostfix("(5.5 + 2)"));
        assertEquals("5.5 2 + 9 *", Infix.convertToPostfix("(5.5 + 2)* (9)"));
    }
}
