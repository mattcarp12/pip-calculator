package org.matt.calculatorapp.Presenter;

import org.matt.calculatorapp.Model.Calculator;
import org.matt.calculatorapp.AppView.AppView;
import javax.inject.Inject;

public class AppPresenter implements Presenter {


    private Calculator calculator;
    private AppView appView;

    @Inject
    public AppPresenter(AppView appView, Calculator calculator) {
        this.appView = appView;
        this.calculator = calculator;
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
    public void setResult(String result) {
        calculator.setResult(result);
    }

    @Override
    public void setCalculatorMode(String mode, boolean convert) {
        if (convert) calculator.convertInputString(mode);
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

    @Override
    public String getMode() {
        return calculator.getMode();
    }

    @Override
    public void update() {
        appView.setTvInputString(calculator.getInputString());
        appView.setTvResult(calculator.getResult());
        appView.setTvMode(calculator.getMode());
    }
}
