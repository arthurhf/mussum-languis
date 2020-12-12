grammar MussumLanguis;

@header {
	import br.com.mussumlanguis.datastructures.MussumSymbol;
	import br.com.mussumlanguis.datastructures.MussumSymbolTable;
	import br.com.mussumlanguis.datastructures.MussumVariable;
	import br.com.mussumlanguis.exceptions.MussumSemanticException;
}

@members {
	private int _type;
	private String _varName;
	private String _varValue;
	private MussumSymbolTable symbolTable = new MussumSymbolTable();
	private MussumSymbol symbol;
	
	public void verifyID() {
		String id = ((TokenStream) _input).LT(-1).getText();
		
		if (!symbolTable.exists(id)) {
			throw new MussumSemanticException("Symbol " + id + " not declared");
		}
	}
	
	public void addSymbol() {
		_varName = ((TokenStream) _input).LT(-1).getText();
		_varValue = null;
		symbol = new MussumVariable(_varName, _type, _varValue);
		
		if (!symbolTable.exists(_varName)) {
			System.out.println("Simbolo adicionado: " + symbol); 
			symbolTable.add(symbol);
		} else {
			throw new MussumSemanticException("Symbol " + _varName + " already declared");
		}
	}
	
	public void checkVariableUsage(){
 		for (String i : symbolTable.keySet()) {
 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
 				System.out.println("Variable " + i + " was never used");
 			}
		}
 	}
}

prog	: 'programis' decl block 'cacildis;' {
												checkVariableUsage();
											  }
		;
		
decl	: (var_decl)+
		;
		
var_decl	: type ID { addSymbol(); } (COMMA ID { addSymbol(); } )* SC
			;

type	: 'numeris'	{	_type = MussumVariable.NUMBER;	} 
		| 'textis' 	{	_type = MussumVariable.TEXT;	}
		;
		
block	: (cmd)+
		;
		
forg	: FOR L_PAREN ID ATTR expr SC ID OPREL (NUMBER|ID) SC var_change R_PAREN L_CURL block R_CURL
		;
		
whileg	: WHILE L_PAREN ID ATTR expr R_PAREN L_CURL block R_CURL
		;

var_change	: ID op=('++'|'--' | '-') WS*
			;
			
cmd		: read_cmd 	{	System.out.println("Reconheci um comando de leitura!");		} 
 		| write_cmd	{	System.out.println("Reconheci um comando de escrita");		}
 		| attr_cmd	{	System.out.println("Reconheci um comando de atribuicao");	}
 		| forg		{	System.out.println("Reconheci um laço for");				}
 		| whileg	{	System.out.println("Reconheci um laço while");				}
		;
		
read_cmd	: 'inputis'	L_PAREN ID { verifyID() } R_PAREN SC 
			;
			
write_cmd	: 'escrevis' L_PAREN ID { verifyID(); } R_PAREN SC
			;
			
attr_cmd	:  ID { verifyID(); } ATTR expr SC
			;
			
expr		:  expr_token ( OP expr_token)*
			;
			
expr_token	: ID { verifyID(); }  
			| NUMBER
			;
			
	
L_PAREN	: '('
		;
	
R_PAREN	: ')'
		;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;

FOR	: 'paris' 
	;

WHILE : 'enquantis'
	  ;

L_CURL	: '{' 
		;

R_CURL	: '}' 
		;
	 
COMMA	: ','
		;
	
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
	 
ID	: [a-z] ([a-z] | [A-Z] | [0-9])* 
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;