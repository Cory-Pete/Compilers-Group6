// Generated from Little.g4 by ANTLR 4.7.1
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
		IDENTIFIER=1, INTEGER=2, STRING=3, COMMENTS=4, FLOAT=5, KEYWORDS=6, OPERATORS=7, 
		WHITESPACE=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IDENTIFIER", "INTEGER", "STRING", "COMMENTS", "FLOAT", "KEYWORDS", "OPERATORS", 
		"WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'[a-Z]+ ([a-Z]|[0-9])*'", "'[0-9]+'", "'(?<=\")[\\S\\s]*(?=\")'", 
		null, null, null, null, "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IDENTIFIER", "INTEGER", "STRING", "COMMENTS", "FLOAT", "KEYWORDS", 
		"OPERATORS", "WHITESPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00ce\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5H\n\5\f\5"+
		"\16\5K\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00bd\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c9\n\b\3\t\3\t\3\t\3\t\3I\2\n\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\3\2\4\6\2,-//\61\61??\6\2*+..=>@@\2\u00e4"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5)\3\2\2\2\7\60\3\2\2\2\t"+
		"C\3\2\2\2\13P\3\2\2\2\r\u00bc\3\2\2\2\17\u00c8\3\2\2\2\21\u00ca\3\2\2"+
		"\2\23\24\7]\2\2\24\25\7c\2\2\25\26\7/\2\2\26\27\7\\\2\2\27\30\7_\2\2\30"+
		"\31\7-\2\2\31\32\7\"\2\2\32\33\7*\2\2\33\34\7]\2\2\34\35\7c\2\2\35\36"+
		"\7/\2\2\36\37\7\\\2\2\37 \7_\2\2 !\7~\2\2!\"\7]\2\2\"#\7\62\2\2#$\7/\2"+
		"\2$%\7;\2\2%&\7_\2\2&\'\7+\2\2\'(\7,\2\2(\4\3\2\2\2)*\7]\2\2*+\7\62\2"+
		"\2+,\7/\2\2,-\7;\2\2-.\7_\2\2./\7-\2\2/\6\3\2\2\2\60\61\7*\2\2\61\62\7"+
		"A\2\2\62\63\7>\2\2\63\64\7?\2\2\64\65\7$\2\2\65\66\7+\2\2\66\67\7]\2\2"+
		"\678\7^\2\289\7U\2\29:\7^\2\2:;\7u\2\2;<\7_\2\2<=\7,\2\2=>\7*\2\2>?\7"+
		"A\2\2?@\7?\2\2@A\7$\2\2AB\7+\2\2B\b\3\2\2\2CD\7/\2\2DE\7/\2\2EI\3\2\2"+
		"\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ\3\2\2\2IG\3\2\2\2JL\3\2\2\2KI\3\2"+
		"\2\2LM\7\f\2\2MN\3\2\2\2NO\b\5\2\2O\n\3\2\2\2PQ\7]\2\2QR\7\62\2\2RS\7"+
		"/\2\2ST\7;\2\2TU\7_\2\2UV\7,\2\2VW\3\2\2\2WX\13\2\2\2XY\7]\2\2YZ\7\62"+
		"\2\2Z[\7/\2\2[\\\7;\2\2\\]\7_\2\2]^\7-\2\2^\f\3\2\2\2_`\7R\2\2`a\7T\2"+
		"\2ab\7Q\2\2bc\7I\2\2cd\7T\2\2de\7C\2\2e\u00bd\7O\2\2fg\7D\2\2gh\7G\2\2"+
		"hi\7I\2\2ij\7K\2\2j\u00bd\7P\2\2kl\7G\2\2lm\7P\2\2m\u00bd\7F\2\2no\7H"+
		"\2\2op\7W\2\2pq\7P\2\2qr\7E\2\2rs\7V\2\2st\7K\2\2tu\7Q\2\2u\u00bd\7P\2"+
		"\2vw\7T\2\2wx\7G\2\2xy\7C\2\2y\u00bd\7F\2\2z{\7Y\2\2{|\7T\2\2|}\7K\2\2"+
		"}~\7V\2\2~\u00bd\7G\2\2\177\u0080\7K\2\2\u0080\u00bd\7H\2\2\u0081\u0082"+
		"\7G\2\2\u0082\u0083\7N\2\2\u0083\u0084\7U\2\2\u0084\u00bd\7G\2\2\u0085"+
		"\u0086\7G\2\2\u0086\u0087\7P\2\2\u0087\u0088\7F\2\2\u0088\u0089\7K\2\2"+
		"\u0089\u00bd\7H\2\2\u008a\u008b\7Y\2\2\u008b\u008c\7J\2\2\u008c\u008d"+
		"\7K\2\2\u008d\u008e\7N\2\2\u008e\u00bd\7G\2\2\u008f\u0090\7G\2\2\u0090"+
		"\u0091\7P\2\2\u0091\u0092\7F\2\2\u0092\u0093\7Y\2\2\u0093\u0094\7J\2\2"+
		"\u0094\u0095\7K\2\2\u0095\u0096\7N\2\2\u0096\u00bd\7G\2\2\u0097\u0098"+
		"\7E\2\2\u0098\u0099\7Q\2\2\u0099\u009a\7P\2\2\u009a\u009b\7V\2\2\u009b"+
		"\u009c\7K\2\2\u009c\u009d\7P\2\2\u009d\u009e\7W\2\2\u009e\u00bd\7G\2\2"+
		"\u009f\u00a0\7D\2\2\u00a0\u00a1\7T\2\2\u00a1\u00a2\7G\2\2\u00a2\u00a3"+
		"\7C\2\2\u00a3\u00bd\7M\2\2\u00a4\u00a5\7T\2\2\u00a5\u00a6\7G\2\2\u00a6"+
		"\u00a7\7V\2\2\u00a7\u00a8\7W\2\2\u00a8\u00a9\7T\2\2\u00a9\u00bd\7P\2\2"+
		"\u00aa\u00ab\7K\2\2\u00ab\u00ac\7P\2\2\u00ac\u00bd\7V\2\2\u00ad\u00ae"+
		"\7X\2\2\u00ae\u00af\7Q\2\2\u00af\u00b0\7K\2\2\u00b0\u00bd\7F\2\2\u00b1"+
		"\u00b2\7U\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4\7T\2\2\u00b4\u00b5\7K\2\2"+
		"\u00b5\u00b6\7P\2\2\u00b6\u00bd\7I\2\2\u00b7\u00b8\7H\2\2\u00b8\u00b9"+
		"\7N\2\2\u00b9\u00ba\7Q\2\2\u00ba\u00bb\7C\2\2\u00bb\u00bd\7V\2\2\u00bc"+
		"_\3\2\2\2\u00bcf\3\2\2\2\u00bck\3\2\2\2\u00bcn\3\2\2\2\u00bcv\3\2\2\2"+
		"\u00bcz\3\2\2\2\u00bc\177\3\2\2\2\u00bc\u0081\3\2\2\2\u00bc\u0085\3\2"+
		"\2\2\u00bc\u008a\3\2\2\2\u00bc\u008f\3\2\2\2\u00bc\u0097\3\2\2\2\u00bc"+
		"\u009f\3\2\2\2\u00bc\u00a4\3\2\2\2\u00bc\u00aa\3\2\2\2\u00bc\u00ad\3\2"+
		"\2\2\u00bc\u00b1\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bd\16\3\2\2\2\u00be\u00bf"+
		"\7<\2\2\u00bf\u00c9\7?\2\2\u00c0\u00c9\t\2\2\2\u00c1\u00c2\7#\2\2\u00c2"+
		"\u00c9\7?\2\2\u00c3\u00c9\t\3\2\2\u00c4\u00c5\7>\2\2\u00c5\u00c9\7?\2"+
		"\2\u00c6\u00c7\7@\2\2\u00c7\u00c9\7?\2\2\u00c8\u00be\3\2\2\2\u00c8\u00c0"+
		"\3\2\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c9\20\3\2\2\2\u00ca\u00cb\7\"\2\2\u00cb\u00cc\3\2\2"+
		"\2\u00cc\u00cd\b\t\2\2\u00cd\22\3\2\2\2\6\2I\u00bc\u00c8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}