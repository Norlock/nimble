// Generated from NimbleParser.g4 by ANTLR 4.5.1
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NimbleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING_TYPE=1, INTEGER_TYPE=2, DOUBLE_TYPE=3, BOOLEAN_TYPE=4, VOID=5, 
		NULL=6, GLOBAL=7, PACKAGE=8, INTERNAL=9, MAIN=10, SEMICOLON=11, COMMA=12, 
		DOT=13, LEFT_PARENTHESE=14, RIGHT_PARENTHESE=15, LEFT_BRACE=16, RIGHT_BRACE=17, 
		LEFT_SQUARE_BRACKET=18, RIGHT_SQUARE_BRACKET=19, ASSIGN=20, LEFT_LESSER=21, 
		LEFT_GREATER=22, EQUAL=23, NOT_EQUAL=24, LEFT_LESSER_OR_EQUAL=25, LEFT_GREATER_OR_EQUAL=26, 
		AND=27, OR=28, INCREMENT=29, DECREMENT=30, ADD=31, SUBSTRACT=32, MULTIPLY=33, 
		DIVIDE=34, MODULO=35, NOT=36, IF=37, ELSE=38, GOTO=39, RETURN=40, FOR=41, 
		WHILE=42, CLASS=43, PRINT=44, TRUE=45, FALSE=46, INTEGER=47, DOUBLE=48, 
		STRING=49, IDENTIFIER=50, WS=51, COMMENT=52, LINE_COMMENT=53;
	public static final int
		RULE_parse = 0, RULE_component = 1, RULE_classDeclaration = 2, RULE_comment = 3, 
		RULE_main = 4, RULE_function = 5, RULE_field = 6, RULE_constructorDeclaration = 7, 
		RULE_block = 8, RULE_variableDeclaration = 9, RULE_variableAssignment = 10, 
		RULE_statement = 11, RULE_ifStatement = 12, RULE_functionCall = 13, RULE_printStatement = 14, 
		RULE_returnStatement = 15, RULE_returnValue = 16, RULE_whileLoop = 17, 
		RULE_conditionBlock = 18, RULE_condition = 19, RULE_modifier = 20, RULE_variableType = 21, 
		RULE_constructorParameters = 22, RULE_expression = 23, RULE_atom = 24;
	public static final String[] ruleNames = {
		"parse", "component", "classDeclaration", "comment", "main", "function", 
		"field", "constructorDeclaration", "block", "variableDeclaration", "variableAssignment", 
		"statement", "ifStatement", "functionCall", "printStatement", "returnStatement", 
		"returnValue", "whileLoop", "conditionBlock", "condition", "modifier", 
		"variableType", "constructorParameters", "expression", "atom"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'string'", "'int'", "'double'", "'bool'", "'void'", "'null'", "'global'", 
		"'package'", "'internal'", "'main'", "';'", "','", "'.'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "'='", "'<'", "'>'", "'=='", "'!='", "'<='", 
		"'>='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'!'", "'if'", "'else'", "'goto'", "'return'", "'for'", "'while'", "'class'", 
		"'print'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STRING_TYPE", "INTEGER_TYPE", "DOUBLE_TYPE", "BOOLEAN_TYPE", "VOID", 
		"NULL", "GLOBAL", "PACKAGE", "INTERNAL", "MAIN", "SEMICOLON", "COMMA", 
		"DOT", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", "LEFT_BRACE", "RIGHT_BRACE", 
		"LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", "ASSIGN", "LEFT_LESSER", 
		"LEFT_GREATER", "EQUAL", "NOT_EQUAL", "LEFT_LESSER_OR_EQUAL", "LEFT_GREATER_OR_EQUAL", 
		"AND", "OR", "INCREMENT", "DECREMENT", "ADD", "SUBSTRACT", "MULTIPLY", 
		"DIVIDE", "MODULO", "NOT", "IF", "ELSE", "GOTO", "RETURN", "FOR", "WHILE", 
		"CLASS", "PRINT", "TRUE", "FALSE", "INTEGER", "DOUBLE", "STRING", "IDENTIFIER", 
		"WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NimbleParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NimbleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(NimbleParser.EOF, 0); }
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			classDeclaration();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GLOBAL) | (1L << PACKAGE) | (1L << INTERNAL) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0)) {
				{
				{
				setState(51);
				component();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			main();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GLOBAL) | (1L << PACKAGE) | (1L << INTERNAL) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0)) {
				{
				{
				setState(58);
				component();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitComponent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_component);
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				field();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				comment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(NimbleParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NimbleParser.IDENTIFIER, 0); }
		public TerminalNode SEMICOLON() { return getToken(NimbleParser.SEMICOLON, 0); }
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(CLASS);
			setState(72);
			match(IDENTIFIER);
			setState(73);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(NimbleParser.COMMENT, 0); }
		public TerminalNode LINE_COMMENT() { return getToken(NimbleParser.LINE_COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==COMMENT || _la==LINE_COMMENT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(NimbleParser.MAIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(MAIN);
			setState(78);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(NimbleParser.IDENTIFIER, 0); }
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			modifier();
			setState(81);
			returnValue();
			setState(82);
			match(IDENTIFIER);
			setState(83);
			constructorDeclaration();
			setState(84);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			modifier();
			setState(87);
			variableDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESE() { return getToken(NimbleParser.LEFT_PARENTHESE, 0); }
		public TerminalNode RIGHT_PARENTHESE() { return getToken(NimbleParser.RIGHT_PARENTHESE, 0); }
		public ConstructorParametersContext constructorParameters() {
			return getRuleContext(ConstructorParametersContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(LEFT_PARENTHESE);
			setState(91);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_TYPE) | (1L << INTEGER_TYPE) | (1L << DOUBLE_TYPE) | (1L << BOOLEAN_TYPE))) != 0)) {
				{
				setState(90);
				constructorParameters();
				}
			}

			setState(93);
			match(RIGHT_PARENTHESE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(NimbleParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(NimbleParser.RIGHT_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(LEFT_BRACE);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_TYPE) | (1L << INTEGER_TYPE) | (1L << DOUBLE_TYPE) | (1L << BOOLEAN_TYPE) | (1L << IF) | (1L << RETURN) | (1L << WHILE) | (1L << PRINT) | (1L << IDENTIFIER) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0)) {
				{
				{
				setState(96);
				statement();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(NimbleParser.IDENTIFIER, 0); }
		public TerminalNode SEMICOLON() { return getToken(NimbleParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(NimbleParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			variableType();
			setState(105);
			match(IDENTIFIER);
			setState(108);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(106);
				match(ASSIGN);
				setState(107);
				expression(0);
				}
			}

			setState(110);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NimbleParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(NimbleParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NimbleParser.SEMICOLON, 0); }
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(IDENTIFIER);
			setState(113);
			match(ASSIGN);
			setState(114);
			expression(0);
			setState(115);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				variableAssignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				functionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				whileLoop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				printStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(123);
				comment();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(124);
				returnStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(NimbleParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(NimbleParser.IF, i);
		}
		public List<ConditionBlockContext> conditionBlock() {
			return getRuleContexts(ConditionBlockContext.class);
		}
		public ConditionBlockContext conditionBlock(int i) {
			return getRuleContext(ConditionBlockContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(NimbleParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(NimbleParser.ELSE, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(IF);
			setState(128);
			conditionBlock();
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					match(ELSE);
					setState(130);
					match(IF);
					setState(131);
					conditionBlock();
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(139);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(137);
				match(ELSE);
				setState(138);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NimbleParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PARENTHESE() { return getToken(NimbleParser.LEFT_PARENTHESE, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESE() { return getToken(NimbleParser.RIGHT_PARENTHESE, 0); }
		public TerminalNode SEMICOLON() { return getToken(NimbleParser.SEMICOLON, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IDENTIFIER);
			setState(142);
			match(LEFT_PARENTHESE);
			setState(143);
			atom();
			setState(144);
			match(RIGHT_PARENTHESE);
			setState(145);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(NimbleParser.PRINT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NimbleParser.SEMICOLON, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(PRINT);
			setState(148);
			condition();
			setState(149);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(NimbleParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(NimbleParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(RETURN);
			setState(153);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << LEFT_PARENTHESE) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << DOUBLE) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(152);
				expression(0);
				}
			}

			setState(155);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnValueContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(NimbleParser.VOID, 0); }
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitReturnValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnValue);
		try {
			setState(159);
			switch (_input.LA(1)) {
			case STRING_TYPE:
			case INTEGER_TYPE:
			case DOUBLE_TYPE:
			case BOOLEAN_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				variableType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(NimbleParser.WHILE, 0); }
		public ConditionBlockContext conditionBlock() {
			return getRuleContext(ConditionBlockContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(WHILE);
			setState(162);
			conditionBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionBlockContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConditionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterConditionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitConditionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitConditionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionBlockContext conditionBlock() throws RecognitionException {
		ConditionBlockContext _localctx = new ConditionBlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			condition();
			setState(165);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESE() { return getToken(NimbleParser.LEFT_PARENTHESE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESE() { return getToken(NimbleParser.RIGHT_PARENTHESE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(LEFT_PARENTHESE);
			setState(168);
			expression(0);
			setState(169);
			match(RIGHT_PARENTHESE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(NimbleParser.GLOBAL, 0); }
		public TerminalNode PACKAGE() { return getToken(NimbleParser.PACKAGE, 0); }
		public TerminalNode INTERNAL() { return getToken(NimbleParser.INTERNAL, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GLOBAL) | (1L << PACKAGE) | (1L << INTERNAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableTypeContext extends ParserRuleContext {
		public TerminalNode INTEGER_TYPE() { return getToken(NimbleParser.INTEGER_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(NimbleParser.STRING_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(NimbleParser.BOOLEAN_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(NimbleParser.DOUBLE_TYPE, 0); }
		public VariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterVariableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitVariableType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitVariableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableTypeContext variableType() throws RecognitionException {
		VariableTypeContext _localctx = new VariableTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_TYPE) | (1L << INTEGER_TYPE) | (1L << DOUBLE_TYPE) | (1L << BOOLEAN_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorParametersContext extends ParserRuleContext {
		public List<VariableTypeContext> variableType() {
			return getRuleContexts(VariableTypeContext.class);
		}
		public VariableTypeContext variableType(int i) {
			return getRuleContext(VariableTypeContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(NimbleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(NimbleParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(NimbleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NimbleParser.COMMA, i);
		}
		public ConstructorParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterConstructorParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitConstructorParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitConstructorParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorParametersContext constructorParameters() throws RecognitionException {
		ConstructorParametersContext _localctx = new ConstructorParametersContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constructorParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			variableType();
			setState(176);
			match(IDENTIFIER);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(177);
				match(COMMA);
				setState(178);
				variableType();
				setState(179);
				match(IDENTIFIER);
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomExpressionContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterAtomExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitAtomExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitAtomExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(NimbleParser.ADD, 0); }
		public TerminalNode SUBSTRACT() { return getToken(NimbleParser.SUBSTRACT, 0); }
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_LESSER_OR_EQUAL() { return getToken(NimbleParser.LEFT_LESSER_OR_EQUAL, 0); }
		public TerminalNode LEFT_GREATER_OR_EQUAL() { return getToken(NimbleParser.LEFT_GREATER_OR_EQUAL, 0); }
		public TerminalNode LEFT_LESSER() { return getToken(NimbleParser.LEFT_LESSER, 0); }
		public TerminalNode LEFT_GREATER() { return getToken(NimbleParser.LEFT_GREATER, 0); }
		public RelationalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(NimbleParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(NimbleParser.NOT_EQUAL, 0); }
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(NimbleParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(NimbleParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(NimbleParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(NimbleParser.MODULO, 0); }
		public MultiplicationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitMultiplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitMultiplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(NimbleParser.AND, 0); }
		public TerminalNode OR() { return getToken(NimbleParser.OR, 0); }
		public BitwiseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterBitwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitBitwiseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitBitwiseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(187);
				match(NOT);
				setState(188);
				expression(7);
				}
				break;
			case NULL:
			case LEFT_PARENTHESE:
			case TRUE:
			case FALSE:
			case INTEGER:
			case DOUBLE:
			case STRING:
			case IDENTIFIER:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(193);
						((AdditiveExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBSTRACT) ) {
							((AdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(194);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(196);
						((MultiplicationExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MODULO))) != 0)) ) {
							((MultiplicationExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(197);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(199);
						((RelationalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_LESSER) | (1L << LEFT_GREATER) | (1L << LEFT_LESSER_OR_EQUAL) | (1L << LEFT_GREATER_OR_EQUAL))) != 0)) ) {
							((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(200);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(202);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(203);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(205);
						((BitwiseExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BitwiseExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(206);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoubleAtomContext extends AtomContext {
		public TerminalNode DOUBLE() { return getToken(NimbleParser.DOUBLE, 0); }
		public DoubleAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterDoubleAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitDoubleAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitDoubleAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(NimbleParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NimbleParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterBooleanAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitBooleanAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentheseExpressionContext extends AtomContext {
		public TerminalNode LEFT_PARENTHESE() { return getToken(NimbleParser.LEFT_PARENTHESE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESE() { return getToken(NimbleParser.RIGHT_PARENTHESE, 0); }
		public ParentheseExpressionContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterParentheseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitParentheseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitParentheseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierAtomContext extends AtomContext {
		public TerminalNode IDENTIFIER() { return getToken(NimbleParser.IDENTIFIER, 0); }
		public IdentifierAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterIdentifierAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitIdentifierAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitIdentifierAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(NimbleParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerAtomContext extends AtomContext {
		public TerminalNode INTEGER() { return getToken(NimbleParser.INTEGER, 0); }
		public IntegerAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterIntegerAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitIntegerAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitIntegerAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullAtomContext extends AtomContext {
		public TerminalNode NULL() { return getToken(NimbleParser.NULL, 0); }
		public NullAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).enterNullAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NimbleParserListener ) ((NimbleParserListener)listener).exitNullAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NimbleParserVisitor ) return ((NimbleParserVisitor<? extends T>)visitor).visitNullAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_atom);
		int _la;
		try {
			setState(222);
			switch (_input.LA(1)) {
			case LEFT_PARENTHESE:
				_localctx = new ParentheseExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(LEFT_PARENTHESE);
				setState(213);
				expression(0);
				setState(214);
				match(RIGHT_PARENTHESE);
				}
				break;
			case INTEGER:
				_localctx = new IntegerAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(INTEGER);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case IDENTIFIER:
				_localctx = new IdentifierAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(IDENTIFIER);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				match(STRING);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				match(DOUBLE);
				}
				break;
			case NULL:
				_localctx = new NullAtomContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u00e3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\2\3\2\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\5\t^\n\t\3\t\3\t\3\n\3"+
		"\n\7\nd\n\n\f\n\16\ng\13\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13o\n\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0080\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\7\16\u0087\n\16\f\16\16\16\u008a\13\16\3\16"+
		"\3\16\5\16\u008e\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\5\21\u009c\n\21\3\21\3\21\3\22\3\22\5\22\u00a2\n\22\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\7\30\u00b8\n\30\f\30\16\30\u00bb\13\30\3\31\3"+
		"\31\3\31\3\31\5\31\u00c1\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u00d2\n\31\f\31\16\31\u00d5\13"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00e1\n\32"+
		"\3\32\2\3\60\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\2\13\3\2\66\67\3\2\t\13\3\2\3\6\3\2!\"\3\2#%\4\2\27\30\33\34\3\2\31\32"+
		"\3\2\35\36\3\2/\60\u00e8\2\64\3\2\2\2\4G\3\2\2\2\6I\3\2\2\2\bM\3\2\2\2"+
		"\nO\3\2\2\2\fR\3\2\2\2\16X\3\2\2\2\20[\3\2\2\2\22a\3\2\2\2\24j\3\2\2\2"+
		"\26r\3\2\2\2\30\177\3\2\2\2\32\u0081\3\2\2\2\34\u008f\3\2\2\2\36\u0095"+
		"\3\2\2\2 \u0099\3\2\2\2\"\u00a1\3\2\2\2$\u00a3\3\2\2\2&\u00a6\3\2\2\2"+
		"(\u00a9\3\2\2\2*\u00ad\3\2\2\2,\u00af\3\2\2\2.\u00b1\3\2\2\2\60\u00c0"+
		"\3\2\2\2\62\u00e0\3\2\2\2\648\5\6\4\2\65\67\5\4\3\2\66\65\3\2\2\2\67:"+
		"\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;?\5\n\6\2<>\5\4\3\2"+
		"=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\2\2\3"+
		"C\3\3\2\2\2DH\5\16\b\2EH\5\f\7\2FH\5\b\5\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2"+
		"\2H\5\3\2\2\2IJ\7-\2\2JK\7\64\2\2KL\7\r\2\2L\7\3\2\2\2MN\t\2\2\2N\t\3"+
		"\2\2\2OP\7\f\2\2PQ\5\22\n\2Q\13\3\2\2\2RS\5*\26\2ST\5\"\22\2TU\7\64\2"+
		"\2UV\5\20\t\2VW\5\22\n\2W\r\3\2\2\2XY\5*\26\2YZ\5\24\13\2Z\17\3\2\2\2"+
		"[]\7\20\2\2\\^\5.\30\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\21\2\2`\21\3"+
		"\2\2\2ae\7\22\2\2bd\5\30\r\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f"+
		"h\3\2\2\2ge\3\2\2\2hi\7\23\2\2i\23\3\2\2\2jk\5,\27\2kn\7\64\2\2lm\7\26"+
		"\2\2mo\5\60\31\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\r\2\2q\25\3\2\2\2r"+
		"s\7\64\2\2st\7\26\2\2tu\5\60\31\2uv\7\r\2\2v\27\3\2\2\2w\u0080\5\24\13"+
		"\2x\u0080\5\26\f\2y\u0080\5\32\16\2z\u0080\5\34\17\2{\u0080\5$\23\2|\u0080"+
		"\5\36\20\2}\u0080\5\b\5\2~\u0080\5 \21\2\177w\3\2\2\2\177x\3\2\2\2\177"+
		"y\3\2\2\2\177z\3\2\2\2\177{\3\2\2\2\177|\3\2\2\2\177}\3\2\2\2\177~\3\2"+
		"\2\2\u0080\31\3\2\2\2\u0081\u0082\7\'\2\2\u0082\u0088\5&\24\2\u0083\u0084"+
		"\7(\2\2\u0084\u0085\7\'\2\2\u0085\u0087\5&\24\2\u0086\u0083\3\2\2\2\u0087"+
		"\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008d\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7(\2\2\u008c\u008e\5\22\n\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\33\3\2\2\2\u008f\u0090\7\64\2"+
		"\2\u0090\u0091\7\20\2\2\u0091\u0092\5\62\32\2\u0092\u0093\7\21\2\2\u0093"+
		"\u0094\7\r\2\2\u0094\35\3\2\2\2\u0095\u0096\7.\2\2\u0096\u0097\5(\25\2"+
		"\u0097\u0098\7\r\2\2\u0098\37\3\2\2\2\u0099\u009b\7*\2\2\u009a\u009c\5"+
		"\60\31\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\7\r\2\2\u009e!\3\2\2\2\u009f\u00a2\5,\27\2\u00a0\u00a2\7\7\2\2"+
		"\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2#\3\2\2\2\u00a3\u00a4\7"+
		",\2\2\u00a4\u00a5\5&\24\2\u00a5%\3\2\2\2\u00a6\u00a7\5(\25\2\u00a7\u00a8"+
		"\5\22\n\2\u00a8\'\3\2\2\2\u00a9\u00aa\7\20\2\2\u00aa\u00ab\5\60\31\2\u00ab"+
		"\u00ac\7\21\2\2\u00ac)\3\2\2\2\u00ad\u00ae\t\3\2\2\u00ae+\3\2\2\2\u00af"+
		"\u00b0\t\4\2\2\u00b0-\3\2\2\2\u00b1\u00b2\5,\27\2\u00b2\u00b9\7\64\2\2"+
		"\u00b3\u00b4\7\16\2\2\u00b4\u00b5\5,\27\2\u00b5\u00b6\7\64\2\2\u00b6\u00b8"+
		"\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba/\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\b\31\1\2"+
		"\u00bd\u00be\7&\2\2\u00be\u00c1\5\60\31\t\u00bf\u00c1\5\62\32\2\u00c0"+
		"\u00bc\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00d3\3\2\2\2\u00c2\u00c3\f\b"+
		"\2\2\u00c3\u00c4\t\5\2\2\u00c4\u00d2\5\60\31\t\u00c5\u00c6\f\7\2\2\u00c6"+
		"\u00c7\t\6\2\2\u00c7\u00d2\5\60\31\b\u00c8\u00c9\f\6\2\2\u00c9\u00ca\t"+
		"\7\2\2\u00ca\u00d2\5\60\31\7\u00cb\u00cc\f\5\2\2\u00cc\u00cd\t\b\2\2\u00cd"+
		"\u00d2\5\60\31\6\u00ce\u00cf\f\4\2\2\u00cf\u00d0\t\t\2\2\u00d0\u00d2\5"+
		"\60\31\5\u00d1\u00c2\3\2\2\2\u00d1\u00c5\3\2\2\2\u00d1\u00c8\3\2\2\2\u00d1"+
		"\u00cb\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\61\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7"+
		"\7\20\2\2\u00d7\u00d8\5\60\31\2\u00d8\u00d9\7\21\2\2\u00d9\u00e1\3\2\2"+
		"\2\u00da\u00e1\7\61\2\2\u00db\u00e1\t\n\2\2\u00dc\u00e1\7\64\2\2\u00dd"+
		"\u00e1\7\63\2\2\u00de\u00e1\7\62\2\2\u00df\u00e1\7\b\2\2\u00e0\u00d6\3"+
		"\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00db\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e0"+
		"\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\63\3\2\2"+
		"\2\228?G]en\177\u0088\u008d\u009b\u00a1\u00b9\u00c0\u00d1\u00d3\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}