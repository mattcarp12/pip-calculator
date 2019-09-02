package org.matt.calculatorapp.Model;

import org.matt.calculatorapp.Model.Utility.EvaluatorUtils;

public class AppCalculator implements Calculator {

    private StringBuilder inputString;
    private String result;
    private String mode;
    private int parenDepth;

    public AppCalculator() {
        inputString = new StringBuilder();
        result = "";
        mode = "INFIX";
        parenDepth = 0;
    }

    @Override
    public void addToInputString(char c) {
        inputString.append(c);
        try {
            result = Evaluator.evaluateInputString(inputString.toString(), mode);
        } catch(Exception e) {
            result = "";
        }
    }

    @Override
    public void addParen() {
        if (inputString.length() != 0) {
            char endOfInputString = inputString.charAt(inputString.length() - 1);
            if (EvaluatorUtils.isOperator(endOfInputString) || endOfInputString == '(') {
                inputString.append('(');
                parenDepth++;
            } else if (parenDepth == 0) {
                if (endOfInputString == '.') {
                    inputString.append('0');
                }
                inputString.append("*(");
                parenDepth++;
            } else {
                inputString.append(')');
                parenDepth--;
            }
        } else {
            inputString.append('(');
            parenDepth++;
        }

        try {
            result = Evaluator.evaluateInputString(inputString.toString(), mode);
        } catch(Exception e) {
            result = "";
        }

    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setCalculatorMode(String mode) {
        inputString = new StringBuilder(Converter.convert(inputString.toString(), this.mode, mode));
        this.mode = mode;
    }

    @Override
    public String getInputString() {
        return inputString.toString();
    }

    @Override
    public void setInputString(String inputString) {
        this.inputString = new StringBuilder(inputString);
    }

    @Override
    public void clear() {
        inputString = new StringBuilder();
        result = "";
        parenDepth = 0;
    }

    @Override
    public void deleteFromInputString() {
        char c = inputString.charAt(inputString.length() - 1);
        if (c == '(') parenDepth--;
        if (c == ')') parenDepth++;
        inputString.deleteCharAt(inputString.length() - 1);
        try {
            result = Evaluator.evaluateInputString(inputString.toString(), mode);
        } catch(Exception e) {
            result = "";
        }
    }


}
