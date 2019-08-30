package org.matt.calculatorapp.Model;

public interface Calculator {

    void addToInputString(char c);

    double getResult();

    void setCalculatorMode(String mode);

    String getInputString();

    void clear();

}
