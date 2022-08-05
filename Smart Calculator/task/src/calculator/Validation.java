package calculator;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public interface Validation {
    Pattern IDENTIFIER = compile("\\p{Alpha}+");
    Pattern EXPRESSION = compile("[-+ ]*\\(*\\w+( *([/*]|[-+]+) *\\(*\\w+\\)*)*");
    Pattern ASSIGNMENT = compile("\\p{Alpha}+\\s*=[-+ ]*\\(*\\w+( *([/*]|[-+]+) *\\(*\\w+\\)*)*");

    String ERR_INVALID_EXPRESSION = "Invalid expression";
    String ERR_INVALID_ASSIGNMENT = "Invalid assignment";
    String ERR_INVALID_IDENTIFIER = "Invalid identifier";
    String ERR_UNKNOWN_VARIABLE = "Invalid expression";//"Unknown variable";
    String ERR_UNKNOWN_COMMAND = "Unknown command";

    boolean checkExpression(String expression);

    boolean checkAssignment(String expression);

    boolean checkVariables(String expression);

    boolean checkParentheses(String expression);

    boolean checkIdentifier(String identifier);

}