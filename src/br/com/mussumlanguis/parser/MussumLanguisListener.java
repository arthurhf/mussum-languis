// Generated from MussumLanguis.g4 by ANTLR 4.7.1
package br.com.mussumlanguis.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MussumLanguisParser}.
 */
public interface MussumLanguisListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MussumLanguisParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MussumLanguisParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(MussumLanguisParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(MussumLanguisParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(MussumLanguisParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(MussumLanguisParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(MussumLanguisParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(MussumLanguisParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(MussumLanguisParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(MussumLanguisParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(MussumLanguisParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(MussumLanguisParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MussumLanguisParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MussumLanguisParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(MussumLanguisParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(MussumLanguisParser.TermoContext ctx);
}