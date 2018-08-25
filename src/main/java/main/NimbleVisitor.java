package main;

import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import utils.JasminConstants;
import utils.JasminHelper;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<ParserData> {

    // store variables
    private Map<Integer, Map<String, VariableData>> variables = new HashMap<>();
    public static Map<String, FieldData> fields = new HashMap<>();

    private VariableData getVariable(String identifier, ParserRuleContext ctx) {
        HashSet<Integer> hashCodes = getBlockHashCodes(ctx);

        for(int hashCode : hashCodes) {
            Map<String, VariableData> blockVariables = variables.get(hashCode);
            if (blockVariables.containsKey(identifier)) {
                return blockVariables.get(identifier);
            }
        }

        return null;
    }

    private BaseValue getFieldOrVariable(String identifier, ParserRuleContext ctx) {
        if(fields.containsKey(identifier))
            return fields.get(identifier);
        else
            return getVariable(identifier, ctx);

    }

    private void setVariable(ParserRuleContext ctx, String id, VariableData variable) {
        int hashCode = getBlockHashCode(ctx);
        Map<String, VariableData> block = variables.get(hashCode);
        block.put(id, variable);
        variables.put(hashCode, block);
    }

    /**
     * Returns the hash codes for each block in the tree of this context.
     * @param ctx context of caller.
     * @return hash codes of the blocks.
     */
    private HashSet<Integer> getBlockHashCodes(ParserRuleContext ctx) {
        HashSet<Integer> hashCodes = new HashSet<>();
        while(ctx.invokingState != -1) {
            if(ctx instanceof NimbleParser.BlockContext)
                hashCodes.add(ctx.hashCode());
            ctx = ctx.getParent();
        }
        return hashCodes;
    }

    /**
     * Returns the hashcode of the block.
     * @param ctx context of caller.
     * @return
     */
    private int getBlockHashCode(ParserRuleContext ctx) {
        while(!(ctx instanceof NimbleParser.BlockContext) && ctx.invokingState != -1) {
            ctx = ctx.getParent();
        }
        return ctx.hashCode();
    }

    private ParserData getFieldAssignment(ParserRuleContext ctx, int varType, String id, BaseValue value) {
        ParserData field = getDataAssignment(ctx, varType, value);
        String staticField = Paths.get(JasminHelper.className, id).toString();
        field.addCommand(JasminConstants.PUT_STATIC + staticField + " " + JasminConstants.DataType.getDataTypeStr(varType));
        return field;
    }

    private ParserData getDataAssignment(ParserRuleContext ctx, int varType, BaseValue value) {
        ParserData data = new ParserData(ctx);
        boolean castable = value.isAutoCastable(varType);
        int valueType = value.getDataType();

        if(varType != valueType && !castable) {
            data.throwError("Cannot assign this type of value to the variable.");
        }

        if(value instanceof BaseExpression && value.isBoolean()) {
            BaseExpression baseExpression = (BaseExpression) value;
            baseExpression.setBooleanReturnValue();
        }

        data.appendCode(value);
        if(castable)
            data.addCommand(value.getCastCommand(varType));

        return data;
    }

    private ParserData getVariableAssignment(ParserRuleContext ctx, int varType, int varIndex, BaseValue value) {
        ParserData variable = getDataAssignment(ctx, varType, value);

        String prefix = JasminConstants.Prefix.getPrefix(varType).toString();
        if (0 <= varIndex && varIndex <= 3) {
            variable.addCommand(prefix + JasminConstants.STORE_VAl_SMALL + varIndex);
        } else {
            variable.addCommand(prefix + JasminConstants.STORE_VAL + varIndex);
        }

        return variable;
    }

    // TODO
    @Override
    public ParserData visitParse(NimbleParser.ParseContext ctx) {
        ParserData parserData = new ParserData(ctx);

        visit(ctx.classDeclaration());
        for (int i = 0; i < ctx.component().size(); i++) {
            parserData.appendCode(visit(ctx.component(i)));
        }
        parserData.appendCode(visit(ctx.main()));
        return parserData;
    }

    @Override
    public ParserData visitClassDeclaration(NimbleParser.ClassDeclarationContext ctx) {
        JasminHelper.className = ctx.IDENTIFIER().getText();
        return super.visitClassDeclaration(ctx);
    }

    @Override
    public ParserData visitComponent(NimbleParser.ComponentContext ctx) {
        return visit(ctx.field());
    }

    @Override
    public ParserData visitField(NimbleParser.FieldContext ctx) {
        return visit(ctx.variableDeclaration());
    }

    @Override
    public ParserData visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();

        if(ctx.getStop().getType() != NimbleParser.SEMICOLON) {
            throw new ParseException(ctx, "Missing semicolon");
        }
        else if (getFieldOrVariable(id, ctx) != null) {
            throw new ParseException(ctx, "Identifier " + id + " has already been declared");
        }

        BaseValue value = (BaseValue) this.visit(ctx.expression());
        int varType = ctx.variableType().start.getType();
        int varIndex = JasminHelper.getVariableIndex();

        if (value == null)  // Create default value
            value = new ValueData(varType, ctx);

        ParserData parserData;
        if(ctx.getParent() instanceof NimbleParser.FieldContext) {
            parserData = getFieldAssignment(ctx, varType, id, value);
            fields.put(id, new FieldData(ctx, id, varType));
        } else {
            parserData = getVariableAssignment(ctx, varType, varIndex, value);
            setVariable(ctx, id, new VariableData(ctx, varType, varIndex));
        }
        JasminHelper.updateVariableIndex(varType);

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
        if(ctx.SEMICOLON() == null) {
            throw new ParseException(ctx, "Missing semicolon.");
        }

        BaseValue variable = getFieldOrVariable(id, ctx);
        if(variable == null)
            throw new ParseException(ctx, "Identifier has not been declared yet.");

        BaseValue baseValue = (BaseValue) this.visit(ctx.expression());
        if(fields.containsKey(id))
            return getFieldAssignment(ctx, variable.getDataType(), id, baseValue);
        else
            return getVariableAssignment(ctx, variable.getDataType(),
                    ((VariableData)variable).getVarIndex(), baseValue);
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

        // if contains else
        if(ctx.block() != null)
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

        if(data instanceof BaseExpression && data.isBoolean()) {
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
            expressionData.throwError("Conditions can only contain boolean expressions");

        expressionData.appendCode(this.visit(ctx.block()));
        return expressionData;
    }

    @Override
    public ParserData visitBlock(NimbleParser.BlockContext ctx) {
        variables.put(ctx.hashCode(), new HashMap<>());
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

        return expressionData;
    }

    @Override
    public ParserData visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {
        BaseValue left = (BaseValue) this.visit(ctx.expression(0));
        BaseValue right = (BaseValue) this.visit(ctx.expression(1));

        ExpressionData expressionData = new ExpressionData(ctx, left, right);

        if(ctx.op.getType() == NimbleParser.ADD)
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
        BaseValue var = getFieldOrVariable(ctx.getText(), ctx);
        if(var == null)
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
