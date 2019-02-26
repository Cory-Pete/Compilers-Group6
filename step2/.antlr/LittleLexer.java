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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00e1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00a2\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00ae\n\r\3\16\3\16\7\16\u00b2\n\16\f\16\16\16\u00b5\13\16\3\17"+
		"\6\17\u00b8\n\17\r\17\16\17\u00b9\3\20\3\20\7\20\u00be\n\20\f\20\16\20"+
		"\u00c1\13\20\3\20\3\20\3\21\7\21\u00c6\n\21\f\21\16\21\u00c9\13\21\3\21"+
		"\3\21\6\21\u00cd\n\21\r\21\16\21\u00ce\3\22\3\22\3\22\3\22\7\22\u00d5"+
		"\n\22\f\22\16\22\u00d8\13\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\4"+
		"\u00bf\u00d6\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\3\2\b\6\2,-//\61\61??\6\2*+..=>@@\3"+
		"\2C|\4\2\62;C|\3\2\62;\4\2\13\f\"\"\2\u00fb\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2"+
		"\2\5-\3\2\2\2\7\60\3\2\2\2\t\66\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17@\3\2"+
		"\2\2\21B\3\2\2\2\23E\3\2\2\2\25H\3\2\2\2\27\u00a1\3\2\2\2\31\u00ad\3\2"+
		"\2\2\33\u00af\3\2\2\2\35\u00b7\3\2\2\2\37\u00bb\3\2\2\2!\u00c7\3\2\2\2"+
		"#\u00d0\3\2\2\2%\u00dd\3\2\2\2\'(\7g\2\2()\7o\2\2)*\7r\2\2*+\7v\2\2+,"+
		"\7{\2\2,\4\3\2\2\2-.\7<\2\2./\7?\2\2/\6\3\2\2\2\60\61\7-\2\2\61\62\7\""+
		"\2\2\62\63\7~\2\2\63\64\7\"\2\2\64\65\7/\2\2\65\b\3\2\2\2\66\67\7,\2\2"+
		"\678\7\"\2\289\7~\2\29:\7\"\2\2:;\7\61\2\2;\n\3\2\2\2<=\7>\2\2=\f\3\2"+
		"\2\2>?\7@\2\2?\16\3\2\2\2@A\7?\2\2A\20\3\2\2\2BC\7#\2\2CD\7?\2\2D\22\3"+
		"\2\2\2EF\7>\2\2FG\7?\2\2G\24\3\2\2\2HI\7@\2\2IJ\7?\2\2J\26\3\2\2\2KL\7"+
		"D\2\2LM\7G\2\2MN\7I\2\2NO\7K\2\2O\u00a2\7P\2\2PQ\7G\2\2QR\7P\2\2R\u00a2"+
		"\7F\2\2ST\7H\2\2TU\7W\2\2UV\7P\2\2VW\7E\2\2WX\7V\2\2XY\7K\2\2YZ\7Q\2\2"+
		"Z\u00a2\7P\2\2[\\\7T\2\2\\]\7G\2\2]^\7C\2\2^\u00a2\7F\2\2_`\7Y\2\2`a\7"+
		"T\2\2ab\7K\2\2bc\7V\2\2c\u00a2\7G\2\2de\7K\2\2e\u00a2\7H\2\2fg\7G\2\2"+
		"gh\7N\2\2hi\7U\2\2i\u00a2\7G\2\2jk\7G\2\2kl\7P\2\2lm\7F\2\2mn\7K\2\2n"+
		"\u00a2\7H\2\2op\7Y\2\2pq\7J\2\2qr\7K\2\2rs\7N\2\2s\u00a2\7G\2\2tu\7G\2"+
		"\2uv\7P\2\2vw\7F\2\2wx\7Y\2\2xy\7J\2\2yz\7K\2\2z{\7N\2\2{\u00a2\7G\2\2"+
		"|}\7E\2\2}~\7Q\2\2~\177\7P\2\2\177\u0080\7V\2\2\u0080\u0081\7K\2\2\u0081"+
		"\u0082\7P\2\2\u0082\u0083\7W\2\2\u0083\u00a2\7G\2\2\u0084\u0085\7D\2\2"+
		"\u0085\u0086\7T\2\2\u0086\u0087\7G\2\2\u0087\u0088\7C\2\2\u0088\u00a2"+
		"\7M\2\2\u0089\u008a\7T\2\2\u008a\u008b\7G\2\2\u008b\u008c\7V\2\2\u008c"+
		"\u008d\7W\2\2\u008d\u008e\7T\2\2\u008e\u00a2\7P\2\2\u008f\u0090\7K\2\2"+
		"\u0090\u0091\7P\2\2\u0091\u00a2\7V\2\2\u0092\u0093\7X\2\2\u0093\u0094"+
		"\7Q\2\2\u0094\u0095\7K\2\2\u0095\u00a2\7F\2\2\u0096\u0097\7U\2\2\u0097"+
		"\u0098\7V\2\2\u0098\u0099\7T\2\2\u0099\u009a\7K\2\2\u009a\u009b\7P\2\2"+
		"\u009b\u00a2\7I\2\2\u009c\u009d\7H\2\2\u009d\u009e\7N\2\2\u009e\u009f"+
		"\7Q\2\2\u009f\u00a0\7C\2\2\u00a0\u00a2\7V\2\2\u00a1K\3\2\2\2\u00a1P\3"+
		"\2\2\2\u00a1S\3\2\2\2\u00a1[\3\2\2\2\u00a1_\3\2\2\2\u00a1d\3\2\2\2\u00a1"+
		"f\3\2\2\2\u00a1j\3\2\2\2\u00a1o\3\2\2\2\u00a1t\3\2\2\2\u00a1|\3\2\2\2"+
		"\u00a1\u0084\3\2\2\2\u00a1\u0089\3\2\2\2\u00a1\u008f\3\2\2\2\u00a1\u0092"+
		"\3\2\2\2\u00a1\u0096\3\2\2\2\u00a1\u009c\3\2\2\2\u00a2\30\3\2\2\2\u00a3"+
		"\u00a4\7<\2\2\u00a4\u00ae\7?\2\2\u00a5\u00ae\t\2\2\2\u00a6\u00a7\7#\2"+
		"\2\u00a7\u00ae\7?\2\2\u00a8\u00ae\t\3\2\2\u00a9\u00aa\7>\2\2\u00aa\u00ae"+
		"\7?\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ae\7?\2\2\u00ad\u00a3\3\2\2\2\u00ad"+
		"\u00a5\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ad\u00a9\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ae\32\3\2\2\2\u00af\u00b3\t\4\2\2\u00b0\u00b2"+
		"\t\5\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\34\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\t\6\2"+
		"\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\36\3\2\2\2\u00bb\u00bf\7$\2\2\u00bc\u00be\13\2\2\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3"+
		" \3\2\2\2\u00c4\u00c6\t\6\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cc\7\60\2\2\u00cb\u00cd\t\6\2\2\u00cc\u00cb\3\2\2\2"+
		"\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\"\3"+
		"\2\2\2\u00d0\u00d1\7/\2\2\u00d1\u00d2\7/\2\2\u00d2\u00d6\3\2\2\2\u00d3"+
		"\u00d5\13\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d7\3"+
		"\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00da\7\f\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\22\2\2\u00dc$\3\2\2\2"+
		"\u00dd\u00de\t\7\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b\23\2\2\u00e0&\3"+
		"\2\2\2\f\2\u00a1\u00ad\u00b1\u00b3\u00b9\u00bf\u00c7\u00ce\u00d6\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}