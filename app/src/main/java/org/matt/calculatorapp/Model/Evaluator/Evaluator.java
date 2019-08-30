package org.matt.calculatorapp.Model.Evaluator;

public class Evaluator {

    public static double evaluateInputString(String inputString, String mode) {
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

    private static double evaluateInputStringInfix(String inputString){
        return Infix.evaluate(inputString);
    }

    private static double evaluateInputStringPrefix(String inputString) {
        return 0;
    }

    private static double evaluateInputStringPostfix(String inputString) {
        return 0;
    }

}
