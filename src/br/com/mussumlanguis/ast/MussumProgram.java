package br.com.mussumlanguis.ast;

import java.util.ArrayList;

import br.com.mussumlanguis.datastructures.MussumSymbolTable;

public class MussumProgram {
	
	private MussumSymbolTable symbolTable;
	private ArrayList<AbstractCommand> commands;
	private String programName;
	
	public void generateTarget() {
		
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
