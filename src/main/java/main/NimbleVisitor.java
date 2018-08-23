package main;

import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import utils.JasminConstants;
import utils.JasminHelper;

import java.util.HashMap;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<ParserData> {

    // store variables
    private Map<String, VariableData> variables = new HashMap<>();

    private VariableData getVariable(String identifier, ParserRuleContext ctx) {
        VariableData nimbleVariable = variables.get(identifier);

        if (nimbleVariable == null) {
            throw new ParseException(ctx, "Unknown identifier: " + identifier);
        }

        return nimbleVariable;
    }

    // TODO
    @Override
    public ParserData visitParse(NimbleParser.ParseContext ctx) {
        ParserData parserData = super.visit(ctx.main());
        return parserData;
    }

    @Override
    public ParserData visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();

        if(ctx.getStop().getType() != NimbleParser.SEMICOLON) {
            throw new ParseException(ctx, "Missing semicolon");
        }
        else if (variables.get(id) != null) {
            throw new ParseException(ctx, "Identifier " + id + " has already been declared");
        }

        int varType = ctx.variableType().start.getType();

        BaseValue value = (BaseValue) this.visit(ctx.expression());

        if (value == null)  // Create default value
            value = new ValueData(varType, ctx);

        int varIndex = JasminHelper.getVariableIndex();
        ParserData parserData = getVariableAssignment(ctx, varType, varIndex, value);
        variables.put(id, new VariableData(ctx, varType, varIndex));
        JasminHelper.updateVariableIndex(varType);

        return parserData;
    }

    private ParserData getVariableAssignment(ParserRuleContext ctx, int varType, int varIndex, BaseValue value) {
        ParserData variable = new ParserData(ctx);
        boolean castable = value.isAutoCastable(varType);
        int valueType = value.getDataType();

        if(varType != valueType && !castable) {
            variable.throwError("Can't assign type of value to this variable.");
        }

        if(value instanceof BaseExpression && value.isBoolean()) {
            String labelGoto = JasminHelper.getNewLabel();

            value.loadBooleanOnStack(true);
            value.setGotoRedirection(labelGoto);
            value.setLabel(((ExpressionData)value).getLabel());
            value.loadBooleanOnStack(false);
            value.setLabel(labelGoto);
        }

        variable.appendCode(value);
        if(castable)
            variable.addCommand(value.getCastCommand(varType));

        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if (0 <= varIndex && varIndex <= 3) {
            variable.addCommand(prefix + JasminConstants.STORE_VAl_SMALL + varIndex);
        } else {
            variable.addCommand(prefix + JasminConstants.STORE_VAL + varIndex);
        }

        return variable;
    }

    /**
     * Visit variable assignment
     *
     * @param ctx
     * @return
     */
    @Override
    public ParserData visitVariableAssignment(NimbleParser.VariableAssignmentContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        if(ctx.SEMICOLON() == null) {
            throw new ParseException(ctx, "missing semicolon");
        }

        VariableData variable = getVariable(id, ctx);

        BaseValue baseValue = (BaseValue) this.visit(ctx.expression());
        return getVariableAssignment(ctx, variable.getDataType(), variable.getVarIndex(), baseValue);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitIfStatement(NimbleParser.IfStatementContext ctx) {
        ParserData parserData = new ParserData(ctx);

        String gotoLabel = JasminHelper.getNewLabel();
        for(int i = 0; i < ctx.conditionBlock().size(); i++) {
            ExpressionData expressionData = (ExpressionData) this.visit(ctx.conditionBlock(i));

            parserData.appendCode(expressionData);
            parserData.setGotoRedirection(gotoLabel); // Label to go to after conditionblock
            parserData.setLabel(expressionData.getLabel());
        }

        if(ctx.block() != null)
            parserData.appendCode(this.visit(ctx.block())); // TODO ldc "asdad" || ldc asdad uitzoeken?
        
        parserData.setLabel(gotoLabel);
        return parserData;
    }

    @Override
    public ParserData visitParentheseExpression(NimbleParser.ParentheseExpressionContext ctx) {
        return this.visit(ctx.expression());
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public ParserData visitFunction(NimbleParser.FunctionContext ctx) {
        return super.visitFunction(ctx);
    }

    @Override
    public ParserData visitReturnValue(NimbleParser.ReturnValueContext ctx) {
        return super.visitReturnValue(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        return super.visitWhileLoop(ctx);
    }

    @Override
    public ParserData visitPrintStatement(NimbleParser.PrintStatementContext ctx) {
        BaseValue data = (BaseValue) this.visit(ctx.condition());
        data.print();
        return data;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        ExpressionData expressionData = (ExpressionData) this.visit(ctx.condition());
        if(!expressionData.isBoolean())
            expressionData.throwError("If statements can only contain boolean expressions");

        expressionData.appendCode(this.visit(ctx.block()));
        return expressionData;
    }

    @Override
    public ParserData visitBlock(NimbleParser.BlockContext ctx) {
        ParserData parserData = new ParserData(ctx);
        for(int i = 0; i < ctx.statement().size(); i++) {
            parserData.appendCode(this.visit(ctx.statement(i)));
        }

        return parserData;
    }

    @Override
    public ParserData visitCondition(NimbleParser.ConditionContext ctx) {
        return this.visit(ctx.expression());
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return super.visitConstructorDeclaration(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {
        return super.visitConstructorParameters(ctx);
    }

    @Override
    public ParserData visitBitwiseExpression(NimbleParser.BitwiseExpressionContext ctx) {
        ExpressionData expressionData;
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));
        expressionData = new ExpressionData(ctx, left, right);
        if(ctx.op.getType() == NimbleParser.AND) {
            expressionData.setAndExpression();
        } else {
            expressionData.setOrExpression();
        }

        for(int i = 0; i < ctx.expression().size() - 1; i++) {
            // TODO for meerdere && || expressions?
        }
        return expressionData;
    }

    @Override
    public ParserData visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {

        // Left is dominant (e.g. "test" + 3) -> "test3" || (3 + "test") -> Exception
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));

        ExpressionData expressionData = new ExpressionData(ctx, left, right);

        int additiveOperator = ctx.op.getType();
        if(additiveOperator == NimbleParser.ADD)
            expressionData.setAddExpression();
        else
            expressionData.setSubtractExpression();
        return expressionData;
    }

    @Override
    public ParserData visitRelationalExpression(NimbleParser.RelationalExpressionContext ctx) {
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));
        ExpressionData expressionData = new ExpressionData(ctx, left, right);
        expressionData.setRelationalExpression(ctx.op.getType());
        return expressionData;
    }

    /**
     * Visit a parse tree produced by the {@code equalityExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitEqualityExpression(NimbleParser.EqualityExpressionContext ctx) {
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));

        if(left.getDataType() != right.getDataType()) {
            throw new ParseException(ctx, "Equality expression only compares similar types of variables.");
        }

        // isEqual and isEqualOperator
        final int isEqualOperator = ctx.op.getType();

        ExpressionData exprData = new ExpressionData(ctx, left, right);
        exprData.setCompareExpression(isEqualOperator);

        return exprData;
    }

    /**
     * Visit a parse tree produced by the {@code notExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ParserData visitNotExpression(NimbleParser.NotExpressionContext ctx) {
        BaseValue value = (BaseValue) this.visit(ctx.expression());
        String gotoLbl = JasminHelper.getNewLabel();

        if(value.getDataType() != NimbleParser.BOOLEAN_TYPE) {
            value.throwError("Not expression only allowed for boolean types");
        } else if (value instanceof ExpressionData) {
            JavaByteCommand cmd = value.getLastCmd();
            if(cmd.isBranchOffCommand()) {
                cmd.cast().invertType();
            } else {
                throw new ParseException(ctx, "Invalid expression.");
            }
        } else {
            String branchOffLbl = JasminHelper.getNewLabel();
            value.addCommand(BranchOffType.IF_NOT_EQUAL, branchOffLbl);
            value.loadBooleanOnStack(true);
            value.setGotoRedirection(gotoLbl);
            value.setLabel(branchOffLbl);
            value.loadBooleanOnStack(false);
            value.setLabel(gotoLbl);
        }
        return value;
    }

    @Override
    public ParserData visitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx) {
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));
        ExpressionData expressionData = new ExpressionData(ctx, left, right);
        expressionData.setMultiplicationExpression(ctx.op.getType());
        return expressionData;
    }

    @Override
    public ParserData visitIntegerAtom(NimbleParser.IntegerAtomContext ctx) {
        try {
            return new ValueData(ctx, Integer.parseInt(ctx.getText()));
        } catch (NumberFormatException e) {
            throw new ParseException(ctx, "Can't format: " + ctx.getText() + " to an integer.");
        }
    }

    @Override
    public ParserData visitDoubleAtom(NimbleParser.DoubleAtomContext ctx) {
        try {
            return new ValueData(ctx, Double.parseDouble(ctx.getText()));
        } catch (NumberFormatException e) {
            throw new ParseException(ctx, "Can't format: " + ctx.getText() + " to an integer.");
        }
    }

    @Override
    public ParserData visitStringAtom(NimbleParser.StringAtomContext ctx) {
        return new ValueData(ctx, ctx.getText());
    }

    @Override
    public ParserData visitBooleanAtom(NimbleParser.BooleanAtomContext ctx) {
        String boolStr = ctx.getText();
        if (boolStr.equals("true") || boolStr.equals("false")) {
            return new ValueData(ctx, Boolean.parseBoolean(boolStr));
        } else {
            throw new ParseException(ctx, "Value: " + boolStr + " is neither 'true' or 'false'.");
        }
    }

    @Override
    public ParserData visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
        return getVariable(ctx.getText(), ctx);
    }

    @Override
    public ParserData visitNullAtom(NimbleParser.NullAtomContext ctx) {
        return super.visitNullAtom(ctx);
    }

    @Override
    public ParserData visitTerminal(TerminalNode terminalNode) {
        return super.visitTerminal(terminalNode);
    }

    @Override
    public ParserData visitErrorNode(ErrorNode errorNode) {
        return super.visitErrorNode(errorNode);
    }
}
