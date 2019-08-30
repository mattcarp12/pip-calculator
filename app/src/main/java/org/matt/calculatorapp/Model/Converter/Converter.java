package org.matt.calculatorapp.Model.Converter;

public class Converter {

    public static String convert(String inputString, String from, String to) {
        switch(from){
            case "INFIX":
                if (to == "PREFIX") return convertInfixToPrefix(inputString);
                if (to == "POSTFIX") return convertInfixToPostfix(inputString);
            case "PREFIX":
                if (to == "INFIX") return convertPrefixToInfix(inputString);
                if (to == "POSTFIX") return convertPrefixToInfix(convertInfixToPostfix(inputString));
            case "POSTFIX":
                if (to == "INFIX") return convertPostfixToInfix(inputString);
                if (to == "PREFIX") return convertPostfixToInfix(convertInfixToPrefix(inputString));
            default:
                return "";
        }
    }

    private static String convertInfixToPrefix(String inputString) {
        return "";
    }

    private static String convertInfixToPostfix(String inputString) {
        return "";
    }

    private static String convertPrefixToInfix(String inputString) {
        return "";
    }

    private static String convertPostfixToInfix(String inputString) {
        return "";
    }

}
