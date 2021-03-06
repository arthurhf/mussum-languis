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
	import br.com.mussumlanguis.ast.DoWhileCommand;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT_DECL=7, INT_VAL=8, 
		DOUBLE_DECL=9, DOUBLE_VAL=10, STRING_DECL=11, STRING_VAL=12, BOOLEAN_DECL=13, 
		BOOLEAN_VAL=14, CHAR_DECL=15, CHAR_VAL=16, L_PAREN=17, R_PAREN=18, SC=19, 
		OP=20, OP_CHANGE=21, ATTR=22, IF=23, ELSE=24, DO=25, FOR=26, WHILE=27, 
		L_CURL=28, R_CURL=29, COMMA=30, OPREL=31, ID=32, WS=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "INT_DECL", "INT_VAL", 
		"DOUBLE_DECL", "DOUBLE_VAL", "STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", 
		"BOOLEAN_VAL", "CHAR_DECL", "CHAR_VAL", "L_PAREN", "R_PAREN", "SC", "OP", 
		"OP_CHANGE", "ATTR", "IF", "ELSE", "DO", "FOR", "WHILE", "L_CURL", "R_CURL", 
		"COMMA", "OPREL", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'#COMENTIS'", "'#DESCOMENTIS'", "'inputis'", 
		"'escrevis'", "'inteiris'", null, "'quebradis'", null, null, null, "'booleanis'", 
		null, "'caract\u00E9ris'", null, "'('", "')'", "';'", null, null, "'='", 
		"'se'", "'sen\u00E3ozis'", "'facis'", "'paris'", "'enquantis'", "'{'", 
		"'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "INT_DECL", "INT_VAL", "DOUBLE_DECL", 
		"DOUBLE_VAL", "STRING_DECL", "STRING_VAL", "BOOLEAN_DECL", "BOOLEAN_VAL", 
		"CHAR_DECL", "CHAR_VAL", "L_PAREN", "R_PAREN", "SC", "OP", "OP_CHANGE", 
		"ATTR", "IF", "ELSE", "DO", "FOR", "WHILE", "L_CURL", "R_CURL", "COMMA", 
		"OPREL", "ID", "WS"
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
				throw new MussumSemanticException("Variávis " + id + " não declaradis");
			}
		}
		
		public void addSymbol() {
			_varName = ((TokenStream) _input).LT(-1).getText();
			_varValue = null;
			symbol = new MussumVariable(_varName, _type, _varValue);
			
			if (!symbolTable.exists(_varName)) {
				symbolTable.add(symbol);
			} else {
				throw new MussumSemanticException("Variávis " + _varName + " já declaradis");
			}
		}
		
		public void checkVariableUsage(){
	 		for (String i : symbolTable.keySet()) {
	 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
	 				
	 				Logger logger  = Logger.getLogger(MussumLanguisParser.class.getName()); 
	  
	        		// Set Logger level() 
	        		logger.setLevel(Level.WARNING);
	  
	        		// Call warning method 
	        		logger.warning("Variávis " + i + " nunca usadis"); 
	 			}
			}
	 	}
	 	
	 	public void verifyAssignment(){
	 		_varName = ((TokenStream) _input).LT(-1).getText();
	 		if(((MussumVariable) symbolTable.get(_varName)).getValue() == null){
	 				throw new MussumSemanticException("Variávis " + _varName + " não inicializadis");
	 		}
	 	}
	 	
	 	public void assignValue(){
	 		//função pra passar o valor da atribuição pra variável no hashmap
	 		((MussumVariable) symbolTable.get(_exprId)).setValue(_exprContent);
	 	}

		public void verifyVarType(int currType) {
			if (_varType == -1) {
				_varType = currType;
			} else if (_varType != currType) {
				throw new MussumSemanticException ("Você está misturandis variávis do tipo " + 
					MussumVariable.getMussumType(currType) + " com " + MussumVariable.getMussumType(_varType));
			
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u013c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\6\t\u008c\n\t\r\t\16\t\u008d\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\6\13\u009b\n\13\r\13\16\13\u009c\3\13\3\13\6\13\u00a1"+
		"\n\13\r\13\16\13\u00a2\5\13\u00a5\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b6\n\f\3\r\3\r\7\r\u00ba\n\r\f\r\16"+
		"\r\u00bd\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00dc\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\5\21\u00eb\n\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00fb\n\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \5 \u0130\n \3!\3!\7!\u0134\n!\f!\16!\u0137\13!\3\"\3\"\3"+
		"\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#\3\2\t\3\2\62;\6\2\"\"\62;C\\c|\5\2\62;C\\c|\5\2,"+
		"-//\61\61\4\2>>@@\3\2c|\5\2\13\f\17\17\"\"\2\u0148\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5O\3\2\2\2\7Y\3\2\2\2\tc\3\2\2"+
		"\2\13p\3\2\2\2\rx\3\2\2\2\17\u0081\3\2\2\2\21\u008b\3\2\2\2\23\u008f\3"+
		"\2\2\2\25\u009a\3\2\2\2\27\u00b5\3\2\2\2\31\u00b7\3\2\2\2\33\u00c0\3\2"+
		"\2\2\35\u00db\3\2\2\2\37\u00dd\3\2\2\2!\u00e8\3\2\2\2#\u00ee\3\2\2\2%"+
		"\u00f0\3\2\2\2\'\u00f2\3\2\2\2)\u00f4\3\2\2\2+\u00fa\3\2\2\2-\u00fc\3"+
		"\2\2\2/\u00fe\3\2\2\2\61\u0101\3\2\2\2\63\u010a\3\2\2\2\65\u0110\3\2\2"+
		"\2\67\u0116\3\2\2\29\u0120\3\2\2\2;\u0122\3\2\2\2=\u0124\3\2\2\2?\u012f"+
		"\3\2\2\2A\u0131\3\2\2\2C\u0138\3\2\2\2EF\7r\2\2FG\7t\2\2GH\7q\2\2HI\7"+
		"i\2\2IJ\7t\2\2JK\7c\2\2KL\7o\2\2LM\7k\2\2MN\7u\2\2N\4\3\2\2\2OP\7e\2\2"+
		"PQ\7c\2\2QR\7e\2\2RS\7k\2\2ST\7n\2\2TU\7f\2\2UV\7k\2\2VW\7u\2\2WX\7=\2"+
		"\2X\6\3\2\2\2YZ\7%\2\2Z[\7E\2\2[\\\7Q\2\2\\]\7O\2\2]^\7G\2\2^_\7P\2\2"+
		"_`\7V\2\2`a\7K\2\2ab\7U\2\2b\b\3\2\2\2cd\7%\2\2de\7F\2\2ef\7G\2\2fg\7"+
		"U\2\2gh\7E\2\2hi\7Q\2\2ij\7O\2\2jk\7G\2\2kl\7P\2\2lm\7V\2\2mn\7K\2\2n"+
		"o\7U\2\2o\n\3\2\2\2pq\7k\2\2qr\7p\2\2rs\7r\2\2st\7w\2\2tu\7v\2\2uv\7k"+
		"\2\2vw\7u\2\2w\f\3\2\2\2xy\7g\2\2yz\7u\2\2z{\7e\2\2{|\7t\2\2|}\7g\2\2"+
		"}~\7x\2\2~\177\7k\2\2\177\u0080\7u\2\2\u0080\16\3\2\2\2\u0081\u0082\7"+
		"k\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7t\2\2\u0087\u0088\7k\2\2\u0088\u0089\7u\2\2\u0089"+
		"\20\3\2\2\2\u008a\u008c\t\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\22\3\2\2\2\u008f\u0090"+
		"\7s\2\2\u0090\u0091\7w\2\2\u0091\u0092\7g\2\2\u0092\u0093\7d\2\2\u0093"+
		"\u0094\7t\2\2\u0094\u0095\7c\2\2\u0095\u0096\7f\2\2\u0096\u0097\7k\2\2"+
		"\u0097\u0098\7u\2\2\u0098\24\3\2\2\2\u0099\u009b\t\2\2\2\u009a\u0099\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00a4\3\2\2\2\u009e\u00a0\7\60\2\2\u009f\u00a1\t\2\2\2\u00a0\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\26\3\2\2"+
		"\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7z\2\2\u00a9\u00aa"+
		"\7v\2\2\u00aa\u00ab\7k\2\2\u00ab\u00b6\7u\2\2\u00ac\u00ad\7u\2\2\u00ad"+
		"\u00ae\7v\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7p\2\2"+
		"\u00b1\u00b2\7i\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b6"+
		"\7u\2\2\u00b5\u00a6\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b6\30\3\2\2\2\u00b7"+
		"\u00bb\7$\2\2\u00b8\u00ba\t\3\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00bf\7$\2\2\u00bf\32\3\2\2\2\u00c0\u00c1\7d\2\2"+
		"\u00c1\u00c2\7q\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7k\2\2\u00c8"+
		"\u00c9\7u\2\2\u00c9\34\3\2\2\2\u00ca\u00cb\7x\2\2\u00cb\u00cc\7g\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00ce\7f\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7f\2\2"+
		"\u00d0\u00d1\7g\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00dc\7u\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7"+
		"\u00d8\7n\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7k\2\2\u00da\u00dc\7u\2\2"+
		"\u00db\u00ca\3\2\2\2\u00db\u00d5\3\2\2\2\u00dc\36\3\2\2\2\u00dd\u00de"+
		"\7e\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7c\2\2\u00e1"+
		"\u00e2\7e\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7\u00eb\2\2\u00e4\u00e5\7"+
		"t\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7u\2\2\u00e7 \3\2\2\2\u00e8\u00ea"+
		"\7$\2\2\u00e9\u00eb\t\4\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\7$\2\2\u00ed\"\3\2\2\2\u00ee\u00ef\7*\2\2\u00ef$\3\2\2\2\u00f0"+
		"\u00f1\7+\2\2\u00f1&\3\2\2\2\u00f2\u00f3\7=\2\2\u00f3(\3\2\2\2\u00f4\u00f5"+
		"\t\5\2\2\u00f5*\3\2\2\2\u00f6\u00f7\7-\2\2\u00f7\u00fb\7-\2\2\u00f8\u00f9"+
		"\7/\2\2\u00f9\u00fb\7/\2\2\u00fa\u00f6\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		",\3\2\2\2\u00fc\u00fd\7?\2\2\u00fd.\3\2\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100"+
		"\7g\2\2\u0100\60\3\2\2\2\u0101\u0102\7u\2\2\u0102\u0103\7g\2\2\u0103\u0104"+
		"\7p\2\2\u0104\u0105\7\u00e5\2\2\u0105\u0106\7q\2\2\u0106\u0107\7|\2\2"+
		"\u0107\u0108\7k\2\2\u0108\u0109\7u\2\2\u0109\62\3\2\2\2\u010a\u010b\7"+
		"h\2\2\u010b\u010c\7c\2\2\u010c\u010d\7e\2\2\u010d\u010e\7k\2\2\u010e\u010f"+
		"\7u\2\2\u010f\64\3\2\2\2\u0110\u0111\7r\2\2\u0111\u0112\7c\2\2\u0112\u0113"+
		"\7t\2\2\u0113\u0114\7k\2\2\u0114\u0115\7u\2\2\u0115\66\3\2\2\2\u0116\u0117"+
		"\7g\2\2\u0117\u0118\7p\2\2\u0118\u0119\7s\2\2\u0119\u011a\7w\2\2\u011a"+
		"\u011b\7c\2\2\u011b\u011c\7p\2\2\u011c\u011d\7v\2\2\u011d\u011e\7k\2\2"+
		"\u011e\u011f\7u\2\2\u011f8\3\2\2\2\u0120\u0121\7}\2\2\u0121:\3\2\2\2\u0122"+
		"\u0123\7\177\2\2\u0123<\3\2\2\2\u0124\u0125\7.\2\2\u0125>\3\2\2\2\u0126"+
		"\u0130\t\6\2\2\u0127\u0128\7@\2\2\u0128\u0130\7?\2\2\u0129\u012a\7>\2"+
		"\2\u012a\u0130\7?\2\2\u012b\u012c\7?\2\2\u012c\u0130\7?\2\2\u012d\u012e"+
		"\7#\2\2\u012e\u0130\7?\2\2\u012f\u0126\3\2\2\2\u012f\u0127\3\2\2\2\u012f"+
		"\u0129\3\2\2\2\u012f\u012b\3\2\2\2\u012f\u012d\3\2\2\2\u0130@\3\2\2\2"+
		"\u0131\u0135\t\7\2\2\u0132\u0134\t\4\2\2\u0133\u0132\3\2\2\2\u0134\u0137"+
		"\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136B\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0138\u0139\t\b\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b\""+
		"\2\2\u013bD\3\2\2\2\20\2\u008d\u009c\u00a2\u00a4\u00b5\u00b9\u00bb\u00db"+
		"\u00ea\u00fa\u012f\u0133\u0135\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}