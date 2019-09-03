package org.matt.calculatorapp.Model;

import org.matt.calculatorapp.Model.Utility.EvaluatorUtils;

import java.math.BigDecimal;
import java.util.Stack;

public class Postfix {

    public static String evaluateInputString(String inputString) throws Exception {

        Stack<BigDecimal> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();

        for (char c : inputString.toCharArray()) {

            if (Character.isDigit(c) || c == '.')
                operand.append(c);

            if (c == ' ' && operand.length() != 0) {
                stack.push(new BigDecimal(operand.toString()));
                operand.setLength(0);
            }

            if (EvaluatorUtils.isOperator(c)) {
                if (operand.length() != 0) {
                    stack.push(new BigDecimal(operand.toString()));
                    operand.setLength(0);
                }
                stack.push(EvaluatorUtils.applyOperator(c, stack.pop(), stack.pop()));
            }
        }
        return stack.pop().toString();
    }

    public static String convertToInfix(String inputString) {
        Stack<String> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();

        for (char c : inputString.toCharArray()) {

            if (Character.isDigit(c) || c == '.')
                operand.append(c);

            if (c == ' ' && operand.length() != 0) {
                stack.push(operand.toString());
                operand.setLength(0);
            }

            if (EvaluatorUtils.isOperator(c)) {
                if (operand.length() != 0) {
                    stack.push(operand.toString());
                    operand.setLength(0);
                }
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op2 + " " + c + " " + op1 + ")");
            }
        }
        return stack.pop();
    }
}
