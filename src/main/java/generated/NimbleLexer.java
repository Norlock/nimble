// Generated from NimbleLexer.g4 by ANTLR 4.5.1
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NimbleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING_TYPE=1, INTEGER_TYPE=2, BOOLEAN_TYPE=3, VOID=4, NULL=5, GLOBAL=6, 
		PACKAGE=7, INTERNAL=8, MAIN=9, SEMICOLON=10, COMMA=11, DOT=12, LEFT_PARENTHESE=13, 
		RIGHT_PARENTHESE=14, LEFT_BRACE=15, RIGHT_BRACE=16, LEFT_SQUARE_BRACKET=17, 
		RIGHT_SQUARE_BRACKET=18, ASSIGN=19, LESSER=20, GREATER=21, EQUAL=22, NOT_EQUAL=23, 
		LESSER_OR_EQUAL=24, GREATER_OR_EQUAL=25, AND=26, OR=27, INCREMENT=28, 
		DECREMENT=29, ADD=30, SUBSTRACT=31, MULTIPLY=32, DIVIDE=33, MODULO=34, 
		NOT=35, IF=36, ELSE=37, GOTO=38, RETURN=39, FOR=40, WHILE=41, CLASS=42, 
		BOOLEAN=43, INTEGER=44, STRING=45, IDENTIFIER=46, WS=47, COMMENT=48, LINE_COMMENT=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"STRING_TYPE", "INTEGER_TYPE", "BOOLEAN_TYPE", "VOID", "NULL", "GLOBAL", 
		"PACKAGE", "INTERNAL", "MAIN", "SEMICOLON", "COMMA", "DOT", "LEFT_PARENTHESE", 
		"RIGHT_PARENTHESE", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_SQUARE_BRACKET", 
		"RIGHT_SQUARE_BRACKET", "ASSIGN", "LESSER", "GREATER", "EQUAL", "NOT_EQUAL", 
		"LESSER_OR_EQUAL", "GREATER_OR_EQUAL", "AND", "OR", "INCREMENT", "DECREMENT", 
		"ADD", "SUBSTRACT", "MULTIPLY", "DIVIDE", "MODULO", "NOT", "IF", "ELSE", 
		"GOTO", "RETURN", "FOR", "WHILE", "CLASS", "BOOLEAN", "INTEGER", "STRING", 
		"IDENTIFIER", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'string'", "'int'", "'bool'", "'void'", "'null'", "'global'", "'package'", 
		"'internal'", "'main'", "';'", "','", "'.'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "'='", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", "'&&'", 
		"'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'if'", 
		"'else'", "'goto'", "'return'", "'for'", "'while'", "'class'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STRING_TYPE", "INTEGER_TYPE", "BOOLEAN_TYPE", "VOID", "NULL", "GLOBAL", 
		"PACKAGE", "INTERNAL", "MAIN", "SEMICOLON", "COMMA", "DOT", "LEFT_PARENTHESE", 
		"RIGHT_PARENTHESE", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_SQUARE_BRACKET", 
		"RIGHT_SQUARE_BRACKET", "ASSIGN", "LESSER", "GREATER", "EQUAL", "NOT_EQUAL", 
		"LESSER_OR_EQUAL", "GREATER_OR_EQUAL", "AND", "OR", "INCREMENT", "DECREMENT", 
		"ADD", "SUBSTRACT", "MULTIPLY", "DIVIDE", "MODULO", "NOT", "IF", "ELSE", 
		"GOTO", "RETURN", "FOR", "WHILE", "CLASS", "BOOLEAN", "INTEGER", "STRING", 
		"IDENTIFIER", "WS", "COMMENT", "LINE_COMMENT"
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


	public NimbleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NimbleLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u013e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)"+
		"\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0106"+
		"\n,\3-\6-\u0109\n-\r-\16-\u010a\3.\3.\3.\3.\7.\u0111\n.\f.\16.\u0114\13"+
		".\3.\3.\3/\3/\7/\u011a\n/\f/\16/\u011d\13/\3\60\6\60\u0120\n\60\r\60\16"+
		"\60\u0121\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u012a\n\61\f\61\16\61\u012d"+
		"\13\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0138\n\62\f"+
		"\62\16\62\u013b\13\62\3\62\3\62\3\u012b\2\63\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63\3\2\b\3\2\62;\5\2\f\f\17\17$$\5\2C\\aac|\6\2"+
		"\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0145\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3"+
		"\2\2\2\5l\3\2\2\2\7p\3\2\2\2\tu\3\2\2\2\13z\3\2\2\2\r\177\3\2\2\2\17\u0086"+
		"\3\2\2\2\21\u008e\3\2\2\2\23\u0097\3\2\2\2\25\u009c\3\2\2\2\27\u009e\3"+
		"\2\2\2\31\u00a0\3\2\2\2\33\u00a2\3\2\2\2\35\u00a4\3\2\2\2\37\u00a6\3\2"+
		"\2\2!\u00a8\3\2\2\2#\u00aa\3\2\2\2%\u00ac\3\2\2\2\'\u00ae\3\2\2\2)\u00b0"+
		"\3\2\2\2+\u00b2\3\2\2\2-\u00b4\3\2\2\2/\u00b7\3\2\2\2\61\u00ba\3\2\2\2"+
		"\63\u00bd\3\2\2\2\65\u00c0\3\2\2\2\67\u00c3\3\2\2\29\u00c6\3\2\2\2;\u00c9"+
		"\3\2\2\2=\u00cc\3\2\2\2?\u00ce\3\2\2\2A\u00d0\3\2\2\2C\u00d2\3\2\2\2E"+
		"\u00d4\3\2\2\2G\u00d6\3\2\2\2I\u00d8\3\2\2\2K\u00db\3\2\2\2M\u00e0\3\2"+
		"\2\2O\u00e5\3\2\2\2Q\u00ec\3\2\2\2S\u00f0\3\2\2\2U\u00f6\3\2\2\2W\u0105"+
		"\3\2\2\2Y\u0108\3\2\2\2[\u010c\3\2\2\2]\u0117\3\2\2\2_\u011f\3\2\2\2a"+
		"\u0125\3\2\2\2c\u0133\3\2\2\2ef\7u\2\2fg\7v\2\2gh\7t\2\2hi\7k\2\2ij\7"+
		"p\2\2jk\7i\2\2k\4\3\2\2\2lm\7k\2\2mn\7p\2\2no\7v\2\2o\6\3\2\2\2pq\7d\2"+
		"\2qr\7q\2\2rs\7q\2\2st\7n\2\2t\b\3\2\2\2uv\7x\2\2vw\7q\2\2wx\7k\2\2xy"+
		"\7f\2\2y\n\3\2\2\2z{\7p\2\2{|\7w\2\2|}\7n\2\2}~\7n\2\2~\f\3\2\2\2\177"+
		"\u0080\7i\2\2\u0080\u0081\7n\2\2\u0081\u0082\7q\2\2\u0082\u0083\7d\2\2"+
		"\u0083\u0084\7c\2\2\u0084\u0085\7n\2\2\u0085\16\3\2\2\2\u0086\u0087\7"+
		"r\2\2\u0087\u0088\7c\2\2\u0088\u0089\7e\2\2\u0089\u008a\7m\2\2\u008a\u008b"+
		"\7c\2\2\u008b\u008c\7i\2\2\u008c\u008d\7g\2\2\u008d\20\3\2\2\2\u008e\u008f"+
		"\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7v\2\2\u0091\u0092\7g\2\2\u0092"+
		"\u0093\7t\2\2\u0093\u0094\7p\2\2\u0094\u0095\7c\2\2\u0095\u0096\7n\2\2"+
		"\u0096\22\3\2\2\2\u0097\u0098\7o\2\2\u0098\u0099\7c\2\2\u0099\u009a\7"+
		"k\2\2\u009a\u009b\7p\2\2\u009b\24\3\2\2\2\u009c\u009d\7=\2\2\u009d\26"+
		"\3\2\2\2\u009e\u009f\7.\2\2\u009f\30\3\2\2\2\u00a0\u00a1\7\60\2\2\u00a1"+
		"\32\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3\34\3\2\2\2\u00a4\u00a5\7+\2\2\u00a5"+
		"\36\3\2\2\2\u00a6\u00a7\7}\2\2\u00a7 \3\2\2\2\u00a8\u00a9\7\177\2\2\u00a9"+
		"\"\3\2\2\2\u00aa\u00ab\7]\2\2\u00ab$\3\2\2\2\u00ac\u00ad\7_\2\2\u00ad"+
		"&\3\2\2\2\u00ae\u00af\7?\2\2\u00af(\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1*"+
		"\3\2\2\2\u00b2\u00b3\7@\2\2\u00b3,\3\2\2\2\u00b4\u00b5\7?\2\2\u00b5\u00b6"+
		"\7?\2\2\u00b6.\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00b9\7?\2\2\u00b9\60"+
		"\3\2\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bc\7?\2\2\u00bc\62\3\2\2\2\u00bd"+
		"\u00be\7@\2\2\u00be\u00bf\7?\2\2\u00bf\64\3\2\2\2\u00c0\u00c1\7(\2\2\u00c1"+
		"\u00c2\7(\2\2\u00c2\66\3\2\2\2\u00c3\u00c4\7~\2\2\u00c4\u00c5\7~\2\2\u00c5"+
		"8\3\2\2\2\u00c6\u00c7\7-\2\2\u00c7\u00c8\7-\2\2\u00c8:\3\2\2\2\u00c9\u00ca"+
		"\7/\2\2\u00ca\u00cb\7/\2\2\u00cb<\3\2\2\2\u00cc\u00cd\7-\2\2\u00cd>\3"+
		"\2\2\2\u00ce\u00cf\7/\2\2\u00cf@\3\2\2\2\u00d0\u00d1\7,\2\2\u00d1B\3\2"+
		"\2\2\u00d2\u00d3\7\61\2\2\u00d3D\3\2\2\2\u00d4\u00d5\7\'\2\2\u00d5F\3"+
		"\2\2\2\u00d6\u00d7\7#\2\2\u00d7H\3\2\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da"+
		"\7h\2\2\u00daJ\3\2\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de"+
		"\7u\2\2\u00de\u00df\7g\2\2\u00dfL\3\2\2\2\u00e0\u00e1\7i\2\2\u00e1\u00e2"+
		"\7q\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7q\2\2\u00e4N\3\2\2\2\u00e5\u00e6"+
		"\7t\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7w\2\2\u00e9"+
		"\u00ea\7t\2\2\u00ea\u00eb\7p\2\2\u00ebP\3\2\2\2\u00ec\u00ed\7h\2\2\u00ed"+
		"\u00ee\7q\2\2\u00ee\u00ef\7t\2\2\u00efR\3\2\2\2\u00f0\u00f1\7y\2\2\u00f1"+
		"\u00f2\7j\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7g\2\2"+
		"\u00f5T\3\2\2\2\u00f6\u00f7\7e\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7c\2"+
		"\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7u\2\2\u00fbV\3\2\2\2\u00fc\u00fd\7"+
		"v\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7w\2\2\u00ff\u0106\7g\2\2\u0100\u0101"+
		"\7h\2\2\u0101\u0102\7c\2\2\u0102\u0103\7n\2\2\u0103\u0104\7u\2\2\u0104"+
		"\u0106\7g\2\2\u0105\u00fc\3\2\2\2\u0105\u0100\3\2\2\2\u0106X\3\2\2\2\u0107"+
		"\u0109\t\2\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010bZ\3\2\2\2\u010c\u0112\7$\2\2\u010d\u0111"+
		"\n\3\2\2\u010e\u010f\7$\2\2\u010f\u0111\7$\2\2\u0110\u010d\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\7$\2\2\u0116"+
		"\\\3\2\2\2\u0117\u011b\t\4\2\2\u0118\u011a\t\5\2\2\u0119\u0118\3\2\2\2"+
		"\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c^\3"+
		"\2\2\2\u011d\u011b\3\2\2\2\u011e\u0120\t\6\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0124\b\60\2\2\u0124`\3\2\2\2\u0125\u0126\7\61\2\2\u0126\u0127"+
		"\7,\2\2\u0127\u012b\3\2\2\2\u0128\u012a\13\2\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\3\2"+
		"\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7,\2\2\u012f\u0130\7\61\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\b\61\2\2\u0132b\3\2\2\2\u0133\u0134\7\61\2"+
		"\2\u0134\u0135\7\61\2\2\u0135\u0139\3\2\2\2\u0136\u0138\n\7\2\2\u0137"+
		"\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\b\62\2\2\u013d"+
		"d\3\2\2\2\13\2\u0105\u010a\u0110\u0112\u011b\u0121\u012b\u0139\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}