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
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, DOUBLE=6, STRING=7, BOOLEAN=8, 
		L_PAREN=9, R_PAREN=10, SC=11, OP=12, OP_CHANGE=13, ATTR=14, IF=15, ELSE=16, 
		FOR=17, WHILE=18, L_CURL=19, R_CURL=20, COMMA=21, OPREL=22, ID=23, NUMBER=24, 
		WS=25;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type = 3, RULE_block = 4, 
		RULE_cmd = 5, RULE_read_cmd = 6, RULE_write_cmd = 7, RULE_decision_cmd = 8, 
		RULE_whileg = 9, RULE_forg = 10, RULE_attr_cmd = 11, RULE_expr = 12, RULE_expr_token = 13;
	public static final String[] ruleNames = {
		"prog", "decl", "var_decl", "type", "block", "cmd", "read_cmd", "write_cmd", 
		"decision_cmd", "whileg", "forg", "attr_cmd", "expr", "expr_token"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'inputis'", "'escrevis'", "'inteiris'", 
		"'quebradis'", null, "'booleanis'", "'('", "')'", "';'", null, null, "'='", 
		"'se'", "'sen\u00E3ozis'", "'paris'", "'enquantis'", "'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "INT", "DOUBLE", "STRING", "BOOLEAN", "L_PAREN", 
		"R_PAREN", "SC", "OP", "OP_CHANGE", "ATTR", "IF", "ELSE", "FOR", "WHILE", 
		"L_CURL", "R_CURL", "COMMA", "OPREL", "ID", "NUMBER", "WS"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			decl();
			setState(30);
			block();
			setState(31);
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
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				var_decl();
				}
				}
				setState(37); 
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
		enterRule(_localctx, 4, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			type();
			setState(40);
			match(ID);
			 addSymbol(); 
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(42);
				match(COMMA);
				setState(43);
				match(ID);
				 addSymbol(); 
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(INT);
					_type = MussumVariable.INT;		
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(STRING);
					_type = MussumVariable.TEXT;	
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(DOUBLE);
					_type = MussumVariable.DOUBLE;	
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				currThread = new ArrayList<AbstractCommand>();
							commandStack.push(currThread);
						
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				cmd();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
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
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				read_cmd();
					System.out.println("Reconheci um comando de leitura!");		
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				write_cmd();
					System.out.println("Reconheci um comando de escrita");		
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				decision_cmd();
					System.out.println("Reconheci um comando de decisao");		
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				attr_cmd();
					System.out.println("Reconheci um comando de atribuicao");	
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				forg();
					System.out.println("Reconheci um laço for");				
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				whileg();
					System.out.println("Reconheci um laço while");				
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
		enterRule(_localctx, 12, RULE_read_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__2);
			setState(89);
			match(L_PAREN);
			setState(90);
			match(ID);
				verifyID();
											
											_readId = _input.LT(-1).getText();
										
			setState(92);
			match(R_PAREN);
			setState(93);
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
		enterRule(_localctx, 14, RULE_write_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__3);
			setState(97);
			match(L_PAREN);
			setState(98);
			match(ID);
				verifyID(); 
											verifyAssignment();
											_writeId = _input.LT(-1).getText();
										
			setState(100);
			match(R_PAREN);
			setState(101);
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
		enterRule(_localctx, 16, RULE_decision_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(IF);
			setState(105);
			match(L_PAREN);
			setState(106);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
													verifyAssignment();
												
			setState(108);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();		
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(110);
				match(ID);
				verifyAssignment();
				}
				break;
			case NUMBER:
				{
				setState(112);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprDecision += _input.LT(-1).getText();		
			setState(116);
			match(R_PAREN);
			setState(117);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
													commandStack.push(currThread);
												
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				cmd();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(124);
			match(R_CURL);
				trueList = commandStack.pop();					
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(126);
				match(ELSE);
				setState(127);
				match(L_CURL);
					currThread = new ArrayList<AbstractCommand>();	
														commandStack.push(currThread);
													
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					cmd();
					}
					}
					setState(132); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
				setState(134);
				match(R_CURL);
					falseList = commandStack.pop();
														DecisionCommand cmd = new DecisionCommand(_exprDecision, trueList, falseList);
														commandStack.peek().add(cmd);
													
				}
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
		enterRule(_localctx, 18, RULE_whileg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(WHILE);
			setState(140);
			match(L_PAREN);
			setState(141);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
										
			setState(143);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(145);
				match(ID);
				verifyAssignment();
				}
				break;
			case NUMBER:
				{
				setState(147);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprWhile += _input.LT(-1).getText();		
			setState(151);
			match(R_PAREN);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(159);
			match(R_CURL);
				commandList = commandStack.pop();	
											WhileCommand cmd = new WhileCommand(_exprWhile, commandList);
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
		public Attr_cmdContext attr_cmd() {
			return getRuleContext(Attr_cmdContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MussumLanguisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumLanguisParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(MussumLanguisParser.OPREL, 0); }
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
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
		enterRule(_localctx, 20, RULE_forg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(FOR);
			setState(163);
			match(L_PAREN);
			setState(164);
			attr_cmd();
			setState(165);
			match(ID);
				_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(167);
			match(OPREL);
				_exprFor += _input.LT(-1).getText();		
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(169);
				match(NUMBER);
				}
				break;
			case ID:
				{
				setState(170);
				match(ID);
				verifyAssignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprFor += _input.LT(-1).getText();		
			setState(175);
			match(SC);
				_exprFor += _input.LT(-1).getText();		
			setState(177);
			match(ID);
				_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(179);
			match(OP_CHANGE);
				_exprFor += _input.LT(-1).getText();		
			setState(181);
			match(R_PAREN);
			setState(182);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
										
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				cmd();
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(189);
			match(R_CURL);
				commandList = commandStack.pop();	
											ForCommand cmd = new ForCommand(_exprFor, commandList);
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
		enterRule(_localctx, 22, RULE_attr_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ID);
			 	verifyID(); 
										_exprId = _input.LT(-1).getText();
										_attrVariable = _input.LT(-1).getText();
										
									
			setState(194);
			match(ATTR);
			 	_exprContent = "";	
			setState(196);
			expr();
			setState(197);
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			expr_token();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(201);
				match(OP);
				 _exprContent += _input.LT(-1).getText();	
				setState(203);
				expr_token();
				}
				}
				setState(208);
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
		enterRule(_localctx, 26, RULE_expr_token);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(ID);
					verifyID();
											_exprContent += _input.LT(-1).getText();
											_attrValue = _input.LT(-1).getText();
										
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00da\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\6\6C\n\6\r"+
		"\6\16\6D\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\6\n{\n\n\r\n\16\n|\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0085\n\n\r"+
		"\n\16\n\u0086\3\n\3\n\3\n\5\n\u008c\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0097\n\13\3\13\3\13\3\13\3\13\3\13\6\13\u009e\n"+
		"\13\r\13\16\13\u009f\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00af\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00bc"+
		"\n\f\r\f\16\f\u00bd\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\7\16\u00cf\n\16\f\16\16\16\u00d2\13\16\3\17\3\17\3\17\3"+
		"\17\5\17\u00d8\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2"+
		"\2\2\u00e0\2\36\3\2\2\2\4%\3\2\2\2\6)\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\f"+
		"X\3\2\2\2\16Z\3\2\2\2\20b\3\2\2\2\22j\3\2\2\2\24\u008d\3\2\2\2\26\u00a4"+
		"\3\2\2\2\30\u00c2\3\2\2\2\32\u00ca\3\2\2\2\34\u00d7\3\2\2\2\36\37\7\3"+
		"\2\2\37 \5\4\3\2 !\5\n\6\2!\"\7\4\2\2\"#\b\2\1\2#\3\3\2\2\2$&\5\6\4\2"+
		"%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)*\5\b\5\2*+\7\31"+
		"\2\2+\61\b\4\1\2,-\7\27\2\2-.\7\31\2\2.\60\b\4\1\2/,\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\r\2"+
		"\2\65\7\3\2\2\2\66\67\7\7\2\2\67?\b\5\1\289\7\t\2\29?\b\5\1\2:;\7\b\2"+
		"\2;?\b\5\1\2<=\7\n\2\2=?\b\5\1\2>\66\3\2\2\2>8\3\2\2\2>:\3\2\2\2><\3\2"+
		"\2\2?\t\3\2\2\2@B\b\6\1\2AC\5\f\7\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3"+
		"\2\2\2E\13\3\2\2\2FG\5\16\b\2GH\b\7\1\2HY\3\2\2\2IJ\5\20\t\2JK\b\7\1\2"+
		"KY\3\2\2\2LM\5\22\n\2MN\b\7\1\2NY\3\2\2\2OP\5\30\r\2PQ\b\7\1\2QY\3\2\2"+
		"\2RS\5\26\f\2ST\b\7\1\2TY\3\2\2\2UV\5\24\13\2VW\b\7\1\2WY\3\2\2\2XF\3"+
		"\2\2\2XI\3\2\2\2XL\3\2\2\2XO\3\2\2\2XR\3\2\2\2XU\3\2\2\2Y\r\3\2\2\2Z["+
		"\7\5\2\2[\\\7\13\2\2\\]\7\31\2\2]^\b\b\1\2^_\7\f\2\2_`\7\r\2\2`a\b\b\1"+
		"\2a\17\3\2\2\2bc\7\6\2\2cd\7\13\2\2de\7\31\2\2ef\b\t\1\2fg\7\f\2\2gh\7"+
		"\r\2\2hi\b\t\1\2i\21\3\2\2\2jk\7\21\2\2kl\7\13\2\2lm\7\31\2\2mn\b\n\1"+
		"\2no\7\30\2\2os\b\n\1\2pq\7\31\2\2qt\b\n\1\2rt\7\32\2\2sp\3\2\2\2sr\3"+
		"\2\2\2tu\3\2\2\2uv\b\n\1\2vw\7\f\2\2wx\7\25\2\2xz\b\n\1\2y{\5\f\7\2zy"+
		"\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\26\2\2\177\u008b"+
		"\b\n\1\2\u0080\u0081\7\22\2\2\u0081\u0082\7\25\2\2\u0082\u0084\b\n\1\2"+
		"\u0083\u0085\5\f\7\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\26\2\2"+
		"\u0089\u008a\b\n\1\2\u008a\u008c\3\2\2\2\u008b\u0080\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\23\3\2\2\2\u008d\u008e\7\24\2\2\u008e\u008f\7\13\2\2\u008f"+
		"\u0090\7\31\2\2\u0090\u0091\b\13\1\2\u0091\u0092\7\30\2\2\u0092\u0096"+
		"\b\13\1\2\u0093\u0094\7\31\2\2\u0094\u0097\b\13\1\2\u0095\u0097\7\32\2"+
		"\2\u0096\u0093\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099"+
		"\b\13\1\2\u0099\u009a\7\f\2\2\u009a\u009b\7\25\2\2\u009b\u009d\b\13\1"+
		"\2\u009c\u009e\5\f\7\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\26\2\2"+
		"\u00a2\u00a3\b\13\1\2\u00a3\25\3\2\2\2\u00a4\u00a5\7\23\2\2\u00a5\u00a6"+
		"\7\13\2\2\u00a6\u00a7\5\30\r\2\u00a7\u00a8\7\31\2\2\u00a8\u00a9\b\f\1"+
		"\2\u00a9\u00aa\7\30\2\2\u00aa\u00ae\b\f\1\2\u00ab\u00af\7\32\2\2\u00ac"+
		"\u00ad\7\31\2\2\u00ad\u00af\b\f\1\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\f\1\2\u00b1\u00b2\7\r\2\2\u00b2"+
		"\u00b3\b\f\1\2\u00b3\u00b4\7\31\2\2\u00b4\u00b5\b\f\1\2\u00b5\u00b6\7"+
		"\17\2\2\u00b6\u00b7\b\f\1\2\u00b7\u00b8\7\f\2\2\u00b8\u00b9\7\25\2\2\u00b9"+
		"\u00bb\b\f\1\2\u00ba\u00bc\5\f\7\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c0\7\26\2\2\u00c0\u00c1\b\f\1\2\u00c1\27\3\2\2\2\u00c2\u00c3\7\31"+
		"\2\2\u00c3\u00c4\b\r\1\2\u00c4\u00c5\7\20\2\2\u00c5\u00c6\b\r\1\2\u00c6"+
		"\u00c7\5\32\16\2\u00c7\u00c8\7\r\2\2\u00c8\u00c9\b\r\1\2\u00c9\31\3\2"+
		"\2\2\u00ca\u00d0\5\34\17\2\u00cb\u00cc\7\16\2\2\u00cc\u00cd\b\16\1\2\u00cd"+
		"\u00cf\5\34\17\2\u00ce\u00cb\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\33\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\u00d4\7\31\2\2\u00d4\u00d8\b\17\1\2\u00d5\u00d6\7\32\2\2\u00d6\u00d8"+
		"\b\17\1\2\u00d7\u00d3\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\35\3\2\2\2\21"+
		"\'\61>DXs|\u0086\u008b\u0096\u009f\u00ae\u00bd\u00d0\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}