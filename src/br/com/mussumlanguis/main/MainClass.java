package br.com.mussumlanguis.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.mussumlanguis.exceptions.MussumSemanticException;
import br.com.mussumlanguis.parser.MussumLanguisLexer;
import br.com.mussumlanguis.parser.MussumLanguisParser;

//Classe responsável pela interação com o usuário

public class MainClass {
	public static void main(String[] args) {
		try {
			
			MussumLanguisLexer lexer;
			MussumLanguisParser parser;
			
			lexer = new MussumLanguisLexer(CharStreams.fromFileName("input.mus"));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			parser = new MussumLanguisParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Programis Compiladis!! Cacildis");
			
		}
		catch (MussumSemanticException ex) {
			System.err.println("Semantic error - " + ex.getMessage());
		}
		catch (Exception ex){
			System.err.println("Error " + ex.getMessage()); 
		}
	}

}
