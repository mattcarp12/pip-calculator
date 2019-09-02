package org.matt.calculatorapp.ModelTest.Evaluator;

import org.junit.Test;
import org.matt.calculatorapp.Model.Postfix;

import static org.junit.Assert.assertEquals;

public class PostfixEvaluatorTest {

    @Test
    public void EvaluateInputStringTest() {
        try {
            assertEquals("5", Postfix.evaluateInputString("3 2 +"));
            assertEquals("-1", Postfix.evaluateInputString("2 3 -"));
            assertEquals("6", Postfix.evaluateInputString("2 3 *"));
            assertEquals("6", Postfix.evaluateInputString("2 3 *"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
