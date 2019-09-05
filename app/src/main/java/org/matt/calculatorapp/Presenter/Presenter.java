package org.matt.calculatorapp.Presenter;

public interface Presenter {

    void addToInputString(char c);

    String getInputString();

    void setInputString(String inputString);

    void deleteFromInputString();

    void addParen();

    String getResult();

    void setResult(String result);

    String getMode();

    void setCalculatorMode(String mode, boolean convert);

    void clearCalculator();

}

