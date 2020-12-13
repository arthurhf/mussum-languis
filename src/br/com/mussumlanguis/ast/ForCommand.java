package br.com.mussumlanguis.ast;

import java.util.ArrayList;

public class ForCommand extends AbstractCommand {
	
	private String condition;
	private ArrayList<AbstractCommand> commandList;
	
	public ForCommand(String condition, ArrayList<AbstractCommand> commandList) {
		this.condition = condition;
		this.commandList = commandList;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder generatedCode = new StringBuilder();
		
		generatedCode.append("    for ( " + this.condition + " ) {\n");
		for (AbstractCommand cmd: commandList) {
			generatedCode.append("    " + cmd.generateJavaCode());
		}
		generatedCode.append("    }\n");
		
		return generatedCode.toString();
	}
	
	@Override
	public String toString() {
		return String.format("ForCommand [condition=%s, commandList=%s]", this.condition, this.commandList);
	}


}
