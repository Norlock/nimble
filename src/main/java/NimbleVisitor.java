import generated.NimbleParser;
import generated.NimbleParserVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NimbleVisitor implements NimbleParserVisitor {
    /**
     * Visit a parse tree produced by {@link NimbleParser#main}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitMain(NimbleParser.MainContext ctx) {

        System.out.println(parseTree.getText());

        if(parseTree.getChild(0).getText().equals("main")) {
            System.out.println("Starting nimble application");
            visitMain((parseTree);
        };
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitBlock(NimbleParser.BlockContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitStatement(NimbleParser.StatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#variableDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitIfStatement(NimbleParser.IfStatementContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFunctionCall(NimbleParser.FunctionCallContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFunctionDeclaration(NimbleParser.FunctionDeclarationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#functionType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitFunctionType(NimbleParser.FunctionTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitWhileLoop(NimbleParser.WhileLoopContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitConditionBlock(NimbleParser.ConditionBlockContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#modifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitModifier(NimbleParser.ModifierContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#variableType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitVariableType(NimbleParser.VariableTypeContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Object visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx) {
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
    public Object visitOrExpression(NimbleParser.OrExpressionContext ctx) {
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
    public Object visitAndExpression(NimbleParser.AndExpressionContext ctx) {
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
    public Object visitAtomExpression(NimbleParser.AtomExpressionContext ctx) {
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
    public Object visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx) {
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
    public Object visitRelationalExpression(NimbleParser.RelationalExpressionContext ctx) {
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
    public Object visitEqualityExpression(NimbleParser.EqualityExpressionContext ctx) {
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
    public Object visitNotExpression(NimbleParser.NotExpressionContext ctx) {
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
    public Object visitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx) {
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
    public Object visitParantheseExpression(NimbleParser.ParantheseExpressionContext ctx) {
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
    public Object visitNumberAtom(NimbleParser.NumberAtomContext ctx) {
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
    public Object visitBooleanAtom(NimbleParser.BooleanAtomContext ctx) {
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
    public Object visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx) {
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
    public Object visitStringAtom(NimbleParser.StringAtomContext ctx) {
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
    public Object visitNullAtom(NimbleParser.NullAtomContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {

        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
