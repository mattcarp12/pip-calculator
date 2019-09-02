package org.matt.calculatorapp.Presenter;

import org.matt.calculatorapp.Model.AppCalculator;
import org.matt.calculatorapp.Model.Calculator;
import org.matt.calculatorapp.AppView.AppView;

public class AppPresenter implements Presenter {

    private Calculator calculator;
    private AppView appView;

    public AppPresenter(AppView appView) {
        this.appView = appView;
        calculator = new AppCalculator();
    }

    @Override
    public void clearCalculator() {
        calculator.clear();
        appView.clearInputString();
        appView.clearResult();
    }

    @Override
    public void setInputString(String inputString) {
        calculator.setInputString(inputString);
        appView.setTvInputString(inputString);
    }

    @Override
    public void addParen() {
        calculator.addParen();
        update();
    }

    @Override
    public void addToInputString(char c) {
        calculator.addToInputString(c);
        update();
    }

    @Override
    public String getResult() {
        return calculator.getResult();
    }

    @Override
    public void setCalculatorMode(String mode) {
        calculator.setCalculatorMode(mode);
        update();
    }

    @Override
    public String getInputString() {
        return calculator.getInputString();
    }

    @Override
    public void deleteFromInputString() {
        calculator.deleteFromInputString();
        update();
    }

    private void update() {
        appView.setTvInputString(calculator.getInputString());
        appView.setTvResult(calculator.getResult());
    }
}
