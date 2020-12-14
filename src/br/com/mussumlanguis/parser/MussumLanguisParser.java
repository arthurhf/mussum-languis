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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT_DECL=7, INT_VAL=8, 
		DOUBLE_DECL=9, DOUBLE_VAL=10, STRING_DECL=11, STRING_VAL=12, BOOLEAN_DECL=13, 
		BOOLEAN_VAL=14, CHAR_DECL=15, CHAR_VAL=16, L_PAREN=17, R_PAREN=18, SC=19, 
		OP=20, OP_CHANGE=21, ATTR=22, IF=23, ELSE=24, DO=25, FOR=26, WHILE=27, 
		L_CURL=28, R_CURL=29, COMMA=30, OPREL=31, ID=32, WS=33;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type = 3, RULE_block = 4, 
		RULE_cmd = 5, RULE_comment = 6, RULE_read_cmd = 7, RULE_write_cmd = 8, 
		RULE_decision_cmd = 9, RULE_dog = 10, RULE_whileg = 11, RULE_forg = 12, 
		RULE_attr_cmd = 13, RULE_expr = 14, RULE_expr_token = 15;
	public static final String[] ruleNames = {
		"prog", "decl", "var_decl", "type", "block", "cmd", "comment", "read_cmd", 
		"write_cmd", "decision_cmd", "dog", "whileg", "forg", "attr_cmd", "expr", 
		"expr_token"
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

	public MussumLanguisParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
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
			setState(32);
			match(T__0);
			setState(33);
			block();
			setState(34);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(37);
					var_decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(40); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public List<TerminalNode> ATTR() { return getTokens(MussumLanguisParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(MussumLanguisParser.ATTR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
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
			setState(42);
			type();
			setState(43);
			match(ID);
				addSymbol();	
												_exprId = _input.LT(-1).getText();
											
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(45);
				match(ATTR);
				 	_exprContent = "";	
													_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
												
				setState(47);
				expr();
					assignValue();			
													AttrCommand cmd = new AttrCommand(_exprId, _exprContent);	
													commandStack.peek().add(cmd);
												
				}
			}

			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(52);
				match(COMMA);
				setState(53);
				match(ID);
				 	addSymbol(); 			
													_exprId = _input.LT(-1).getText();
												
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ATTR) {
					{
					setState(55);
					match(ATTR);
					 	_exprContent = "";	
														_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
													
					setState(57);
					expr();
						assignValue();			
														AttrCommand cmd = new AttrCommand(_exprId, _exprContent);
														commandStack.peek().add(cmd);
													
					}
				}

				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(INT_DECL);
					_type = MussumVariable.INT;		
				}
				break;
			case STRING_DECL:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(STRING_DECL);
					_type = MussumVariable.TEXT;	
				}
				break;
			case DOUBLE_DECL:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(DOUBLE_DECL);
					_type = MussumVariable.DOUBLE;	
				}
				break;
			case BOOLEAN_DECL:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				match(BOOLEAN_DECL);
					_type = MussumVariable.BOOLEAN;	
				}
				break;
			case CHAR_DECL:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
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
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
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
						
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(84);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(82);
					cmd();
					}
					break;
				case 2:
					{
					setState(83);
					decl();
					}
					break;
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
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
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				read_cmd();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				write_cmd();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				decision_cmd();
				}
				break;
			case INT_DECL:
			case DOUBLE_DECL:
			case STRING_DECL:
			case BOOLEAN_DECL:
			case CHAR_DECL:
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				attr_cmd();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				forg();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				whileg();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 7);
				{
				setState(94);
				dog();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 8);
				{
				setState(95);
				comment();
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
		enterRule(_localctx, 12, RULE_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__2);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(99);
					matchWildcard();
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(105);
			match(T__3);
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
		enterRule(_localctx, 14, RULE_read_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__4);
			setState(108);
			match(L_PAREN);
			setState(109);
			match(ID);
				verifyID();
											
											_readId = _input.LT(-1).getText();
										
			setState(111);
			match(R_PAREN);
			setState(112);
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
		enterRule(_localctx, 16, RULE_write_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__5);
			setState(116);
			match(L_PAREN);
			setState(117);
			match(ID);
				verifyID(); 
											verifyAssignment();
											_writeId = _input.LT(-1).getText();
										
			setState(119);
			match(R_PAREN);
			setState(120);
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
		enterRule(_localctx, 18, RULE_decision_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(IF);
			setState(124);
			match(L_PAREN);
			setState(125);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
													verifyAssignment();
													_exprContent = "";
												
			setState(127);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();		
			setState(129);
			expr();
				_exprDecision += _exprContent;					
			setState(131);
			match(R_PAREN);
			setState(132);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
													commandStack.push(currThread);
													conditionStack.push(_exprDecision);
												
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(134);
				cmd();
				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(139);
			match(R_CURL);
				trueList = commandStack.pop();					
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(141);
				match(ELSE);
				setState(142);
				match(L_CURL);
					currThread = new ArrayList<AbstractCommand>();	
														commandStack.push(currThread);
													
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
				setState(149);
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
		enterRule(_localctx, 20, RULE_dog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(DO);
			setState(157);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
										commandStack.push(currThread);
									
			setState(160); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(159);
				cmd();
				}
				}
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(164);
			match(R_CURL);
			setState(165);
			match(WHILE);
			setState(166);
			match(L_PAREN);
			setState(167);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
										verifyAssignment();
										_exprContent = "";
									
			setState(169);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(171);
			expr();
				_exprWhile += _exprContent;					
			setState(173);
			match(R_PAREN);
				
										DoWhileCommand cmd = new DoWhileCommand(_exprWhile, commandStack.pop());
										commandStack.peek().add(cmd);
									
			setState(175);
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
		enterRule(_localctx, 22, RULE_whileg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(WHILE);
			setState(178);
			match(L_PAREN);
			setState(179);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
											_exprContent = "";
										
			setState(181);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(183);
			expr();
				_exprWhile += _exprContent;					
			setState(185);
			match(R_PAREN);
			setState(186);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprWhile);
										
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				cmd();
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(193);
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
		enterRule(_localctx, 24, RULE_forg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(FOR);
			setState(197);
			match(L_PAREN);
			setState(198);
			match(ID);
			 	verifyID(); 
											_exprId = _input.LT(-1).getText();
											_attrVariable = _input.LT(-1).getText();
										
										
			setState(200);
			match(ATTR);
			 	_exprContent = "";	
											_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
										
			setState(202);
			expr();
			setState(203);
			match(SC);
				_exprFor = _exprId + " = " + _exprContent + ";";	
											assignValue();
										
			setState(205);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(207);
			match(OPREL);
				_exprFor += _input.LT(-1).getText();		
											_exprContent = "";
										
			setState(209);
			expr();
				_exprFor += _exprContent;					
			setState(211);
			match(SC);
				_exprFor += _input.LT(-1).getText();		
			setState(213);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(215);
			match(OP_CHANGE);
				_exprFor += _input.LT(-1).getText();		
			setState(217);
			match(R_PAREN);
			setState(218);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprFor);
										
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(220);
				cmd();
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << INT_DECL) | (1L << DOUBLE_DECL) | (1L << STRING_DECL) | (1L << BOOLEAN_DECL) | (1L << CHAR_DECL) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(225);
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
		public TerminalNode ATTR() { return getToken(MussumLanguisParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
			case DOUBLE_DECL:
			case STRING_DECL:
			case BOOLEAN_DECL:
			case CHAR_DECL:
				{
				{
				setState(228);
				type();
				setState(229);
				match(ID);
				}
				 	addSymbol(); 							
				}
				break;
			case ID:
				{
				setState(233);
				match(ID);
				 	verifyID(); 							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				_exprId = _input.LT(-1).getText();		
			setState(238);
			match(ATTR);
			 	_exprContent = "";	
														_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
													
			setState(240);
			expr();
			setState(241);
			match(SC);
				
														assignValue();
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
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
			case DOUBLE_VAL:
			case STRING_VAL:
			case ID:
				{
				{
				setState(244);
				expr_token();
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(245);
					match(OP);
					 _exprContent += _input.LT(-1).getText();	
					setState(247);
					expr_token();
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case BOOLEAN_VAL:
			case CHAR_VAL:
				{
				setState(257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN_VAL:
					{
					setState(253);
					match(BOOLEAN_VAL);
						verifyVarType(MussumVariable.BOOLEAN);		
																String booleanInput = _input.LT(-1).getText();
																_exprContent += booleanInput.equals("falsis") ? "false" : "true";
															
					}
					break;
				case CHAR_VAL:
					{
					setState(255);
					match(CHAR_VAL);
						verifyVarType(MussumVariable.CHAR);			
																_exprContent += _input.LT(-1).getText();
															
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
		enterRule(_localctx, 30, RULE_expr_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(261);
				match(ID);
					verifyID();	
															verifyAssignment();
															int type = ((MussumVariable) symbolTable.get(_input.LT(-1).getText())).getType();
															verifyVarType(type);
														
				}
				break;
			case INT_VAL:
				{
				setState(263);
				match(INT_VAL);
					verifyVarType(MussumVariable.INT);			
				}
				break;
			case DOUBLE_VAL:
				{
				setState(265);
				match(DOUBLE_VAL);
					verifyVarType(MussumVariable.DOUBLE);		
				}
				break;
			case STRING_VAL:
				{
				setState(267);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\6\3)\n\3\r\3\16\3*\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\65\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\7\4A\n\4\f\4\16\4D\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5R\n\5\3\6\3\6\3"+
		"\6\6\6W\n\6\r\6\16\6X\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7c\n\7\3\b\3\b"+
		"\7\bg\n\b\f\b\16\bj\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\6\13\u008a\n\13\r\13\16\13\u008b\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\6\13\u0094\n\13\r\13\16\13\u0095\3\13\3\13\3\13\5\13\u009b\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\6\f\u00a3\n\f\r\f\16\f\u00a4\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\6\r\u00c0\n\r\r\r\16\r\u00c1\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00e0\n\16\r\16\16"+
		"\16\u00e1\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ee"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00fb"+
		"\n\20\f\20\16\20\u00fe\13\20\3\20\3\20\3\20\3\20\5\20\u0104\n\20\5\20"+
		"\u0106\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0110\n\21\3"+
		"\21\3\21\3\21\3h\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u0122"+
		"\2\"\3\2\2\2\4(\3\2\2\2\6,\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\fb\3\2\2\2\16"+
		"d\3\2\2\2\20m\3\2\2\2\22u\3\2\2\2\24}\3\2\2\2\26\u009e\3\2\2\2\30\u00b3"+
		"\3\2\2\2\32\u00c6\3\2\2\2\34\u00ed\3\2\2\2\36\u0105\3\2\2\2 \u010f\3\2"+
		"\2\2\"#\7\3\2\2#$\5\n\6\2$%\7\4\2\2%&\b\2\1\2&\3\3\2\2\2\')\5\6\4\2(\'"+
		"\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\5\3\2\2\2,-\5\b\5\2-.\7\"\2\2"+
		".\64\b\4\1\2/\60\7\30\2\2\60\61\b\4\1\2\61\62\5\36\20\2\62\63\b\4\1\2"+
		"\63\65\3\2\2\2\64/\3\2\2\2\64\65\3\2\2\2\65B\3\2\2\2\66\67\7 \2\2\678"+
		"\7\"\2\28>\b\4\1\29:\7\30\2\2:;\b\4\1\2;<\5\36\20\2<=\b\4\1\2=?\3\2\2"+
		"\2>9\3\2\2\2>?\3\2\2\2?A\3\2\2\2@\66\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2"+
		"\2\2CE\3\2\2\2DB\3\2\2\2EF\7\25\2\2F\7\3\2\2\2GH\7\t\2\2HR\b\5\1\2IJ\7"+
		"\r\2\2JR\b\5\1\2KL\7\13\2\2LR\b\5\1\2MN\7\17\2\2NR\b\5\1\2OP\7\21\2\2"+
		"PR\b\5\1\2QG\3\2\2\2QI\3\2\2\2QK\3\2\2\2QM\3\2\2\2QO\3\2\2\2R\t\3\2\2"+
		"\2SV\b\6\1\2TW\5\f\7\2UW\5\4\3\2VT\3\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2"+
		"\2XY\3\2\2\2Y\13\3\2\2\2Zc\5\20\t\2[c\5\22\n\2\\c\5\24\13\2]c\5\34\17"+
		"\2^c\5\32\16\2_c\5\30\r\2`c\5\26\f\2ac\5\16\b\2bZ\3\2\2\2b[\3\2\2\2b\\"+
		"\3\2\2\2b]\3\2\2\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\r\3\2\2\2"+
		"dh\7\5\2\2eg\13\2\2\2fe\3\2\2\2gj\3\2\2\2hi\3\2\2\2hf\3\2\2\2ik\3\2\2"+
		"\2jh\3\2\2\2kl\7\6\2\2l\17\3\2\2\2mn\7\7\2\2no\7\23\2\2op\7\"\2\2pq\b"+
		"\t\1\2qr\7\24\2\2rs\7\25\2\2st\b\t\1\2t\21\3\2\2\2uv\7\b\2\2vw\7\23\2"+
		"\2wx\7\"\2\2xy\b\n\1\2yz\7\24\2\2z{\7\25\2\2{|\b\n\1\2|\23\3\2\2\2}~\7"+
		"\31\2\2~\177\7\23\2\2\177\u0080\7\"\2\2\u0080\u0081\b\13\1\2\u0081\u0082"+
		"\7!\2\2\u0082\u0083\b\13\1\2\u0083\u0084\5\36\20\2\u0084\u0085\b\13\1"+
		"\2\u0085\u0086\7\24\2\2\u0086\u0087\7\36\2\2\u0087\u0089\b\13\1\2\u0088"+
		"\u008a\5\f\7\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\37\2\2\u008e"+
		"\u009a\b\13\1\2\u008f\u0090\7\32\2\2\u0090\u0091\7\36\2\2\u0091\u0093"+
		"\b\13\1\2\u0092\u0094\5\f\7\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2"+
		"\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098"+
		"\7\37\2\2\u0098\u0099\b\13\1\2\u0099\u009b\3\2\2\2\u009a\u008f\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\b\13\1\2\u009d\25"+
		"\3\2\2\2\u009e\u009f\7\33\2\2\u009f\u00a0\7\36\2\2\u00a0\u00a2\b\f\1\2"+
		"\u00a1\u00a3\5\f\7\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\37\2\2"+
		"\u00a7\u00a8\7\35\2\2\u00a8\u00a9\7\23\2\2\u00a9\u00aa\7\"\2\2\u00aa\u00ab"+
		"\b\f\1\2\u00ab\u00ac\7!\2\2\u00ac\u00ad\b\f\1\2\u00ad\u00ae\5\36\20\2"+
		"\u00ae\u00af\b\f\1\2\u00af\u00b0\7\24\2\2\u00b0\u00b1\b\f\1\2\u00b1\u00b2"+
		"\7\25\2\2\u00b2\27\3\2\2\2\u00b3\u00b4\7\35\2\2\u00b4\u00b5\7\23\2\2\u00b5"+
		"\u00b6\7\"\2\2\u00b6\u00b7\b\r\1\2\u00b7\u00b8\7!\2\2\u00b8\u00b9\b\r"+
		"\1\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\b\r\1\2\u00bb\u00bc\7\24\2\2\u00bc"+
		"\u00bd\7\36\2\2\u00bd\u00bf\b\r\1\2\u00be\u00c0\5\f\7\2\u00bf\u00be\3"+
		"\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c4\7\37\2\2\u00c4\u00c5\b\r\1\2\u00c5\31\3\2\2"+
		"\2\u00c6\u00c7\7\34\2\2\u00c7\u00c8\7\23\2\2\u00c8\u00c9\7\"\2\2\u00c9"+
		"\u00ca\b\16\1\2\u00ca\u00cb\7\30\2\2\u00cb\u00cc\b\16\1\2\u00cc\u00cd"+
		"\5\36\20\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf\b\16\1\2\u00cf\u00d0\7\"\2"+
		"\2\u00d0\u00d1\b\16\1\2\u00d1\u00d2\7!\2\2\u00d2\u00d3\b\16\1\2\u00d3"+
		"\u00d4\5\36\20\2\u00d4\u00d5\b\16\1\2\u00d5\u00d6\7\25\2\2\u00d6\u00d7"+
		"\b\16\1\2\u00d7\u00d8\7\"\2\2\u00d8\u00d9\b\16\1\2\u00d9\u00da\7\27\2"+
		"\2\u00da\u00db\b\16\1\2\u00db\u00dc\7\24\2\2\u00dc\u00dd\7\36\2\2\u00dd"+
		"\u00df\b\16\1\2\u00de\u00e0\5\f\7\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\7\37\2\2\u00e4\u00e5\b\16\1\2\u00e5\33\3\2\2\2\u00e6\u00e7\5\b"+
		"\5\2\u00e7\u00e8\7\"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\17\1\2\u00ea"+
		"\u00ee\3\2\2\2\u00eb\u00ec\7\"\2\2\u00ec\u00ee\b\17\1\2\u00ed\u00e6\3"+
		"\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\17\1\2\u00f0"+
		"\u00f1\7\30\2\2\u00f1\u00f2\b\17\1\2\u00f2\u00f3\5\36\20\2\u00f3\u00f4"+
		"\7\25\2\2\u00f4\u00f5\b\17\1\2\u00f5\35\3\2\2\2\u00f6\u00fc\5 \21\2\u00f7"+
		"\u00f8\7\26\2\2\u00f8\u00f9\b\20\1\2\u00f9\u00fb\5 \21\2\u00fa\u00f7\3"+
		"\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0106\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7\20\2\2\u0100\u0104\b"+
		"\20\1\2\u0101\u0102\7\22\2\2\u0102\u0104\b\20\1\2\u0103\u00ff\3\2\2\2"+
		"\u0103\u0101\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u00f6\3\2\2\2\u0105\u0103"+
		"\3\2\2\2\u0106\37\3\2\2\2\u0107\u0108\7\"\2\2\u0108\u0110\b\21\1\2\u0109"+
		"\u010a\7\n\2\2\u010a\u0110\b\21\1\2\u010b\u010c\7\f\2\2\u010c\u0110\b"+
		"\21\1\2\u010d\u010e\7\16\2\2\u010e\u0110\b\21\1\2\u010f\u0107\3\2\2\2"+
		"\u010f\u0109\3\2\2\2\u010f\u010b\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111"+
		"\3\2\2\2\u0111\u0112\b\21\1\2\u0112!\3\2\2\2\26*\64>BQVXbh\u008b\u0095"+
		"\u009a\u00a4\u00c1\u00e1\u00ed\u00fc\u0103\u0105\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}