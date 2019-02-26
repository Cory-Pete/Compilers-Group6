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
		KEYWORD=10, OPERATOR=11, IDENTIFIER=12, INTLITERAL=13, STRINGLITERAL=14, 
		FLOATLITERAL=15, COMMENTS=16, WHITESPACE=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"KEYWORD", "OPERATOR", "IDENTIFIER", "INTLITERAL", "STRINGLITERAL", "FLOATLITERAL", 
		"COMMENTS", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':='", "'+ | -'", "'* | /'", "'<'", "'>'", "'='", "'!='", "'<='", 
		"'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "KEYWORD", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00e0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a1\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u00ad\n\f\3\r\3\r\7\r\u00b1\n\r\f\r\16\r\u00b4\13"+
		"\r\3\16\6\16\u00b7\n\16\r\16\16\16\u00b8\3\17\3\17\7\17\u00bd\n\17\f\17"+
		"\16\17\u00c0\13\17\3\17\3\17\3\20\7\20\u00c5\n\20\f\20\16\20\u00c8\13"+
		"\20\3\20\3\20\6\20\u00cc\n\20\r\20\16\20\u00cd\3\21\3\21\3\21\3\21\7\21"+
		"\u00d4\n\21\f\21\16\21\u00d7\13\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\4\u00be\u00d5\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\b\6\2,-//\61\61??\6\2*+..=>"+
		"@@\3\2C|\4\2\62;C|\3\2\62;\4\2\13\f\"\"\2\u00fb\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5(\3\2"+
		"\2\2\7.\3\2\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21="+
		"\3\2\2\2\23@\3\2\2\2\25\u00a0\3\2\2\2\27\u00ac\3\2\2\2\31\u00ae\3\2\2"+
		"\2\33\u00b6\3\2\2\2\35\u00ba\3\2\2\2\37\u00c6\3\2\2\2!\u00cf\3\2\2\2#"+
		"\u00dc\3\2\2\2%&\7<\2\2&\'\7?\2\2\'\4\3\2\2\2()\7-\2\2)*\7\"\2\2*+\7~"+
		"\2\2+,\7\"\2\2,-\7/\2\2-\6\3\2\2\2./\7,\2\2/\60\7\"\2\2\60\61\7~\2\2\61"+
		"\62\7\"\2\2\62\63\7\61\2\2\63\b\3\2\2\2\64\65\7>\2\2\65\n\3\2\2\2\66\67"+
		"\7@\2\2\67\f\3\2\2\289\7?\2\29\16\3\2\2\2:;\7#\2\2;<\7?\2\2<\20\3\2\2"+
		"\2=>\7>\2\2>?\7?\2\2?\22\3\2\2\2@A\7@\2\2AB\7?\2\2B\24\3\2\2\2CD\7R\2"+
		"\2DE\7T\2\2EF\7Q\2\2FG\7I\2\2GH\7T\2\2HI\7C\2\2I\u00a1\7O\2\2JK\7D\2\2"+
		"KL\7G\2\2LM\7I\2\2MN\7K\2\2N\u00a1\7P\2\2OP\7G\2\2PQ\7P\2\2Q\u00a1\7F"+
		"\2\2RS\7H\2\2ST\7W\2\2TU\7P\2\2UV\7E\2\2VW\7V\2\2WX\7K\2\2XY\7Q\2\2Y\u00a1"+
		"\7P\2\2Z[\7T\2\2[\\\7G\2\2\\]\7C\2\2]\u00a1\7F\2\2^_\7Y\2\2_`\7T\2\2`"+
		"a\7K\2\2ab\7V\2\2b\u00a1\7G\2\2cd\7K\2\2d\u00a1\7H\2\2ef\7G\2\2fg\7N\2"+
		"\2gh\7U\2\2h\u00a1\7G\2\2ij\7G\2\2jk\7P\2\2kl\7F\2\2lm\7K\2\2m\u00a1\7"+
		"H\2\2no\7Y\2\2op\7J\2\2pq\7K\2\2qr\7N\2\2r\u00a1\7G\2\2st\7G\2\2tu\7P"+
		"\2\2uv\7F\2\2vw\7Y\2\2wx\7J\2\2xy\7K\2\2yz\7N\2\2z\u00a1\7G\2\2{|\7E\2"+
		"\2|}\7Q\2\2}~\7P\2\2~\177\7V\2\2\177\u0080\7K\2\2\u0080\u0081\7P\2\2\u0081"+
		"\u0082\7W\2\2\u0082\u00a1\7G\2\2\u0083\u0084\7D\2\2\u0084\u0085\7T\2\2"+
		"\u0085\u0086\7G\2\2\u0086\u0087\7C\2\2\u0087\u00a1\7M\2\2\u0088\u0089"+
		"\7T\2\2\u0089\u008a\7G\2\2\u008a\u008b\7V\2\2\u008b\u008c\7W\2\2\u008c"+
		"\u008d\7T\2\2\u008d\u00a1\7P\2\2\u008e\u008f\7K\2\2\u008f\u0090\7P\2\2"+
		"\u0090\u00a1\7V\2\2\u0091\u0092\7X\2\2\u0092\u0093\7Q\2\2\u0093\u0094"+
		"\7K\2\2\u0094\u00a1\7F\2\2\u0095\u0096\7U\2\2\u0096\u0097\7V\2\2\u0097"+
		"\u0098\7T\2\2\u0098\u0099\7K\2\2\u0099\u009a\7P\2\2\u009a\u00a1\7I\2\2"+
		"\u009b\u009c\7H\2\2\u009c\u009d\7N\2\2\u009d\u009e\7Q\2\2\u009e\u009f"+
		"\7C\2\2\u009f\u00a1\7V\2\2\u00a0C\3\2\2\2\u00a0J\3\2\2\2\u00a0O\3\2\2"+
		"\2\u00a0R\3\2\2\2\u00a0Z\3\2\2\2\u00a0^\3\2\2\2\u00a0c\3\2\2\2\u00a0e"+
		"\3\2\2\2\u00a0i\3\2\2\2\u00a0n\3\2\2\2\u00a0s\3\2\2\2\u00a0{\3\2\2\2\u00a0"+
		"\u0083\3\2\2\2\u00a0\u0088\3\2\2\2\u00a0\u008e\3\2\2\2\u00a0\u0091\3\2"+
		"\2\2\u00a0\u0095\3\2\2\2\u00a0\u009b\3\2\2\2\u00a1\26\3\2\2\2\u00a2\u00a3"+
		"\7<\2\2\u00a3\u00ad\7?\2\2\u00a4\u00ad\t\2\2\2\u00a5\u00a6\7#\2\2\u00a6"+
		"\u00ad\7?\2\2\u00a7\u00ad\t\3\2\2\u00a8\u00a9\7>\2\2\u00a9\u00ad\7?\2"+
		"\2\u00aa\u00ab\7@\2\2\u00ab\u00ad\7?\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a4"+
		"\3\2\2\2\u00ac\u00a5\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\30\3\2\2\2\u00ae\u00b2\t\4\2\2\u00af\u00b1\t\5\2"+
		"\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\32\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\t\6\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\34\3\2\2\2\u00ba\u00be\7$\2\2\u00bb\u00bd\13\2\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2\36\3\2\2\2"+
		"\u00c3\u00c5\t\6\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00cb\7\60\2\2\u00ca\u00cc\t\6\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3"+
		"\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce \3\2\2\2\u00cf\u00d0"+
		"\7/\2\2\u00d0\u00d1\7/\2\2\u00d1\u00d5\3\2\2\2\u00d2\u00d4\13\2\2\2\u00d3"+
		"\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d5\u00d3\3\2"+
		"\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7\f\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00db\b\21\2\2\u00db\"\3\2\2\2\u00dc\u00dd\t\7\2"+
		"\2\u00dd\u00de\3\2\2\2\u00de\u00df\b\22\2\2\u00df$\3\2\2\2\f\2\u00a0\u00ac"+
		"\u00b0\u00b2\u00b8\u00be\u00c6\u00cd\u00d5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}