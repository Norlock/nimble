package main;

import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import utils.JasminConstants;
import utils.JasminHelper;

public class NimbleVisitor extends NimbleParserBaseVisitor<ParserData> {


    // TODO
    @Override
    public ParserData visitParse(NimbleParser.ParseContext ctx) {
        ParserData main = this.visit(ctx.main());
        FileData fileData = new FileData(main.getCtx());

        this.visit(ctx.classDeclaration());
        for (int i = 0; i < ctx.component().size(); i++) {
            fileData.appendCode(this.visit(ctx.component(i)));
        }

        return fileData;
    }

    @Override
    public ParserData visitMain(NimbleParser.MainContext ctx) {
        return this.visit(ctx.block());
    }

    @Override
    public ParserData visitClassDeclaration(NimbleParser.ClassDeclarationContext ctx) {
        JasminHelper.className = ctx.IDENTIFIER().getText();
        return super.visitClassDeclaration(ctx);
    }

    @Override
    public ParserData visitComponent(NimbleParser.ComponentContext ctx) {
        if (ctx.field() != null)
            return visit(ctx.field());
        else if (ctx.function() != null)
            return visit(ctx.function());
        return super.visitComponent(ctx); // TODO checken of comments of hier worden gehonoreerd.
    }

    @Override
    public ParserData visitField(NimbleParser.FieldContext ctx) {
        return this.visit(ctx.variableDeclaration());
    }

    @Override
    public ParserData visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();

        if (ctx.getStop().getType() != NimbleParser.SEMICOLON) {
            throw new ParseException(ctx, "Missing semicolon");
        } else if (JasminHelper.getFieldOrVariable(id, ctx) != null) {
            throw new ParseException(ctx, "Identifier " + id + " has already been declared");
        }

        BaseValue value = (BaseValue) this.visit(ctx.expression());
        int varType = ctx.variableType().start.getType();

        // Create default value
        if (value == null) {
            value = new ValueData(varType, ctx);
        }

        ParserData parserData;
        if (ctx.getParent() instanceof NimbleParser.FieldContext) {
            parserData = JasminHelper.getFieldAssignment(ctx, varType, id, value);
            JasminHelper.setField(id, new FieldData(ctx, id, varType));
        } else {
            int varIndex = JasminHelper.getVariableIndex(ctx);
            parserData = JasminHelper.getVariableAssignment(ctx, varType, varIndex, value);
            JasminHelper.setVariable(ctx, id, new VariableData(ctx, varType, varIndex));
            JasminHelper.updateVariableIndex(ctx, varType);
        }

        return parserData;
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
        if (ctx.SEMICOLON() == null) {
            throw new ParseException(ctx, "Missing semicolon.");
        }

        BaseValue fieldOrVariable = JasminHelper.getFieldOrVariable(id, ctx);
        if (fieldOrVariable == null)
            throw new ParseException(ctx, "Identifier has not been declared yet.");

        BaseValue baseValue = (BaseValue) this.visit(ctx.expression());
        if (JasminHelper.isField(id))
            return JasminHelper.getFieldAssignment(ctx, fieldOrVariable.getDataType(), id, baseValue);
        else {
            VariableData variable = (VariableData) fieldOrVariable;
            return JasminHelper.getVariableAssignment(ctx, variable.getDataType(),
                    variable.getVarIndex(), baseValue);
        }
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
        for (int i = 0; i < ctx.conditionBlock().size(); i++) {
            ExpressionData expressionData = (ExpressionData) this.visit(ctx.conditionBlock(i));

            parserData.appendCode(expressionData);
            parserData.setGotoRedirection(gotoLabel); // Label to go to after conditionblock
            parserData.setLabel(expressionData.getLabel());
        }

