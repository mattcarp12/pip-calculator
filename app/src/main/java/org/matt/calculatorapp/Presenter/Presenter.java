package org.matt.calculatorapp.Presenter;

public interface Presenter {

    void addToInputString(char c);

    int getResult();

    void setCalculatorMode(String mode);

    String getInputString();

    void clearCalculator();

}
