// Generated from NimbleParser.g4 by ANTLR 4.5.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NimbleParser}.
 */
public interface NimbleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NimbleParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(NimbleParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(NimbleParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(NimbleParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(NimbleParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(NimbleParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(NimbleParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(NimbleParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(NimbleParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(NimbleParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(NimbleParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(NimbleParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(NimbleParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(NimbleParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(NimbleParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(NimbleParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#constructorParameters}.
	 * @param ctx the parse tree
	 */
	void enterConstructorParameters(NimbleParser.ConstructorParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#constructorParameters}.
	 * @param ctx the parse tree
	 */
	void exitConstructorParameters(NimbleParser.ConstructorParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(NimbleParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(NimbleParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#functionAssignments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionAssignments(NimbleParser.FunctionAssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#functionAssignments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionAssignments(NimbleParser.FunctionAssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(NimbleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(NimbleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(NimbleParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(NimbleParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(NimbleParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(NimbleParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(NimbleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(NimbleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(NimbleParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(NimbleParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(NimbleParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(NimbleParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(NimbleParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(NimbleParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(NimbleParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(NimbleParser.ReturnValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(NimbleParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(NimbleParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#conditionBlock}.
	 * @param ctx the parse tree
	 */
	void enterConditionBlock(NimbleParser.ConditionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#conditionBlock}.
	 * @param ctx the parse tree
	 */
	void exitConditionBlock(NimbleParser.ConditionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(NimbleParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(NimbleParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(NimbleParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(NimbleParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NimbleParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterVariableType(NimbleParser.VariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NimbleParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitVariableType(NimbleParser.VariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(NimbleParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(NimbleParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(NimbleParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(NimbleParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(NimbleParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(NimbleParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(NimbleParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(NimbleParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(NimbleParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(NimbleParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitwiseExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseExpression(NimbleParser.BitwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitwiseExpression}
	 * labeled alternative in {@link NimbleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseExpression(NimbleParser.BitwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheseExpression}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParentheseExpression(NimbleParser.ParentheseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheseExpression}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParentheseExpression(NimbleParser.ParentheseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntegerAtom(NimbleParser.IntegerAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntegerAtom(NimbleParser.IntegerAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(NimbleParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(NimbleParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierAtom(NimbleParser.IdentifierAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierAtom(NimbleParser.IdentifierAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(NimbleParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(NimbleParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDoubleAtom(NimbleParser.DoubleAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDoubleAtom(NimbleParser.DoubleAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallAtom(NimbleParser.FunctionCallAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallAtom(NimbleParser.FunctionCallAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNullAtom(NimbleParser.NullAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link NimbleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNullAtom(NimbleParser.NullAtomContext ctx);
}