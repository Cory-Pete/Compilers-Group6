// Generated from /Users/matthewsagen/Library/Mobile Documents/com~apple~CloudDocs/Documents/Compilers/step2/Little.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, KEYWORD=27, OPERATOR=28, IDENTIFIER=29, INTLITERAL=30, 
		STRINGLITERAL=31, FLOATLITERAL=32, COMMENTS=33, WHITESPACE=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "STRINGLITERAL", 
		"FLOATLITERAL", "COMMENTS", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PROGRAM'", "'BEGIN'", "'empty'", "'STRING'", "':='", "'FLOAT'", 
		"'INT'", "'VOID'", "'FUNCTION'", "'END'", "'READ'", "'WRITE'", "'RETURN'", 
		"'+ | -'", "'* | /'", "'IF'", "'ENDIF'", "'ELSE'", "'<'", "'>'", "'='", 
		"'!='", "'<='", "'>='", "'WHILE'", "'ENDWHILE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "STRINGLITERAL", 
		"FLOATLITERAL", "COMMENTS", "WHITESPACE"
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


	public LittleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0161\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0122"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u012e\n\35"+
		"\3\36\3\36\7\36\u0132\n\36\f\36\16\36\u0135\13\36\3\37\6\37\u0138\n\37"+
		"\r\37\16\37\u0139\3 \3 \7 \u013e\n \f \16 \u0141\13 \3 \3 \3!\7!\u0146"+
		"\n!\f!\16!\u0149\13!\3!\3!\6!\u014d\n!\r!\16!\u014e\3\"\3\"\3\"\3\"\7"+
		"\"\u0155\n\"\f\"\16\"\u0158\13\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\4\u013f\u0156"+
		"\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$\3\2\b\6\2,-//\61\61??\6\2*+..=>@@\4\2C\\c|\5\2\62;C\\"+
		"c|\3\2\62;\4\2\13\f\"\"\2\u017b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5O\3\2\2\2\7U\3\2\2\2\t[\3\2\2\2\13"+
		"b\3\2\2\2\re\3\2\2\2\17k\3\2\2\2\21o\3\2\2\2\23t\3\2\2\2\25}\3\2\2\2\27"+
		"\u0081\3\2\2\2\31\u0086\3\2\2\2\33\u008c\3\2\2\2\35\u0093\3\2\2\2\37\u0099"+
		"\3\2\2\2!\u009f\3\2\2\2#\u00a2\3\2\2\2%\u00a8\3\2\2\2\'\u00ad\3\2\2\2"+
		")\u00af\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3\2\2\2/\u00b6\3\2\2\2\61\u00b9"+
		"\3\2\2\2\63\u00bc\3\2\2\2\65\u00c2\3\2\2\2\67\u0121\3\2\2\29\u012d\3\2"+
		"\2\2;\u012f\3\2\2\2=\u0137\3\2\2\2?\u013b\3\2\2\2A\u0147\3\2\2\2C\u0150"+
		"\3\2\2\2E\u015d\3\2\2\2GH\7R\2\2HI\7T\2\2IJ\7Q\2\2JK\7I\2\2KL\7T\2\2L"+
		"M\7C\2\2MN\7O\2\2N\4\3\2\2\2OP\7D\2\2PQ\7G\2\2QR\7I\2\2RS\7K\2\2ST\7P"+
		"\2\2T\6\3\2\2\2UV\7g\2\2VW\7o\2\2WX\7r\2\2XY\7v\2\2YZ\7{\2\2Z\b\3\2\2"+
		"\2[\\\7U\2\2\\]\7V\2\2]^\7T\2\2^_\7K\2\2_`\7P\2\2`a\7I\2\2a\n\3\2\2\2"+
		"bc\7<\2\2cd\7?\2\2d\f\3\2\2\2ef\7H\2\2fg\7N\2\2gh\7Q\2\2hi\7C\2\2ij\7"+
		"V\2\2j\16\3\2\2\2kl\7K\2\2lm\7P\2\2mn\7V\2\2n\20\3\2\2\2op\7X\2\2pq\7"+
		"Q\2\2qr\7K\2\2rs\7F\2\2s\22\3\2\2\2tu\7H\2\2uv\7W\2\2vw\7P\2\2wx\7E\2"+
		"\2xy\7V\2\2yz\7K\2\2z{\7Q\2\2{|\7P\2\2|\24\3\2\2\2}~\7G\2\2~\177\7P\2"+
		"\2\177\u0080\7F\2\2\u0080\26\3\2\2\2\u0081\u0082\7T\2\2\u0082\u0083\7"+
		"G\2\2\u0083\u0084\7C\2\2\u0084\u0085\7F\2\2\u0085\30\3\2\2\2\u0086\u0087"+
		"\7Y\2\2\u0087\u0088\7T\2\2\u0088\u0089\7K\2\2\u0089\u008a\7V\2\2\u008a"+
		"\u008b\7G\2\2\u008b\32\3\2\2\2\u008c\u008d\7T\2\2\u008d\u008e\7G\2\2\u008e"+
		"\u008f\7V\2\2\u008f\u0090\7W\2\2\u0090\u0091\7T\2\2\u0091\u0092\7P\2\2"+
		"\u0092\34\3\2\2\2\u0093\u0094\7-\2\2\u0094\u0095\7\"\2\2\u0095\u0096\7"+
		"~\2\2\u0096\u0097\7\"\2\2\u0097\u0098\7/\2\2\u0098\36\3\2\2\2\u0099\u009a"+
		"\7,\2\2\u009a\u009b\7\"\2\2\u009b\u009c\7~\2\2\u009c\u009d\7\"\2\2\u009d"+
		"\u009e\7\61\2\2\u009e \3\2\2\2\u009f\u00a0\7K\2\2\u00a0\u00a1\7H\2\2\u00a1"+
		"\"\3\2\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7P\2\2\u00a4\u00a5\7F\2\2\u00a5"+
		"\u00a6\7K\2\2\u00a6\u00a7\7H\2\2\u00a7$\3\2\2\2\u00a8\u00a9\7G\2\2\u00a9"+
		"\u00aa\7N\2\2\u00aa\u00ab\7U\2\2\u00ab\u00ac\7G\2\2\u00ac&\3\2\2\2\u00ad"+
		"\u00ae\7>\2\2\u00ae(\3\2\2\2\u00af\u00b0\7@\2\2\u00b0*\3\2\2\2\u00b1\u00b2"+
		"\7?\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7#\2\2\u00b4\u00b5\7?\2\2\u00b5.\3"+
		"\2\2\2\u00b6\u00b7\7>\2\2\u00b7\u00b8\7?\2\2\u00b8\60\3\2\2\2\u00b9\u00ba"+
		"\7@\2\2\u00ba\u00bb\7?\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\7Y\2\2\u00bd\u00be"+
		"\7J\2\2\u00be\u00bf\7K\2\2\u00bf\u00c0\7N\2\2\u00c0\u00c1\7G\2\2\u00c1"+
		"\64\3\2\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7P\2\2\u00c4\u00c5\7F\2\2\u00c5"+
		"\u00c6\7Y\2\2\u00c6\u00c7\7J\2\2\u00c7\u00c8\7K\2\2\u00c8\u00c9\7N\2\2"+
		"\u00c9\u00ca\7G\2\2\u00ca\66\3\2\2\2\u00cb\u00cc\7D\2\2\u00cc\u00cd\7"+
		"G\2\2\u00cd\u00ce\7I\2\2\u00ce\u00cf\7K\2\2\u00cf\u0122\7P\2\2\u00d0\u00d1"+
		"\7G\2\2\u00d1\u00d2\7P\2\2\u00d2\u0122\7F\2\2\u00d3\u00d4\7H\2\2\u00d4"+
		"\u00d5\7W\2\2\u00d5\u00d6\7P\2\2\u00d6\u00d7\7E\2\2\u00d7\u00d8\7V\2\2"+
		"\u00d8\u00d9\7K\2\2\u00d9\u00da\7Q\2\2\u00da\u0122\7P\2\2\u00db\u00dc"+
		"\7T\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7C\2\2\u00de\u0122\7F\2\2\u00df"+
		"\u00e0\7Y\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2\7K\2\2\u00e2\u00e3\7V\2\2"+
		"\u00e3\u0122\7G\2\2\u00e4\u00e5\7K\2\2\u00e5\u0122\7H\2\2\u00e6\u00e7"+
		"\7G\2\2\u00e7\u00e8\7N\2\2\u00e8\u00e9\7U\2\2\u00e9\u0122\7G\2\2\u00ea"+
		"\u00eb\7G\2\2\u00eb\u00ec\7P\2\2\u00ec\u00ed\7F\2\2\u00ed\u00ee\7K\2\2"+
		"\u00ee\u0122\7H\2\2\u00ef\u00f0\7Y\2\2\u00f0\u00f1\7J\2\2\u00f1\u00f2"+
		"\7K\2\2\u00f2\u00f3\7N\2\2\u00f3\u0122\7G\2\2\u00f4\u00f5\7G\2\2\u00f5"+
		"\u00f6\7P\2\2\u00f6\u00f7\7F\2\2\u00f7\u00f8\7Y\2\2\u00f8\u00f9\7J\2\2"+
		"\u00f9\u00fa\7K\2\2\u00fa\u00fb\7N\2\2\u00fb\u0122\7G\2\2\u00fc\u00fd"+
		"\7E\2\2\u00fd\u00fe\7Q\2\2\u00fe\u00ff\7P\2\2\u00ff\u0100\7V\2\2\u0100"+
		"\u0101\7K\2\2\u0101\u0102\7P\2\2\u0102\u0103\7W\2\2\u0103\u0122\7G\2\2"+
		"\u0104\u0105\7D\2\2\u0105\u0106\7T\2\2\u0106\u0107\7G\2\2\u0107\u0108"+
		"\7C\2\2\u0108\u0122\7M\2\2\u0109\u010a\7T\2\2\u010a\u010b\7G\2\2\u010b"+
		"\u010c\7V\2\2\u010c\u010d\7W\2\2\u010d\u010e\7T\2\2\u010e\u0122\7P\2\2"+
		"\u010f\u0110\7K\2\2\u0110\u0111\7P\2\2\u0111\u0122\7V\2\2\u0112\u0113"+
		"\7X\2\2\u0113\u0114\7Q\2\2\u0114\u0115\7K\2\2\u0115\u0122\7F\2\2\u0116"+
		"\u0117\7U\2\2\u0117\u0118\7V\2\2\u0118\u0119\7T\2\2\u0119\u011a\7K\2\2"+
		"\u011a\u011b\7P\2\2\u011b\u0122\7I\2\2\u011c\u011d\7H\2\2\u011d\u011e"+
		"\7N\2\2\u011e\u011f\7Q\2\2\u011f\u0120\7C\2\2\u0120\u0122\7V\2\2\u0121"+
		"\u00cb\3\2\2\2\u0121\u00d0\3\2\2\2\u0121\u00d3\3\2\2\2\u0121\u00db\3\2"+
		"\2\2\u0121\u00df\3\2\2\2\u0121\u00e4\3\2\2\2\u0121\u00e6\3\2\2\2\u0121"+
		"\u00ea\3\2\2\2\u0121\u00ef\3\2\2\2\u0121\u00f4\3\2\2\2\u0121\u00fc\3\2"+
		"\2\2\u0121\u0104\3\2\2\2\u0121\u0109\3\2\2\2\u0121\u010f\3\2\2\2\u0121"+
		"\u0112\3\2\2\2\u0121\u0116\3\2\2\2\u0121\u011c\3\2\2\2\u01228\3\2\2\2"+
		"\u0123\u0124\7<\2\2\u0124\u012e\7?\2\2\u0125\u012e\t\2\2\2\u0126\u0127"+
		"\7#\2\2\u0127\u012e\7?\2\2\u0128\u012e\t\3\2\2\u0129\u012a\7>\2\2\u012a"+
		"\u012e\7?\2\2\u012b\u012c\7@\2\2\u012c\u012e\7?\2\2\u012d\u0123\3\2\2"+
		"\2\u012d\u0125\3\2\2\2\u012d\u0126\3\2\2\2\u012d\u0128\3\2\2\2\u012d\u0129"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012e:\3\2\2\2\u012f\u0133\t\4\2\2\u0130"+
		"\u0132\t\5\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134<\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0138"+
		"\t\6\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a>\3\2\2\2\u013b\u013f\7$\2\2\u013c\u013e\13\2\2\2"+
		"\u013d\u013c\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u0140\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\7$\2\2\u0143"+
		"@\3\2\2\2\u0144\u0146\t\6\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2"+
		"\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147"+
		"\3\2\2\2\u014a\u014c\7\60\2\2\u014b\u014d\t\6\2\2\u014c\u014b\3\2\2\2"+
		"\u014d\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014fB\3"+
		"\2\2\2\u0150\u0151\7/\2\2\u0151\u0152\7/\2\2\u0152\u0156\3\2\2\2\u0153"+
		"\u0155\13\2\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0157\3"+
		"\2\2\2\u0156\u0154\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159"+
		"\u015a\7\f\2\2\u015a\u015b\3\2\2\2\u015b\u015c\b\"\2\2\u015cD\3\2\2\2"+
		"\u015d\u015e\t\7\2\2\u015e\u015f\3\2\2\2\u015f\u0160\b#\2\2\u0160F\3\2"+
		"\2\2\f\2\u0121\u012d\u0131\u0133\u0139\u013f\u0147\u014e\u0156\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}