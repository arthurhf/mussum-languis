package br.com.mussumlanguis.datastructures;

public class MussumVariable extends MussumSymbol{
	
	public static final int INT = 0;
	public static final int TEXT = 1;
	public static final int DOUBLE = 2;
	public static final int BOOLEAN = 3;
	
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
		return String.format("    %s %s;\n", generateTypeCode(), super.name);	
	}
	
	private String generateTypeCode() {
		switch (this.type) {
			case INT: 
				return "int";
				
			case TEXT:	
				return "String";
			
			case DOUBLE: 
				return "double";
			
			case BOOLEAN: 
				return "boolean";
			
			default: 
				throw new RuntimeException("tipis não definidis");
		}
	}
	

}
