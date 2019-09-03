package org.matt.calculatorapp.ModelTest.Evaluator;

import org.junit.Test;
import org.matt.calculatorapp.Model.Prefix;

import static org.junit.Assert.assertEquals;

public class PrefixEvaluatorTest {

    @Test
    public void EvaluateInputStringTest() {
        try {
            assertEquals("21", Prefix.evaluateInputString("+9* 2 6"));
            assertEquals("8", Prefix.evaluateInputString("-+8/6 3 2"));
            assertEquals("25", Prefix.evaluateInputString("- + 7 * 4 5 + 2 0"));
            assertEquals("50", Prefix.evaluateInputString("+ 20 30"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
