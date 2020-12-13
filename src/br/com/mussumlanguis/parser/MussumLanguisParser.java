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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT=8, DOUBLE=9, 
		STRING=10, BOOLEAN=11, L_PAREN=12, R_PAREN=13, SC=14, OP=15, OP_CHANGE=16, 
		ATTR=17, IF=18, ELSE=19, FOR=20, WHILE=21, L_CURL=22, R_CURL=23, COMMA=24, 
		OPREL=25, ID=26, NUMBER=27, WS=28;
	public static final int
		RULE_prog = 0, RULE_function = 1, RULE_decl = 2, RULE_var_decl = 3, RULE_type = 4, 
		RULE_block = 5, RULE_cmd = 6, RULE_comment = 7, RULE_read_cmd = 8, RULE_write_cmd = 9, 
		RULE_decision_cmd = 10, RULE_whileg = 11, RULE_forg = 12, RULE_attr_cmd = 13, 
		RULE_expr = 14, RULE_expr_token = 15;
	public static final String[] ruleNames = {
		"prog", "function", "decl", "var_decl", "type", "block", "cmd", "comment", 
		"read_cmd", "write_cmd", "decision_cmd", "whileg", "forg", "attr_cmd", 
		"expr", "expr_token"
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(32);
				function();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(T__0);
			setState(39);
			decl();
			setState(40);
			block();
			setState(41);
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
			setState(44);
			match(T__2);
			setState(45);
			match(ID);
			setState(46);
			match(L_CURL);
			setState(47);
			decl();
			setState(48);
			block();
			setState(49);
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
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				var_decl();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << STRING) | (1L << BOOLEAN))) != 0) );
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
			setState(57);
			type();
			setState(58);
			match(ID);
			 addSymbol(); 
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(60);
				match(COMMA);
				setState(61);
				match(ID);
				 addSymbol(); 
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
		public TerminalNode INT() { return getToken(MussumLanguisParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MussumLanguisParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(MussumLanguisParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(MussumLanguisParser.BOOLEAN, 0); }
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
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(INT);
					_type = MussumVariable.INT;		
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(STRING);
					_type = MussumVariable.TEXT;	
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(DOUBLE);
					_type = MussumVariable.DOUBLE;	
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(BOOLEAN);
					_type = MussumVariable.BOOLEAN;	
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
						
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				cmd();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
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
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				read_cmd();
					System.out.println("Reconheci um comando de leitura!");		
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				write_cmd();
					System.out.println("Reconheci um comando de escrita");		
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				decision_cmd();
					System.out.println("Reconheci um comando de decisao");		
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				attr_cmd();
					System.out.println("Reconheci um comando de atribuicao");	
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				forg();
					System.out.println("Reconheci um laço for");				
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(101);
				whileg();
					System.out.println("Reconheci um laço while");				
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
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
			setState(109);
			match(T__3);
			setState(110);
			matchWildcard();
			setState(111);
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
			setState(113);
			match(T__5);
			setState(114);
			match(L_PAREN);
			setState(115);
			match(ID);
				verifyID();
											
											_readId = _input.LT(-1).getText();
										
			setState(117);
			match(R_PAREN);
			setState(118);
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
			setState(121);
			match(T__6);
			setState(122);
			match(L_PAREN);
			setState(123);
			match(ID);
				verifyID(); 
											verifyAssignment();
											_writeId = _input.LT(-1).getText();
										
			setState(125);
			match(R_PAREN);
			setState(126);
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
		public List<TerminalNode> ID() { return getTokens(MussumLanguisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumLanguisParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public List<TerminalNode> L_CURL() { return getTokens(MussumLanguisParser.L_CURL); }
		public TerminalNode L_CURL(int i) {
			return getToken(MussumLanguisParser.L_CURL, i);
		}
		public List<TerminalNode> R_CURL() { return getTokens(MussumLanguisParser.R_CURL); }
		public TerminalNode R_CURL(int i) {
			return getToken(MussumLanguisParser.R_CURL, i);
		}
		public TerminalNode NUMBER() { return getToken(MussumLanguisParser.NUMBER, 0); }
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
			setState(129);
			match(IF);
			setState(130);
			match(L_PAREN);
			setState(131);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
													verifyAssignment();
												
			setState(133);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();		
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(135);
				match(ID);
					verifyAssignment();								
				}
				break;
			case NUMBER:
				{
				setState(137);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprDecision += _input.LT(-1).getText();		
			setState(141);
			match(R_PAREN);
			setState(142);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
													commandStack.push(currThread);
													conditionStack.push(_exprDecision);
												
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				cmd();
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(149);
			match(R_CURL);
				trueList = commandStack.pop();					
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(151);
				match(ELSE);
				setState(152);
				match(L_CURL);
					currThread = new ArrayList<AbstractCommand>();	
														commandStack.push(currThread);
													
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(154);
					cmd();
					}
					}
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
				setState(159);
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

	public static class WhilegContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MussumLanguisParser.WHILE, 0); }
		public TerminalNode L_PAREN() { return getToken(MussumLanguisParser.L_PAREN, 0); }
		public List<TerminalNode> ID() { return getTokens(MussumLanguisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumLanguisParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public TerminalNode L_CURL() { return getToken(MussumLanguisParser.L_CURL, 0); }
		public TerminalNode R_CURL() { return getToken(MussumLanguisParser.R_CURL, 0); }
		public TerminalNode NUMBER() { return getToken(MussumLanguisParser.NUMBER, 0); }
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
		enterRule(_localctx, 22, RULE_whileg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(WHILE);
			setState(167);
			match(L_PAREN);
			setState(168);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
										
			setState(170);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(172);
				match(ID);
					verifyAssignment();							
				}
				break;
			case NUMBER:
				{
				setState(174);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprWhile += _input.LT(-1).getText();		
			setState(178);
			match(R_PAREN);
			setState(179);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprWhile);
										
			setState(182); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(181);
				cmd();
				}
				}
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(186);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		public TerminalNode NUMBER() { return getToken(MussumLanguisParser.NUMBER, 0); }
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
		enterRule(_localctx, 24, RULE_forg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(FOR);
			setState(190);
			match(L_PAREN);
			setState(191);
			match(ID);
			 	verifyID(); 
											_exprId = _input.LT(-1).getText();
											_attrVariable = _input.LT(-1).getText();
										
										
			setState(193);
			match(ATTR);
			 	_exprContent = "";	
			setState(195);
			expr();
			setState(196);
			match(SC);
				_exprFor = _exprId + " = " + _exprContent + ";";	
										
			setState(198);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(200);
			match(OPREL);
				_exprFor += _input.LT(-1).getText();		
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(202);
				match(NUMBER);
				}
				break;
			case ID:
				{
				setState(203);
				match(ID);
					verifyAssignment();							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprFor += _input.LT(-1).getText();		
			setState(208);
			match(SC);
				_exprFor += _input.LT(-1).getText();		
			setState(210);
			match(ID);
				_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(212);
			match(OP_CHANGE);
				_exprFor += _input.LT(-1).getText();		
			setState(214);
			match(R_PAREN);
			setState(215);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprFor);
										
			setState(218); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(217);
				cmd();
				}
				}
				setState(220); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(222);
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
		enterRule(_localctx, 26, RULE_attr_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ID);
			 	verifyID(); 
										_exprId = _input.LT(-1).getText();
										_attrVariable = _input.LT(-1).getText();
										
									
			setState(227);
			match(ATTR);
			 	_exprContent = "";	
			setState(229);
			expr();
			setState(230);
			match(SC);
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
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			expr_token();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(234);
				match(OP);
				 _exprContent += _input.LT(-1).getText();	
				setState(236);
				expr_token();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public TerminalNode NUMBER() { return getToken(MussumLanguisParser.NUMBER, 0); }
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
		enterRule(_localctx, 30, RULE_expr_token);
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(ID);
					verifyID();
											_exprContent += _input.LT(-1).getText();
											_attrValue = _input.LT(-1).getText();
										
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(NUMBER);
					_exprContent += _input.LT(-1).getText();
											_attrValue = _input.LT(-1).getText();
											assignValue();
										
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00fb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2"+
		"$\n\2\f\2\16\2\'\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\6\48\n\4\r\4\16\49\3\5\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16"+
		"\5E\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6Q\n\6\3\7\3\7\6\7"+
		"U\n\7\r\7\16\7V\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008d\n\f\3\f\3\f\3\f\3\f\3\f\6\f\u0094\n"+
		"\f\r\f\16\f\u0095\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u009e\n\f\r\f\16\f\u009f"+
		"\3\f\3\f\3\f\5\f\u00a5\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00b2\n\r\3\r\3\r\3\r\3\r\3\r\6\r\u00b9\n\r\r\r\16\r\u00ba\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00d0\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\6\16\u00dd\n\16\r\16\16\16\u00de\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00f0\n\20"+
		"\f\20\16\20\u00f3\13\20\3\21\3\21\3\21\3\21\5\21\u00f9\n\21\3\21\2\2\22"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u0101\2%\3\2\2\2\4.\3\2"+
		"\2\2\6\67\3\2\2\2\b;\3\2\2\2\nP\3\2\2\2\fR\3\2\2\2\16m\3\2\2\2\20o\3\2"+
		"\2\2\22s\3\2\2\2\24{\3\2\2\2\26\u0083\3\2\2\2\30\u00a8\3\2\2\2\32\u00bf"+
		"\3\2\2\2\34\u00e3\3\2\2\2\36\u00eb\3\2\2\2 \u00f8\3\2\2\2\"$\5\4\3\2#"+
		"\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\3\2"+
		"\2)*\5\6\4\2*+\5\f\7\2+,\7\4\2\2,-\b\2\1\2-\3\3\2\2\2./\7\5\2\2/\60\7"+
		"\34\2\2\60\61\7\30\2\2\61\62\5\6\4\2\62\63\5\f\7\2\63\64\7\31\2\2\64\65"+
		"\b\3\1\2\65\5\3\2\2\2\668\5\b\5\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\2"+
		"9:\3\2\2\2:\7\3\2\2\2;<\5\n\6\2<=\7\34\2\2=C\b\5\1\2>?\7\32\2\2?@\7\34"+
		"\2\2@B\b\5\1\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2"+
		"\2\2FG\7\20\2\2G\t\3\2\2\2HI\7\n\2\2IQ\b\6\1\2JK\7\f\2\2KQ\b\6\1\2LM\7"+
		"\13\2\2MQ\b\6\1\2NO\7\r\2\2OQ\b\6\1\2PH\3\2\2\2PJ\3\2\2\2PL\3\2\2\2PN"+
		"\3\2\2\2Q\13\3\2\2\2RT\b\7\1\2SU\5\16\b\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2"+
		"\2VW\3\2\2\2W\r\3\2\2\2XY\5\22\n\2YZ\b\b\1\2Zn\3\2\2\2[\\\5\24\13\2\\"+
		"]\b\b\1\2]n\3\2\2\2^_\5\26\f\2_`\b\b\1\2`n\3\2\2\2ab\5\34\17\2bc\b\b\1"+
		"\2cn\3\2\2\2de\5\32\16\2ef\b\b\1\2fn\3\2\2\2gh\5\30\r\2hi\b\b\1\2in\3"+
		"\2\2\2jk\5\20\t\2kl\b\b\1\2ln\3\2\2\2mX\3\2\2\2m[\3\2\2\2m^\3\2\2\2ma"+
		"\3\2\2\2md\3\2\2\2mg\3\2\2\2mj\3\2\2\2n\17\3\2\2\2op\7\6\2\2pq\13\2\2"+
		"\2qr\7\7\2\2r\21\3\2\2\2st\7\b\2\2tu\7\16\2\2uv\7\34\2\2vw\b\n\1\2wx\7"+
		"\17\2\2xy\7\20\2\2yz\b\n\1\2z\23\3\2\2\2{|\7\t\2\2|}\7\16\2\2}~\7\34\2"+
		"\2~\177\b\13\1\2\177\u0080\7\17\2\2\u0080\u0081\7\20\2\2\u0081\u0082\b"+
		"\13\1\2\u0082\25\3\2\2\2\u0083\u0084\7\24\2\2\u0084\u0085\7\16\2\2\u0085"+
		"\u0086\7\34\2\2\u0086\u0087\b\f\1\2\u0087\u0088\7\33\2\2\u0088\u008c\b"+
		"\f\1\2\u0089\u008a\7\34\2\2\u008a\u008d\b\f\1\2\u008b\u008d\7\35\2\2\u008c"+
		"\u0089\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\f"+
		"\1\2\u008f\u0090\7\17\2\2\u0090\u0091\7\30\2\2\u0091\u0093\b\f\1\2\u0092"+
		"\u0094\5\16\b\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\31\2\2\u0098"+
		"\u00a4\b\f\1\2\u0099\u009a\7\25\2\2\u009a\u009b\7\30\2\2\u009b\u009d\b"+
		"\f\1\2\u009c\u009e\5\16\b\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\31"+
		"\2\2\u00a2\u00a3\b\f\1\2\u00a3\u00a5\3\2\2\2\u00a4\u0099\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\f\1\2\u00a7\27\3\2\2"+
		"\2\u00a8\u00a9\7\27\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\7\34\2\2\u00ab"+
		"\u00ac\b\r\1\2\u00ac\u00ad\7\33\2\2\u00ad\u00b1\b\r\1\2\u00ae\u00af\7"+
		"\34\2\2\u00af\u00b2\b\r\1\2\u00b0\u00b2\7\35\2\2\u00b1\u00ae\3\2\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\r\1\2\u00b4\u00b5\7\17"+
		"\2\2\u00b5\u00b6\7\30\2\2\u00b6\u00b8\b\r\1\2\u00b7\u00b9\5\16\b\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\31\2\2\u00bd\u00be\b\r\1\2\u00be"+
		"\31\3\2\2\2\u00bf\u00c0\7\26\2\2\u00c0\u00c1\7\16\2\2\u00c1\u00c2\7\34"+
		"\2\2\u00c2\u00c3\b\16\1\2\u00c3\u00c4\7\23\2\2\u00c4\u00c5\b\16\1\2\u00c5"+
		"\u00c6\5\36\20\2\u00c6\u00c7\7\20\2\2\u00c7\u00c8\b\16\1\2\u00c8\u00c9"+
		"\7\34\2\2\u00c9\u00ca\b\16\1\2\u00ca\u00cb\7\33\2\2\u00cb\u00cf\b\16\1"+
		"\2\u00cc\u00d0\7\35\2\2\u00cd\u00ce\7\34\2\2\u00ce\u00d0\b\16\1\2\u00cf"+
		"\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b\16"+
		"\1\2\u00d2\u00d3\7\20\2\2\u00d3\u00d4\b\16\1\2\u00d4\u00d5\7\34\2\2\u00d5"+
		"\u00d6\b\16\1\2\u00d6\u00d7\7\22\2\2\u00d7\u00d8\b\16\1\2\u00d8\u00d9"+
		"\7\17\2\2\u00d9\u00da\7\30\2\2\u00da\u00dc\b\16\1\2\u00db\u00dd\5\16\b"+
		"\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\31\2\2\u00e1\u00e2\b\16\1\2"+
		"\u00e2\33\3\2\2\2\u00e3\u00e4\7\34\2\2\u00e4\u00e5\b\17\1\2\u00e5\u00e6"+
		"\7\23\2\2\u00e6\u00e7\b\17\1\2\u00e7\u00e8\5\36\20\2\u00e8\u00e9\7\20"+
		"\2\2\u00e9\u00ea\b\17\1\2\u00ea\35\3\2\2\2\u00eb\u00f1\5 \21\2\u00ec\u00ed"+
		"\7\21\2\2\u00ed\u00ee\b\20\1\2\u00ee\u00f0\5 \21\2\u00ef\u00ec\3\2\2\2"+
		"\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\37"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\34\2\2\u00f5\u00f9\b\21\1\2"+
		"\u00f6\u00f7\7\35\2\2\u00f7\u00f9\b\21\1\2\u00f8\u00f4\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f9!\3\2\2\2\22%9CPVm\u008c\u0095\u009f\u00a4\u00b1\u00ba\u00cf"+
		"\u00de\u00f1\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}