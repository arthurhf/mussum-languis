package br.com.mussumlanguis.ast;

import br.com.mussumlanguis.datastructures.MussumVariable;
import br.com.mussumlanguis.exceptions.MussumSemanticException;

public class ReadCommand extends AbstractCommand {
	
	private String id;
	private MussumVariable var;
	
	public ReadCommand(String id, MussumVariable var) {
		this.id = id;
		this.var = var;
	}

	@Override
	public String generateJavaCode() throws MussumSemanticException {
		return String.format("    %s = %s;\n", this.id, getOperationCode());
	}
	
	private String getOperationCode() throws MussumSemanticException {
		switch (this.var.getType()) {
			case MussumVariable.INT:
				return "_key.nextInt()";
				
			case MussumVariable.DOUBLE:
				return "_key.nextDouble()";
			
			case MussumVariable.TEXT:
				return "_key.nextLine()";
				
			case MussumVariable.CHAR:
				return "_key.next(\".\").charAt(0)";
				
			case MussumVariable.BOOLEAN:
				throw new MussumSemanticException("Não é possívis ler uma variávis booleanis");
			
			default:
				throw new RuntimeException("tipis não definidis");
				
		}
	}

}
