package calculator;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

public class ExpressionValidation implements Validation {
    final private Map<String, BigInteger> variables;

    ExpressionValidation(Map<String, BigInteger> variables) {
        this.variables = variables;
    }

    @Override
    public boolean checkExpression(String expression) {
        final var isCorrectExpression = EXPRESSION.matcher(expression).matches();

        if (!isCorrectExpression) {
            System.out.println(ERR_INVALID_EXPRESSION);
        }
        return isCorrectExpression;
    }

    @Override
    public boolean checkAssignment(String expression) {
        final var isCorrectAssignment = ASSIGNMENT.matcher(expression).matches();

        if (!isCorrectAssignment) {
            System.out.println(ERR_INVALID_ASSIGNMENT);
        }
        return isCorrectAssignment;
    }

    @Override
    public boolean checkParentheses(String expression) {
        int count = 0;
        for (final var parenthesis : expression.replaceAll("[^()]", "").toCharArray()) {
            count += parenthesis == '(' ? 1 : -1;
            if (count < 0) {
                break;
            }
        }
        if (count != 0) {
            System.out.println(ERR_INVALID_EXPRESSION);
        }
        return count == 0;
    }

    @Override
    public boolean checkVariables(String expression) {
        final var variables = Set.of(expression.split("[^\\p{Alpha}]+"));
        final var isVariablesDefined = this.variables.keySet().containsAll(variables);

        if (!isVariablesDefined) {
            System.out.println(ERR_UNKNOWN_VARIABLE);
        }
        return isVariablesDefined;

    }

    @Override
    public boolean checkIdentifier(String identifier) {
        final var isCorrectIdentifier = IDENTIFIER.matcher(identifier).matches();

        if (!isCorrectIdentifier) {
            System.out.println(ERR_INVALID_IDENTIFIER);
        }
        return isCorrectIdentifier;
    }
}