import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<ValueInfo> {

    // store variables
    private Map<String, ValueInfo> variables = new HashMap<>();

    /**
     * Visit a parse tree produced by {@link NimbleParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitMain(NimbleParser.MainContext ctx) {
        return super.visitMain(ctx);
    }

    @Override
    public ValueInfo visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {

        String id = ctx.IDENTIFIER().getText();
        String type = ctx.variableType().getText();

        if (ctx.expression() == null) {
            variables.put(id, null);

        } else {
//            assignVariable(id, type, this.visit(ctx.expression()));
            ValueInfo value = this.visit(ctx.expression());
            variables.put(id, value);

            switch (type) {
                case "string":
                    String str = value.toString();
                    System.out.println("String: " + str);
                    break;
                case "bool":
                    boolean bool = value.asBoolean();
                    System.out.println("Bool: " + bool);
                    break;
                case "int":
                    Integer integer = value.asInteger();
                    System.out.println("Int: " + integer);
                    break;
            }
        }


        return super.visitVariableDeclaration(ctx);
    }

    private ValueInfo getVariable(String identifier) {
        ValueInfo valueInfo = variables.get(identifier);

        if(valueInfo == null) {
            throw new RuntimeException("Variable: " + identifier + " has been assigned before being declared");
        }

        return valueInfo;
    }

    /**
     *
     * @param id
     * @param type
     * @param expressionValue value from expression.
     * @return
     */
    private ValueInfo assignVariable(String id, String type, ValueInfo expressionValue) {
        variables.put(id, expressionValue);

        switch (type) {
            case "string":
                String str = expressionValue.toString();
                System.out.println("String: " + str);
                break;
            case "bool":
                boolean bool = expressionValue.asBoolean();
                System.out.println("Bool: " + bool);
                break;
            case "int":
                Integer integer = expressionValue.asInteger();
                System.out.println("Int: " + integer);
                break;
            default:
                System.err.println("Unknown type: " + type);
        }
    }

    /**
     * Visit variable assignment
     * @param ctx
     * @return
     */
    @Override
    public ValueInfo visitVariableAssignment(NimbleParser.VariableAssignmentContext ctx) {
        ValueInfo valueInfo = getVariable(ctx.IDENTIFIER().getText());

    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitIfStatement(NimbleParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public ValueInfo visitFunction(NimbleParser.FunctionContext ctx) {
        return super.visitFunction(ctx);
    }

    @Override
    public ValueInfo visitReturnValue(NimbleParser.ReturnValueContext ctx) {
        return super.visitReturnValue(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        return super.visitWhileLoop(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        return super.visitConditionBlock(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#modifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitModifier(NimbleParser.ModifierContext ctx) {
        return super.visitModifier(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return super.visitConstructorDeclaration(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ValueInfo visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {
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
    public ValueInfo visitOrExpression(NimbleParser.OrExpressionContext ctx) {
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
    public ValueInfo visitAndExpression(NimbleParser.AndExpressionContext ctx) {
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
    public ValueInfo visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {
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
    public ValueInfo visitRelationalExpression(NimbleParser.RelationalExpressionContext ctx) {
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
    public ValueInfo visitEqualityExpression(NimbleParser.EqualityExpressionContext ctx) {
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
    public ValueInfo visitNotExpression(NimbleParser.NotExpressionContext ctx) {
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
    public ValueInfo visitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx) {
        return super.visitMultiplicationExpression(ctx);
    }

    @Override
    public ValueInfo visitIntegerAtom(NimbleParser.IntegerAtomContext ctx) {
        return new ValueInfo(ctx.getText());
    }

    @Override
    public ValueInfo visitStringAtom(NimbleParser.StringAtomContext ctx) {
        return new ValueInfo(ctx.getText());
    }

    @Override
    public ValueInfo visitBooleanAtom(NimbleParser.BooleanAtomContext ctx) {
        return new ValueInfo(ctx.getText());
    }

    @Override
    public ValueInfo visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
        return getVariable(ctx.getText());
    }

    @Override
    public ValueInfo visitNullAtom(NimbleParser.NullAtomContext ctx) {
        return super.visitNullAtom(ctx);
    }

    @Override
    public ValueInfo visitTerminal(TerminalNode terminalNode) {
        return super.visitTerminal(terminalNode);
    }

    @Override
    public ValueInfo visitErrorNode(ErrorNode errorNode) {
        return super.visitErrorNode(errorNode);
    }
}
