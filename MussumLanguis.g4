/** java -cp .:antlr-4.7.1-complete.jar org.antlr.v4.Tool MussumLanguis.g4 -package br.com.mussumlanguis.parser -o ./src/br/com/mussumlanguis/parser/
 * 
 */
grammar MussumLanguis;

@header{
	import br.com.mussumlanguis.datastructures.*;
	import br.com.mussumlanguis.exceptions.*; 	
 	import java.util.ArrayList;
 }
 
 @members{
 	private int _type;
 	private String _varName;
 	private String _varValue;
 	private MussumSymbolTable symbolTable = new MussumSymbolTable();
 	private MussumSymbol symbol;
 	
 	public void addSymbol(){
 		_varName = ((TokenStream) _input).LT(-1).getText();
		_varValue = null;
		if(!symbolTable.exists(_varName)){
			symbol = new MussumVariable(_varName, _type, _varValue);
			symbolTable.add(symbol);
			System.out.println("Symbol added " + symbol);
		}else{
			throw new MussumSemanticException("Symbol "+_varName+ " already declared");
		}
		
 	}
 	
 	public void checkID(String id){
 		if(!symbolTable.exists(id)){
        	throw new MussumSemanticException("Symbol "+id+" not declared");
        }
 		
 	}
 	
 	public void checkVariableUsage(){
 		for (String i : symbolTable.keySet()) {
 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
 				System.out.println("Variable " + i + " was never used");
 			}
		}
 	}
 	
 	public void addVariableValue(String id, String value){
 		((MussumVariable) symbolTable.get(id)).setValue(value);
 		System.out.println("changed value " + symbolTable.get(id));
 	}
 	
 }
 

prog	: 'programis' decl bloco  'cacildis;' {
												checkVariableUsage();
											  } 
		;
		
decl	: (declaravar)+
		;
		
declaravar	: tipo ID {
						addSymbol();
						
					}
			(VIR ID {
						addSymbol();
						
					}			
			)* SC
			;

tipo	: 'numeris' {
						_type = MussumVariable.NUMBER;
					} 
		| 'textis' {
						_type = MussumVariable.TEXT;
					}
		;
		
bloco	: (cmd)+
		;
		
forg	: FOR AP ID ATTR expr SC ID OPREL (NUMBER|ID) SC varChange FP LCURL bloco RCURL
		;
varChange	: ID op=('++'|'--' | '-') WS*
			;
cmd		:  cmdleitura { 
					
					} 
 		|  cmdescrita { System.out.println("Reconheci um comando de escrita");   }
 		|  cmdattrib  { System.out.println("Reconheci um comando de atribuicao");}
 		|	forg	{System.out.println("Reconheci um laço for");}
		;
		
cmdleitura	: 'inputis' AP
                     ID {
                     		checkID(_input.LT(-1).getText());                     		
						} 
                     FP 
                     SC 
			;
			
cmdescrita	: 'escrevis' AP ID{
                     			checkID(_input.LT(-1).getText());                     		
							  } 
						FP SC
			;
			
cmdattrib	:  ID ATTR expr SC
			;
			
expr		:  termo ( OP termo )*
			;
			
termo		: ID | NUMBER
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;

FOR	: 'paris' ;

LCURL	: '{' ;
RCURL	: '}' ;
	 
VIR	: ','
	;
	
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
	 
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;