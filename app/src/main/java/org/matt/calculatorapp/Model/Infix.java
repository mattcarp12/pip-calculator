package org.matt.calculatorapp.Model;

import java.math.BigDecimal;
import java.util.Stack;
import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.precedence;
import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.applyOperator;
import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.isOperator;

public class Infix{

    public static String evaluateInputString(String inputString) throws Exception {

        Stack<Character> operatorStack = new Stack<>();
        Stack<BigDecimal> operandStack = new Stack<>();
        StringBuilder operand = new StringBuilder();
        boolean operationPerformed = false;

        for (Character c : inputString.toCharArray()) {
            if (Character.isDigit(c) || c == '.') operand.append(c);

            if (c == '(') operatorStack.push(c);

            if (isOperator(c)) {
                if (operand.length() != 0) {
                    operandStack.push(new BigDecimal(operand.toString()));
                    operand.setLength(0);
                }
                while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                precedence.get(operatorStack.peek()) >= precedence.get(c)) {
                    operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                    operationPerformed = true;
                }

                operatorStack.push(c);
            }

            if (c == ')') {
                if (operand.length() != 0) {
                    operandStack.push(new BigDecimal(operand.toString()));
                    operand.setLength(0);
                }
                while (operatorStack.peek() != '(') {
                    operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                    operationPerformed = true;
                }
                operatorStack.pop();
            }
        }
        if (operand.length() != 0)
            operandStack.push(new BigDecimal(operand.toString()));
        while (!operatorStack.isEmpty()) {
            operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
            operationPerformed = true;
        }

        if (!operationPerformed) return "";
        BigDecimal result = operandStack.pop();
        return result.toString();
    }

    public static String convertToPostfix(String inputString) {
        StringBuilder postfixString = new StringBuilder();
        StringBuilder operand = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c) || c == '.')
                operand.append(c);

            if (c == '(')
                stack.push(c);

            if (c == ')') {
                if (operand.length() != 0) {
                    postfixString.append(operand.toString() + " ");
                    operand.setLength(0);
                }
                while (stack.peek() != '(') {
                    postfixString.append(stack.pop() + " ");
                }
                stack.pop();
            }

            if (isOperator(c)) {
                if (operand.length() != 0) {
                    postfixString.append(operand.toString() + " ");
                    operand.setLength(0);
                }
                if (stack.isEmpty() || stack.peek() == '(' ||
                        precedence.get(stack.peek()) < precedence.get(c)) {
                    stack.push(c);
                } else {
                    while (stack.peek() == '(' || precedence.get(stack.peek()) >= precedence.get(c)) {
                        if (stack.peek() == '(') {
                            stack.push(c);
                            break;
                        } else {
                            postfixString.append(stack.pop() + " ");
                        }
                    }
                    stack.push(c);
                }
            }
        }

        if (operand.length() != 0)
            postfixString.append(operand.toString() + " ");

        while (!stack.isEmpty())
            postfixString.append(stack.pop() + " ");

        return postfixString.toString().trim();
    }

}
