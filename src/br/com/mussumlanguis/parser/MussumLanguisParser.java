// Generated from MussumLanguis.g4 by ANTLR 4.7.1
package br.com.mussumlanguis.parser;

	import br.com.mussumlanguis.datastructures.MussumSymbol;
	import br.com.mussumlanguis.datastructures.MussumSymbolTable;
	import br.com.mussumlanguis.datastructures.MussumVariable;
	import br.com.mussumlanguis.exceptions.MussumSemanticException;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		L_PAREN=10, R_PAREN=11, SC=12, OP=13, ATTR=14, FOR=15, L_CURL=16, R_CURL=17, 
		COMMA=18, OPREL=19, ID=20, NUMBER=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type = 3, RULE_block = 4, 
		RULE_forg = 5, RULE_var_change = 6, RULE_cmd = 7, RULE_read_cmd = 8, RULE_write_cmd = 9, 
		RULE_attr_cmd = 10, RULE_expr = 11, RULE_expr_token = 12;
	public static final String[] ruleNames = {
		"prog", "decl", "var_decl", "type", "block", "forg", "var_change", "cmd", 
		"read_cmd", "write_cmd", "attr_cmd", "expr", "expr_token"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'numeris'", "'textis'", "'++'", "'--'", 
		"'-'", "'inputis'", "'escrevis'", "'('", "')'", "';'", null, "'='", "'paris'", 
		"'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "L_PAREN", 
		"R_PAREN", "SC", "OP", "ATTR", "FOR", "L_CURL", "R_CURL", "COMMA", "OPREL", 
		"ID", "NUMBER", "WS"
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
		
		public void verifyID() {
			String id = _input.LT(-1).getText();
			
			if (!symbolTable.exists(id)) {
				throw new MussumSemanticException("Symbol " + id + " not declared");
			}
		}
		
		public void addSymbol() {
			_varName = _input.LT(-1).getText();
			_varValue = null;
			symbol = new MussumVariable(_varName, _type, _varValue);
			
			if (!symbolTable.exists(_varName)) {
				System.out.println("Simbolo adicionado: " + symbol); 
				symbolTable.add(symbol);
			} else {
				throw new MussumSemanticException("Symbol " + _varName + " already declared");
			}
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
			setState(26);
			match(T__0);
			setState(27);
			decl();
			setState(28);
			block();
			setState(29);
			match(T__1);
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
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				var_decl();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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
			setState(36);
			type();
			setState(37);
			match(ID);
			 addSymbol(); 
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(39);
				match(COMMA);
				setState(40);
				match(ID);
				 addSymbol(); 
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
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
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__2);
					_type = MussumVariable.NUMBER;	
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(T__3);
					_type = MussumVariable.TEXT;	
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
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				cmd();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << FOR) | (1L << ID))) != 0) );
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
		public Var_changeContext var_change() {
			return getRuleContext(Var_changeContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MussumLanguisParser.R_PAREN, 0); }
		public TerminalNode L_CURL() { return getToken(MussumLanguisParser.L_CURL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode R_CURL() { return getToken(MussumLanguisParser.R_CURL, 0); }
		public TerminalNode NUMBER() { return getToken(MussumLanguisParser.NUMBER, 0); }
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
		enterRule(_localctx, 10, RULE_forg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(FOR);
			setState(61);
			match(L_PAREN);
			setState(62);
			match(ID);
			setState(63);
			match(ATTR);
			setState(64);
			expr();
			setState(65);
			match(SC);
			setState(66);
			match(ID);
			setState(67);
			match(OPREL);
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(69);
			match(SC);
			setState(70);
			var_change();
			setState(71);
			match(R_PAREN);
			setState(72);
			match(L_CURL);
			setState(73);
			block();
			setState(74);
			match(R_CURL);
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

	public static class Var_changeContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public List<TerminalNode> WS() { return getTokens(MussumLanguisParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MussumLanguisParser.WS, i);
		}
		public Var_changeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_change; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterVar_change(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitVar_change(this);
		}
	}

	public final Var_changeContext var_change() throws RecognitionException {
		Var_changeContext _localctx = new Var_changeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_change);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
			setState(77);
			((Var_changeContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
				((Var_changeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(78);
				match(WS);
				}
				}
				setState(83);
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

	public static class CmdContext extends ParserRuleContext {
		public Read_cmdContext read_cmd() {
			return getRuleContext(Read_cmdContext.class,0);
		}
		public Write_cmdContext write_cmd() {
			return getRuleContext(Write_cmdContext.class,0);
		}
		public Attr_cmdContext attr_cmd() {
			return getRuleContext(Attr_cmdContext.class,0);
		}
		public ForgContext forg() {
			return getRuleContext(ForgContext.class,0);
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
		enterRule(_localctx, 14, RULE_cmd);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				read_cmd();
					System.out.println("Reconheci um comando de leitura!");		
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				write_cmd();
					System.out.println("Reconheci um comando de escrita");		
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				attr_cmd();
					System.out.println("Reconheci um comando de atribuicao");	
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				forg();
					System.out.println("Reconheci um laço for");				
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
		enterRule(_localctx, 16, RULE_read_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__7);
			setState(99);
			match(L_PAREN);
			setState(100);
			match(ID);
			 verifyID() 
			setState(102);
			match(R_PAREN);
			setState(103);
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
			setState(105);
			match(T__8);
			setState(106);
			match(L_PAREN);
			setState(107);
			match(ID);
			 verifyID(); 
			setState(109);
			match(R_PAREN);
			setState(110);
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
		enterRule(_localctx, 20, RULE_attr_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(ID);
			 verifyID(); 
			setState(114);
			match(ATTR);
			setState(115);
			expr();
			setState(116);
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
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			expr_token();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(119);
				match(OP);
				setState(120);
				expr_token();
				}
				}
				setState(125);
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
		enterRule(_localctx, 24, RULE_expr_token);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ID);
				 verifyID(); 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(NUMBER);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0086\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\3\6\3#\n\3\r\3\16"+
		"\3$\3\4\3\4\3\4\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\5\58\n\5\3\6\6\6;\n\6\r\6\16\6<\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\bR\n\b\f\b\16\bU\13\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tc\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\16\3\16\3\16\5\16\u0084"+
		"\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2\26\27\3\2\7"+
		"\t\2\u0082\2\34\3\2\2\2\4\"\3\2\2\2\6&\3\2\2\2\b\67\3\2\2\2\n:\3\2\2\2"+
		"\f>\3\2\2\2\16N\3\2\2\2\20b\3\2\2\2\22d\3\2\2\2\24k\3\2\2\2\26r\3\2\2"+
		"\2\30x\3\2\2\2\32\u0083\3\2\2\2\34\35\7\3\2\2\35\36\5\4\3\2\36\37\5\n"+
		"\6\2\37 \7\4\2\2 \3\3\2\2\2!#\5\6\4\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2"+
		"$%\3\2\2\2%\5\3\2\2\2&\'\5\b\5\2\'(\7\26\2\2(.\b\4\1\2)*\7\24\2\2*+\7"+
		"\26\2\2+-\b\4\1\2,)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2"+
		"\2\60.\3\2\2\2\61\62\7\16\2\2\62\7\3\2\2\2\63\64\7\5\2\2\648\b\5\1\2\65"+
		"\66\7\6\2\2\668\b\5\1\2\67\63\3\2\2\2\67\65\3\2\2\28\t\3\2\2\29;\5\20"+
		"\t\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\13\3\2\2\2>?\7\21\2\2?@"+
		"\7\f\2\2@A\7\26\2\2AB\7\20\2\2BC\5\30\r\2CD\7\16\2\2DE\7\26\2\2EF\7\25"+
		"\2\2FG\t\2\2\2GH\7\16\2\2HI\5\16\b\2IJ\7\r\2\2JK\7\22\2\2KL\5\n\6\2LM"+
		"\7\23\2\2M\r\3\2\2\2NO\7\26\2\2OS\t\3\2\2PR\7\30\2\2QP\3\2\2\2RU\3\2\2"+
		"\2SQ\3\2\2\2ST\3\2\2\2T\17\3\2\2\2US\3\2\2\2VW\5\22\n\2WX\b\t\1\2Xc\3"+
		"\2\2\2YZ\5\24\13\2Z[\b\t\1\2[c\3\2\2\2\\]\5\26\f\2]^\b\t\1\2^c\3\2\2\2"+
		"_`\5\f\7\2`a\b\t\1\2ac\3\2\2\2bV\3\2\2\2bY\3\2\2\2b\\\3\2\2\2b_\3\2\2"+
		"\2c\21\3\2\2\2de\7\n\2\2ef\7\f\2\2fg\7\26\2\2gh\b\n\1\2hi\7\r\2\2ij\7"+
		"\16\2\2j\23\3\2\2\2kl\7\13\2\2lm\7\f\2\2mn\7\26\2\2no\b\13\1\2op\7\r\2"+
		"\2pq\7\16\2\2q\25\3\2\2\2rs\7\26\2\2st\b\f\1\2tu\7\20\2\2uv\5\30\r\2v"+
		"w\7\16\2\2w\27\3\2\2\2x}\5\32\16\2yz\7\17\2\2z|\5\32\16\2{y\3\2\2\2|\177"+
		"\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\31\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\26"+
		"\2\2\u0081\u0084\b\16\1\2\u0082\u0084\7\27\2\2\u0083\u0080\3\2\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\33\3\2\2\2\n$.\67<Sb}\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}