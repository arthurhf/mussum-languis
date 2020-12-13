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
	 * Enter a parse tree produced by {@link MussumLanguisParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MussumLanguisParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MussumLanguisParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(MussumLanguisParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(MussumLanguisParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MussumLanguisParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MussumLanguisParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MussumLanguisParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MussumLanguisParser.BlockContext ctx);
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
	 * Enter a parse tree produced by {@link MussumLanguisParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(MussumLanguisParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(MussumLanguisParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#read_cmd}.
	 * @param ctx the parse tree
	 */
	void enterRead_cmd(MussumLanguisParser.Read_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#read_cmd}.
	 * @param ctx the parse tree
	 */
	void exitRead_cmd(MussumLanguisParser.Read_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void enterWrite_cmd(MussumLanguisParser.Write_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void exitWrite_cmd(MussumLanguisParser.Write_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#decision_cmd}.
	 * @param ctx the parse tree
	 */
	void enterDecision_cmd(MussumLanguisParser.Decision_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#decision_cmd}.
	 * @param ctx the parse tree
	 */
	void exitDecision_cmd(MussumLanguisParser.Decision_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#whileg}.
	 * @param ctx the parse tree
	 */
	void enterWhileg(MussumLanguisParser.WhilegContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#whileg}.
	 * @param ctx the parse tree
	 */
	void exitWhileg(MussumLanguisParser.WhilegContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#forg}.
	 * @param ctx the parse tree
	 */
	void enterForg(MussumLanguisParser.ForgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#forg}.
	 * @param ctx the parse tree
	 */
	void exitForg(MussumLanguisParser.ForgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumLanguisParser#attr_cmd}.
	 * @param ctx the parse tree
	 */
	void enterAttr_cmd(MussumLanguisParser.Attr_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#attr_cmd}.
	 * @param ctx the parse tree
	 */
	void exitAttr_cmd(MussumLanguisParser.Attr_cmdContext ctx);
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
	 * Enter a parse tree produced by {@link MussumLanguisParser#expr_token}.
	 * @param ctx the parse tree
	 */
	void enterExpr_token(MussumLanguisParser.Expr_tokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumLanguisParser#expr_token}.
	 * @param ctx the parse tree
	 */
	void exitExpr_token(MussumLanguisParser.Expr_tokenContext ctx);
}