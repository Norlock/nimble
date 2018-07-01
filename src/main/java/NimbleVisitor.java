import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import model.Data;
import model.NimbleVariable;
import model.TokenData;
import model.ValueData;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<Data> {

    // store variables
    private Map<String, NimbleVariable> variables = new HashMap<>();

    /**
     * Visit a parse tree produced by {@link NimbleParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitMain(NimbleParser.MainContext ctx) {
        String a = NimbleParser.VOCABULARY.getLiteralName(NimbleParser.ADD);
        return super.visitMain(ctx);
    }

    private NimbleVariable getVariable(String identifier) {
        NimbleVariable nimbleVariable = variables.get(identifier);

        if(nimbleVariable == null) {
            throw new RuntimeException("NimbleVariable: " + identifier + " has been assigned before being declared");
        }

        return nimbleVariable;
    }

    @Override
    public Data visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();

        if (variables.get(id) != null)
            throw new RuntimeException("Identifier " + id + " has already been declared");

        int tokenType = ctx.variableType().start.getType();
        TokenData tokenData = new TokenData(tokenType);

        if (ctx.expression() == null) {
            variables.put(id, new NimbleVariable(tokenData, id));
        } else {
            ValueData value = (ValueData) this.visit(ctx.expression());
            variables.put(id, new NimbleVariable(tokenData, id));
        }

        return super.visitVariableDeclaration(ctx);
    }

    /**
     * Visit variable assignment
     * @param ctx
     * @return
     */
    @Override
    public Data visitVariableAssignment(NimbleParser.VariableAssignmentContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        NimbleVariable variable = getVariable(id);

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

    /**
     * Visit a parse tree produced by the {@code additiveExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Data visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {
        return super.visitAdditiveExpression(ctx);
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
            return  new ValueData(Integer.parseInt(ctx.getText()));
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
        boolean result;
        if(boolStr.equals("true") || boolStr.equals("false")) {
           return new ValueData(Boolean.parseBoolean(boolStr));
        } else {
            throw new RuntimeException("Value: " + boolStr + " is not a string.");
        }
    }

    @Override
    public Data visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
        NimbleVariable nimbleVariable = getVariable(ctx.getText());
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
