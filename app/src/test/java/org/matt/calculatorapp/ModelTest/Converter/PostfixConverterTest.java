package org.matt.calculatorapp.ModelTest.Converter;

import org.junit.Test;
import org.matt.calculatorapp.Model.Postfix;

import static org.junit.Assert.assertEquals;

public class PostfixConverterTest {

    @Test
    public void ConvertPostfixToInfix() {
        assertEquals("(1 + (2 + 3))", Postfix.convertToInfix("1 2 3 + +"));
        assertEquals("((1 * 2) + 3)", Postfix.convertToInfix("1 2 * 3 +"));
    }
}
