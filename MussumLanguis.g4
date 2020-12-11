/** java -cp .:antlr-4.7.1-complete.jar org.antlr.v4.Tool MussumLanguis.g4 -package br.com.mussumlanguis.parser -o ./src/br/com/mussumlanguis/parser/
 * 
 */
 
grammar MussumLanguis;

prog	: 'programis' decl block 'cacildis;' 
		;
		
decl	: (var_decl)+
		;
		
var_decl	: type ID (COMMA ID)* SC
			;

type	: 'numeris'	{	System.out.println("TIPO NUMERO");	} 
		| 'textis' 	{	System.out.println("TIPO TEXTO");	}
		;
		
block	: (cmd)+
		;
		
forg	: FOR L_PAREN ID ATTR expr SC ID OPREL (NUMBER|ID) SC var_change R_PAREN L_CURL block R_CURL
		;
var_change	: ID op=('++'|'--' | '-') WS*
			;
			
cmd		: read_cmd 	{	System.out.println("Reconheci um comando de leitura!");		} 
 		| write_cmd	{	System.out.println("Reconheci um comando de escrita");		}
 		| attr_cmd	{	System.out.println("Reconheci um comando de atribuicao");	}
 		| forg		{	System.out.println("Reconheci um laço for");				}
		;
		
read_cmd	: 'inputis'	L_PAREN
                     	ID 	{	System.out.println("ID=" + _input.LT(-1).getText());	} 
                     	R_PAREN
                     	SC 
			;
			
write_cmd	: 'escrevis' L_PAREN ID R_PAREN SC
			;
			
attr_cmd		:  ID ATTR expr SC
			;
			
expr		:  expr_token ( OP expr_token)*
			;
			
expr_token	: ID | NUMBER
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