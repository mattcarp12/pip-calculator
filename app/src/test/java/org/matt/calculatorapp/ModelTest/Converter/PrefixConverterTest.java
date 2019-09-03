package org.matt.calculatorapp.ModelTest.Converter;

import org.junit.Test;
import org.matt.calculatorapp.Model.Prefix;

import static org.junit.Assert.assertEquals;

public class PrefixConverterTest {

    @Test
    public void PrefixToInfixTest() {
        assertEquals("((10 + 20) * (30 - 100))", Prefix.convertToInfix("* + 10 20 - 30 100"));
        assertEquals("((1 - (2 / 3)) * ((4 / 5) - 6))", Prefix.convertToInfix("* - 1 / 2 3 - / 4 5 6"));
    }
}
