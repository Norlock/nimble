import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.Data;
import model.NimbleVariable;
import model.TokenData;
import model.ValueData;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<Data> {

    // store variables
    private Map<String, NimbleVariable> variables = new HashMap<>();

    private NimbleVariable getVariable(String identifier, ParserRuleContext ctx) {
        NimbleVariable nimbleVariable = variables.get(identifier);

        if (nimbleVariable == null) {
            throw new ParseException(ctx, "NimbleVariable: " + identifier + " has been assigned before being declared");
        }

        return nimbleVariable;
    }

    @Override
    public Data visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();

        if (variables.get(id) != null)
            throw new ParseException(ctx, "Identifier " + id + " has already been declared");

        int tokenType = ctx.variableType().start.getType();
        TokenData tokenData = new TokenData(tokenType);

        if (ctx.expression() == null) {
            variables.put(id, new NimbleVariable(tokenData, id));
            return tokenData;
        } else {
            ValueData value = (ValueData) this.visit(ctx.expression());
            variables.put(id, new NimbleVariable(tokenData, value, id));
            return value;
        }

    }

    /**
     * Visit variable assignment
     *
     * @param ctx
     * @return
     */
    @Override
    public Data visitVariableAssignment(NimbleParser.VariableAssignmentContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        NimbleVariable variable = getVariable(id, ctx);

        ValueData value = (ValueData) this.visit(ctx.expression());
        variable.setValueData(value);
        variables.put(id, variable);

        return value;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitIfStatement(NimbleParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Data visitFunction(NimbleParser.FunctionContext ctx) {
        return super.visitFunction(ctx);
    }

    @Override
    public Data visitReturnValue(NimbleParser.ReturnValueContext ctx) {
        return super.visitReturnValue(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        return super.visitWhileLoop(ctx);
    }

    @Override
    public Data visitPrintStatement(NimbleParser.PrintStatementContext ctx) {
        ValueData value = (ValueData) this.visit(ctx.condition());
        if (value == null) {
            throw new ParseException(ctx, "Can't print uninitialized variable.");
        }
        return super.visitPrintStatement(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        return super.visitConditionBlock(ctx);
    }

    @Override
    public Data visitCondition(NimbleParser.ConditionContext ctx) {
        return visit(ctx.expression());
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#modifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitModifier(NimbleParser.ModifierContext ctx) {
        return super.visitModifier(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return super.visitConstructorDeclaration(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {
        return super.visitConstructorParameters(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code orExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitOrExpression(NimbleParser.OrExpressionContext ctx) {
        return super.visitOrExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code andExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitAndExpression(NimbleParser.AndExpressionContext ctx) {
        return super.visitAndExpression(ctx);
    }

    @Override
    public Data visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {

        // Left is dominant (e.g. "test" + 3) -> "test3" || (3 + "test") -> Exception
        System.out.println(ctx.expression().size());
        ValueData left = (ValueData) this.visit(ctx.expression(0));
        ValueData right = (ValueData) this.visit(ctx.expression(1));

        final boolean add;

        switch (ctx.op.getType()) {
            case NimbleParser.ADD:
                add = true;
                break;
            case NimbleParser.SUBSTRACT:
                add = false;
                break;
            default:
                throw new RuntimeException("Additive expression has unknown token: "
                        + NimbleParser.VOCABULARY.getLiteralName(ctx.op.getType()));
        }

        if(add) {
            if (left.isString()) {
                return new ValueData(left.getValueStr() + right.toString());
            } else if (left.isBoolean() || right.isBoolean()) { // Moet na left.isString blijven
                throw new RuntimeException("Can't add or substract from a boolean");
            } else if (right.isString()) {
                throw new RuntimeException("Can't add or substract with a string");
            } else if (left.isDouble()) {
                if (right.isDouble()) {
                    return new ValueData(left.getValueDouble() + right.getValueDouble());
                } else if (right.isInteger()) {
                    return new ValueData(left.getValueDouble() + right.getValueInt());
                }
            } else if (left.isInteger()) {
                if(right.isDouble()) {
                    return new ValueData(left.getValueInt() + left.getValueDouble());
                } else if (right.isInteger()) {
                    return  new ValueData(left.getValueInt() + right.getValueInt());
                }
            }
        }
        else {
            if(left.isString() || right.isString())
                throw new RuntimeException("Can't substract from a String");
            else if (left.isBoolean() || right.isBoolean())
                throw new RuntimeException("Can't substract from a boolean");
            else if (left.isDouble()) {
                if(right.isDouble()) {
                    return new ValueData(left.getValueDouble() - right.getValueDouble());
                } else if (right.isInteger()) {
                    return new ValueData(left.getValueDouble() - right.getValueInt());
                }
            } else {
                if(right.isInteger()) {
                    return new ValueData(left.getValueInt() - right.getValueInt());
                } else if(right.isDouble()) {
                    return new ValueData(left.getValueInt() - right.getValueDouble());
                }
            }
        }
        throw new RuntimeException("Unknown type in additive expression");
    }


/**
 * Visit a parse tree produced by the {@code relationalExpression}
 * labeled alternative in {@link NimbleParser#expression}.
 *
 * @param ctx the parse tree
 * @return the visitor result
 */
    @Override
    public Data visitRelationalExpression(NimbleParser.RelationalExpressionContext ctx) {
        return super.visitRelationalExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code equalityExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitEqualityExpression(NimbleParser.EqualityExpressionContext ctx) {
        return super.visitEqualityExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code notExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitNotExpression(NimbleParser.NotExpressionContext ctx) {
        return super.visitNotExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code multiplicationExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx) {
        return super.visitMultiplicationExpression(ctx);
    }

    @Override
    public Data visitIntegerAtom(NimbleParser.IntegerAtomContext ctx) {
        try {
            return new ValueData(Integer.parseInt(ctx.getText()));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Can't format: " + ctx.getText() + " to an integer");
        }
    }

    @Override
    public Data visitStringAtom(NimbleParser.StringAtomContext ctx) {
        return new ValueData(ctx.getText());
    }

    @Override
    public Data visitBooleanAtom(NimbleParser.BooleanAtomContext ctx) {
        String boolStr = ctx.getText();
        if (boolStr.equals("true") || boolStr.equals("false")) {
            return new ValueData(Boolean.parseBoolean(boolStr));
        } else {
            throw new RuntimeException("Value: " + boolStr + " is not a string.");
        }
    }

    @Override
    public Data visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
        NimbleVariable nimbleVariable = getVariable(ctx.getText(), ctx);
        return nimbleVariable.getValueData();
    }

    @Override
    public Data visitNullAtom(NimbleParser.NullAtomContext ctx) {
        return super.visitNullAtom(ctx);
    }

    @Override
    public Data visitTerminal(TerminalNode terminalNode) {
        return super.visitTerminal(terminalNode);
    }

    @Override
    public Data visitErrorNode(ErrorNode errorNode) {
        return super.visitErrorNode(errorNode);
    }
}
