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
		T__9=10, KEYWORD=11, OPERATOR=12, IDENTIFIER=13, INTLITERAL=14, STRINGLITERAL=15, 
		FLOATLITERAL=16, COMMENTS=17, WHITESPACE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "STRINGLITERAL", 
		"FLOATLITERAL", "COMMENTS", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'empty'", "':='", "'+ | -'", "'* | /'", "'<'", "'>'", "'='", "'!='", 
		"'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "KEYWORD", 
		"OPERATOR", "IDENTIFIER", "INTLITERAL", "STRINGLITERAL", "FLOATLITERAL", 
		"COMMENTS", "WHITESPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00e8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a9\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b5\n\r\3\16\3\16\7\16\u00b9\n\16"+
		"\f\16\16\16\u00bc\13\16\3\17\6\17\u00bf\n\17\r\17\16\17\u00c0\3\20\3\20"+
		"\7\20\u00c5\n\20\f\20\16\20\u00c8\13\20\3\20\3\20\3\21\7\21\u00cd\n\21"+
		"\f\21\16\21\u00d0\13\21\3\21\3\21\6\21\u00d4\n\21\r\21\16\21\u00d5\3\22"+
		"\3\22\3\22\3\22\7\22\u00dc\n\22\f\22\16\22\u00df\13\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\4\u00c6\u00dd\2\24\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\b\6"+
		"\2,-//\61\61??\6\2*+..=>@@\3\2C|\4\2\62;C|\3\2\62;\4\2\13\f\"\"\2\u0103"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\'\3\2\2\2\5-\3\2\2\2\7\60\3\2\2\2\t\66\3\2\2\2\13<\3"+
		"\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2\23E\3\2\2\2\25H\3\2\2\2\27\u00a8"+
		"\3\2\2\2\31\u00b4\3\2\2\2\33\u00b6\3\2\2\2\35\u00be\3\2\2\2\37\u00c2\3"+
		"\2\2\2!\u00ce\3\2\2\2#\u00d7\3\2\2\2%\u00e4\3\2\2\2\'(\7g\2\2()\7o\2\2"+
		")*\7r\2\2*+\7v\2\2+,\7{\2\2,\4\3\2\2\2-.\7<\2\2./\7?\2\2/\6\3\2\2\2\60"+
		"\61\7-\2\2\61\62\7\"\2\2\62\63\7~\2\2\63\64\7\"\2\2\64\65\7/\2\2\65\b"+
		"\3\2\2\2\66\67\7,\2\2\678\7\"\2\289\7~\2\29:\7\"\2\2:;\7\61\2\2;\n\3\2"+
		"\2\2<=\7>\2\2=\f\3\2\2\2>?\7@\2\2?\16\3\2\2\2@A\7?\2\2A\20\3\2\2\2BC\7"+
		"#\2\2CD\7?\2\2D\22\3\2\2\2EF\7>\2\2FG\7?\2\2G\24\3\2\2\2HI\7@\2\2IJ\7"+
		"?\2\2J\26\3\2\2\2KL\7R\2\2LM\7T\2\2MN\7Q\2\2NO\7I\2\2OP\7T\2\2PQ\7C\2"+
		"\2Q\u00a9\7O\2\2RS\7D\2\2ST\7G\2\2TU\7I\2\2UV\7K\2\2V\u00a9\7P\2\2WX\7"+
		"G\2\2XY\7P\2\2Y\u00a9\7F\2\2Z[\7H\2\2[\\\7W\2\2\\]\7P\2\2]^\7E\2\2^_\7"+
		"V\2\2_`\7K\2\2`a\7Q\2\2a\u00a9\7P\2\2bc\7T\2\2cd\7G\2\2de\7C\2\2e\u00a9"+
		"\7F\2\2fg\7Y\2\2gh\7T\2\2hi\7K\2\2ij\7V\2\2j\u00a9\7G\2\2kl\7K\2\2l\u00a9"+
		"\7H\2\2mn\7G\2\2no\7N\2\2op\7U\2\2p\u00a9\7G\2\2qr\7G\2\2rs\7P\2\2st\7"+
		"F\2\2tu\7K\2\2u\u00a9\7H\2\2vw\7Y\2\2wx\7J\2\2xy\7K\2\2yz\7N\2\2z\u00a9"+
		"\7G\2\2{|\7G\2\2|}\7P\2\2}~\7F\2\2~\177\7Y\2\2\177\u0080\7J\2\2\u0080"+
		"\u0081\7K\2\2\u0081\u0082\7N\2\2\u0082\u00a9\7G\2\2\u0083\u0084\7E\2\2"+
		"\u0084\u0085\7Q\2\2\u0085\u0086\7P\2\2\u0086\u0087\7V\2\2\u0087\u0088"+
		"\7K\2\2\u0088\u0089\7P\2\2\u0089\u008a\7W\2\2\u008a\u00a9\7G\2\2\u008b"+
		"\u008c\7D\2\2\u008c\u008d\7T\2\2\u008d\u008e\7G\2\2\u008e\u008f\7C\2\2"+
		"\u008f\u00a9\7M\2\2\u0090\u0091\7T\2\2\u0091\u0092\7G\2\2\u0092\u0093"+
		"\7V\2\2\u0093\u0094\7W\2\2\u0094\u0095\7T\2\2\u0095\u00a9\7P\2\2\u0096"+
		"\u0097\7K\2\2\u0097\u0098\7P\2\2\u0098\u00a9\7V\2\2\u0099\u009a\7X\2\2"+
		"\u009a\u009b\7Q\2\2\u009b\u009c\7K\2\2\u009c\u00a9\7F\2\2\u009d\u009e"+
		"\7U\2\2\u009e\u009f\7V\2\2\u009f\u00a0\7T\2\2\u00a0\u00a1\7K\2\2\u00a1"+
		"\u00a2\7P\2\2\u00a2\u00a9\7I\2\2\u00a3\u00a4\7H\2\2\u00a4\u00a5\7N\2\2"+
		"\u00a5\u00a6\7Q\2\2\u00a6\u00a7\7C\2\2\u00a7\u00a9\7V\2\2\u00a8K\3\2\2"+
		"\2\u00a8R\3\2\2\2\u00a8W\3\2\2\2\u00a8Z\3\2\2\2\u00a8b\3\2\2\2\u00a8f"+
		"\3\2\2\2\u00a8k\3\2\2\2\u00a8m\3\2\2\2\u00a8q\3\2\2\2\u00a8v\3\2\2\2\u00a8"+
		"{\3\2\2\2\u00a8\u0083\3\2\2\2\u00a8\u008b\3\2\2\2\u00a8\u0090\3\2\2\2"+
		"\u00a8\u0096\3\2\2\2\u00a8\u0099\3\2\2\2\u00a8\u009d\3\2\2\2\u00a8\u00a3"+
		"\3\2\2\2\u00a9\30\3\2\2\2\u00aa\u00ab\7<\2\2\u00ab\u00b5\7?\2\2\u00ac"+
		"\u00b5\t\2\2\2\u00ad\u00ae\7#\2\2\u00ae\u00b5\7?\2\2\u00af\u00b5\t\3\2"+
		"\2\u00b0\u00b1\7>\2\2\u00b1\u00b5\7?\2\2\u00b2\u00b3\7@\2\2\u00b3\u00b5"+
		"\7?\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4"+
		"\u00af\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\32\3\2\2"+
		"\2\u00b6\u00ba\t\4\2\2\u00b7\u00b9\t\5\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\34\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00bf\t\6\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\36\3\2\2\2\u00c2\u00c6"+
		"\7$\2\2\u00c3\u00c5\13\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00ca\7$\2\2\u00ca \3\2\2\2\u00cb\u00cd\t\6\2\2\u00cc\u00cb"+
		"\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\7\60\2\2\u00d2\u00d4\t"+
		"\6\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\"\3\2\2\2\u00d7\u00d8\7/\2\2\u00d8\u00d9\7/\2\2\u00d9"+
		"\u00dd\3\2\2\2\u00da\u00dc\13\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3"+
		"\2\2\2\u00dd\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00e1\7\f\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\22"+
		"\2\2\u00e3$\3\2\2\2\u00e4\u00e5\t\7\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\b\23\2\2\u00e7&\3\2\2\2\f\2\u00a8\u00b4\u00b8\u00ba\u00c0\u00c6\u00ce"+
		"\u00d5\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}