        // if contains else
        if (ctx.block() != null)
            parserData.appendCode(this.visit(ctx.block()));

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
        ParserData parserData = new ParserData(ctx);
        JasminHelper.setVariableBlock(ctx);
        parserData.appendCode(this.visit(ctx.constructorDeclaration()));
        return super.visitFunction(ctx);
    }

    @Override
    public ParserData visitReturnValue(NimbleParser.ReturnValueContext ctx) {
        return super.visitReturnValue(ctx);
    }

    @Override
    public ParserData visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        BaseExpression conditionBlock = (BaseExpression) this.visit(ctx.conditionBlock());
        ParserData whileLoop = new ParserData(ctx);
        String whileLabel = JasminHelper.getNewLabel();
        whileLoop.setLabel(whileLabel);
        whileLoop.appendCode(conditionBlock);
        whileLoop.setGotoRedirection(whileLabel);
        whileLoop.setLabel(conditionBlock.getLabel());
        return whileLoop;
    }

    @Override
    public ParserData visitPrintStatement(NimbleParser.PrintStatementContext ctx) {
        BaseValue data = (BaseValue) this.visit(ctx.condition());
        ParserData print = new ParserData(ctx);

        print.addCommand(JasminConstants.LOAD_SYSO_ONTO_STACK);

        if (data instanceof BaseExpression && data.isBoolean()) {
            BaseExpression baseExpression = (BaseExpression) data;
            baseExpression.setBooleanReturnValue();
        }

        print.appendCode(data);

        // Call println
        String printStr = JasminConstants.INVOKE_VIRTUAL + "java/io/PrintStream/println("
                + JasminConstants.DataType.getDataTypeStr(data.getDataType()) + ")V";

        print.addCommand(printStr);
        return print;
    }

    @Override
    public ParserData visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        ExpressionData expressionData = (ExpressionData) this.visit(ctx.condition());
        if (!expressionData.isBoolean())
            expressionData.throwError("Conditions can only contain boolean expressions");

        expressionData.appendCode(this.visit(ctx.block()));
        return expressionData;
    }

    @Override
    public ParserData visitBlock(NimbleParser.BlockContext ctx) {
        JasminHelper.setVariableBlock(ctx);
        ParserData parserData = new ParserData(ctx);
        for (int i = 0; i < ctx.statement().size(); i++) {
            parserData.appendCode(this.visit(ctx.statement(i)));
        }

        return parserData;
    }

    @Override
    public ParserData visitCondition(NimbleParser.ConditionContext ctx) {
        return this.visit(ctx.expression());
    }

    @Override
    public ParserData visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return visit(ctx.constructorParameters());
    }

    @Override
    public ParserData visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {

        for(int i = 0; i < ctx.variableType().size(); i++) {
            int varType = ctx.variableType(i).start.getType();
            String identifier = ctx.IDENTIFIER(i).getText();

            int varIndex = JasminHelper.getVariableIndex(ctx);
            JasminHelper.setVariable(ctx, identifier, new VariableData(ctx, varType, varIndex));
            System.out.println("vartype is: " + JasminConstants.DataType.getDataTypeStr(varType));
            System.out.println("Identifier: " + identifier);
        }

        // Nothing has to be added, variables are already loaded.
        return new ParserData(ctx);
    }

    @Override
    public ParserData visitBitwiseExpression(NimbleParser.BitwiseExpressionContext ctx) {
        ExpressionData expressionData;
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));
        expressionData = new ExpressionData(ctx, left, right);
        if (ctx.op.getType() == NimbleParser.AND) {
            expressionData.setAndExpression();
        } else {
            expressionData.setOrExpression();
        }

        return expressionData;
    }

    @Override
    public ParserData visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));

        ExpressionData expressionData = new ExpressionData(ctx, left, right);

        if (ctx.op.getType() == NimbleParser.ADD)
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

        if (left.getDataType() != right.getDataType()) {
            throw new ParseException(ctx, "Equality expression only compares similar types of variables.");
        }

        ExpressionData exprData = new ExpressionData(ctx, left, right);
        exprData.setCompareExpression(ctx.op.getType());

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
        return new NotExpressionData(ctx, value);
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
            throw new ParseException(ctx, "NumberFormatException: " + e.getLocalizedMessage());
        }
    }

    @Override
    public ParserData visitDoubleAtom(NimbleParser.DoubleAtomContext ctx) {
        try {
            return new ValueData(ctx, Double.parseDouble(ctx.getText()));
        } catch (NumberFormatException e) {
            throw new ParseException(ctx, "NumberFormatException: " + e.getLocalizedMessage());
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
            throw new ParseException(ctx, "Value: " + boolStr + " is neither 'true' nor 'false'.");
        }
    }

    @Override
    public ParserData visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
        BaseValue var = JasminHelper.getFieldOrVariable(ctx.getText(), ctx);
        if (var == null)
            throw new ParseException(ctx, "Variable has not been declared yet.");
        else
            return var;
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
