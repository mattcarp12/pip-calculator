package org.matt.calculatorapp.Model;

import java.math.BigDecimal;
import java.util.Stack;

import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.applyOperatorPrefix;
import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.isOperator;

public class Prefix {

    public static String evaluateInputString(String inputString) throws Exception {
        Stack<BigDecimal> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();
        boolean operationPerformed = false;
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char c = inputString.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                operand.append(c);
            }

            if (c == ' ' && operand.length() != 0) {
                stack.push(new BigDecimal(operand.reverse().toString()));
                operand.setLength(0);
            }

            if (isOperator(c)) {
                if (operand.length() == 0 && c == '-') {
                    stack.push(new BigDecimal(0));
                }
                if (operand.length() != 0) {
                    stack.push(new BigDecimal(operand.reverse().toString()));
                    operand.setLength(0);
                }
                stack.push(applyOperatorPrefix(c, stack.pop(), stack.pop()));
                operationPerformed = true;
            }
        }
        if (!operationPerformed) return "";
        return stack.pop().toString();
    }

    public static String convertToInfix(String inputString) throws Exception {
        Stack<String> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char c = inputString.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                operand.append(c);
            }

            if (c == ' ' && operand.length() != 0) {
                stack.push(operand.reverse().toString());
                operand.setLength(0);
            }

            if (isOperator(c)) {
                if (operand.length() != 0) {
                    stack.push(operand.reverse().toString());
                    operand.setLength(0);
                }
                stack.push("(" + stack.pop() + " " + c + " " + stack.pop() + ")");
            }
        }
        return stack.pop();
    }

}
