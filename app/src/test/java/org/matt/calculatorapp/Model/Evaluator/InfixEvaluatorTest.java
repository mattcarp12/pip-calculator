package org.matt.calculatorapp.Model.Evaluator;

import static org.junit.Assert.*;
import org.junit.Test;

public class InfixEvaluatorTest {

    @Test
    public void EvaluateInputStringTest() {
        Infix infix = new Infix();
        try {
            assertEquals("5", infix.evaluateInputString("3 + 2"));
            assertEquals("1", infix.evaluateInputString("3 - 2"));
            assertEquals("6", infix.evaluateInputString("3 * 2"));
            assertEquals("1.5", infix.evaluateInputString("3 / 2"));
            assertEquals("20", infix.evaluateInputString("5*(2 + 2)"));
            assertEquals("4", infix.evaluateInputString("(2) + 2"));
            assertEquals("16", infix.evaluateInputString("8 / 2 * (2 + 2)"));
            assertEquals("0", Infix.evaluateInputString("3*0"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
