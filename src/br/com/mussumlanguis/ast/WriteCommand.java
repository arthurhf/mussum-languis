package br.com.mussumlanguis.ast;

public class WriteCommand extends AbstractCommand {
	
	private String id;
	
	public WriteCommand(String id) {
		this.id = id;
	}
	
	@Override
	public String generateJavaCode() {
		return String.format("    System.out.println(%s);\n", this.id);
	}

}
