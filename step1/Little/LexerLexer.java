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
public class LexerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INTEGER=2, STRING=3, COMMENTS=4, FLOAT=5, KEYWORDS=6, OPERATORS=7, 
		WHITESPACE=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "INTEGER", "STRING", "COMMENTS", "FLOAT", "KEYWORDS", "OPERATORS", 
		"WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'[a-Z]([a-Z]|[0-9])*'", "'[0-9]+'", "'(?<=\")[\\S\\s]*(?=\")'", 
		"'-{2}'", null, null, null, "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "INTEGER", "STRING", "COMMENTS", "FLOAT", "KEYWORDS", "OPERATORS", 
		"WHITESPACE"
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


	public LexerLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00c6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7\u00b5\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c1\n\b"+
		"\3\t\3\t\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\4\6\2,-"+
		"//\61\61??\6\2*+..=>@@\2\u00db\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2"+
		"\2\5\'\3\2\2\2\7.\3\2\2\2\tA\3\2\2\2\13H\3\2\2\2\r\u00b4\3\2\2\2\17\u00c0"+
		"\3\2\2\2\21\u00c2\3\2\2\2\23\24\7]\2\2\24\25\7c\2\2\25\26\7/\2\2\26\27"+
		"\7\\\2\2\27\30\7_\2\2\30\31\7*\2\2\31\32\7]\2\2\32\33\7c\2\2\33\34\7/"+
		"\2\2\34\35\7\\\2\2\35\36\7_\2\2\36\37\7~\2\2\37 \7]\2\2 !\7\62\2\2!\""+
		"\7/\2\2\"#\7;\2\2#$\7_\2\2$%\7+\2\2%&\7,\2\2&\4\3\2\2\2\'(\7]\2\2()\7"+
		"\62\2\2)*\7/\2\2*+\7;\2\2+,\7_\2\2,-\7-\2\2-\6\3\2\2\2./\7*\2\2/\60\7"+
		"A\2\2\60\61\7>\2\2\61\62\7?\2\2\62\63\7$\2\2\63\64\7+\2\2\64\65\7]\2\2"+
		"\65\66\7^\2\2\66\67\7U\2\2\678\7^\2\289\7u\2\29:\7_\2\2:;\7,\2\2;<\7*"+
		"\2\2<=\7A\2\2=>\7?\2\2>?\7$\2\2?@\7+\2\2@\b\3\2\2\2AB\7/\2\2BC\7}\2\2"+
		"CD\7\64\2\2DE\7\177\2\2EF\3\2\2\2FG\b\5\2\2G\n\3\2\2\2HI\7]\2\2IJ\7\62"+
		"\2\2JK\7/\2\2KL\7;\2\2LM\7_\2\2MN\7,\2\2NO\3\2\2\2OP\13\2\2\2PQ\7]\2\2"+
		"QR\7\62\2\2RS\7/\2\2ST\7;\2\2TU\7_\2\2UV\7-\2\2V\f\3\2\2\2WX\7R\2\2XY"+
		"\7T\2\2YZ\7Q\2\2Z[\7I\2\2[\\\7T\2\2\\]\7C\2\2]\u00b5\7O\2\2^_\7D\2\2_"+
		"`\7G\2\2`a\7I\2\2ab\7K\2\2b\u00b5\7P\2\2cd\7G\2\2de\7P\2\2e\u00b5\7F\2"+
		"\2fg\7H\2\2gh\7W\2\2hi\7P\2\2ij\7E\2\2jk\7V\2\2kl\7K\2\2lm\7Q\2\2m\u00b5"+
		"\7P\2\2no\7T\2\2op\7G\2\2pq\7C\2\2q\u00b5\7F\2\2rs\7Y\2\2st\7T\2\2tu\7"+
		"K\2\2uv\7V\2\2v\u00b5\7G\2\2wx\7K\2\2x\u00b5\7H\2\2yz\7G\2\2z{\7N\2\2"+
		"{|\7U\2\2|\u00b5\7G\2\2}~\7G\2\2~\177\7P\2\2\177\u0080\7F\2\2\u0080\u0081"+
		"\7K\2\2\u0081\u00b5\7H\2\2\u0082\u0083\7Y\2\2\u0083\u0084\7J\2\2\u0084"+
		"\u0085\7K\2\2\u0085\u0086\7N\2\2\u0086\u00b5\7G\2\2\u0087\u0088\7G\2\2"+
		"\u0088\u0089\7P\2\2\u0089\u008a\7F\2\2\u008a\u008b\7Y\2\2\u008b\u008c"+
		"\7J\2\2\u008c\u008d\7K\2\2\u008d\u008e\7N\2\2\u008e\u00b5\7G\2\2\u008f"+
		"\u0090\7E\2\2\u0090\u0091\7Q\2\2\u0091\u0092\7P\2\2\u0092\u0093\7V\2\2"+
		"\u0093\u0094\7K\2\2\u0094\u0095\7P\2\2\u0095\u0096\7W\2\2\u0096\u00b5"+
		"\7G\2\2\u0097\u0098\7D\2\2\u0098\u0099\7T\2\2\u0099\u009a\7G\2\2\u009a"+
		"\u009b\7C\2\2\u009b\u00b5\7M\2\2\u009c\u009d\7T\2\2\u009d\u009e\7G\2\2"+
		"\u009e\u009f\7V\2\2\u009f\u00a0\7W\2\2\u00a0\u00a1\7T\2\2\u00a1\u00b5"+
		"\7P\2\2\u00a2\u00a3\7K\2\2\u00a3\u00a4\7P\2\2\u00a4\u00b5\7V\2\2\u00a5"+
		"\u00a6\7X\2\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8\7K\2\2\u00a8\u00b5\7F\2\2"+
		"\u00a9\u00aa\7U\2\2\u00aa\u00ab\7V\2\2\u00ab\u00ac\7T\2\2\u00ac\u00ad"+
		"\7K\2\2\u00ad\u00ae\7P\2\2\u00ae\u00b5\7I\2\2\u00af\u00b0\7H\2\2\u00b0"+
		"\u00b1\7N\2\2\u00b1\u00b2\7Q\2\2\u00b2\u00b3\7C\2\2\u00b3\u00b5\7V\2\2"+
		"\u00b4W\3\2\2\2\u00b4^\3\2\2\2\u00b4c\3\2\2\2\u00b4f\3\2\2\2\u00b4n\3"+
		"\2\2\2\u00b4r\3\2\2\2\u00b4w\3\2\2\2\u00b4y\3\2\2\2\u00b4}\3\2\2\2\u00b4"+
		"\u0082\3\2\2\2\u00b4\u0087\3\2\2\2\u00b4\u008f\3\2\2\2\u00b4\u0097\3\2"+
		"\2\2\u00b4\u009c\3\2\2\2\u00b4\u00a2\3\2\2\2\u00b4\u00a5\3\2\2\2\u00b4"+
		"\u00a9\3\2\2\2\u00b4\u00af\3\2\2\2\u00b5\16\3\2\2\2\u00b6\u00b7\7<\2\2"+
		"\u00b7\u00c1\7?\2\2\u00b8\u00c1\t\2\2\2\u00b9\u00ba\7#\2\2\u00ba\u00c1"+
		"\7?\2\2\u00bb\u00c1\t\3\2\2\u00bc\u00bd\7>\2\2\u00bd\u00c1\7?\2\2\u00be"+
		"\u00bf\7@\2\2\u00bf\u00c1\7?\2\2\u00c0\u00b6\3\2\2\2\u00c0\u00b8\3\2\2"+
		"\2\u00c0\u00b9\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\20\3\2\2\2\u00c2\u00c3\7\"\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\b\t\2\2\u00c5\22\3\2\2\2\5\2\u00b4\u00c0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}