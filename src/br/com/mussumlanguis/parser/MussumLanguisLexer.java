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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MussumLanguisLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, L_PAREN=7, R_PAREN=8, 
		SC=9, OP=10, OP_CHANGE=11, ATTR=12, IF=13, ELSE=14, FOR=15, WHILE=16, 
		L_CURL=17, R_CURL=18, COMMA=19, OPREL=20, ID=21, NUMBER=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "L_PAREN", "R_PAREN", 
		"SC", "OP", "OP_CHANGE", "ATTR", "IF", "ELSE", "FOR", "WHILE", "L_CURL", 
		"R_CURL", "COMMA", "OPREL", "ID", "NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'numeris'", "'textis'", "'inputis'", 
		"'escrevis'", "'('", "')'", "';'", null, null, "'='", "'se'", "'sen\u00E3ozis'", 
		"'paris'", "'enquantis'", "'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "L_PAREN", "R_PAREN", "SC", 
		"OP", "OP_CHANGE", "ATTR", "IF", "ELSE", "FOR", "WHILE", "L_CURL", "R_CURL", 
		"COMMA", "OPREL", "ID", "NUMBER", "WS"
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
		
		public void checkVariableUsage(){
	 		for (String i : symbolTable.keySet()) {
	 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
	 				
	 				Logger logger  = Logger.getLogger(MussumLanguisParser.class.getName()); 
	  
	        		// Set Logger level() 
	        		logger.setLevel(Level.WARNING);
	  
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00ba\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\5\fr\n\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00a1\n\25\3\26\3\26\7\26\u00a5\n\26\f\26\16\26\u00a8\13\26\3\27\6\27"+
		"\u00ab\n\27\r\27\16\27\u00ac\3\27\3\27\6\27\u00b1\n\27\r\27\16\27\u00b2"+
		"\5\27\u00b5\n\27\3\30\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2"+
		"\13\f\17\17\"\"\2\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5;\3\2\2\2\7E\3\2\2\2\tM\3\2\2\2"+
		"\13T\3\2\2\2\r\\\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3\2\2\2\25k\3\2\2"+
		"\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35x\3\2\2\2\37\u0081\3\2\2\2!\u0087"+
		"\3\2\2\2#\u0091\3\2\2\2%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u00a0\3\2\2\2"+
		"+\u00a2\3\2\2\2-\u00aa\3\2\2\2/\u00b6\3\2\2\2\61\62\7r\2\2\62\63\7t\2"+
		"\2\63\64\7q\2\2\64\65\7i\2\2\65\66\7t\2\2\66\67\7c\2\2\678\7o\2\289\7"+
		"k\2\29:\7u\2\2:\4\3\2\2\2;<\7e\2\2<=\7c\2\2=>\7e\2\2>?\7k\2\2?@\7n\2\2"+
		"@A\7f\2\2AB\7k\2\2BC\7u\2\2CD\7=\2\2D\6\3\2\2\2EF\7p\2\2FG\7w\2\2GH\7"+
		"o\2\2HI\7g\2\2IJ\7t\2\2JK\7k\2\2KL\7u\2\2L\b\3\2\2\2MN\7v\2\2NO\7g\2\2"+
		"OP\7z\2\2PQ\7v\2\2QR\7k\2\2RS\7u\2\2S\n\3\2\2\2TU\7k\2\2UV\7p\2\2VW\7"+
		"r\2\2WX\7w\2\2XY\7v\2\2YZ\7k\2\2Z[\7u\2\2[\f\3\2\2\2\\]\7g\2\2]^\7u\2"+
		"\2^_\7e\2\2_`\7t\2\2`a\7g\2\2ab\7x\2\2bc\7k\2\2cd\7u\2\2d\16\3\2\2\2e"+
		"f\7*\2\2f\20\3\2\2\2gh\7+\2\2h\22\3\2\2\2ij\7=\2\2j\24\3\2\2\2kl\t\2\2"+
		"\2l\26\3\2\2\2mn\7-\2\2nr\7-\2\2op\7/\2\2pr\7/\2\2qm\3\2\2\2qo\3\2\2\2"+
		"r\30\3\2\2\2st\7?\2\2t\32\3\2\2\2uv\7u\2\2vw\7g\2\2w\34\3\2\2\2xy\7u\2"+
		"\2yz\7g\2\2z{\7p\2\2{|\7\u00e5\2\2|}\7q\2\2}~\7|\2\2~\177\7k\2\2\177\u0080"+
		"\7u\2\2\u0080\36\3\2\2\2\u0081\u0082\7r\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7t\2\2\u0084\u0085\7k\2\2\u0085\u0086\7u\2\2\u0086 \3\2\2\2\u0087\u0088"+
		"\7g\2\2\u0088\u0089\7p\2\2\u0089\u008a\7s\2\2\u008a\u008b\7w\2\2\u008b"+
		"\u008c\7c\2\2\u008c\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\u008f\7k\2\2"+
		"\u008f\u0090\7u\2\2\u0090\"\3\2\2\2\u0091\u0092\7}\2\2\u0092$\3\2\2\2"+
		"\u0093\u0094\7\177\2\2\u0094&\3\2\2\2\u0095\u0096\7.\2\2\u0096(\3\2\2"+
		"\2\u0097\u00a1\t\3\2\2\u0098\u0099\7@\2\2\u0099\u00a1\7?\2\2\u009a\u009b"+
		"\7>\2\2\u009b\u00a1\7?\2\2\u009c\u009d\7?\2\2\u009d\u00a1\7?\2\2\u009e"+
		"\u009f\7#\2\2\u009f\u00a1\7?\2\2\u00a0\u0097\3\2\2\2\u00a0\u0098\3\2\2"+
		"\2\u00a0\u009a\3\2\2\2\u00a0\u009c\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1*"+
		"\3\2\2\2\u00a2\u00a6\t\4\2\2\u00a3\u00a5\t\5\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7,\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a9\u00ab\t\6\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b4\3\2\2\2\u00ae"+
		"\u00b0\7\60\2\2\u00af\u00b1\t\6\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00ae\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5.\3\2\2\2\u00b6\u00b7\t\7\2\2"+
		"\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\30\2\2\u00b9\60\3\2\2\2\n\2q\u00a0"+
		"\u00a4\u00a6\u00ac\u00b2\u00b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}