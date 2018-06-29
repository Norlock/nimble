// Generated from NimbleParser.g4 by ANTLR 4.5.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NimbleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NimbleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NimbleParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(NimbleParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(NimbleParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(NimbleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(NimbleParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(NimbleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(NimbleParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(NimbleParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(NimbleParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(NimbleParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#returnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(NimbleParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(NimbleParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#conditionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBlock(NimbleParser.ConditionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(NimbleParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(NimbleParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableType(NimbleParser.VariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NimbleParser#constructorParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorParameters(NimbleParser.ConstructorParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(NimbleParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(NimbleParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(NimbleParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(NimbleParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(NimbleParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(NimbleParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheseExpression}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheseExpression(NimbleParser.ParentheseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerAtom(NimbleParser.IntegerAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(NimbleParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(NimbleParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullAtom(NimbleParser.NullAtomContext ctx);
}