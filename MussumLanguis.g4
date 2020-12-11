/** java -cp .:antlr-4.7.1-complete.jar org.antlr.v4.Tool MussumLanguis.g4 -package br.com.mussumlanguis.parser -o ./src/br/com/mussumlanguis/parser/
 * 
 */
 
grammar MussumLanguis;

prog	: 'programis' decl bloco  'cacildis;' 
		;
		
decl	: (declaravar)+
		;
		
declaravar	: tipo ID (VIR ID)* SC
			;

tipo	: 'numeris' {System.out.println("TIPO NUMERO");} | 'textis' {System.out.println("TIPO TEXTO");}
		;
		
bloco	: (cmd)+
		;
		
forg	: FOR AP ID ATTR expr SC ID OPREL (NUMBER|ID) SC varChange FP LCURL bloco RCURL
		;
varChange	: ID op=('++'|'--' | '-') WS*
			;
cmd		:  cmdleitura { System.out.println("Reconheci um comando de leitura!");  } 
 		|  cmdescrita { System.out.println("Reconheci um comando de escrita");   }
 		|  cmdattrib  { System.out.println("Reconheci um comando de atribuicao");}
 		|	forg	{System.out.println("Reconheci um laço for");}
		;
		
cmdleitura	: 'inputis' AP
                     ID { System.out.println("ID=" + _input.LT(-1).getText());} 
                     FP 
                     SC 
			;
			
cmdescrita	: 'escrevis' AP ID FP SC
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