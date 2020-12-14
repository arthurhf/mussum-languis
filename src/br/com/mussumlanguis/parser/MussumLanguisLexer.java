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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT_DECL=8, INT_VAL=9, 
		DOUBLE_DECL=10, DOUBLE_VAL=11, STRING_DECL=12, STRING_VAL=13, BOOLEAN_DECL=14, 
		BOOLEAN_VAL=15, CHAR_DECL=16, CHAR_VAL=17, L_PAREN=18, R_PAREN=19, SC=20, 
		OP=21, OP_CHANGE=22, ATTR=23, IF=24, ELSE=25, DO=26, FOR=27, WHILE=28, 
		L_CURL=29, R_CURL=30, COMMA=31, OPREL=32, ID=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INT_DECL", "INT_VAL", 
		"DOUBLE_DECL", "DOUBLE_VAL", "STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", 
		"BOOLEAN_VAL", "CHAR_DECL", "CHAR_VAL", "L_PAREN", "R_PAREN", "SC", "OP", 
		"OP_CHANGE", "ATTR", "IF", "ELSE", "DO", "FOR", "WHILE", "L_CURL", "R_CURL", 
		"COMMA", "OPREL", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'funcionis'", "'#COMENTIS'", "'#DESCOMENTIS'", 
		"'inputis'", "'escrevis'", "'inteiris'", null, "'quebradis'", null, null, 
		null, "'booleanis'", null, "'caract\u00E9ris'", null, "'('", "')'", "';'", 
		null, null, "'='", "'se'", "'sen\u00E3ozis'", "'facis'", "'paris'", "'enquantis'", 
		"'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "INT_DECL", "INT_VAL", 
		"DOUBLE_DECL", "DOUBLE_VAL", "STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", 
		"BOOLEAN_VAL", "CHAR_DECL", "CHAR_VAL", "L_PAREN", "R_PAREN", "SC", "OP", 
		"OP_CHANGE", "ATTR", "IF", "ELSE", "DO", "FOR", "WHILE", "L_CURL", "R_CURL", 
		"COMMA", "OPREL", "ID", "WS"
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
		
		private int _varType = -1;

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

		public void verifyVarType(int currType) {
			if (_varType == -1) {
				_varType = currType;
			} else if (_varType != currType) {
				throw new MussumSemanticException ("Tentativis de declarar variaveis do tipo " + 
					MussumVariable.getMussumType(currType) + " em " + MussumVariable.getMussumType(_varType));
			
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0147\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\6\n\u0098\n"+
		"\n\r\n\16\n\u0099\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\6\f\u00a7\n\f\r\f\16\f\u00a8\3\f\3\f\6\f\u00ad\n\f\r\f\16\f\u00ae\5"+
		"\f\u00b1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00c2\n\r\3\16\3\16\7\16\u00c6\n\16\f\16\16\16\u00c9\13\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00e7\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\5\22\u00f6\n\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\5\27\u0106\n\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u013b\n"+
		"!\3\"\3\"\7\"\u013f\n\"\f\"\16\"\u0142\13\"\3#\3#\3#\3#\2\2$\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$\3\2\b\3\2\62;\5\2\62;C\\c|\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\13\f\17"+
		"\17\"\"\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\3G\3\2\2\2\5Q\3\2\2\2\7[\3\2\2\2\te\3\2\2\2\13o\3\2\2\2\r|\3\2"+
		"\2\2\17\u0084\3\2\2\2\21\u008d\3\2\2\2\23\u0097\3\2\2\2\25\u009b\3\2\2"+
		"\2\27\u00a6\3\2\2\2\31\u00c1\3\2\2\2\33\u00c3\3\2\2\2\35\u00cc\3\2\2\2"+
		"\37\u00e6\3\2\2\2!\u00e8\3\2\2\2#\u00f3\3\2\2\2%\u00f9\3\2\2\2\'\u00fb"+
		"\3\2\2\2)\u00fd\3\2\2\2+\u00ff\3\2\2\2-\u0105\3\2\2\2/\u0107\3\2\2\2\61"+
		"\u0109\3\2\2\2\63\u010c\3\2\2\2\65\u0115\3\2\2\2\67\u011b\3\2\2\29\u0121"+
		"\3\2\2\2;\u012b\3\2\2\2=\u012d\3\2\2\2?\u012f\3\2\2\2A\u013a\3\2\2\2C"+
		"\u013c\3\2\2\2E\u0143\3\2\2\2GH\7r\2\2HI\7t\2\2IJ\7q\2\2JK\7i\2\2KL\7"+
		"t\2\2LM\7c\2\2MN\7o\2\2NO\7k\2\2OP\7u\2\2P\4\3\2\2\2QR\7e\2\2RS\7c\2\2"+
		"ST\7e\2\2TU\7k\2\2UV\7n\2\2VW\7f\2\2WX\7k\2\2XY\7u\2\2YZ\7=\2\2Z\6\3\2"+
		"\2\2[\\\7h\2\2\\]\7w\2\2]^\7p\2\2^_\7e\2\2_`\7k\2\2`a\7q\2\2ab\7p\2\2"+
		"bc\7k\2\2cd\7u\2\2d\b\3\2\2\2ef\7%\2\2fg\7E\2\2gh\7Q\2\2hi\7O\2\2ij\7"+
		"G\2\2jk\7P\2\2kl\7V\2\2lm\7K\2\2mn\7U\2\2n\n\3\2\2\2op\7%\2\2pq\7F\2\2"+
		"qr\7G\2\2rs\7U\2\2st\7E\2\2tu\7Q\2\2uv\7O\2\2vw\7G\2\2wx\7P\2\2xy\7V\2"+
		"\2yz\7K\2\2z{\7U\2\2{\f\3\2\2\2|}\7k\2\2}~\7p\2\2~\177\7r\2\2\177\u0080"+
		"\7w\2\2\u0080\u0081\7v\2\2\u0081\u0082\7k\2\2\u0082\u0083\7u\2\2\u0083"+
		"\16\3\2\2\2\u0084\u0085\7g\2\2\u0085\u0086\7u\2\2\u0086\u0087\7e\2\2\u0087"+
		"\u0088\7t\2\2\u0088\u0089\7g\2\2\u0089\u008a\7x\2\2\u008a\u008b\7k\2\2"+
		"\u008b\u008c\7u\2\2\u008c\20\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7"+
		"p\2\2\u008f\u0090\7v\2\2\u0090\u0091\7g\2\2\u0091\u0092\7k\2\2\u0092\u0093"+
		"\7t\2\2\u0093\u0094\7k\2\2\u0094\u0095\7u\2\2\u0095\22\3\2\2\2\u0096\u0098"+
		"\t\2\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\24\3\2\2\2\u009b\u009c\7s\2\2\u009c\u009d\7w\2\2"+
		"\u009d\u009e\7g\2\2\u009e\u009f\7d\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1"+
		"\7c\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7u\2\2\u00a4"+
		"\26\3\2\2\2\u00a5\u00a7\t\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2"+
		"\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00b0\3\2\2\2\u00aa\u00ac"+
		"\7\60\2\2\u00ab\u00ad\t\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2"+
		"\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00aa"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\30\3\2\2\2\u00b2\u00b3\7v\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\u00b5\7z\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7k\2\2"+
		"\u00b7\u00c2\7u\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb"+
		"\7t\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7i\2\2\u00be"+
		"\u00bf\7w\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c2\7u\2\2\u00c1\u00b2\3\2\2"+
		"\2\u00c1\u00b8\3\2\2\2\u00c2\32\3\2\2\2\u00c3\u00c7\7$\2\2\u00c4\u00c6"+
		"\t\3\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7$"+
		"\2\2\u00cb\34\3\2\2\2\u00cc\u00cd\7d\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf"+
		"\7q\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7c\2\2\u00d2"+
		"\u00d3\7p\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7u\2\2\u00d5\36\3\2\2\2\u00d6"+
		"\u00d7\7x\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7f\2\2"+
		"\u00da\u00db\7c\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de"+
		"\7t\2\2\u00de\u00df\7k\2\2\u00df\u00e7\7u\2\2\u00e0\u00e1\7h\2\2\u00e1"+
		"\u00e2\7c\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7k\2\2"+
		"\u00e5\u00e7\7u\2\2\u00e6\u00d6\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e7 \3\2"+
		"\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec"+
		"\7c\2\2\u00ec\u00ed\7e\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7\u00eb\2\2"+
		"\u00ef\u00f0\7t\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7u\2\2\u00f2\"\3\2"+
		"\2\2\u00f3\u00f5\7$\2\2\u00f4\u00f6\t\3\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\7$\2\2\u00f8$\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa"+
		"&\3\2\2\2\u00fb\u00fc\7+\2\2\u00fc(\3\2\2\2\u00fd\u00fe\7=\2\2\u00fe*"+
		"\3\2\2\2\u00ff\u0100\t\4\2\2\u0100,\3\2\2\2\u0101\u0102\7-\2\2\u0102\u0106"+
		"\7-\2\2\u0103\u0104\7/\2\2\u0104\u0106\7/\2\2\u0105\u0101\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0106.\3\2\2\2\u0107\u0108\7?\2\2\u0108\60\3\2\2\2\u0109"+
		"\u010a\7u\2\2\u010a\u010b\7g\2\2\u010b\62\3\2\2\2\u010c\u010d\7u\2\2\u010d"+
		"\u010e\7g\2\2\u010e\u010f\7p\2\2\u010f\u0110\7\u00e5\2\2\u0110\u0111\7"+
		"q\2\2\u0111\u0112\7|\2\2\u0112\u0113\7k\2\2\u0113\u0114\7u\2\2\u0114\64"+
		"\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7c\2\2\u0117\u0118\7e\2\2\u0118"+
		"\u0119\7k\2\2\u0119\u011a\7u\2\2\u011a\66\3\2\2\2\u011b\u011c\7r\2\2\u011c"+
		"\u011d\7c\2\2\u011d\u011e\7t\2\2\u011e\u011f\7k\2\2\u011f\u0120\7u\2\2"+
		"\u01208\3\2\2\2\u0121\u0122\7g\2\2\u0122\u0123\7p\2\2\u0123\u0124\7s\2"+
		"\2\u0124\u0125\7w\2\2\u0125\u0126\7c\2\2\u0126\u0127\7p\2\2\u0127\u0128"+
		"\7v\2\2\u0128\u0129\7k\2\2\u0129\u012a\7u\2\2\u012a:\3\2\2\2\u012b\u012c"+
		"\7}\2\2\u012c<\3\2\2\2\u012d\u012e\7\177\2\2\u012e>\3\2\2\2\u012f\u0130"+
		"\7.\2\2\u0130@\3\2\2\2\u0131\u013b\t\5\2\2\u0132\u0133\7@\2\2\u0133\u013b"+
		"\7?\2\2\u0134\u0135\7>\2\2\u0135\u013b\7?\2\2\u0136\u0137\7?\2\2\u0137"+
		"\u013b\7?\2\2\u0138\u0139\7#\2\2\u0139\u013b\7?\2\2\u013a\u0131\3\2\2"+
		"\2\u013a\u0132\3\2\2\2\u013a\u0134\3\2\2\2\u013a\u0136\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013bB\3\2\2\2\u013c\u0140\t\6\2\2\u013d\u013f\t\3\2\2\u013e"+
		"\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141D\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\t\7\2\2\u0144\u0145"+
		"\3\2\2\2\u0145\u0146\b#\2\2\u0146F\3\2\2\2\20\2\u0099\u00a8\u00ae\u00b0"+
		"\u00c1\u00c5\u00c7\u00e6\u00f5\u0105\u013a\u013e\u0140\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}