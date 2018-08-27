package main;

import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.FunctionContainer;
import utils.JasminConstants;
import utils.JasminHelper;

public class NimbleVisitor extends NimbleParserBaseVisitor<ParserData> {

    @Override
    public ParserData visitParse(NimbleParser.ParseContext ctx) {
        this.visit(ctx.classDeclaration());
        FileData fileData = new FileData(ctx);

        // First iterate through components --> Will assign fields
        for (int i = 0; i < ctx.component().size(); i++) {
            ParserData parserData = this.visit(ctx.component(i));
            if(parserData instanceof FunctionData) {
                fileData.appendFunction((FunctionData) parserData);
            } else {
                fileData.appendField(parserData);
            }
        }

        fileData.appendMain((FunctionData) this.visit(ctx.main()));
        return fileData;
    }

    @Override
    public ParserData visitMain(NimbleParser.MainContext ctx) {
        FunctionData functionData = new FunctionData(this.visit(ctx.block()));
        functionData.addCommand(JasminConstants.RETURN);
        return functionData;
    }

    @Override
    public ParserData visitClassDeclaration(NimbleParser.ClassDeclarationContext ctx) {
        JasminHelper.className = ctx.IDENTIFIER().getText();
        return new ParserData(ctx);
    }

    @Override
    public ParserData visitComponent(NimbleParser.ComponentContext ctx) {
        if (ctx.field() != null)
            return visit(ctx.field());
        else if (ctx.function() != null)
            return visit(ctx.function());

        return new ParserData(ctx);
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
    public ParserData visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();

        FunctionContainer container = JasminHelper.getFunctionContainer(identifier);
        if(container == null)
            throw new ParseException(ctx, "Cannot find function: " + identifier);

        FunctionExpressionData functionExpressionData = new FunctionExpressionData(ctx, container);
        if(ctx.functionAssignments() != null) {
            functionExpressionData.appendCode(this.visit(ctx.functionAssignments()));
        } else if (container.getConstructorTypes().size() > 0) {
            throw new ParseException(ctx, "Function: " + identifier + " requires parameters to be set.");
        }

        functionExpressionData.setFunctionCall();

        if(!useReturnValue(ctx)) {
            functionExpressionData.addCommand(JasminConstants.POP);
        }

        return functionExpressionData;
    }

    private boolean useReturnValue(ParserRuleContext ctx) {
        if(ctx instanceof NimbleParser.VariableAssignmentContext
                || ctx instanceof NimbleParser.VariableDeclarationContext) {
            return true;
        } else if(ctx.invokingState == -1) {
            return false;
        } else {
            return useReturnValue(ctx.getParent());
        }
    }

    @Override
    public ParserData visitFunctionAssignments(NimbleParser.FunctionAssignmentsContext ctx) {
        ParserData parserData = new ParserData(ctx);
        NimbleParser.FunctionCallContext parentCtx = (NimbleParser.FunctionCallContext) ctx.getParent();
        String identifier = parentCtx.IDENTIFIER().getText();
        FunctionContainer container = JasminHelper.getFunctionContainer(identifier);
        int paramsSize = container.getConstructorTypes().size();
        if(ctx.expression().size() != paramsSize)
            throw new ParseException(ctx, "Function: " + identifier + " misses parameters.");

        for(int i = 0; i < paramsSize; i++) {
            BaseValue baseValue = (BaseValue) this.visit(ctx.expression(i));
            int paramType = container.getConstructorType(i);
            if(baseValue.getDataType() != paramType)
                throw new ParseException(ctx, "Incorrect type(s) for function: " + identifier);
            if(baseValue instanceof BaseExpression && baseValue.isBoolean()) {
                ((BaseExpression) baseValue).setBooleanReturnValue();
            }
            parserData.appendCode(baseValue);
        }

        return parserData;
    }

    @Override
    public ParserData visitFunction(NimbleParser.FunctionContext ctx) {
        // Will load the constructor variables
        JasminHelper.setVariableBlock(ctx);
        this.visit(ctx.constructorDeclaration());
        this.visit(ctx.returnValue());

        FunctionData functionData = new FunctionData(this.visit(ctx.block()));
        FunctionContainer container = functionData.getFunctionContainer();
        if(!container.hasReturnStatement() && container.isVoid()) {
            // Void doesn't need return, Nimble will append automatically.
            functionData.addCommand(JasminConstants.RETURN);
        } else if(!container.hasReturnStatement() && !container.isVoid()) {
            throw new ParseException(ctx, "Function misses return statement.");
        }

        return functionData;
    }

    /**
     * What kind of data type does it expects to return? void, bool, etc.
     * @param ctx context
     * @return no modified return value.
     */
    @Override
    public ParserData visitReturnValue(NimbleParser.ReturnValueContext ctx) {
        int type = ctx.variableType().start.getType();
        FunctionContainer container = JasminHelper.getFunctionContainer(ctx);
        container.setReturnType(type);
        return new ParserData(ctx);
    }

    @Override
    public ParserData visitReturnStatement(NimbleParser.ReturnStatementContext ctx) {
        if(ctx.expression() != null) {
            BaseValue value = (BaseValue) this.visit(ctx.expression());
            return JasminHelper.getReturnAssignment(ctx, value);
        }
        else {
            return JasminHelper.getReturnAssignment(ctx);
        }
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
        return JasminHelper.getPrintAssignment(ctx, data);
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
        return this.visit(ctx.constructorParameters());
    }

    @Override
    public ParserData visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {

        for(int i = 0; i < ctx.variableType().size(); i++) {
            int varType = ctx.variableType(i).start.getType();
            int varIndex = JasminHelper.getVariableIndex(ctx);
            String identifier = ctx.IDENTIFIER(i).getText();

            JasminHelper.setVariable(ctx, identifier, new VariableData(ctx, varType, varIndex));
            FunctionContainer container = JasminHelper.getFunctionContainer(ctx);
            container.appendConstructorParam(varType);
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
        else if (var instanceof FieldData)
            return new FieldData((FieldData) var);
        else
            return new VariableData((VariableData) var);
    }
}
