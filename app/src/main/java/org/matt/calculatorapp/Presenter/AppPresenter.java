package org.matt.calculatorapp.Presenter;

import org.matt.calculatorapp.Model.AppCalculator;
import org.matt.calculatorapp.Model.Calculator;
import org.matt.calculatorapp.View.View;

public class AppPresenter implements Presenter {

    private Calculator calculator;
    private View view;

    @Override
    public void clearCalculator() {
        calculator.clear();
        view.clearInputString();
        view.clearResult();
    }

    public AppPresenter(View view) {
        this.view = view;
        calculator = new AppCalculator();
    }

    @Override
    public void addToInputString(char c) {
        calculator.addToInputString(c);
        view.setInputString(calculator.getInputString());
    }

    @Override
    public double getResult() {
        return calculator.getResult();
    }

    @Override
    public void setCalculatorMode(String mode) {
        calculator.setCalculatorMode(mode);
        view.setInputString(calculator.getInputString());
    }

    @Override
    public String getInputString() {
        return getInputString();
    }
}
