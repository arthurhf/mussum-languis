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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT=8, DOUBLE=9, 
		STRING=10, BOOLEAN=11, L_PAREN=12, R_PAREN=13, SC=14, OP=15, OP_CHANGE=16, 
		ATTR=17, IF=18, ELSE=19, FOR=20, WHILE=21, L_CURL=22, R_CURL=23, COMMA=24, 
		OPREL=25, ID=26, NUMBER=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INT", "DOUBLE", 
		"STRING", "BOOLEAN", "L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", 
		"IF", "ELSE", "FOR", "WHILE", "L_CURL", "R_CURL", "COMMA", "OPREL", "ID", 
		"NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'funcionis'", "'#COMENTIS'", "'#DESCOMENTIS'", 
		"'inputis'", "'escrevis'", "'inteiris'", "'quebradis'", null, "'booleanis'", 
		"'('", "')'", "';'", null, null, "'='", "'se'", "'sen\u00E3ozis'", "'paris'", 
		"'enquantis'", "'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "INT", "DOUBLE", "STRING", 
		"BOOLEAN", "L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", "IF", 
		"ELSE", "FOR", "WHILE", "L_CURL", "R_CURL", "COMMA", "OPREL", "ID", "NUMBER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u0104\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a4"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00bc\n\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u00eb\n\32\3\33\3\33\7\33\u00ef\n\33\f\33\16\33\u00f2\13\33\3\34\6\34"+
		"\u00f5\n\34\r\34\16\34\u00f6\3\34\3\34\6\34\u00fb\n\34\r\34\16\34\u00fc"+
		"\5\34\u00ff\n\34\3\35\3\35\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\b\5\2,-//\61\61\4\2>>@@\3"+
		"\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u010d\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5E\3\2\2\2\7"+
		"O\3\2\2\2\tY\3\2\2\2\13c\3\2\2\2\rp\3\2\2\2\17x\3\2\2\2\21\u0081\3\2\2"+
		"\2\23\u008a\3\2\2\2\25\u00a3\3\2\2\2\27\u00a5\3\2\2\2\31\u00af\3\2\2\2"+
		"\33\u00b1\3\2\2\2\35\u00b3\3\2\2\2\37\u00b5\3\2\2\2!\u00bb\3\2\2\2#\u00bd"+
		"\3\2\2\2%\u00bf\3\2\2\2\'\u00c2\3\2\2\2)\u00cb\3\2\2\2+\u00d1\3\2\2\2"+
		"-\u00db\3\2\2\2/\u00dd\3\2\2\2\61\u00df\3\2\2\2\63\u00ea\3\2\2\2\65\u00ec"+
		"\3\2\2\2\67\u00f4\3\2\2\29\u0100\3\2\2\2;<\7r\2\2<=\7t\2\2=>\7q\2\2>?"+
		"\7i\2\2?@\7t\2\2@A\7c\2\2AB\7o\2\2BC\7k\2\2CD\7u\2\2D\4\3\2\2\2EF\7e\2"+
		"\2FG\7c\2\2GH\7e\2\2HI\7k\2\2IJ\7n\2\2JK\7f\2\2KL\7k\2\2LM\7u\2\2MN\7"+
		"=\2\2N\6\3\2\2\2OP\7h\2\2PQ\7w\2\2QR\7p\2\2RS\7e\2\2ST\7k\2\2TU\7q\2\2"+
		"UV\7p\2\2VW\7k\2\2WX\7u\2\2X\b\3\2\2\2YZ\7%\2\2Z[\7E\2\2[\\\7Q\2\2\\]"+
		"\7O\2\2]^\7G\2\2^_\7P\2\2_`\7V\2\2`a\7K\2\2ab\7U\2\2b\n\3\2\2\2cd\7%\2"+
		"\2de\7F\2\2ef\7G\2\2fg\7U\2\2gh\7E\2\2hi\7Q\2\2ij\7O\2\2jk\7G\2\2kl\7"+
		"P\2\2lm\7V\2\2mn\7K\2\2no\7U\2\2o\f\3\2\2\2pq\7k\2\2qr\7p\2\2rs\7r\2\2"+
		"st\7w\2\2tu\7v\2\2uv\7k\2\2vw\7u\2\2w\16\3\2\2\2xy\7g\2\2yz\7u\2\2z{\7"+
		"e\2\2{|\7t\2\2|}\7g\2\2}~\7x\2\2~\177\7k\2\2\177\u0080\7u\2\2\u0080\20"+
		"\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084"+
		"\u0085\7g\2\2\u0085\u0086\7k\2\2\u0086\u0087\7t\2\2\u0087\u0088\7k\2\2"+
		"\u0088\u0089\7u\2\2\u0089\22\3\2\2\2\u008a\u008b\7s\2\2\u008b\u008c\7"+
		"w\2\2\u008c\u008d\7g\2\2\u008d\u008e\7d\2\2\u008e\u008f\7t\2\2\u008f\u0090"+
		"\7c\2\2\u0090\u0091\7f\2\2\u0091\u0092\7k\2\2\u0092\u0093\7u\2\2\u0093"+
		"\24\3\2\2\2\u0094\u0095\7v\2\2\u0095\u0096\7g\2\2\u0096\u0097\7z\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7k\2\2\u0099\u00a4\7u\2\2\u009a\u009b\7u\2\2"+
		"\u009b\u009c\7v\2\2\u009c\u009d\7t\2\2\u009d\u009e\7k\2\2\u009e\u009f"+
		"\7p\2\2\u009f\u00a0\7i\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7k\2\2\u00a2"+
		"\u00a4\7u\2\2\u00a3\u0094\3\2\2\2\u00a3\u009a\3\2\2\2\u00a4\26\3\2\2\2"+
		"\u00a5\u00a6\7d\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9"+
		"\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7p\2\2\u00ac"+
		"\u00ad\7k\2\2\u00ad\u00ae\7u\2\2\u00ae\30\3\2\2\2\u00af\u00b0\7*\2\2\u00b0"+
		"\32\3\2\2\2\u00b1\u00b2\7+\2\2\u00b2\34\3\2\2\2\u00b3\u00b4\7=\2\2\u00b4"+
		"\36\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6 \3\2\2\2\u00b7\u00b8\7-\2\2\u00b8"+
		"\u00bc\7-\2\2\u00b9\u00ba\7/\2\2\u00ba\u00bc\7/\2\2\u00bb\u00b7\3\2\2"+
		"\2\u00bb\u00b9\3\2\2\2\u00bc\"\3\2\2\2\u00bd\u00be\7?\2\2\u00be$\3\2\2"+
		"\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7g\2\2\u00c1&\3\2\2\2\u00c2\u00c3\7"+
		"u\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7\u00e5\2\2\u00c6"+
		"\u00c7\7q\2\2\u00c7\u00c8\7|\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7u\2\2"+
		"\u00ca(\3\2\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7t\2"+
		"\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7u\2\2\u00d0*\3\2\2\2\u00d1\u00d2\7"+
		"g\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7s\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6"+
		"\7c\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7k\2\2\u00d9"+
		"\u00da\7u\2\2\u00da,\3\2\2\2\u00db\u00dc\7}\2\2\u00dc.\3\2\2\2\u00dd\u00de"+
		"\7\177\2\2\u00de\60\3\2\2\2\u00df\u00e0\7.\2\2\u00e0\62\3\2\2\2\u00e1"+
		"\u00eb\t\3\2\2\u00e2\u00e3\7@\2\2\u00e3\u00eb\7?\2\2\u00e4\u00e5\7>\2"+
		"\2\u00e5\u00eb\7?\2\2\u00e6\u00e7\7?\2\2\u00e7\u00eb\7?\2\2\u00e8\u00e9"+
		"\7#\2\2\u00e9\u00eb\7?\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea"+
		"\u00e4\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\64\3\2\2"+
		"\2\u00ec\u00f0\t\4\2\2\u00ed\u00ef\t\5\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\66\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f5\t\6\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fe\3\2\2\2\u00f8"+
		"\u00fa\7\60\2\2\u00f9\u00fb\t\6\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3"+
		"\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u00f8\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff8\3\2\2\2\u0100\u0101\t\7\2\2"+
		"\u0101\u0102\3\2\2\2\u0102\u0103\b\35\2\2\u0103:\3\2\2\2\13\2\u00a3\u00bb"+
		"\u00ea\u00ee\u00f0\u00f6\u00fc\u00fe\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}