package br.com.mussumlanguis.ast;

import br.com.mussumlanguis.datastructures.MussumVariable;

public class ReadCommand extends AbstractCommand {
	
	private String id;
	private MussumVariable var;
	
	public ReadCommand(String id, MussumVariable var) {
		this.id = id;
		this.var = var;
	}

	@Override
	public String generateJavaCode() {
		String readOperation = this.var.getType() == MussumVariable.NUMBER ? "nextDouble()" : "nextLine()";
		return String.format("    %s = _key.%s;\n", this.id, readOperation);
	}

}
