package br.com.mussumlanguis.ast;

public class AttrCommand extends AbstractCommand {
	
	private String id;
	private String expression;
	
	public AttrCommand(String id, String expression) {
		this.id = id;
		this.expression = expression;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
