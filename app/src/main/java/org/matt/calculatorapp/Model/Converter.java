package org.matt.calculatorapp.Model;

import static org.matt.calculatorapp.Model.Utility.EvaluatorUtils.reverseExpression;

public class Converter {

    public static String convert(String inputString, String from, String to) {
        try {
            switch(from){
                case "INFIX":
                    if (to == "PREFIX") return convertInfixToPrefix(inputString);
                    if (to == "POSTFIX") return convertInfixToPostfix(inputString);
                    return inputString;
                case "PREFIX":
                    if (to == "INFIX") return convertPrefixToInfix(inputString);
                    if (to == "POSTFIX") return convertInfixToPostfix(convertPrefixToInfix(inputString));
                    return inputString;
                case "POSTFIX":
                    if (to == "INFIX") return convertPostfixToInfix(inputString);
                    if (to == "PREFIX") return convertInfixToPrefix(convertPostfixToInfix(inputString));
                    return inputString;
                default:
                    return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String convertInfixToPrefix(String inputString) throws Exception {
        // Reverse infix expression, convert to postfix, then reverse again
        return reverseExpression(convertInfixToPostfix(reverseExpression(inputString)));
    }

    private static String convertInfixToPostfix(String inputString) throws Exception {
        return Infix.convertToPostfix(inputString);
    }

    private static String convertPrefixToInfix(String inputString) throws Exception {
        return Prefix.convertToInfix(inputString);
    }

    private static String convertPostfixToInfix(String inputString) throws Exception {
        return Postfix.convertToInfix(inputString);
    }

}
