package org.matt.calculatorapp.Model;

import org.matt.calculatorapp.Model.Utility.EvaluatorUtils;

import javax.inject.Inject;

public class AppCalculator implements Calculator {

    private StringBuilder inputString;
    private String result;
    private String mode;
    private int parenDepth;

    @Inject
    public AppCalculator() {
        inputString = new StringBuilder();
        result = "";
        mode = "INFIX";
        parenDepth = 0;
    }

    @Override
    public void addToInputString(char c) {
        inputString.append(c);
        evaluate();
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

        evaluate();
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void setCalculatorMode(String mode) {
        this.mode = mode;
    }

    @Override
    public void convertInputString(String mode) {
        inputString = new StringBuilder(Converter.convert(inputString.toString(), this.mode, mode));
    }

    @Override
    public String getInputString() {
        return inputString.toString();
    }

    @Override
    public void setInputString(String inputString) {
        this.inputString = new StringBuilder(inputString);
        evaluate();
    }

    @Override
    public void clear() {
        inputString = new StringBuilder();
        result = "";
        parenDepth = 0;
    }

    @Override
    public void deleteFromInputString() {
        if (inputString.length() == 0) return;
        char c = inputString.charAt(inputString.length() - 1);
        if (c == '(') parenDepth--;
        if (c == ')') parenDepth++;
        inputString.deleteCharAt(inputString.length() - 1);
        evaluate();
    }

    @Override
    public String getMode() {
        return mode;
    }

    private void evaluate() {
        try {
            result = Evaluator.evaluateInputString(inputString.toString(), mode);
        } catch(Exception e) {
            e.printStackTrace();
            result = "";
        }
    }
}
