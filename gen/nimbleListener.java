// Generated from /home/norlock/Projects/nimble/nimble.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link nimbleParser}.
 */
public interface nimbleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link nimbleParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(nimbleParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link nimbleParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(nimbleParser.ClassModifierContext ctx);
}