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
		null, "'programis'", "'cacildis'", "'#COMENTIS'", "'#DESCOMENTIS'", "'inputis'", 
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
			setState(32);
			match(T__0);
			setState(33);
			decl();
			setState(34);
			block();
			setState(35);
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
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				var_decl();
				}
				}
				setState(41); 
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
		enterRule(_localctx, 4, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			type();
			setState(44);
			match(ID);
			 addSymbol(); 
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(46);
				match(COMMA);
				setState(47);
				match(ID);
				 addSymbol(); 
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_DECL:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(INT_DECL);
					_type = MussumVariable.INT;		
				}
				break;
			case STRING_DECL:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(STRING_DECL);
					_type = MussumVariable.TEXT;	
				}
				break;
			case DOUBLE_DECL:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(DOUBLE_DECL);
					_type = MussumVariable.DOUBLE;	
				}
				break;
			case BOOLEAN_DECL:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(BOOLEAN_DECL);
					_type = MussumVariable.BOOLEAN;	
				}
				break;
			case CHAR_DECL:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				currThread = new ArrayList<AbstractCommand>();
							commandStack.push(currThread);
						
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				cmd();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				read_cmd();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				write_cmd();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				decision_cmd();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				attr_cmd();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				forg();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				whileg();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				dog();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
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
			setState(84);
			match(T__2);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(85);
					matchWildcard();
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(91);
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
			setState(93);
			match(T__4);
			setState(94);
			match(L_PAREN);
			setState(95);
			match(ID);
				verifyID();
											
											_readId = _input.LT(-1).getText();
										
			setState(97);
			match(R_PAREN);
			setState(98);
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
			setState(101);
			match(T__5);
			setState(102);
			match(L_PAREN);
			setState(103);
			match(ID);
				verifyID(); 
											verifyAssignment();
											_writeId = _input.LT(-1).getText();
										
			setState(105);
			match(R_PAREN);
			setState(106);
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
			setState(109);
			match(IF);
			setState(110);
			match(L_PAREN);
			setState(111);
			match(ID);
				_exprDecision = _input.LT(-1).getText();
													verifyAssignment();
												
			setState(113);
			match(OPREL);
				_exprDecision += _input.LT(-1).getText();		
			setState(115);
			expr();
				_exprDecision += _exprContent;					
			setState(117);
			match(R_PAREN);
			setState(118);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
													commandStack.push(currThread);
													conditionStack.push(_exprDecision);
												
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				cmd();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(125);
			match(R_CURL);
				trueList = commandStack.pop();					
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(127);
				match(ELSE);
				setState(128);
				match(L_CURL);
					currThread = new ArrayList<AbstractCommand>();	
														commandStack.push(currThread);
													
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(130);
					cmd();
					}
					}
					setState(133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
				setState(135);
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
			setState(142);
			match(DO);
			setState(143);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprWhile);
									
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				cmd();
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(150);
			match(R_CURL);
				
											WhileCommand cmd = new WhileCommand(conditionStack.pop(), commandStack.pop());
											commandStack.peek().add(cmd);
									
			setState(152);
			match(WHILE);
			setState(153);
			match(L_PAREN);
			setState(154);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
									
			setState(156);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(158);
			expr();
				_exprWhile += _exprContent;					
			setState(160);
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
		enterRule(_localctx, 22, RULE_whileg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(WHILE);
			setState(163);
			match(L_PAREN);
			setState(164);
			match(ID);
			 	_exprWhile = _input.LT(-1).getText();
											verifyAssignment();
										
			setState(166);
			match(OPREL);
				_exprWhile += _input.LT(-1).getText();		
			setState(168);
			expr();
				_exprWhile += _exprContent;					
			setState(170);
			match(R_PAREN);
			setState(171);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprWhile);
										
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				cmd();
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(178);
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
			setState(181);
			match(FOR);
			setState(182);
			match(L_PAREN);
			setState(183);
			match(ID);
			 	verifyID(); 
											_exprId = _input.LT(-1).getText();
											_attrVariable = _input.LT(-1).getText();
										
										
			setState(185);
			match(ATTR);
			 	_exprContent = "";	
											_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
										
			setState(187);
			expr();
			setState(188);
			match(SC);
				_exprFor = _exprId + " = " + _exprContent + ";";	
										
			setState(190);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(192);
			match(OPREL);
				_exprFor += _input.LT(-1).getText();		
											_exprContent = "";
										
			setState(194);
			expr();
				_exprFor += _exprContent;					
			setState(196);
			match(SC);
				_exprFor += _input.LT(-1).getText();		
			setState(198);
			match(ID);
				
											if (! _exprId.equals(_input.LT(-1).getText())) {
												throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
											}
											_exprFor += _input.LT(-1).getText();
											verifyAssignment();
										
			setState(200);
			match(OP_CHANGE);
				_exprFor += _input.LT(-1).getText();		
			setState(202);
			match(R_PAREN);
			setState(203);
			match(L_CURL);
				currThread = new ArrayList<AbstractCommand>();	
											commandStack.push(currThread);
											conditionStack.push(_exprFor);
										
			setState(206); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(205);
				cmd();
				}
				}
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0) );
			setState(210);
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
			setState(213);
			match(ID);
			 	verifyID(); 
														_exprId = _input.LT(-1).getText();
													
			setState(215);
			match(ATTR);
			 	_exprContent = "";	
														_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
													
			setState(217);
			expr();
			setState(218);
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
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
			case DOUBLE_VAL:
			case STRING_VAL:
			case ID:
				{
				{
				setState(221);
				expr_token();
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(222);
					match(OP);
					 _exprContent += _input.LT(-1).getText();	
					setState(224);
					expr_token();
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case BOOLEAN_VAL:
			case CHAR_VAL:
				{
				setState(234);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN_VAL:
					{
					setState(230);
					match(BOOLEAN_VAL);
						verifyVarType(MussumVariable.BOOLEAN);		
					}
					break;
				case CHAR_VAL:
					{
					setState(232);
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
		enterRule(_localctx, 30, RULE_expr_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(239);
				match(ID);
					verifyID();	
															verifyAssignment();
															int type = ((MussumVariable) symbolTable.get(_input.LT(-1).getText())).getType();
															verifyVarType(type);
														
				}
				break;
			case INT_VAL:
				{
				setState(241);
				match(INT_VAL);
					verifyVarType(MussumVariable.INT);			
				}
				break;
			case DOUBLE_VAL:
				{
				setState(243);
				match(DOUBLE_VAL);
					verifyVarType(MussumVariable.DOUBLE);		
				}
				break;
			case STRING_VAL:
				{
				setState(245);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64\n"+
		"\4\f\4\16\4\67\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5E\n\5\3\6\3\6\6\6I\n\6\r\6\16\6J\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"U\n\7\3\b\3\b\7\bY\n\b\f\b\16\b\\\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\6\13|\n\13\r\13\16\13}\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\6\13\u0086\n\13\r\13\16\13\u0087\3\13\3\13\3\13\5\13\u008d"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\3\f\6\f\u0095\n\f\r\f\16\f\u0096\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\6\r\u00b1\n\r\r\r\16\r\u00b2\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00d1\n\16\r\16\16\16"+
		"\u00d2\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\7\20\u00e4\n\20\f\20\16\20\u00e7\13\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00ed\n\20\3\20\5\20\u00f0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u00fa\n\21\3\21\3\21\3\21\3Z\2\22\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \2\2\2\u0108\2\"\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\bD\3\2"+
		"\2\2\nF\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20_\3\2\2\2\22g\3\2\2\2\24o\3\2"+
		"\2\2\26\u0090\3\2\2\2\30\u00a4\3\2\2\2\32\u00b7\3\2\2\2\34\u00d7\3\2\2"+
		"\2\36\u00ef\3\2\2\2 \u00f9\3\2\2\2\"#\7\3\2\2#$\5\4\3\2$%\5\n\6\2%&\7"+
		"\4\2\2&\'\b\2\1\2\'\3\3\2\2\2(*\5\6\4\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2"+
		"+,\3\2\2\2,\5\3\2\2\2-.\5\b\5\2./\7\"\2\2/\65\b\4\1\2\60\61\7 \2\2\61"+
		"\62\7\"\2\2\62\64\b\4\1\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65"+
		"\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\25\2\29\7\3\2\2\2:;\7\t\2\2"+
		";E\b\5\1\2<=\7\r\2\2=E\b\5\1\2>?\7\13\2\2?E\b\5\1\2@A\7\17\2\2AE\b\5\1"+
		"\2BC\7\21\2\2CE\b\5\1\2D:\3\2\2\2D<\3\2\2\2D>\3\2\2\2D@\3\2\2\2DB\3\2"+
		"\2\2E\t\3\2\2\2FH\b\6\1\2GI\5\f\7\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3"+
		"\2\2\2K\13\3\2\2\2LU\5\20\t\2MU\5\22\n\2NU\5\24\13\2OU\5\34\17\2PU\5\32"+
		"\16\2QU\5\30\r\2RU\5\26\f\2SU\5\16\b\2TL\3\2\2\2TM\3\2\2\2TN\3\2\2\2T"+
		"O\3\2\2\2TP\3\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\r\3\2\2\2VZ\7\5\2\2"+
		"WY\13\2\2\2XW\3\2\2\2Y\\\3\2\2\2Z[\3\2\2\2ZX\3\2\2\2[]\3\2\2\2\\Z\3\2"+
		"\2\2]^\7\6\2\2^\17\3\2\2\2_`\7\7\2\2`a\7\23\2\2ab\7\"\2\2bc\b\t\1\2cd"+
		"\7\24\2\2de\7\25\2\2ef\b\t\1\2f\21\3\2\2\2gh\7\b\2\2hi\7\23\2\2ij\7\""+
		"\2\2jk\b\n\1\2kl\7\24\2\2lm\7\25\2\2mn\b\n\1\2n\23\3\2\2\2op\7\31\2\2"+
		"pq\7\23\2\2qr\7\"\2\2rs\b\13\1\2st\7!\2\2tu\b\13\1\2uv\5\36\20\2vw\b\13"+
		"\1\2wx\7\24\2\2xy\7\36\2\2y{\b\13\1\2z|\5\f\7\2{z\3\2\2\2|}\3\2\2\2}{"+
		"\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\37\2\2\u0080\u008c\b\13\1"+
		"\2\u0081\u0082\7\32\2\2\u0082\u0083\7\36\2\2\u0083\u0085\b\13\1\2\u0084"+
		"\u0086\5\f\7\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\37\2\2\u008a"+
		"\u008b\b\13\1\2\u008b\u008d\3\2\2\2\u008c\u0081\3\2\2\2\u008c\u008d\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\13\1\2\u008f\25\3\2\2\2\u0090"+
		"\u0091\7\33\2\2\u0091\u0092\7\36\2\2\u0092\u0094\b\f\1\2\u0093\u0095\5"+
		"\f\7\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\37\2\2\u0099\u009a\b"+
		"\f\1\2\u009a\u009b\7\35\2\2\u009b\u009c\7\23\2\2\u009c\u009d\7\"\2\2\u009d"+
		"\u009e\b\f\1\2\u009e\u009f\7!\2\2\u009f\u00a0\b\f\1\2\u00a0\u00a1\5\36"+
		"\20\2\u00a1\u00a2\b\f\1\2\u00a2\u00a3\7\24\2\2\u00a3\27\3\2\2\2\u00a4"+
		"\u00a5\7\35\2\2\u00a5\u00a6\7\23\2\2\u00a6\u00a7\7\"\2\2\u00a7\u00a8\b"+
		"\r\1\2\u00a8\u00a9\7!\2\2\u00a9\u00aa\b\r\1\2\u00aa\u00ab\5\36\20\2\u00ab"+
		"\u00ac\b\r\1\2\u00ac\u00ad\7\24\2\2\u00ad\u00ae\7\36\2\2\u00ae\u00b0\b"+
		"\r\1\2\u00af\u00b1\5\f\7\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\37"+
		"\2\2\u00b5\u00b6\b\r\1\2\u00b6\31\3\2\2\2\u00b7\u00b8\7\34\2\2\u00b8\u00b9"+
		"\7\23\2\2\u00b9\u00ba\7\"\2\2\u00ba\u00bb\b\16\1\2\u00bb\u00bc\7\30\2"+
		"\2\u00bc\u00bd\b\16\1\2\u00bd\u00be\5\36\20\2\u00be\u00bf\7\25\2\2\u00bf"+
		"\u00c0\b\16\1\2\u00c0\u00c1\7\"\2\2\u00c1\u00c2\b\16\1\2\u00c2\u00c3\7"+
		"!\2\2\u00c3\u00c4\b\16\1\2\u00c4\u00c5\5\36\20\2\u00c5\u00c6\b\16\1\2"+
		"\u00c6\u00c7\7\25\2\2\u00c7\u00c8\b\16\1\2\u00c8\u00c9\7\"\2\2\u00c9\u00ca"+
		"\b\16\1\2\u00ca\u00cb\7\27\2\2\u00cb\u00cc\b\16\1\2\u00cc\u00cd\7\24\2"+
		"\2\u00cd\u00ce\7\36\2\2\u00ce\u00d0\b\16\1\2\u00cf\u00d1\5\f\7\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\37\2\2\u00d5\u00d6\b\16\1\2\u00d6"+
		"\33\3\2\2\2\u00d7\u00d8\7\"\2\2\u00d8\u00d9\b\17\1\2\u00d9\u00da\7\30"+
		"\2\2\u00da\u00db\b\17\1\2\u00db\u00dc\5\36\20\2\u00dc\u00dd\7\25\2\2\u00dd"+
		"\u00de\b\17\1\2\u00de\35\3\2\2\2\u00df\u00e5\5 \21\2\u00e0\u00e1\7\26"+
		"\2\2\u00e1\u00e2\b\20\1\2\u00e2\u00e4\5 \21\2\u00e3\u00e0\3\2\2\2\u00e4"+
		"\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00f0\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7\20\2\2\u00e9\u00ed\b\20\1\2\u00ea"+
		"\u00eb\7\22\2\2\u00eb\u00ed\b\20\1\2\u00ec\u00e8\3\2\2\2\u00ec\u00ea\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\b\20\1\2\u00ef\u00df\3\2\2\2\u00ef"+
		"\u00ec\3\2\2\2\u00f0\37\3\2\2\2\u00f1\u00f2\7\"\2\2\u00f2\u00fa\b\21\1"+
		"\2\u00f3\u00f4\7\n\2\2\u00f4\u00fa\b\21\1\2\u00f5\u00f6\7\f\2\2\u00f6"+
		"\u00fa\b\21\1\2\u00f7\u00f8\7\16\2\2\u00f8\u00fa\b\21\1\2\u00f9\u00f1"+
		"\3\2\2\2\u00f9\u00f3\3\2\2\2\u00f9\u00f5\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fc\b\21\1\2\u00fc!\3\2\2\2\22+\65DJTZ}\u0087\u008c"+
		"\u0096\u00b2\u00d2\u00e5\u00ec\u00ef\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}