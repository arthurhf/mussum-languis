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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT=7, DOUBLE=8, STRING=9, 
		BOOLEAN=10, L_PAREN=11, R_PAREN=12, SC=13, OP=14, OP_CHANGE=15, ATTR=16, 
		IF=17, ELSE=18, FOR=19, WHILE=20, L_CURL=21, R_CURL=22, COMMA=23, OPREL=24, 
		ID=25, NUMBER=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "INT", "DOUBLE", "STRING", 
		"BOOLEAN", "L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", "IF", 
		"ELSE", "FOR", "WHILE", "L_CURL", "R_CURL", "COMMA", "OPREL", "ID", "NUMBER", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'#COMENTIS'", "'#DESCOMENTIS'", "'inputis'", 
		"'escrevis'", "'inteiris'", "'quebradis'", null, "'booleanis'", "'('", 
		"')'", "';'", null, null, "'='", "'se'", "'sen\u00E3ozis'", "'paris'", 
		"'enquantis'", "'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "INT", "DOUBLE", "STRING", "BOOLEAN", 
		"L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", "IF", "ELSE", "FOR", 
		"WHILE", "L_CURL", "R_CURL", "COMMA", "OPREL", "ID", "NUMBER", "WS"
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
		private Stack<String> conditionStack = new Stack<String>();
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
	 		((MussumVariable) symbolTable.get(_attrVariable)).setValue(_attrValue);
	 		System.out.println("Simbolo atualizado: " + symbolTable.get(_attrVariable) ); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00f8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0098"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00b0\n\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u00df\n\31\3\32\3\32\7\32\u00e3\n\32\f\32\16\32\u00e6\13\32\3\33"+
		"\6\33\u00e9\n\33\r\33\16\33\u00ea\3\33\3\33\6\33\u00ef\n\33\r\33\16\33"+
		"\u00f0\5\33\u00f3\n\33\3\34\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\b\5\2,-//\61\61\4\2>>@@\3"+
		"\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0101\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5C\3\2\2\2\7M\3\2\2\2\t"+
		"W\3\2\2\2\13d\3\2\2\2\rl\3\2\2\2\17u\3\2\2\2\21~\3\2\2\2\23\u0097\3\2"+
		"\2\2\25\u0099\3\2\2\2\27\u00a3\3\2\2\2\31\u00a5\3\2\2\2\33\u00a7\3\2\2"+
		"\2\35\u00a9\3\2\2\2\37\u00af\3\2\2\2!\u00b1\3\2\2\2#\u00b3\3\2\2\2%\u00b6"+
		"\3\2\2\2\'\u00bf\3\2\2\2)\u00c5\3\2\2\2+\u00cf\3\2\2\2-\u00d1\3\2\2\2"+
		"/\u00d3\3\2\2\2\61\u00de\3\2\2\2\63\u00e0\3\2\2\2\65\u00e8\3\2\2\2\67"+
		"\u00f4\3\2\2\29:\7r\2\2:;\7t\2\2;<\7q\2\2<=\7i\2\2=>\7t\2\2>?\7c\2\2?"+
		"@\7o\2\2@A\7k\2\2AB\7u\2\2B\4\3\2\2\2CD\7e\2\2DE\7c\2\2EF\7e\2\2FG\7k"+
		"\2\2GH\7n\2\2HI\7f\2\2IJ\7k\2\2JK\7u\2\2KL\7=\2\2L\6\3\2\2\2MN\7%\2\2"+
		"NO\7E\2\2OP\7Q\2\2PQ\7O\2\2QR\7G\2\2RS\7P\2\2ST\7V\2\2TU\7K\2\2UV\7U\2"+
		"\2V\b\3\2\2\2WX\7%\2\2XY\7F\2\2YZ\7G\2\2Z[\7U\2\2[\\\7E\2\2\\]\7Q\2\2"+
		"]^\7O\2\2^_\7G\2\2_`\7P\2\2`a\7V\2\2ab\7K\2\2bc\7U\2\2c\n\3\2\2\2de\7"+
		"k\2\2ef\7p\2\2fg\7r\2\2gh\7w\2\2hi\7v\2\2ij\7k\2\2jk\7u\2\2k\f\3\2\2\2"+
		"lm\7g\2\2mn\7u\2\2no\7e\2\2op\7t\2\2pq\7g\2\2qr\7x\2\2rs\7k\2\2st\7u\2"+
		"\2t\16\3\2\2\2uv\7k\2\2vw\7p\2\2wx\7v\2\2xy\7g\2\2yz\7k\2\2z{\7t\2\2{"+
		"|\7k\2\2|}\7u\2\2}\20\3\2\2\2~\177\7s\2\2\177\u0080\7w\2\2\u0080\u0081"+
		"\7g\2\2\u0081\u0082\7d\2\2\u0082\u0083\7t\2\2\u0083\u0084\7c\2\2\u0084"+
		"\u0085\7f\2\2\u0085\u0086\7k\2\2\u0086\u0087\7u\2\2\u0087\22\3\2\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7g\2\2\u008a\u008b\7z\2\2\u008b\u008c\7v\2\2"+
		"\u008c\u008d\7k\2\2\u008d\u0098\7u\2\2\u008e\u008f\7u\2\2\u008f\u0090"+
		"\7v\2\2\u0090\u0091\7t\2\2\u0091\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093"+
		"\u0094\7i\2\2\u0094\u0095\7w\2\2\u0095\u0096\7k\2\2\u0096\u0098\7u\2\2"+
		"\u0097\u0088\3\2\2\2\u0097\u008e\3\2\2\2\u0098\24\3\2\2\2\u0099\u009a"+
		"\7d\2\2\u009a\u009b\7q\2\2\u009b\u009c\7q\2\2\u009c\u009d\7n\2\2\u009d"+
		"\u009e\7g\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7k\2\2"+
		"\u00a1\u00a2\7u\2\2\u00a2\26\3\2\2\2\u00a3\u00a4\7*\2\2\u00a4\30\3\2\2"+
		"\2\u00a5\u00a6\7+\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7=\2\2\u00a8\34\3\2"+
		"\2\2\u00a9\u00aa\t\2\2\2\u00aa\36\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac\u00b0"+
		"\7-\2\2\u00ad\u00ae\7/\2\2\u00ae\u00b0\7/\2\2\u00af\u00ab\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0 \3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\"\3\2\2\2\u00b3"+
		"\u00b4\7u\2\2\u00b4\u00b5\7g\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7u\2\2\u00b7"+
		"\u00b8\7g\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7\u00e5\2\2\u00ba\u00bb\7"+
		"q\2\2\u00bb\u00bc\7|\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7u\2\2\u00be&"+
		"\3\2\2\2\u00bf\u00c0\7r\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7t\2\2\u00c2"+
		"\u00c3\7k\2\2\u00c3\u00c4\7u\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7g\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7s\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7c\2\2"+
		"\u00ca\u00cb\7p\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce"+
		"\7u\2\2\u00ce*\3\2\2\2\u00cf\u00d0\7}\2\2\u00d0,\3\2\2\2\u00d1\u00d2\7"+
		"\177\2\2\u00d2.\3\2\2\2\u00d3\u00d4\7.\2\2\u00d4\60\3\2\2\2\u00d5\u00df"+
		"\t\3\2\2\u00d6\u00d7\7@\2\2\u00d7\u00df\7?\2\2\u00d8\u00d9\7>\2\2\u00d9"+
		"\u00df\7?\2\2\u00da\u00db\7?\2\2\u00db\u00df\7?\2\2\u00dc\u00dd\7#\2\2"+
		"\u00dd\u00df\7?\2\2\u00de\u00d5\3\2\2\2\u00de\u00d6\3\2\2\2\u00de\u00d8"+
		"\3\2\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\62\3\2\2\2\u00e0"+
		"\u00e4\t\4\2\2\u00e1\u00e3\t\5\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\64\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e7\u00e9\t\6\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f2\3\2\2\2\u00ec\u00ee\7\60"+
		"\2\2\u00ed\u00ef\t\6\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00ec\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\66\3\2\2\2\u00f4\u00f5\t\7\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f7\b\34\2\2\u00f78\3\2\2\2\13\2\u0097\u00af\u00de\u00e2"+
		"\u00e4\u00ea\u00f0\u00f2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}