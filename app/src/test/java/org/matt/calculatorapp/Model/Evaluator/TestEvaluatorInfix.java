package org.matt.calculatorapp.Model.Evaluator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.matt.calculatorapp.Model.Evaluator.Infix;

public class TestEvaluatorInfix {

    @Test
    public void evaluateInfix() {
        assertEquals(Infix.evaluate("2 + 2"), 4, 0.000001);
        assertEquals(Infix.evaluate("5*(2 + 2)"), 20, 0.000001);
        assertEquals(Infix.evaluate("2 ^ (2)"), 4, 0.000001);
        assertEquals(Infix.evaluate("(2) + 2"), 4, 0.000001);
        assertEquals(Infix.evaluate("8 / 2 * (2 + 2)"), 1, 0.000001);
        assertEquals(Infix.evaluate("2 ^ (9/3)"), 8, 0.000001);
    }
}
