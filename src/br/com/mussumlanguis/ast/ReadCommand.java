package br.com.mussumlanguis.ast;

public class ReadCommand extends AbstractCommand {
	
	private String id;
	
	public ReadCommand(String id) {
		this.id = id;
	}

	@Override
	public String generateJavaCode() {
		return null;
	}

}
