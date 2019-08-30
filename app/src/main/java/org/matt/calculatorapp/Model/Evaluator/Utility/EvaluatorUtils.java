package org.matt.calculatorapp.Model.Evaluator.Utility;

import java.util.HashMap;
import java.util.Map;

public class EvaluatorUtils {

    public static final Map<Character, Integer> precedence = new HashMap<>();
    static {
        precedence.put('-', 1);
        precedence.put('+', 1);
        precedence.put('/', 2);
        precedence.put('*', 2);
        precedence.put('^', 3);
    }

    public static boolean isOperator(char c) {
        return "-+/*^".indexOf(c) != -1;
    }

    public static double applyOperator(char operator, double op1, double op2) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            case '^':
                return Math.pow(op1, op2);
            default:
                return 0;
        }
    }

}
