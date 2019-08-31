package org.matt.calculatorapp.Model;

import org.matt.calculatorapp.Model.Converter.Converter;
import org.matt.calculatorapp.Model.Evaluator.Evaluator;

public class AppCalculator implements Calculator {

    private StringBuilder inputString;
    private double result;
    private String mode;


    public AppCalculator() {
        inputString = new StringBuilder();
        result = 0;
        mode = "INFIX";
    }

    @Override
    public void addToInputString(char c) {
        inputString.append(c);
    }

    @Override
    public double getResult() {
        result = Evaluator.evaluateInputString(inputString.toString(), mode);
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
    public void clear() {
        inputString = new StringBuilder(Double.toString(result));
    }




}
