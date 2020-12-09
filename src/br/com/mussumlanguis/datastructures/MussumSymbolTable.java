package br.com.mussumlanguis.datastructures;

import java.util.HashMap;

public class MussumSymbolTable {
	private  HashMap<String, MussumSymbol> map;
	
	public MussumSymbolTable() {
		map = new HashMap<String, MussumSymbol>();
	}
	
	public void add(MussumSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public MussumSymbol get(String symbolName) {
		return map.get(symbolName);
	}
}
