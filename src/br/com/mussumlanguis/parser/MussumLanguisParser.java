// Generated from MussumLanguis.g4 by ANTLR 4.7.1
package br.com.mussumlanguis.parser;

	import br.com.mussumlanguis.datastructures.*;
	import br.com.mussumlanguis.exceptions.*; 	
 	import java.util.ArrayList;
 
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
		AP=10, FP=11, SC=12, OP=13, ATTR=14, FOR=15, LCURL=16, RCURL=17, VIR=18, 
		OPREL=19, ID=20, NUMBER=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_forg = 5, RULE_varChange = 6, RULE_cmd = 7, RULE_cmdleitura = 8, 
		RULE_cmdescrita = 9, RULE_cmdattrib = 10, RULE_expr = 11, RULE_termo = 12;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "forg", "varChange", "cmd", 
		"cmdleitura", "cmdescrita", "cmdattrib", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programis'", "'cacildis;'", "'numeris'", "'textis'", "'++'", "'--'", 
		"'-'", "'inputis'", "'escrevis'", "'('", "')'", "';'", null, "'='", "'paris'", 
		"'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
		"SC", "OP", "ATTR", "FOR", "LCURL", "RCURL", "VIR", "OPREL", "ID", "NUMBER", 
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
	 	
	 	public void addSymbol(){
	 		_varName = ((TokenStream) _input).LT(-1).getText();
			_varValue = null;
			if(!symbolTable.exists(_varName)){
				symbol = new MussumVariable(_varName, _type, _varValue);
				symbolTable.add(symbol);
				System.out.println("Symbol added " + symbol);
			}else{
				throw new MussumSemanticException("Symbol "+_varName+ " already declared");
			}
			
	 	}
	 	
	 	public void checkID(String id){
	 		if(!symbolTable.exists(id)){
	        	throw new MussumSemanticException("Symbol "+id+" not declared");
	        }
	 		
	 	}
	 	
	 	public void checkVariableUsage(){
	 		for (String i : symbolTable.keySet()) {
	 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
	 				System.out.println("Variable " + i + " was never used");
	 			}
			}
	 	}
	 	
	 	public void addVariableValue(String id, String value){
	 		((MussumVariable) symbolTable.get(id)).setValue(value);
	 		System.out.println("changed value " + symbolTable.get(id));
	 	}
	 	
	 
	public MussumLanguisParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
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
			bloco();
			setState(29);
			match(T__1);

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
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(35); 
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MussumLanguisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MussumLanguisParser.ID, i);
		}
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(MussumLanguisParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(MussumLanguisParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			tipo();
			setState(38);
			match(ID);

									addSymbol();
									
								
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(40);
				match(VIR);
				setState(41);
				match(ID);

										addSymbol();
										
									
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);

										_type = MussumVariable.NUMBER;
									
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				cmd();
				}
				}
				setState(59); 
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
		public TerminalNode AP() { return getToken(MussumLanguisParser.AP, 0); }
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
		public VarChangeContext varChange() {
			return getRuleContext(VarChangeContext.class,0);
		}
		public TerminalNode FP() { return getToken(MussumLanguisParser.FP, 0); }
		public TerminalNode LCURL() { return getToken(MussumLanguisParser.LCURL, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(MussumLanguisParser.RCURL, 0); }
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
			setState(61);
			match(FOR);
			setState(62);
			match(AP);
			setState(63);
			match(ID);
			setState(64);
			match(ATTR);
			setState(65);
			expr();
			setState(66);
			match(SC);
			setState(67);
			match(ID);
			setState(68);
			match(OPREL);
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(70);
			match(SC);
			setState(71);
			varChange();
			setState(72);
			match(FP);
			setState(73);
			match(LCURL);
			setState(74);
			bloco();
			setState(75);
			match(RCURL);
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

	public static class VarChangeContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public List<TerminalNode> WS() { return getTokens(MussumLanguisParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MussumLanguisParser.WS, i);
		}
		public VarChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterVarChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitVarChange(this);
		}
	}

	public final VarChangeContext varChange() throws RecognitionException {
		VarChangeContext _localctx = new VarChangeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varChange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ID);
			setState(78);
			((VarChangeContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
				((VarChangeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(79);
				match(WS);
				}
				}
				setState(84);
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
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
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
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				cmdleitura();
				 
									
									
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				cmdescrita();
				 System.out.println("Reconheci um comando de escrita");   
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				cmdattrib();
				 System.out.println("Reconheci um comando de atribuicao");
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MussumLanguisParser.AP, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode FP() { return getToken(MussumLanguisParser.FP, 0); }
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__7);
			setState(100);
			match(AP);
			setState(101);
			match(ID);

			                     		checkID(_input.LT(-1).getText());                     		
									
			setState(103);
			match(FP);
			setState(104);
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MussumLanguisParser.AP, 0); }
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode FP() { return getToken(MussumLanguisParser.FP, 0); }
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__8);
			setState(107);
			match(AP);
			setState(108);
			match(ID);

			                     			checkID(_input.LT(-1).getText());                     		
										  
			setState(110);
			match(FP);
			setState(111);
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(MussumLanguisParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(MussumLanguisParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
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
			termo();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(119);
				match(OP);
				setState(120);
				termo();
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MussumLanguisParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(MussumLanguisParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MussumLanguisListener ) ((MussumLanguisListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3$\n\3\r"+
		"\3\16\3%\3\4\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\59\n\5\3\6\6\6<\n\6\r\6\16\6=\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\bS\n\b\f\b\16\bV"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\16\3\16\3\16\2\2\17\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2\26\27\3\2\7\t\2~\2\34\3\2\2\2"+
		"\4#\3\2\2\2\6\'\3\2\2\2\b8\3\2\2\2\n;\3\2\2\2\f?\3\2\2\2\16O\3\2\2\2\20"+
		"c\3\2\2\2\22e\3\2\2\2\24l\3\2\2\2\26s\3\2\2\2\30x\3\2\2\2\32\u0080\3\2"+
		"\2\2\34\35\7\3\2\2\35\36\5\4\3\2\36\37\5\n\6\2\37 \7\4\2\2 !\b\2\1\2!"+
		"\3\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2"+
		"\2\2\'(\5\b\5\2()\7\26\2\2)/\b\4\1\2*+\7\24\2\2+,\7\26\2\2,.\b\4\1\2-"+
		"*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2"+
		"\62\63\7\16\2\2\63\7\3\2\2\2\64\65\7\5\2\2\659\b\5\1\2\66\67\7\6\2\2\67"+
		"9\b\5\1\28\64\3\2\2\28\66\3\2\2\29\t\3\2\2\2:<\5\20\t\2;:\3\2\2\2<=\3"+
		"\2\2\2=;\3\2\2\2=>\3\2\2\2>\13\3\2\2\2?@\7\21\2\2@A\7\f\2\2AB\7\26\2\2"+
		"BC\7\20\2\2CD\5\30\r\2DE\7\16\2\2EF\7\26\2\2FG\7\25\2\2GH\t\2\2\2HI\7"+
		"\16\2\2IJ\5\16\b\2JK\7\r\2\2KL\7\22\2\2LM\5\n\6\2MN\7\23\2\2N\r\3\2\2"+
		"\2OP\7\26\2\2PT\t\3\2\2QS\7\30\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2"+
		"\2\2U\17\3\2\2\2VT\3\2\2\2WX\5\22\n\2XY\b\t\1\2Yd\3\2\2\2Z[\5\24\13\2"+
		"[\\\b\t\1\2\\d\3\2\2\2]^\5\26\f\2^_\b\t\1\2_d\3\2\2\2`a\5\f\7\2ab\b\t"+
		"\1\2bd\3\2\2\2cW\3\2\2\2cZ\3\2\2\2c]\3\2\2\2c`\3\2\2\2d\21\3\2\2\2ef\7"+
		"\n\2\2fg\7\f\2\2gh\7\26\2\2hi\b\n\1\2ij\7\r\2\2jk\7\16\2\2k\23\3\2\2\2"+
		"lm\7\13\2\2mn\7\f\2\2no\7\26\2\2op\b\13\1\2pq\7\r\2\2qr\7\16\2\2r\25\3"+
		"\2\2\2st\7\26\2\2tu\7\20\2\2uv\5\30\r\2vw\7\16\2\2w\27\3\2\2\2x}\5\32"+
		"\16\2yz\7\17\2\2z|\5\32\16\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2"+
		"\2~\31\3\2\2\2\177}\3\2\2\2\u0080\u0081\t\2\2\2\u0081\33\3\2\2\2\t%/8"+
		"=Tc}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}