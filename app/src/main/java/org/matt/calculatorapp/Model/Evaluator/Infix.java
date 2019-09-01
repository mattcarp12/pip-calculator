package org.matt.calculatorapp.Model.Evaluator;

import java.math.BigDecimal;
import java.util.Stack;
import static org.matt.calculatorapp.Model.Evaluator.Utility.EvaluatorUtils.applyOperator;
import static org.matt.calculatorapp.Model.Evaluator.Utility.EvaluatorUtils.isOperator;
import static org.matt.calculatorapp.Model.Evaluator.Utility.EvaluatorUtils.precedence;

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
        /*if(result == (long) result)
            return String.format("%d", (long) result);
        else
            return String.format("%s", result);*/
        /*if (result % 1 == 0) return Integer.toString((int)result);
        else return Double.toString(result);*/
        return result.toString();
    }

}
