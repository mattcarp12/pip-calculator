package org.matt.calculatorapp.Model.Evaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Infix {

    private static final Map<Character, Integer> precendence = new HashMap<>();
    static {
        precendence.put('-', 1);
        precendence.put('+', 1);
        precendence.put('/', 2);
        precendence.put('*', 2);
        precendence.put('^', 3);
    }

    public static double evaluate(String inputString) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Double> operandStack = new Stack<>();
        StringBuilder operand = new StringBuilder();

        for (Character c : inputString.toCharArray()) {
            if (Character.isDigit(c) || c == '.') operand.append(c);

            if (c == '(') operatorStack.push(c);

            if (isOperator(c)) {
                if (operand.length() != 0) {
                    operandStack.push(Double.parseDouble(operand.toString()));
                    operand.setLength(0);
                }
                while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                precendence.get(operatorStack.peek()) >= precendence.get(c))
                    operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                operatorStack.push(c);
            }

            if (c == ')') {
                while (operandStack.peek() != '(')
                    // Apply operator on top of operator stack to two operands on top of operand stack
                    operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                operandStack.pop();
            }
        }
        if (operand.length() != 0)
            operandStack.push(Double.parseDouble(operand.toString()));
        while (!operatorStack.isEmpty())
            operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        return operandStack.pop();
    }

    private static boolean isOperator(char c) {
        return "-+/*^".indexOf(c) != -1;
    }

    private static double applyOperator(char operator, double op1, double op2) {
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
