grammar MussumLanguis;

@header {
	import br.com.mussumlanguis.datastructures.MussumSymbol;
	import br.com.mussumlanguis.datastructures.MussumSymbolTable;
	import br.com.mussumlanguis.datastructures.MussumVariable;
	import br.com.mussumlanguis.exceptions.MussumSemanticException;
	import br.com.mussumlanguis.ast.MussumProgram;
	import br.com.mussumlanguis.ast.AbstractCommand;
	import br.com.mussumlanguis.ast.ReadCommand;
	import br.com.mussumlanguis.ast.WriteCommand;
	import br.com.mussumlanguis.ast.AttrCommand;
	import br.com.mussumlanguis.ast.DecisionCommand;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members {
	private int _type;
	private String _varName;
	private String _varValue;
	private MussumSymbolTable symbolTable = new MussumSymbolTable();
	private MussumSymbol symbol;
	private MussumProgram program = new MussumProgram();
	private ArrayList<AbstractCommand> currThread = new ArrayList<AbstractCommand>();
	private Stack<ArrayList<AbstractCommand>> commandStack = new Stack<ArrayList<AbstractCommand>>();
	
	private String _readId;
	
	private String _writeId;
	
	private String _exprId;
	private String _exprContent;
	
	private String _exprDecision;
	private ArrayList<AbstractCommand> trueList;
	private ArrayList<AbstractCommand> falseList;
	
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
 	
 	public void verifyAssignment(){
 		_varName = ((TokenStream) _input).LT(-1).getText();
 		if(((MussumVariable) symbolTable.get(_varName)).getValue() == null){
 				System.out.println("Variable " + _varName + " wasn't assigned");
 		}
 	}
 	
 	public void assignValue(){
 		//função pra passar o valor da atribuição pra variável no hashmap
 	}

 	public void showCommands() {
 		for (AbstractCommand cmd : program.getCommands()) {
 			System.out.println(cmd);
 		}
 	}
}

prog	: 'programis' decl block 'cacildis;' {
												program.setCommands(commandStack.pop());
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
		
block	:	{	currThread = new ArrayList<AbstractCommand>();
				commandStack.push(currThread);
			}
			(cmd)+
		;
		
forg	: FOR L_PAREN ID ATTR expr SC ID OPREL (NUMBER|ID) SC var_change R_PAREN L_CURL block R_CURL
		;
		
whileg	: WHILE L_PAREN ID ATTR expr R_PAREN L_CURL block R_CURL
		;

var_change	: ID op=('++'|'--' | '-') WS*
			;
			
cmd		: read_cmd 		{	System.out.println("Reconheci um comando de leitura!");		} 
 		| write_cmd		{	System.out.println("Reconheci um comando de escrita");		}
 		| decision_cmd	{	System.out.println("Reconheci um comando de decisao");		}
 		| attr_cmd		{	System.out.println("Reconheci um comando de atribuicao");	}
 		| forg			{	System.out.println("Reconheci um laço for");				}
 		| whileg		{	System.out.println("Reconheci um laço while");				}
		;
		
read_cmd	: 'inputis'	L_PAREN 
						ID	{	verifyID(); 
								_readId = _input.LT(-1).getText();
							}
						R_PAREN 
						SC	{	ReadCommand cmd = new ReadCommand(_readId);	
								commandStack.peek().add(cmd);
							}
			;
			

write_cmd	: 'escrevis' L_PAREN 
						ID 	{	verifyID(); 
								verifyAssignment();
								_writeId = _input.LT(-1).getText();
							} 
						R_PAREN 
						SC	{	WriteCommand cmd = new WriteCommand(_writeId);	
								commandStack.peek().add(cmd);
							}
			;

decision_cmd 	:	'se' 	
					L_PAREN
					ID				{	_exprDecision = _input.LT(-1).getText();		}
					OPREL 			{	_exprDecision = _input.LT(-1).getText();		}
					(ID | NUMBER) 	{	_exprDecision = _input.LT(-1).getText();		}
					R_PAREN L_CURL 	{	currThread = new ArrayList<AbstractCommand>();	
										commandStack.push(currThread);
									}
					(cmd)+ 
					R_CURL			{	trueList = commandStack.pop();					}
					('senãozis'	
					L_CURL			{	currThread = new ArrayList<AbstractCommand>();	
										commandStack.push(currThread);
									} 
					(cmd)+ 
					R_CURL			{	falseList = commandStack.pop();
										DecisionCommand cmd = new DecisionCommand(_exprDecision, trueList, falseList);
										commandStack.peek().add(cmd);
									}
					)?	
				;
							
attr_cmd	:  	ID 		{ 	verifyID(); 
							_exprId = _input.LT(-1).getText();
						} 
				ATTR 	{ 	_exprContent = "";	}
				expr 
				SC		{	AttrCommand cmd = new AttrCommand(_exprId, _exprContent);	
							commandStack.peek().add(cmd);
						}
			;
			
expr		:  	expr_token ( 
				OP 				{ _exprContent += _input.LT(-1).getText();	}
				expr_token )*
			;
			
expr_token	: ID 		{	verifyID();
							_exprContent += _input.LT(-1).getText();
						}  
			| NUMBER 	{	_exprContent += _input.LT(-1).getText();	}
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