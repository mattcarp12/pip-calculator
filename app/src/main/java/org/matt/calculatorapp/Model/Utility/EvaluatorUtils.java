package org.matt.calculatorapp.Model.Utility;

import java.math.BigDecimal;
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
        return "-+/*".indexOf(c) != -1;
    }

    public static BigDecimal applyOperator(char operator, BigDecimal op1, BigDecimal op2) {
        switch (operator) {
            case '+':
                return op2.add(op1);
            case '-':
                return op2.subtract(op1);
            case '*':
                return op2.multiply(op1);
            case '/':
                return op2.divide(op1);
            default:
                return new BigDecimal(0);
        }
    }

}
