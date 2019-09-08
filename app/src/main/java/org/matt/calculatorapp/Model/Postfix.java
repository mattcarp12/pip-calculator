package org.matt.calculatorapp.Model;

import org.matt.calculatorapp.Model.Utility.EvaluatorUtils;

import java.math.BigDecimal;
import java.util.Stack;

import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.applyOperator;
import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.isOperator;

public class Postfix {

    public static String evaluateInputString(String inputString) throws Exception {

        Stack<BigDecimal> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();
        boolean operationPerformed = false;

        for (char c : inputString.toCharArray()) {

            if (Character.isDigit(c) || c == '.')
                operand.append(c);

            if (c == ' ' && operand.length() != 0) {
                stack.push(new BigDecimal(operand.toString()));
                operand.setLength(0);
            }

            if (isOperator(c)) {
                if (operand.length() != 0) {
                    stack.push(new BigDecimal(operand.toString()));
                    operand.setLength(0);
                }
                stack.push(applyOperator(c, stack.pop(), stack.pop()));
                operationPerformed = true;
            }
        }
        if (!operationPerformed) return "";
        return stack.pop().toString();
    }

    public static String convertToInfix(String inputString) throws Exception {
        Stack<String> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();

        for (char c : inputString.toCharArray()) {

            if (Character.isDigit(c) || c == '.')
                operand.append(c);

            if (c == ' ' && operand.length() != 0) {
                stack.push(operand.toString());
                operand.setLength(0);
            }

            if (isOperator(c)) {
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
