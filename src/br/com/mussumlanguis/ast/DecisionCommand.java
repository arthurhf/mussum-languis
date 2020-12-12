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
		// TODO Auto-generated method stub
		return null;
	}

}
