package br.com.mussumlanguis.datastructures;

public abstract class MussumSymbol {
	
	protected String name;
	
	public abstract String generateJavaCode();
	
	public MussumSymbol(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MussumSymbol [name="+name+"]";
	}

}
