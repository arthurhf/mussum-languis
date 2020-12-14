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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MussumLanguisParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_function = 1, RULE_decl = 2, RULE_var_decl = 3, RULE_type = 4, 
		RULE_block = 5, RULE_cmd = 6, RULE_comment = 7, RULE_read_cmd = 8, RULE_write_cmd = 9, 
		RULE_decision_cmd = 10, RULE_dog = 11, RULE_whileg = 12, RULE_forg = 13, 
		RULE_attr_cmd = 14, RULE_expr = 15, RULE_expr_token = 16;
	public static final String[] ruleNames = {
		"prog", "function", "decl", "var_decl", "type", "block", "cmd", "comment", 
		"read_cmd", "write_cmd", "decision_cmd", "dog", "whileg", "forg", "attr_cmd", 
		"expr", "expr_token"
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

	@Override
	public String getGrammarFileName() { return "MussumLanguis.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
				throw new MussumSemanticException ("Você está misturandis variavis do tipo " + 
					MussumVariable.getMussumType(currType) + " com " + MussumVariable.getMussumType(_varType));
			
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

	public MussumLanguisParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(34);
				function();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(T__0);
			setState(41);
			decl();
			setState(42);
			block();
			setState(43);
			match(T__1);

															program.setSymbolTable(symbolTable);
															program.setCommands(commandStack.pop());
															checkVariableUsage();
														 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode L_CURL() { return getToken(MussumLanguisParser.L_CURL, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode R_CURL() { return getToken(MussumLanguisParser.R_CURL, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__2);
			setState(47);
			match(ID);
			setState(48);
			match(L_CURL);
			setState(49);
			decl();
			setState(50);
			block();
			setState(51);
			match(R_CURL);
			System.out.println("Reconheci uma função");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				var_decl();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MussumLanguisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumLanguisParser.ID, i);
		}
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MussumLanguisParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MussumLanguisParser.COMMA, i);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			type();
			setState(60);
			match(ID);
			 addSymbol(); 
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(62);
				match(COMMA);
				setState(63);
				match(ID);
				 addSymbol(); 
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT_DECL() { return getToken(MussumLanguisParser.INT_DECL, 0); }
		public TerminalNode STRING_DECL() { return getToken(MussumLanguisParser.STRING_DECL, 0); }
		public TerminalNode DOUBLE_DECL() { return getToken(MussumLanguisParser.DOUBLE_DECL, 0); }
		public TerminalNode BOOLEAN_DECL() { return getToken(MussumLanguisParser.BOOLEAN_DECL, 0); }
		public TerminalNode CHAR_DECL() { return getToken(MussumLanguisParser.CHAR_DECL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(INT_DECL);
					_type = MussumVariable.INT;		
				}
				break;
			case STRING_DECL:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(STRING_DECL);
					_type = MussumVariable.TEXT;	
				}
				break;
			case DOUBLE_DECL:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(DOUBLE_DECL);
					_type = MussumVariable.DOUBLE;	
				}
				break;
			case BOOLEAN_DECL:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				match(BOOLEAN_DECL);
					_type = MussumVariable.BOOLEAN;	
				}
				break;
			case CHAR_DECL:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				match(CHAR_DECL);
					_type = MussumVariable.CHAR;	
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				currThread = new ArrayList<AbstractCommand>();
							commandStack.push(currThread);
						
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				cmd();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public Read_cmdContext read_cmd() {
			return getRuleContext(Read_cmdContext.class,0);
		}
		public Write_cmdContext write_cmd() {
			return getRuleContext(Write_cmdContext.class,0);
		}
		public Decision_cmdContext decision_cmd() {
			return getRuleContext(Decision_cmdContext.class,0);
		}
		public Attr_cmdContext attr_cmd() {
			return getRuleContext(Attr_cmdContext.class,0);
		}
		public ForgContext forg() {
			return getRuleContext(ForgContext.class,0);
		}
		public WhilegContext whileg() {
			return getRuleContext(WhilegContext.class,0);
		}
		public DogContext dog() {
			return getRuleContext(DogContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				read_cmd();
					System.out.println("Reconheci um comando de leitura!");		
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				write_cmd();
					System.out.println("Reconheci um comando de escrita");		
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				decision_cmd();
					System.out.println("Reconheci um comando de decisao");		
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				attr_cmd();
					System.out.println("Reconheci um comando de atribuicao");	
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				forg();
					System.out.println("Reconheci um laço for");				
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(105);
				whileg();
					System.out.println("Reconheci um laço while");				
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				dog();
					System.out.println("Reconheci um laço do-while");			
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 8);
				{
				setState(111);
				comment();
					System.out.println("Reconheci um comentario");				
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__3);
			setState(117);
			matchWildcard();
			setState(118);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_cmdContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public Read_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterRead_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitRead_cmd(this);
		}
	}

	public final Read_cmdContext read_cmd() throws RecognitionException {
		Read_cmdContext _localctx = new Read_cmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_read_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__5);
			setState(121);
			match(L_PAREN);
			setState(122);
			match(ID);
				verifyID();
											
											_readId = _input.LT(-1).getText();
										
			setState(124);
			match(R_PAREN);
			setState(125);
			match(SC);
				MussumVariable var = (MussumVariable) symbolTable.get(_readId);
											ReadCommand cmd = new ReadCommand(_readId, var);	
											commandStack.peek().add(cmd);
										
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_cmdContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public Write_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterWrite_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitWrite_cmd(this);
		}
	}

	public final Write_cmdContext write_cmd() throws RecognitionException {
		Write_cmdContext _localctx = new Write_cmdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_write_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__6);
			setState(129);
			match(L_PAREN);
			setState(130);
			match(ID);
				verifyID(); 
											verifyAssignment();
											_writeId = _input.LT(-1).getText();
										
			setState(132);
			match(R_PAREN);
			setState(133);
			match(SC);
				WriteCommand cmd = new WriteCommand(_writeId);	
											commandStack.peek().add(cmd);
										
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decision_cmdContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MussumLanguisParser.IF, 0); }
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public List<TerminalNode> L_CURL() { return getTokens(MussumLanguisParser.L_CURL); }
		public TerminalNode L_CURL(int i) {
			return getToken(MussumLanguisParser.L_CURL, i);
		}
		public List<TerminalNode> R_CURL() { return getTokens(MussumLanguisParser.R_CURL); }
		public TerminalNode R_CURL(int i) {
			return getToken(MussumLanguisParser.R_CURL, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MussumLanguisParser.ELSE, 0); }
		public Decision_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decision_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterDecision_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitDecision_cmd(this);
		}
	}

	public final Decision_cmdContext decision_cmd() throws RecognitionException {
		Decision_cmdContext _localctx = new Decision_cmdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_decision_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(IF);
			setState(137);
			match(L_PAREN);
			setState(138);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
													verifyAssignment();
												
			setState(140);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();		
			setState(142);
			expr();
				_exprDecision += _exprContent;					
			setState(144);
			match(R_PAREN);
			setState(145);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
													commandStack.push(currThread);
													conditionStack.push(_exprDecision);
												
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(147);
				cmd();
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(152);
			match(R_CURL);
				trueList = commandStack.pop();					
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(154);
				match(ELSE);
				setState(155);
				match(L_CURL);
					currThread = new ArrayList<AbstractCommand>();	
														commandStack.push(currThread);
													
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(157);
					cmd();
					}
					}
					setState(160); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
				setState(162);
				match(R_CURL);
					falseList = commandStack.pop(); 				
				}
			}

				DecisionCommand cmd = new DecisionCommand(conditionStack.pop(), trueList, falseList);
													commandStack.peek().add(cmd);
												
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DogContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(MussumLanguisParser.DO, 0); }
		public TerminalNode L_CURL() { return getToken(MussumLanguisParser.L_CURL, 0); }
		public TerminalNode R_CURL() { return getToken(MussumLanguisParser.R_CURL, 0); }
		public TerminalNode WHILE() { return getToken(MussumLanguisParser.WHILE, 0); }
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public DogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterDog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitDog(this);
		}
	}

	public final DogContext dog() throws RecognitionException {
		DogContext _localctx = new DogContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(DO);
			setState(170);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprWhile);
									
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				cmd();
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(177);
			match(R_CURL);
				
											WhileCommand cmd = new WhileCommand(conditionStack.pop(), commandStack.pop());
											commandStack.peek().add(cmd);
									
			setState(179);
			match(WHILE);
			setState(180);
			match(L_PAREN);
			setState(181);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
									
			setState(183);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(185);
			expr();
				_exprWhile += _exprContent;					
			setState(187);
			match(R_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhilegContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MussumLanguisParser.WHILE, 0); }
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public TerminalNode L_CURL() { return getToken(MussumLanguisParser.L_CURL, 0); }
		public TerminalNode R_CURL() { return getToken(MussumLanguisParser.R_CURL, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public WhilegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterWhileg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitWhileg(this);
		}
	}

	public final WhilegContext whileg() throws RecognitionException {
		WhilegContext _localctx = new WhilegContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(WHILE);
			setState(190);
			match(L_PAREN);
			setState(191);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
										
			setState(193);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(195);
			expr();
				_exprWhile += _exprContent;					
			setState(197);
			match(R_PAREN);
			setState(198);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprWhile);
										
			setState(201); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(200);
				cmd();
				}
				}
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(205);
			match(R_CURL);
				
											WhileCommand cmd = new WhileCommand(conditionStack.pop(), commandStack.pop());
											commandStack.peek().add(cmd);
										
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForgContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MussumLanguisParser.FOR, 0); }
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public List<TerminalNode> ID() { return getTokens(MussumLanguisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumLanguisParser.ID, i);
		}
		public TerminalNode ATTR() { return getToken(MussumLanguisParser.ATTR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SC() { return getTokens(MussumLanguisParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(MussumLanguisParser.SC, i);
		}
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public TerminalNode OP_CHANGE() { return getToken(MussumLanguisParser.OP_CHANGE, 0); }
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public TerminalNode L_CURL() { return getToken(MussumLanguisParser.L_CURL, 0); }
		public TerminalNode R_CURL() { return getToken(MussumLanguisParser.R_CURL, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ForgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterForg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitForg(this);
		}
	}

	public final ForgContext forg() throws RecognitionException {
		ForgContext _localctx = new ForgContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(FOR);
			setState(209);
			match(L_PAREN);
			setState(210);
			match(ID);
			 	verifyID(); 
											_exprId = _input.LT(-1).getText();
											_attrVariable = _input.LT(-1).getText();
										
										
			setState(212);
			match(ATTR);
			 	_exprContent = "";	
											_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
										
			setState(214);
			expr();
			setState(215);
			match(SC);
				_exprFor = _exprId + " = " + _exprContent + ";";	
										
			setState(217);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(219);
			match(OPREL);
				_exprFor += _input.LT(-1).getText();		
											_exprContent = "";
										
			setState(221);
			expr();
				_exprFor += _exprContent;					
			setState(223);
			match(SC);
				_exprFor += _input.LT(-1).getText();		
			setState(225);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(227);
			match(OP_CHANGE);
				_exprFor += _input.LT(-1).getText();		
			setState(229);
			match(R_PAREN);
			setState(230);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprFor);
										
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				cmd();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(237);
			match(R_CURL);

											ForCommand cmd = new ForCommand(conditionStack.pop(), commandStack.pop());
											commandStack.peek().add(cmd);
										
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_cmdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(MussumLanguisParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public Attr_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterAttr_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitAttr_cmd(this);
		}
	}

	public final Attr_cmdContext attr_cmd() throws RecognitionException {
		Attr_cmdContext _localctx = new Attr_cmdContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attr_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(ID);
			 	verifyID(); 
														_exprId = _input.LT(-1).getText();
													
			setState(242);
			match(ATTR);
			 	_exprContent = "";	
														_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
													
			setState(244);
			expr();
			setState(245);
			match(SC);
				
														//assignValue();
														AttrCommand cmd = new AttrCommand(_exprId, _exprContent);	
														commandStack.peek().add(cmd);
													
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<Expr_tokenContext> expr_token() {
			return getRuleContexts(Expr_tokenContext.class);
		}
		public Expr_tokenContext expr_token(int i) {
			return getRuleContext(Expr_tokenContext.class,i);
		}
		public TerminalNode BOOLEAN_VAL() { return getToken(MussumLanguisParser.BOOLEAN_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(MussumLanguisParser.CHAR_VAL, 0); }
		public List<TerminalNode> OP() { return getTokens(MussumLanguisParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(MussumLanguisParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
			case DOUBLE_VAL:
			case STRING_VAL:
			case ID:
				{
				{
				setState(248);
				expr_token();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(249);
					match(OP);
					 _exprContent += _input.LT(-1).getText();	
					setState(251);
					expr_token();
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case BOOLEAN_VAL:
			case CHAR_VAL:
				{
				setState(261);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN_VAL:
					{
					setState(257);
					match(BOOLEAN_VAL);
						verifyVarType(MussumVariable.BOOLEAN);		
					}
					break;
				case CHAR_VAL:
					{
					setState(259);
					match(CHAR_VAL);
						verifyVarType(MussumVariable.CHAR);			
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
					_exprContent += _input.LT(-1).getText();	
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_tokenContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode INT_VAL() { return getToken(MussumLanguisParser.INT_VAL, 0); }
		public TerminalNode DOUBLE_VAL() { return getToken(MussumLanguisParser.DOUBLE_VAL, 0); }
		public TerminalNode STRING_VAL() { return getToken(MussumLanguisParser.STRING_VAL, 0); }
		public Expr_tokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterExpr_token(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitExpr_token(this);
		}
	}

	public final Expr_tokenContext expr_token() throws RecognitionException {
		Expr_tokenContext _localctx = new Expr_tokenContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(266);
				match(ID);
					verifyID();	
															verifyAssignment();
															int type = ((MussumVariable) symbolTable.get(_input.LT(-1).getText())).getType();
															verifyVarType(type);
														
				}
				break;
			case INT_VAL:
				{
				setState(268);
				match(INT_VAL);
					verifyVarType(MussumVariable.INT);			
				}
				break;
			case DOUBLE_VAL:
				{
				setState(270);
				match(DOUBLE_VAL);
					verifyVarType(MussumVariable.DOUBLE);		
				}
				break;
			case STRING_VAL:
				{
				setState(272);
				match(STRING_VAL);
					verifyVarType(MussumVariable.TEXT);			
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprContent += _input.LT(-1).getText();	
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0119\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\6\4:\n\4\r\4\16\4;\3\5\3\5\3\5\3\5\3\5\3\5\7\5D\n\5"+
		"\f\5\16\5G\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6U\n"+
		"\6\3\7\3\7\6\7Y\n\7\r\7\16\7Z\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bu\n\b\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0097"+
		"\n\f\r\f\16\f\u0098\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00a1\n\f\r\f\16\f\u00a2"+
		"\3\f\3\f\3\f\5\f\u00a8\n\f\3\f\3\f\3\r\3\r\3\r\3\r\6\r\u00b0\n\r\r\r\16"+
		"\r\u00b1\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00cc\n\16\r\16\16"+
		"\16\u00cd\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\6\17\u00ec\n\17\r\17\16\17\u00ed\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00ff\n\21\f\21"+
		"\16\21\u0102\13\21\3\21\3\21\3\21\3\21\5\21\u0108\n\21\3\21\5\21\u010b"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0115\n\22\3\22\3\22"+
		"\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\2\u0122\2\'"+
		"\3\2\2\2\4\60\3\2\2\2\69\3\2\2\2\b=\3\2\2\2\nT\3\2\2\2\fV\3\2\2\2\16t"+
		"\3\2\2\2\20v\3\2\2\2\22z\3\2\2\2\24\u0082\3\2\2\2\26\u008a\3\2\2\2\30"+
		"\u00ab\3\2\2\2\32\u00bf\3\2\2\2\34\u00d2\3\2\2\2\36\u00f2\3\2\2\2 \u010a"+
		"\3\2\2\2\"\u0114\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\3\2\2+,\5\6\4\2,-\5\f\7\2-.\7\4\2\2./"+
		"\b\2\1\2/\3\3\2\2\2\60\61\7\5\2\2\61\62\7#\2\2\62\63\7\37\2\2\63\64\5"+
		"\6\4\2\64\65\5\f\7\2\65\66\7 \2\2\66\67\b\3\1\2\67\5\3\2\2\28:\5\b\5\2"+
		"98\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=>\5\n\6\2>?\7#\2\2"+
		"?E\b\5\1\2@A\7!\2\2AB\7#\2\2BD\b\5\1\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2E"+
		"F\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\26\2\2I\t\3\2\2\2JK\7\n\2\2KU\b\6\1"+
		"\2LM\7\16\2\2MU\b\6\1\2NO\7\f\2\2OU\b\6\1\2PQ\7\20\2\2QU\b\6\1\2RS\7\22"+
		"\2\2SU\b\6\1\2TJ\3\2\2\2TL\3\2\2\2TN\3\2\2\2TP\3\2\2\2TR\3\2\2\2U\13\3"+
		"\2\2\2VX\b\7\1\2WY\5\16\b\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\r"+
		"\3\2\2\2\\]\5\22\n\2]^\b\b\1\2^u\3\2\2\2_`\5\24\13\2`a\b\b\1\2au\3\2\2"+
		"\2bc\5\26\f\2cd\b\b\1\2du\3\2\2\2ef\5\36\20\2fg\b\b\1\2gu\3\2\2\2hi\5"+
		"\34\17\2ij\b\b\1\2ju\3\2\2\2kl\5\32\16\2lm\b\b\1\2mu\3\2\2\2no\5\30\r"+
		"\2op\b\b\1\2pu\3\2\2\2qr\5\20\t\2rs\b\b\1\2su\3\2\2\2t\\\3\2\2\2t_\3\2"+
		"\2\2tb\3\2\2\2te\3\2\2\2th\3\2\2\2tk\3\2\2\2tn\3\2\2\2tq\3\2\2\2u\17\3"+
		"\2\2\2vw\7\6\2\2wx\13\2\2\2xy\7\7\2\2y\21\3\2\2\2z{\7\b\2\2{|\7\24\2\2"+
		"|}\7#\2\2}~\b\n\1\2~\177\7\25\2\2\177\u0080\7\26\2\2\u0080\u0081\b\n\1"+
		"\2\u0081\23\3\2\2\2\u0082\u0083\7\t\2\2\u0083\u0084\7\24\2\2\u0084\u0085"+
		"\7#\2\2\u0085\u0086\b\13\1\2\u0086\u0087\7\25\2\2\u0087\u0088\7\26\2\2"+
		"\u0088\u0089\b\13\1\2\u0089\25\3\2\2\2\u008a\u008b\7\32\2\2\u008b\u008c"+
		"\7\24\2\2\u008c\u008d\7#\2\2\u008d\u008e\b\f\1\2\u008e\u008f\7\"\2\2\u008f"+
		"\u0090\b\f\1\2\u0090\u0091\5 \21\2\u0091\u0092\b\f\1\2\u0092\u0093\7\25"+
		"\2\2\u0093\u0094\7\37\2\2\u0094\u0096\b\f\1\2\u0095\u0097\5\16\b\2\u0096"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7 \2\2\u009b\u00a7\b\f\1\2\u009c"+
		"\u009d\7\33\2\2\u009d\u009e\7\37\2\2\u009e\u00a0\b\f\1\2\u009f\u00a1\5"+
		"\16\b\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7 \2\2\u00a5\u00a6\b\f"+
		"\1\2\u00a6\u00a8\3\2\2\2\u00a7\u009c\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\b\f\1\2\u00aa\27\3\2\2\2\u00ab\u00ac\7\34\2"+
		"\2\u00ac\u00ad\7\37\2\2\u00ad\u00af\b\r\1\2\u00ae\u00b0\5\16\b\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7 \2\2\u00b4\u00b5\b\r\1\2\u00b5"+
		"\u00b6\7\36\2\2\u00b6\u00b7\7\24\2\2\u00b7\u00b8\7#\2\2\u00b8\u00b9\b"+
		"\r\1\2\u00b9\u00ba\7\"\2\2\u00ba\u00bb\b\r\1\2\u00bb\u00bc\5 \21\2\u00bc"+
		"\u00bd\b\r\1\2\u00bd\u00be\7\25\2\2\u00be\31\3\2\2\2\u00bf\u00c0\7\36"+
		"\2\2\u00c0\u00c1\7\24\2\2\u00c1\u00c2\7#\2\2\u00c2\u00c3\b\16\1\2\u00c3"+
		"\u00c4\7\"\2\2\u00c4\u00c5\b\16\1\2\u00c5\u00c6\5 \21\2\u00c6\u00c7\b"+
		"\16\1\2\u00c7\u00c8\7\25\2\2\u00c8\u00c9\7\37\2\2\u00c9\u00cb\b\16\1\2"+
		"\u00ca\u00cc\5\16\b\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7 \2\2\u00d0"+
		"\u00d1\b\16\1\2\u00d1\33\3\2\2\2\u00d2\u00d3\7\35\2\2\u00d3\u00d4\7\24"+
		"\2\2\u00d4\u00d5\7#\2\2\u00d5\u00d6\b\17\1\2\u00d6\u00d7\7\31\2\2\u00d7"+
		"\u00d8\b\17\1\2\u00d8\u00d9\5 \21\2\u00d9\u00da\7\26\2\2\u00da\u00db\b"+
		"\17\1\2\u00db\u00dc\7#\2\2\u00dc\u00dd\b\17\1\2\u00dd\u00de\7\"\2\2\u00de"+
		"\u00df\b\17\1\2\u00df\u00e0\5 \21\2\u00e0\u00e1\b\17\1\2\u00e1\u00e2\7"+
		"\26\2\2\u00e2\u00e3\b\17\1\2\u00e3\u00e4\7#\2\2\u00e4\u00e5\b\17\1\2\u00e5"+
		"\u00e6\7\30\2\2\u00e6\u00e7\b\17\1\2\u00e7\u00e8\7\25\2\2\u00e8\u00e9"+
		"\7\37\2\2\u00e9\u00eb\b\17\1\2\u00ea\u00ec\5\16\b\2\u00eb\u00ea\3\2\2"+
		"\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00f0\7 \2\2\u00f0\u00f1\b\17\1\2\u00f1\35\3\2\2\2\u00f2"+
		"\u00f3\7#\2\2\u00f3\u00f4\b\20\1\2\u00f4\u00f5\7\31\2\2\u00f5\u00f6\b"+
		"\20\1\2\u00f6\u00f7\5 \21\2\u00f7\u00f8\7\26\2\2\u00f8\u00f9\b\20\1\2"+
		"\u00f9\37\3\2\2\2\u00fa\u0100\5\"\22\2\u00fb\u00fc\7\27\2\2\u00fc\u00fd"+
		"\b\21\1\2\u00fd\u00ff\5\"\22\2\u00fe\u00fb\3\2\2\2\u00ff\u0102\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u010b\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0103\u0104\7\21\2\2\u0104\u0108\b\21\1\2\u0105\u0106\7\23\2"+
		"\2\u0106\u0108\b\21\1\2\u0107\u0103\3\2\2\2\u0107\u0105\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010b\b\21\1\2\u010a\u00fa\3\2\2\2\u010a\u0107\3"+
		"\2\2\2\u010b!\3\2\2\2\u010c\u010d\7#\2\2\u010d\u0115\b\22\1\2\u010e\u010f"+
		"\7\13\2\2\u010f\u0115\b\22\1\2\u0110\u0111\7\r\2\2\u0111\u0115\b\22\1"+
		"\2\u0112\u0113\7\17\2\2\u0113\u0115\b\22\1\2\u0114\u010c\3\2\2\2\u0114"+
		"\u010e\3\2\2\2\u0114\u0110\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\b\22\1\2\u0117#\3\2\2\2\22\';ETZt\u0098\u00a2\u00a7\u00b1"+
		"\u00cd\u00ed\u0100\u0107\u010a\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}