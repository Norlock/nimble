package main;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Custom exceptions to suppress stacktrace
 */
public class ParseException extends RuntimeException {

    public ParseException(ParserRuleContext context, String message) {
        super("\nLine (" + context.getStart().getLine() + "): " + message, null, true, false);
    }
}
