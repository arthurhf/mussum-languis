package br.com.mussumlanguis.ast;

import java.util.ArrayList;

public class DecisionCommand extends AbstractCommand {
	
	private String condition;
	private ArrayList<AbstractCommand> trueList;
	private ArrayList<AbstractCommand> falseList;
	
	public DecisionCommand(
			String condition, 
			ArrayList<AbstractCommand> trueList,
			ArrayList<AbstractCommand> falseList) {
		this.condition = condition;
		this.trueList = trueList;
		this.falseList = falseList;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder generatedCode = new StringBuilder();
		
		generatedCode.append("    if ( " + this.condition + " ) {\n");
		for (AbstractCommand cmd: trueList) {
			generatedCode.append("    " + cmd.generateJavaCode());
		}
		generatedCode.append("    }\n");
		
		if (falseList.size() > 0) {
			generatedCode.append("    else {\n");
			for (AbstractCommand cmd: falseList) {
				generatedCode.append("    " + cmd.generateJavaCode());
			}
			generatedCode.append("    }\n");
		
		}
		return generatedCode.toString();
	}
	
	
	@Override
	public String toString() {
		return String.format("DecisionCOmmand [condition=%s, trueList=%s, falseList=%s]", this.condition, this.trueList, this.falseList);
	}

}
