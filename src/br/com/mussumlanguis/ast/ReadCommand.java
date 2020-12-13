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
		return String.format("    %s = %s;\n", this.id, getOperationCode());
	}
	
	private String getOperationCode() {
		switch (this.var.getType()) {
			case MussumVariable.INT:
				return "_key.nextInt()";
				
			case MussumVariable.DOUBLE:
				return "_key.nextDouble()";
			
			case MussumVariable.TEXT:
				return "_key.nextLine()";
			
			default:
				throw new RuntimeException("tipis não definidis");
				
		}
	}

}
