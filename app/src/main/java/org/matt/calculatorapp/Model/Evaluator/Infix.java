package org.matt.calculatorapp.Model.Evaluator;

import java.util.Stack;
import static org.matt.calculatorapp.Model.Evaluator.Utility.EvaluatorUtils.applyOperator;
import static org.matt.calculatorapp.Model.Evaluator.Utility.EvaluatorUtils.isOperator;
import static org.matt.calculatorapp.Model.Evaluator.Utility.EvaluatorUtils.precedence;

public class Infix {

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
                precedence.get(operatorStack.peek()) >= precedence.get(c))
                    operandStack.push(applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                operatorStack.push(c);
            }

            if (c == ')') {
                while (operandStack.peek() != '(')
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

}
