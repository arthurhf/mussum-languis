package br.com.mussumlanguis.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
	
	public Set<String> keySet() {
		return map.keySet();
	}
	
	public ArrayList<MussumSymbol> getAllSymbols() {
		return new ArrayList<MussumSymbol>(map.values());
	}
}
