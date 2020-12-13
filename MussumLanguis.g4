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
	import br.com.mussumlanguis.ast.WhileCommand;
	import br.com.mussumlanguis.ast.ForCommand;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.logging.*; 
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
	private Stack<String> conditionStack = new Stack<String>();
	private String _readId;
	
	private String _writeId;
	
	private String _exprId;
	private String _exprContent;
	
	private String _exprDecision;
	private ArrayList<AbstractCommand> trueList;
	private ArrayList<AbstractCommand> falseList;
	
	private String _attrVariable;
	private String _attrValue;
	
	private String _exprWhile;
	private String _exprFor;
	private ArrayList<AbstractCommand> commandList;
	

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
 				
 				Logger logger  = Logger.getLogger(MussumLanguisParser.class.getName()); 
  
        		// Set Logger level() 
        		logger.setLevel(Level.WARNING);
  
        		// Call warning method 
        		logger.warning("Variable " + i + " was never used"); 
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
 		((MussumVariable) symbolTable.get(_attrVariable)).setValue(_attrValue);
 		System.out.println("Simbolo atualizado: " + symbolTable.get(_attrVariable) ); 
 	}

 	public void showCommands() {
 		for (AbstractCommand cmd : program.getCommands()) {
 			System.out.println(cmd);
 		}
 	}
 	
 	public void generateCode() {
 		program.generateTarget();
 	}
}

prog	: 'programis' decl block 'cacildis;' {
												program.setSymbolTable(symbolTable);
												program.setCommands(commandStack.pop());
												checkVariableUsage();
											 }
		;
		
decl	: (var_decl)+
		;
		
var_decl	: type ID { addSymbol(); } (COMMA ID { addSymbol(); } )* SC
			;

type	:	INT		{	_type = MussumVariable.INT;		} 
		|	STRING 	{	_type = MussumVariable.TEXT;	}
		|	DOUBLE	{	_type = MussumVariable.DOUBLE;	}
		|	BOOLEAN	{	_type = MussumVariable.BOOLEAN;	}
		;
		
block	:	{	currThread = new ArrayList<AbstractCommand>();
				commandStack.push(currThread);
			}
			(cmd)+
		;
			
cmd		: read_cmd 		{	System.out.println("Reconheci um comando de leitura!");		} 
 		| write_cmd		{	System.out.println("Reconheci um comando de escrita");		}
 		| decision_cmd	{	System.out.println("Reconheci um comando de decisao");		}
 		| attr_cmd		{	System.out.println("Reconheci um comando de atribuicao");	}
 		| forg			{	System.out.println("Reconheci um laço for");				}
 		| whileg		{	System.out.println("Reconheci um laço while");				}
 		| comment 		{	System.out.println("Reconheci um comentario");				}
		;

comment		: 	'#COMENTIS' 
				.
				'#DESCOMENTIS'
			;
						
read_cmd	: 'inputis'	L_PAREN 
						ID	{	verifyID();
								
								_readId = _input.LT(-1).getText();
							}
						R_PAREN 
						SC	{	MussumVariable var = (MussumVariable) symbolTable.get(_readId);
								ReadCommand cmd = new ReadCommand(_readId, var);	
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

decision_cmd 	:	IF	
					L_PAREN
					ID				{	_exprDecision = _input.LT(-1).getText();
										verifyAssignment();
									}
					OPREL 			{	_exprDecision += _input.LT(-1).getText();		}
					(
					ID 				{	verifyAssignment();								} 
					| NUMBER ) 		{	_exprDecision += _input.LT(-1).getText();		}
					R_PAREN 
					L_CURL 			{	currThread = new ArrayList<AbstractCommand>();	
										commandStack.push(currThread);
										conditionStack.push(_exprDecision);
									}
					(cmd)+ 
					R_CURL			{	trueList = commandStack.pop();					}
					( 
					ELSE	
					L_CURL			{	currThread = new ArrayList<AbstractCommand>();	
										commandStack.push(currThread);
									} 
					(cmd)+ 
					R_CURL			{	falseList = commandStack.pop(); 				}
					)?				{	DecisionCommand cmd = new DecisionCommand(conditionStack.pop(), trueList, falseList);
										commandStack.peek().add(cmd);
									}
				;
		
whileg	: 	WHILE 
			L_PAREN 
			ID 				{ 	_exprWhile = _input.LT(-1).getText();
								verifyAssignment();
							}
			OPREL 			{	_exprWhile += _input.LT(-1).getText();		}
			(
			ID 				{	verifyAssignment();							} 
			| NUMBER
			) 				{	_exprWhile += _input.LT(-1).getText();		}
			R_PAREN 
			L_CURL 			{	currThread = new ArrayList<AbstractCommand>();	
								commandStack.push(currThread);
								conditionStack.push(_exprWhile);
							}
			(cmd)+
			R_CURL			{	
								WhileCommand cmd = new WhileCommand(conditionStack.pop(), commandStack.pop());
								commandStack.peek().add(cmd);
							}
		;				

forg	: 	FOR 
			L_PAREN 
			ID 				{ 	verifyID(); 
								_exprId = _input.LT(-1).getText();
								_attrVariable = _input.LT(-1).getText();
							
							} 
			ATTR 			{ 	_exprContent = "";	}
			expr 
			SC				{	_exprFor = _exprId + " = " + _exprContent + ";";	
							}	
			ID 				{	
								if (! _exprId.equals(_input.LT(-1).getText())) {
									throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
								}
								
								_exprFor += _input.LT(-1).getText();
								verifyAssignment();
							}
			OPREL 			{	_exprFor += _input.LT(-1).getText();		}
			(NUMBER
			|ID 			{	verifyAssignment();							}
			)				{	_exprFor += _input.LT(-1).getText();		} 
			SC 				{	_exprFor += _input.LT(-1).getText();		}
			ID 				{	_exprFor += _input.LT(-1).getText();
								verifyAssignment();
							}
			OP_CHANGE		{	_exprFor += _input.LT(-1).getText();		}
			R_PAREN 
			L_CURL			{	currThread = new ArrayList<AbstractCommand>();	
								commandStack.push(currThread);
								conditionStack.push(_exprFor);
							}
			(cmd)+ 
			R_CURL			{
								ForCommand cmd = new ForCommand(conditionStack.pop(), commandStack.pop());
								commandStack.peek().add(cmd);
							}
		;
		
attr_cmd	:  	ID 		{ 	verifyID(); 
							_exprId = _input.LT(-1).getText();
							_attrVariable = _input.LT(-1).getText();
							
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
							_attrValue = _input.LT(-1).getText();
						}  
			| NUMBER 	{	_exprContent += _input.LT(-1).getText();
							_attrValue = _input.LT(-1).getText();
							assignValue();
						}
			;
			

INT	: 'inteiris' ;
	
DOUBLE : 'quebradis' ;

STRING : 'textis' | 'stringuis';

BOOLEAN : 'booleanis';

L_PAREN	: '('
		;
	
R_PAREN	: ')'
		;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
OP_CHANGE	:	'++'
			|	'--'
			;
	
ATTR : '='
	 ;

IF	: 'se'
	;

ELSE 	: 'senãozis'
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