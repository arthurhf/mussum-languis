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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MussumLanguisLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		L_PAREN=10, R_PAREN=11, SC=12, OP=13, ATTR=14, IF=15, ELSE=16, FOR=17, 
		WHILE=18, L_CURL=19, R_CURL=20, COMMA=21, OPREL=22, ID=23, NUMBER=24, 
		WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"L_PAREN", "R_PAREN", "SC", "OP", "ATTR", "IF", "ELSE", "FOR", "WHILE", 
		"L_CURL", "R_CURL", "COMMA", "OPREL", "ID", "NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'numeris'", "'textis'", "'++'", "'--'", 
		"'-'", "'inputis'", "'escrevis'", "'('", "')'", "';'", null, "'='", "'se'", 
		"'sen\u00E3ozis'", "'paris'", "'enquantis'", "'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "L_PAREN", 
		"R_PAREN", "SC", "OP", "ATTR", "IF", "ELSE", "FOR", "WHILE", "L_CURL", 
		"R_CURL", "COMMA", "OPREL", "ID", "NUMBER", "WS"
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
		
		public void checkVariableUsage(){
	 		for (String i : symbolTable.keySet()) {
	 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
	 				
	 				Logger logger  = Logger.getLogger(MussumLanguisParser.class.getName()); 
	  
	        		// Set Logger level() 
	        		logger.setLevel(Level.FINEST);
	  
	        		// Call warning method 
	        		logger.warning("Variable " + i + " was never used"); 
	 			}
			}
	 	}
	 	
	 	public void verifyAssignment(){
	 		_varName = ((TokenStream) _input).LT(-1).getText();
	 		if(((MussumVariable) symbolTable.get(_varName)).getValue() == null){
	 				System.out.println("Variable " + _varName + " wasn't assigned");
	 		}
	 	}
	 	
	 	public void assignValue(){
	 		//função pra passar o valor da atribuição pra variável no hashmap
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u00a7\n\27\3\30\3\30\7\30\u00ab\n\30"+
		"\f\30\16\30\u00ae\13\30\3\31\6\31\u00b1\n\31\r\31\16\31\u00b2\3\31\3\31"+
		"\6\31\u00b7\n\31\r\31\16\31\u00b8\5\31\u00bb\n\31\3\32\3\32\3\32\3\32"+
		"\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\b\5\2,-"+
		"//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00c7"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5?\3\2\2\2\7I\3\2\2\2\tQ\3\2"+
		"\2\2\13X\3\2\2\2\r[\3\2\2\2\17^\3\2\2\2\21`\3\2\2\2\23h\3\2\2\2\25q\3"+
		"\2\2\2\27s\3\2\2\2\31u\3\2\2\2\33w\3\2\2\2\35y\3\2\2\2\37{\3\2\2\2!~\3"+
		"\2\2\2#\u0087\3\2\2\2%\u008d\3\2\2\2\'\u0097\3\2\2\2)\u0099\3\2\2\2+\u009b"+
		"\3\2\2\2-\u00a6\3\2\2\2/\u00a8\3\2\2\2\61\u00b0\3\2\2\2\63\u00bc\3\2\2"+
		"\2\65\66\7r\2\2\66\67\7t\2\2\678\7q\2\289\7i\2\29:\7t\2\2:;\7c\2\2;<\7"+
		"o\2\2<=\7k\2\2=>\7u\2\2>\4\3\2\2\2?@\7e\2\2@A\7c\2\2AB\7e\2\2BC\7k\2\2"+
		"CD\7n\2\2DE\7f\2\2EF\7k\2\2FG\7u\2\2GH\7=\2\2H\6\3\2\2\2IJ\7p\2\2JK\7"+
		"w\2\2KL\7o\2\2LM\7g\2\2MN\7t\2\2NO\7k\2\2OP\7u\2\2P\b\3\2\2\2QR\7v\2\2"+
		"RS\7g\2\2ST\7z\2\2TU\7v\2\2UV\7k\2\2VW\7u\2\2W\n\3\2\2\2XY\7-\2\2YZ\7"+
		"-\2\2Z\f\3\2\2\2[\\\7/\2\2\\]\7/\2\2]\16\3\2\2\2^_\7/\2\2_\20\3\2\2\2"+
		"`a\7k\2\2ab\7p\2\2bc\7r\2\2cd\7w\2\2de\7v\2\2ef\7k\2\2fg\7u\2\2g\22\3"+
		"\2\2\2hi\7g\2\2ij\7u\2\2jk\7e\2\2kl\7t\2\2lm\7g\2\2mn\7x\2\2no\7k\2\2"+
		"op\7u\2\2p\24\3\2\2\2qr\7*\2\2r\26\3\2\2\2st\7+\2\2t\30\3\2\2\2uv\7=\2"+
		"\2v\32\3\2\2\2wx\t\2\2\2x\34\3\2\2\2yz\7?\2\2z\36\3\2\2\2{|\7u\2\2|}\7"+
		"g\2\2} \3\2\2\2~\177\7u\2\2\177\u0080\7g\2\2\u0080\u0081\7p\2\2\u0081"+
		"\u0082\7\u00e5\2\2\u0082\u0083\7q\2\2\u0083\u0084\7|\2\2\u0084\u0085\7"+
		"k\2\2\u0085\u0086\7u\2\2\u0086\"\3\2\2\2\u0087\u0088\7r\2\2\u0088\u0089"+
		"\7c\2\2\u0089\u008a\7t\2\2\u008a\u008b\7k\2\2\u008b\u008c\7u\2\2\u008c"+
		"$\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7p\2\2\u008f\u0090\7s\2\2\u0090"+
		"\u0091\7w\2\2\u0091\u0092\7c\2\2\u0092\u0093\7p\2\2\u0093\u0094\7v\2\2"+
		"\u0094\u0095\7k\2\2\u0095\u0096\7u\2\2\u0096&\3\2\2\2\u0097\u0098\7}\2"+
		"\2\u0098(\3\2\2\2\u0099\u009a\7\177\2\2\u009a*\3\2\2\2\u009b\u009c\7."+
		"\2\2\u009c,\3\2\2\2\u009d\u00a7\t\3\2\2\u009e\u009f\7@\2\2\u009f\u00a7"+
		"\7?\2\2\u00a0\u00a1\7>\2\2\u00a1\u00a7\7?\2\2\u00a2\u00a3\7?\2\2\u00a3"+
		"\u00a7\7?\2\2\u00a4\u00a5\7#\2\2\u00a5\u00a7\7?\2\2\u00a6\u009d\3\2\2"+
		"\2\u00a6\u009e\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a7.\3\2\2\2\u00a8\u00ac\t\4\2\2\u00a9\u00ab\t\5\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\60\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\t\6\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00ba\3\2\2\2\u00b4\u00b6\7\60\2\2\u00b5\u00b7\t\6\2\2\u00b6\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\62\3\2\2"+
		"\2\u00bc\u00bd\t\7\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\32\2\2\u00bf"+
		"\64\3\2\2\2\t\2\u00a6\u00aa\u00ac\u00b2\u00b8\u00ba\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}