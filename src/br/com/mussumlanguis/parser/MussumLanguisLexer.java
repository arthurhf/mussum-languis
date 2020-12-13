// Generated from MussumLanguis.g4 by ANTLR 4.7.1
package br.com.mussumlanguis.parser;

import br.com.mussumlanguis.datastructures.MussumSymbol;
import br.com.mussumlanguis.datastructures.MussumSymbolTable;
import br.com.mussumlanguis.datastructures.MussumVariable;
import br.com.mussumlanguis.exceptions.MussumSemanticException;
import br.com.mussumlanguis.ast.MussumProgram;
import br.com.mussumlanguis.ast.AbstractCommand;
import br.com.mussumlanguis.ast.ReadCommand;
import br.com.mussumlanguis.ast.WriteCommand;
import br.com.mussumlanguis.ast.AttrCommand;
import br.com.mussumlanguis.ast.DecisionCommand;
import br.com.mussumlanguis.ast.WhileCommand;
import br.com.mussumlanguis.ast.ForCommand;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class MussumLanguisLexer extends Lexer {
	static {
		RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, INT = 5, DOUBLE = 6, STRING = 7, BOOLEAN = 8,
			L_PAREN = 9, R_PAREN = 10, SC = 11, OP = 12, OP_CHANGE = 13, ATTR = 14, IF = 15, ELSE = 16, FOR = 17,
			WHILE = 18, L_CURL = 19, R_CURL = 20, COMMA = 21, OPREL = 22, ID = 23, NUMBER = 24, WS = 25;
	public static String[] channelNames = { "DEFAULT_TOKEN_CHANNEL", "HIDDEN" };

	public static String[] modeNames = { "DEFAULT_MODE" };

	public static final String[] ruleNames = { "T__0", "T__1", "T__2", "T__3", "INT", "DOUBLE", "STRING", "BOOLEAN",
			"L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", "IF", "ELSE", "FOR", "WHILE", "L_CURL", "R_CURL",
			"COMMA", "OPREL", "ID", "NUMBER", "WS" };

	private static final String[] _LITERAL_NAMES = { null, "'programis'", "'cacildis;'", "'inputis'", "'escrevis'",
			"'inteiris'", "'quebradis'", null, "'booleanis'", "'('", "')'", "';'", null, null, "'='", "'se'",
			"'sen\u00E3ozis'", "'paris'", "'enquantis'", "'{'", "'}'", "','" };
	private static final String[] _SYMBOLIC_NAMES = { null, null, null, null, null, "INT", "DOUBLE", "STRING",
			"BOOLEAN", "L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", "IF", "ELSE", "FOR", "WHILE", "L_CURL",
			"R_CURL", "COMMA", "OPREL", "ID", "NUMBER", "WS" };
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

	private int _type;
	private String _varName;
	private String _varValue;
	private MussumSymbolTable symbolTable = new MussumSymbolTable();
	private MussumSymbol symbol;
	private MussumProgram program = new MussumProgram();
	private ArrayList<AbstractCommand> currThread = new ArrayList<AbstractCommand>();
	private Stack<ArrayList<AbstractCommand>> commandStack = new Stack<ArrayList<AbstractCommand>>();

	private String _readId;

	private String _writeId;

	private String _exprId;
	private String _exprContent;

	private String _exprDecision;
	private ArrayList<AbstractCommand> trueList;
	private ArrayList<AbstractCommand> falseList;

	private String _attrVariable;
	private String _attrValue;

	private String _exprWhile;
	private String _exprFor;
	private ArrayList<AbstractCommand> commandList;

	public void verifyID() {
		String id = ((TokenStream) _input).LT(-1).getText();

		if (!symbolTable.exists(id)) {
			throw new MussumSemanticException("Symbol " + id + " not declared");
		}
	}

	public void addSymbol() {
		_varName = ((TokenStream) _input).LT(-1).getText();
		_varValue = null;
		symbol = new MussumVariable(_varName, _type, _varValue);

		if (!symbolTable.exists(_varName)) {
			System.out.println("Simbolo adicionado: " + symbol);
			symbolTable.add(symbol);
		} else {
			throw new MussumSemanticException("Symbol " + _varName + " already declared");
		}
	}

	public void checkVariableUsage() {
		for (String i : symbolTable.keySet()) {
			if (((MussumVariable) symbolTable.get(i)).getValue() == null) {

				Logger logger = Logger.getLogger(MussumLanguisParser.class.getName());

				// Set Logger level()
				logger.setLevel(Level.WARNING);

				// Call warning method
				logger.warning("Variable " + i + " was never used");
			}
		}
	}

	public void verifyAssignment() {
		_varName = ((TokenStream) _input).LT(-1).getText();
		if (((MussumVariable) symbolTable.get(_varName)).getValue() == null) {
			System.out.println("Variable " + _varName + " wasn't assigned");
		}
	}

	public void assignValue() {
		// função pra passar o valor da atribuição pra variável no hashmap
		((MussumVariable) symbolTable.get(_attrVariable)).setValue(_attrValue);
		System.out.println("Simbolo atualizado: " + symbolTable.get(_attrVariable));
	}

	public void showCommands() {
		for (AbstractCommand cmd : program.getCommands()) {
			System.out.println(cmd);
		}
	}

	public void generateCode() {
		program.generateTarget();
	}

	public MussumLanguisLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String getGrammarFileName() {
		return "MussumLanguis.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public String[] getChannelNames() {
		return channelNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00dd\b\1\4\2"
			+ "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"
			+ "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"
			+ "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"
			+ "\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"
			+ "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"
			+ "\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"
			+ "\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"
			+ "\3\b\3\b\3\b\3\b\3\b\5\b}\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"
			+ "\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u0095\n\16"
			+ "\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"
			+ "\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"
			+ "\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"
			+ "\3\27\3\27\3\27\5\27\u00c4\n\27\3\30\3\30\7\30\u00c8\n\30\f\30\16\30\u00cb"
			+ "\13\30\3\31\6\31\u00ce\n\31\r\31\16\31\u00cf\3\31\3\31\6\31\u00d4\n\31"
			+ "\r\31\16\31\u00d5\5\31\u00d8\n\31\3\32\3\32\3\32\3\32\2\2\33\3\3\5\4\7"
			+ "\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"
			+ "#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\b\5\2,-//\61\61\4\2>>@@"
			+ "\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00e6\2\3\3\2\2\2\2\5"
			+ "\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"
			+ "\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"
			+ "\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"
			+ "\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"
			+ "\63\3\2\2\2\3\65\3\2\2\2\5?\3\2\2\2\7I\3\2\2\2\tQ\3\2\2\2\13Z\3\2\2\2"
			+ "\rc\3\2\2\2\17|\3\2\2\2\21~\3\2\2\2\23\u0088\3\2\2\2\25\u008a\3\2\2\2"
			+ "\27\u008c\3\2\2\2\31\u008e\3\2\2\2\33\u0094\3\2\2\2\35\u0096\3\2\2\2\37"
			+ "\u0098\3\2\2\2!\u009b\3\2\2\2#\u00a4\3\2\2\2%\u00aa\3\2\2\2\'\u00b4\3"
			+ "\2\2\2)\u00b6\3\2\2\2+\u00b8\3\2\2\2-\u00c3\3\2\2\2/\u00c5\3\2\2\2\61"
			+ "\u00cd\3\2\2\2\63\u00d9\3\2\2\2\65\66\7r\2\2\66\67\7t\2\2\678\7q\2\28"
			+ "9\7i\2\29:\7t\2\2:;\7c\2\2;<\7o\2\2<=\7k\2\2=>\7u\2\2>\4\3\2\2\2?@\7e"
			+ "\2\2@A\7c\2\2AB\7e\2\2BC\7k\2\2CD\7n\2\2DE\7f\2\2EF\7k\2\2FG\7u\2\2GH"
			+ "\7=\2\2H\6\3\2\2\2IJ\7k\2\2JK\7p\2\2KL\7r\2\2LM\7w\2\2MN\7v\2\2NO\7k\2"
			+ "\2OP\7u\2\2P\b\3\2\2\2QR\7g\2\2RS\7u\2\2ST\7e\2\2TU\7t\2\2UV\7g\2\2VW"
			+ "\7x\2\2WX\7k\2\2XY\7u\2\2Y\n\3\2\2\2Z[\7k\2\2[\\\7p\2\2\\]\7v\2\2]^\7"
			+ "g\2\2^_\7k\2\2_`\7t\2\2`a\7k\2\2ab\7u\2\2b\f\3\2\2\2cd\7s\2\2de\7w\2\2"
			+ "ef\7g\2\2fg\7d\2\2gh\7t\2\2hi\7c\2\2ij\7f\2\2jk\7k\2\2kl\7u\2\2l\16\3"
			+ "\2\2\2mn\7v\2\2no\7g\2\2op\7z\2\2pq\7v\2\2qr\7k\2\2r}\7u\2\2st\7u\2\2"
			+ "tu\7v\2\2uv\7t\2\2vw\7k\2\2wx\7p\2\2xy\7i\2\2yz\7w\2\2z{\7k\2\2{}\7u\2"
			+ "\2|m\3\2\2\2|s\3\2\2\2}\20\3\2\2\2~\177\7d\2\2\177\u0080\7q\2\2\u0080"
			+ "\u0081\7q\2\2\u0081\u0082\7n\2\2\u0082\u0083\7g\2\2\u0083\u0084\7c\2\2"
			+ "\u0084\u0085\7p\2\2\u0085\u0086\7k\2\2\u0086\u0087\7u\2\2\u0087\22\3\2"
			+ "\2\2\u0088\u0089\7*\2\2\u0089\24\3\2\2\2\u008a\u008b\7+\2\2\u008b\26\3"
			+ "\2\2\2\u008c\u008d\7=\2\2\u008d\30\3\2\2\2\u008e\u008f\t\2\2\2\u008f\32"
			+ "\3\2\2\2\u0090\u0091\7-\2\2\u0091\u0095\7-\2\2\u0092\u0093\7/\2\2\u0093"
			+ "\u0095\7/\2\2\u0094\u0090\3\2\2\2\u0094\u0092\3\2\2\2\u0095\34\3\2\2\2"
			+ "\u0096\u0097\7?\2\2\u0097\36\3\2\2\2\u0098\u0099\7u\2\2\u0099\u009a\7"
			+ "g\2\2\u009a \3\2\2\2\u009b\u009c\7u\2\2\u009c\u009d\7g\2\2\u009d\u009e"
			+ "\7p\2\2\u009e\u009f\7\u00e5\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7|\2\2"
			+ "\u00a1\u00a2\7k\2\2\u00a2\u00a3\7u\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7r"
			+ "\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9"
			+ "\7u\2\2\u00a9$\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad"
			+ "\7s\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7p\2\2\u00b0"
			+ "\u00b1\7v\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7u\2\2\u00b3&\3\2\2\2\u00b4"
			+ "\u00b5\7}\2\2\u00b5(\3\2\2\2\u00b6\u00b7\7\177\2\2\u00b7*\3\2\2\2\u00b8"
			+ "\u00b9\7.\2\2\u00b9,\3\2\2\2\u00ba\u00c4\t\3\2\2\u00bb\u00bc\7@\2\2\u00bc"
			+ "\u00c4\7?\2\2\u00bd\u00be\7>\2\2\u00be\u00c4\7?\2\2\u00bf\u00c0\7?\2\2"
			+ "\u00c0\u00c4\7?\2\2\u00c1\u00c2\7#\2\2\u00c2\u00c4\7?\2\2\u00c3\u00ba"
			+ "\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c3"
			+ "\u00c1\3\2\2\2\u00c4.\3\2\2\2\u00c5\u00c9\t\4\2\2\u00c6\u00c8\t\5\2\2"
			+ "\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"
			+ "\3\2\2\2\u00ca\60\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00ce\t\6\2\2\u00cd"
			+ "\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"
			+ "\2\2\u00d0\u00d7\3\2\2\2\u00d1\u00d3\7\60\2\2\u00d2\u00d4\t\6\2\2\u00d3"
			+ "\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"
			+ "\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"
			+ "\62\3\2\2\2\u00d9\u00da\t\7\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\32\2"
			+ "\2\u00dc\64\3\2\2\2\13\2|\u0094\u00c3\u00c7\u00c9\u00cf\u00d5\u00d7\3" + "\b\2\2";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}