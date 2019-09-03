package org.matt.calculatorapp.ModelTest.Converter;

import org.junit.Test;
import org.matt.calculatorapp.Model.Infix;

import static org.junit.Assert.assertEquals;

public class InfixConverterTest {

    @Test
    public void InfixToPostfixTest() {
        assertEquals("2 2 +", Infix.convertToPostfix("2 + 2"));
        assertEquals("2 2 +", Infix.convertToPostfix("(2 + 2)"));
        assertEquals("5.5 2 +", Infix.convertToPostfix("(5.5 + 2)"));
        assertEquals("5.5 2 + 9 *", Infix.convertToPostfix("(5.5 + 2)* (9)"));
        assertEquals("8 3 + 2 -", Infix.convertToPostfix("8 + 3 - 2"));
        assertEquals("10 20 + 30 100 + *", Infix.convertToPostfix("( 10 + 20 ) * ( 30 + 100 )"));
    }
}
