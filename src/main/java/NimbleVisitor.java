import generated.NimbleParser;
import generated.NimbleParserBaseVisitor;
import generated.NimbleParserVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class NimbleVisitor extends NimbleParserBaseVisitor<Value> {

    // store variables
    private Map<String, Value> variables = new HashMap<String, Value>();

    /**
     * Visit a parse tree produced by {@link NimbleParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitMain(NimbleParser.MainContext ctx) {

        if(ctx.getChild(0).getText().equals("main")) {
            System.out.println("Starting nimble application");
            return super.visitMain(ctx);
        }
        else {
            System.out.println("Can't detect main closing app");
            return null;
        }

    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitBlock(NimbleParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitStatement(NimbleParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#variableDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        variables.put(ctx.IDENTIFIER().getText(), new Value(0));

        return super.visitVariableDeclaration(ctx);
    }

    /**
     * Visit variable assignment
     * @param ctx
     * @return
     */
    @Override
    public Value visitVariableAssignment(NimbleParser.VariableAssignmentContext ctx) {
        String varIdentifier = ctx.IDENTIFIER().getText();
        Value var = variables.get(varIdentifier);

        if(var == null) {
            throw new RuntimeException("Variable: " + varIdentifier + " has been assigned before being declared");
        }

        return super.visitVariableAssignment(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitIfStatement(NimbleParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }


    @Override
    public Value visitFunction(NimbleParser.FunctionContext ctx) {
        return super.visitFunction(ctx);
    }

    @Override
    public Value visitReturnValue(NimbleParser.ReturnValueContext ctx) {
        return super.visitReturnValue(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        return super.visitWhileLoop(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        return super.visitConditionBlock(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#modifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitModifier(NimbleParser.ModifierContext ctx) {
        return super.visitModifier(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#variableType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitVariableType(NimbleParser.VariableTypeContext ctx) {
        return super.visitVariableType(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return super.visitConstructorDeclaration(ctx);
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {
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
    public Value visitOrExpression(NimbleParser.OrExpressionContext ctx) {
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
    public Value visitAndExpression(NimbleParser.AndExpressionContext ctx) {
        return super.visitAndExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code atomExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitAtomExpression(NimbleParser.AtomExpressionContext ctx) {
        return super.visitAtomExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code additiveExpression}
     * labeled alternative in {@link NimbleParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {
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
    public Value visitRelationalExpression(NimbleParser.RelationalExpressionContext ctx) {
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
    public Value visitEqualityExpression(NimbleParser.EqualityExpressionContext ctx) {
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
    public Value visitNotExpression(NimbleParser.NotExpressionContext ctx) {
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
    public Value visitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx) {
        return super.visitMultiplicationExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code parantheseExpression}
     * labeled alternative in {@link NimbleParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitParantheseExpression(NimbleParser.ParantheseExpressionContext ctx) {
        return super.visitParantheseExpression(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code numberAtom}
     * labeled alternative in {@link NimbleParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitNumberAtom(NimbleParser.NumberAtomContext ctx) {
        return super.visitNumberAtom(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code booleanAtom}
     * labeled alternative in {@link NimbleParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitBooleanAtom(NimbleParser.BooleanAtomContext ctx) {
        return super.visitBooleanAtom(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code identifierAtom}
     * labeled alternative in {@link NimbleParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
        return super.visitIdentifierAtom(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code stringAtom}
     * labeled alternative in {@link NimbleParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitStringAtom(NimbleParser.StringAtomContext ctx) {
        return super.visitStringAtom(ctx);
    }

    /**
     * Visit a parse tree produced by the {@code nullAtom}
     * labeled alternative in {@link NimbleParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitNullAtom(NimbleParser.NullAtomContext ctx) {
        return super.visitNullAtom(ctx);
    }

    @Override
    public Value visitChildren(RuleNode node) {
        return super.visitChildren(node);
    }

    @Override
    public Value visitTerminal(TerminalNode terminalNode) {
        return super.visitTerminal(terminalNode);
    }

    @Override
    public Value visitErrorNode(ErrorNode errorNode) {
        return super.visitErrorNode(errorNode);
    }
}
