package org.matt.calculatorapp.Model;

public interface Calculator {

    void addToInputString(char c);

    void addParen();

    String getResult();

    void setResult(String result);

    void setCalculatorMode(String mode);

    void convertInputString(String mode);

    String getInputString();

    void setInputString(String inputString);

    void deleteFromInputString();

    void clear();

    String getMode();
}
