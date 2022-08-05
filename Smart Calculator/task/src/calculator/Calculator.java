package calculator;

import java.math.BigInteger;
import java.util.regex.Pattern;

public interface Calculator {
    Pattern OPERATOR = Pattern.compile("[-+*/]");
    String  LEFT_PARENTHESIS = "(";
    String  RIGHT_PARENTHESIS = ")";

    boolean setExpression(final String expression);

    BigInteger calculate();

    void doAssignment(final String expression);
}