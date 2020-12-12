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
		return String.format("    %s = %s;\n", this.id, this.expression);
	}

}
