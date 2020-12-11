// Generated from MussumLanguis.g4 by ANTLR 4.7.1
package br.com.mussumlanguis.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MussumLanguisLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, FOR=15, LCURL=16, RCURL=17, VIR=18, 
		OPREL=19, ID=20, NUMBER=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"AP", "FP", "SC", "OP", "ATTR", "FOR", "LCURL", "RCURL", "VIR", "OPREL", 
		"ID", "NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'numeris'", "'textis'", "'++'", "'--'", 
		"'-'", "'inputis'", "'escrevis'", "'('", "')'", "';'", null, "'='", "'paris'", 
		"'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
		"SC", "OP", "ATTR", "FOR", "LCURL", "RCURL", "VIR", "OPREL", "ID", "NUMBER", 
		"WS"
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


	public MussumLanguisLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MussumLanguis.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00a4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u008b\n\24\3\25\3\25\7\25\u008f\n\25"+
		"\f\25\16\25\u0092\13\25\3\26\6\26\u0095\n\26\r\26\16\26\u0096\3\26\3\26"+
		"\6\26\u009b\n\26\r\26\16\26\u009c\5\26\u009f\n\26\3\27\3\27\3\27\3\27"+
		"\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\b\5\2,-//\61\61\4\2>>@@"+
		"\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00ab\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\59\3\2\2\2\7C\3"+
		"\2\2\2\tK\3\2\2\2\13R\3\2\2\2\rU\3\2\2\2\17X\3\2\2\2\21Z\3\2\2\2\23b\3"+
		"\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37"+
		"u\3\2\2\2!{\3\2\2\2#}\3\2\2\2%\177\3\2\2\2\'\u008a\3\2\2\2)\u008c\3\2"+
		"\2\2+\u0094\3\2\2\2-\u00a0\3\2\2\2/\60\7r\2\2\60\61\7t\2\2\61\62\7q\2"+
		"\2\62\63\7i\2\2\63\64\7t\2\2\64\65\7c\2\2\65\66\7o\2\2\66\67\7k\2\2\67"+
		"8\7u\2\28\4\3\2\2\29:\7e\2\2:;\7c\2\2;<\7e\2\2<=\7k\2\2=>\7n\2\2>?\7f"+
		"\2\2?@\7k\2\2@A\7u\2\2AB\7=\2\2B\6\3\2\2\2CD\7p\2\2DE\7w\2\2EF\7o\2\2"+
		"FG\7g\2\2GH\7t\2\2HI\7k\2\2IJ\7u\2\2J\b\3\2\2\2KL\7v\2\2LM\7g\2\2MN\7"+
		"z\2\2NO\7v\2\2OP\7k\2\2PQ\7u\2\2Q\n\3\2\2\2RS\7-\2\2ST\7-\2\2T\f\3\2\2"+
		"\2UV\7/\2\2VW\7/\2\2W\16\3\2\2\2XY\7/\2\2Y\20\3\2\2\2Z[\7k\2\2[\\\7p\2"+
		"\2\\]\7r\2\2]^\7w\2\2^_\7v\2\2_`\7k\2\2`a\7u\2\2a\22\3\2\2\2bc\7g\2\2"+
		"cd\7u\2\2de\7e\2\2ef\7t\2\2fg\7g\2\2gh\7x\2\2hi\7k\2\2ij\7u\2\2j\24\3"+
		"\2\2\2kl\7*\2\2l\26\3\2\2\2mn\7+\2\2n\30\3\2\2\2op\7=\2\2p\32\3\2\2\2"+
		"qr\t\2\2\2r\34\3\2\2\2st\7?\2\2t\36\3\2\2\2uv\7r\2\2vw\7c\2\2wx\7t\2\2"+
		"xy\7k\2\2yz\7u\2\2z \3\2\2\2{|\7}\2\2|\"\3\2\2\2}~\7\177\2\2~$\3\2\2\2"+
		"\177\u0080\7.\2\2\u0080&\3\2\2\2\u0081\u008b\t\3\2\2\u0082\u0083\7@\2"+
		"\2\u0083\u008b\7?\2\2\u0084\u0085\7>\2\2\u0085\u008b\7?\2\2\u0086\u0087"+
		"\7?\2\2\u0087\u008b\7?\2\2\u0088\u0089\7#\2\2\u0089\u008b\7?\2\2\u008a"+
		"\u0081\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0086\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008b(\3\2\2\2\u008c\u0090\t\4\2\2\u008d\u008f"+
		"\t\5\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091*\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\t\6\2\2"+
		"\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u009e\3\2\2\2\u0098\u009a\7\60\2\2\u0099\u009b\t\6\2\2"+
		"\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		",\3\2\2\2\u00a0\u00a1\t\7\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\27\2\2"+
		"\u00a3.\3\2\2\2\t\2\u008a\u008e\u0090\u0096\u009c\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}