package main;

import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<Data> {

    // store variables
    private Map<String, VariableData> variables = new HashMap<>();

    private VariableData getVariable(String identifier, ParserRuleContext ctx) {
        VariableData nimbleVariable = variables.get(identifier);

        if (nimbleVariable == null) {
            throw new ParseException(ctx, "Variable: " + identifier + " has been assigned before being declared");
        }

        return nimbleVariable;
    }

    @Override
    public Data visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();

        if (variables.get(id) != null)
            throw new ParseException(ctx, "Identifier " + id + " has already been declared");

        int type = ctx.variableType().start.getType();
        VariableData variable;
        if (ctx.expression() == null) {
            variable = new VariableData(type, id);
            variables.put(id, variable);
            return new ParserData();
        } else {
            Data data = this.visit(ctx.expression());
            if(data instanceof ValueData) {
                variable = new VariableData(type, id, (ValueData)data);
            } else {

            }
            variables.put(id, variable);
            return variable.convertToParserData();
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
        VariableData variable = getVariable(id, ctx);

        ValueData value = (ValueData) this.visit(ctx.expression());
        variable.setValue(value);
        variables.put(id, variable);

        return variable.convertToParserData();
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
        Data data = this.visit(ctx.condition());
        if (data == null) {
            throw new ParseException(ctx, "Can't print uninitialized variable.");
        }

        ParserData parserData = new ParserData();
        if(data instanceof ParserData) {
            parserData.print(((ParserData) data).getJasminCode());
        } else if (data instanceof ValueData) {
            parserData.print((ValueData) data);
        } else {
            throw new RuntimeException("Unknown data class");
        }

        return parserData;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        ParserData condition = (ParserData) this.visit(ctx.condition());
        ParserData block = (ParserData) this.visit(ctx.block());
        // TODO
        return condition;
    }

    @Override
    public Data visitCondition(NimbleParser.ConditionContext ctx) {
        return this.visit(ctx.expression());
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

        ParserData parserData = new ParserData();

        int additiveOperator = ctx.op.getType();
        if(additiveOperator == NimbleParser.ADD) {
            if (left.isString()) {
                parserData.setAdditiveExpressionString(left.getValueStr(), right.getValueStr());
            } else if (left.isBoolean() || right.isBoolean()) { // Moet na left.isString blijven
                throw new ParseException(ctx, "Can't add or substract from a boolean");
            } else if (right.isString()) {
                throw new ParseException(ctx, "Can't add or substract with a string");
            } else if (left.isDouble()) {
                if (right.isDouble()) {
                    parserData.setAdditiveExpressionDouble(left.getValueDouble(), right.getValueDouble(), additiveOperator);
                } else if (right.isInteger()) {
                    parserData.setAdditiveExpressionDouble(left.getValueDouble(), right.getValueInt(), additiveOperator);
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
        return parserData;
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
        ValueData valueLeft = (ValueData) this.visit(ctx.expression(0));
        ValueData valueRight = (ValueData) this.visit(ctx.expression(1));

        if(valueLeft.getType() != valueRight.getType()) {
            throw new ParseException(ctx, "Equality expression only compares similar types of variables");
        }

        // isEqual and isEqualOperator
        final int equalOperator = ctx.op.getType();
        ParserData parserData = new ParserData();

        if(valueLeft.getType() == NimbleParser.INTEGER_TYPE) {
            parserData.setIntegerCompare(valueLeft.getValueInt(), valueRight.getValueInt(),
                    equalOperator);
        } else if (valueLeft.getType() == NimbleParser.DOUBLE_TYPE) {
            parserData.setDoubleCompare(valueLeft.getValueDouble(), valueRight.getValueDouble(),
                    equalOperator);
        } else if (valueLeft.getType() == NimbleParser.BOOLEAN_TYPE) {
            parserData.setBooleanCompare(valueLeft.getValueBool(), valueRight.getValueBool(), equalOperator);
        } else if (valueLeft.getType() == NimbleParser.STRING_TYPE) {
            parserData.setStringCompare(valueLeft.getValueStr(), valueRight.getValueStr(), equalOperator);
        } else if (valueLeft.getType() == NimbleParser.BOOLEAN_TYPE) {
            parserData.setBooleanCompare(valueLeft.getValueBool(), valueRight.getValueBool(), equalOperator);
        } else {
            throw new RuntimeException("not implemented");
        }
        return parserData;
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
            throw new ParseException(ctx, "Can't format: " + ctx.getText() + " to an integer");
        }
    }

    @Override
    public Data visitDoubleAtom(NimbleParser.DoubleAtomContext ctx) {
        try {
            return new ValueData(Double.parseDouble(ctx.getText()));
        } catch (NumberFormatException e) {
            throw new ParseException(ctx, "Can't format: " + ctx.getText() + " to an integer");
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
            throw new ParseException(ctx, "Value: " + boolStr + " is not a string.");
        }
    }

    @Override
    public Data visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) { // TODO (return parserdata variable kan veranderen!)
        return getVariable(ctx.getText(), ctx);
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
