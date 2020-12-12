package br.com.mussumlanguis.datastructures;

public class MussumVariable extends MussumSymbol{
	
	public static final int NUMBER = 0;
	public static final int TEXT = 1;
	
	private int type;
	private String value;
	
	public MussumVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "MussumVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}

	@Override
	public String generateJavaCode() {
		String typeString = this.type == NUMBER ? "Integer" : "String";
		return String.format("    %s %s;\n", typeString, super.name);
		
	}

}
