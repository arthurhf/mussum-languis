package br.com.mussumlanguis.ast;

import java.util.ArrayList;

public class DoWhileCommand extends AbstractCommand {

	private String condition;
	private ArrayList<AbstractCommand> commandList;
	
	public DoWhileCommand(String condition, ArrayList<AbstractCommand> commandList) {
		this.condition = condition;
		this.commandList = commandList;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder generatedCode = new StringBuilder();
		
		generatedCode.append("    do {\n");
		for (AbstractCommand cmd: commandList) {
			generatedCode.append("    " + cmd.generateJavaCode());
		}
		generatedCode.append("    } while (" + this.condition + " ); \n");
		
		return generatedCode.toString();
	}
	
	@Override
	public String toString() {
		return String.format("DoWhileCommand [condition=%s, commandList=%s]", this.condition, this.commandList);
	}

}
