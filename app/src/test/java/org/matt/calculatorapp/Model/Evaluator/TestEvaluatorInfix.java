package org.matt.calculatorapp.Model.Evaluator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.matt.calculatorapp.Model.Evaluator.Infix;

public class TestEvaluatorInfix {

    @Test
    public void evaluateInfix() {
        assertEquals(Infix.evaluate("2 + 2"), 4, 0.0001);
    }
}
