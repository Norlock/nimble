import generated.NimbleParser;
import generated.NimbleParserVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NimbleVisitor implements NimbleParserVisitor<Value> {
    /**
     * Visit a parse tree produced by {@link NimbleParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitMain(NimbleParser.MainContext ctx) {

        System.out.println(ctx.getText());

        if(ctx.getChild(0).getText().equals("main")) {
            System.out.println("Starting nimble application");
            // TODO
        }
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitBlock(NimbleParser.BlockContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitStatement(NimbleParser.StatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#variableDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitIfStatement(NimbleParser.IfStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitFunctionDeclaration(NimbleParser.FunctionDeclarationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitFunctionType(NimbleParser.FunctionTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#modifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitModifier(NimbleParser.ModifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#variableType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitVariableType(NimbleParser.VariableTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Value visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public Value visit(ParseTree parseTree) {

        System.out.println(parseTree.getText());
        return null;
    }

    @Override
    public Value visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Value visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Value visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
