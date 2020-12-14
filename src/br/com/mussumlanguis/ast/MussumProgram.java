package br.com.mussumlanguis.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import br.com.mussumlanguis.datastructures.MussumSymbol;
import br.com.mussumlanguis.datastructures.MussumSymbolTable;

public class MussumProgram {
	
	private MussumSymbolTable symbolTable;
	private ArrayList<AbstractCommand> commands;
	private String programName;
	
	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner; \n");
		str.append("public class MainClass{ \n");
		str.append("  public static void main(String args[]) { \n");
		str.append("    Scanner _key = new Scanner(System.in); \n");
		
		for (MussumSymbol symbol : this.symbolTable.getAllSymbols()) {
			str.append(symbol.generateJavaCode());
		}
		
		for (AbstractCommand command : this.commands) {
			str.append(command.generateJavaCode());
		}
		
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public MussumSymbolTable getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(MussumSymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public ArrayList<AbstractCommand> getCommands() {
		return commands;
	}

	public void setCommands(ArrayList<AbstractCommand> commands) {
		this.commands = commands;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
}
