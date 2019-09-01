package org.matt.calculatorapp.Model.Evaluator;

public class Evaluator {

    public static String evaluateInputString(String inputString, String mode) throws Exception {
        switch (mode) {
            case "PREFIX":
                return Prefix.evaluateInputString(inputString);
            case "INFIX":
                return Infix.evaluateInputString(inputString);
            case "POSTFIX":
                return Postfix.evaluateInputString(inputString);
            default:
                return "";
        }
    }
}
