package org.matt.calculatorapp.Presenter;

public interface Presenter {

    void addToInputString(char c);

    void addParen();

    String getResult();

    void setCalculatorMode(String mode);

    String getInputString();

    void clearCalculator();

    void setInputString(String inputString);

    void deleteFromInputString();

}

