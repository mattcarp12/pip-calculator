package org.matt.calculatorapp.Model;

public class Evaluator {

    public static int evaluateInputString(String inputString, String mode) {
        switch (mode) {
            case "INFIX":
                return evaluateInputStringInfix(inputString);
            case "PREFIX":
                return evaluateInputStringPrefix(inputString);
            case "POSTFIX":
                return evaluateInputStringPostfix(inputString);
            default:
                return 0;
        }
    }

    private static int evaluateInputStringInfix(String inputString){
        return 0;
    }

    private static int evaluateInputStringPrefix(String inputString) {
        return 0;
    }

    private static int evaluateInputStringPostfix(String inputString) {
        return 0;
    }

}
