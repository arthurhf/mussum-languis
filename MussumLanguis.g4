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
	import br.com.mussumlanguis.ast.DoWhileCommand;
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
	
	private int _varType = -1;

	public void verifyID() {
		String id = ((TokenStream) _input).LT(-1).getText();
		
		if (!symbolTable.exists(id)) {
			throw new MussumSemanticException("Variávis " + id + " não declaradis");
		}
	}
	
	public void addSymbol() {
		_varName = ((TokenStream) _input).LT(-1).getText();
		_varValue = null;
		symbol = new MussumVariable(_varName, _type, _varValue);
		
		if (!symbolTable.exists(_varName)) {
			symbolTable.add(symbol);
		} else {
			throw new MussumSemanticException("Variávis " + _varName + " já declaradis");
		}
	}
	
	public void checkVariableUsage(){
 		for (String i : symbolTable.keySet()) {
 			if(((MussumVariable) symbolTable.get(i)).getValue() == null){
 				
 				Logger logger  = Logger.getLogger(MussumLanguisParser.class.getName()); 
  
        		// Set Logger level() 
        		logger.setLevel(Level.WARNING);
  
        		// Call warning method 
        		logger.warning("Variávis " + i + " nunca usadis"); 
 			}
		}
 	}
 	
 	public void verifyAssignment(){
 		_varName = ((TokenStream) _input).LT(-1).getText();
 		if(((MussumVariable) symbolTable.get(_varName)).getValue() == null){
 				throw new MussumSemanticException("Variávis " + _varName + " não inicializadis");
 		}
 	}
 	
 	public void assignValue(){
 		//função pra passar o valor da atribuição pra variável no hashmap
 		((MussumVariable) symbolTable.get(_exprId)).setValue(_exprContent);
 	}

	public void verifyVarType(int currType) {
		if (_varType == -1) {
			_varType = currType;
		} else if (_varType != currType) {
			throw new MussumSemanticException ("Você está misturandis variávis do tipo " + 
				MussumVariable.getMussumType(currType) + " com " + MussumVariable.getMussumType(_varType));
		
		}
	}
	
 	
 	public void generateCode() {
 		program.generateTarget();
 	}
}

prog	:  'programis' block 'cacildis;'	{
													program.setSymbolTable(symbolTable);
													program.setCommands(commandStack.pop());
													checkVariableUsage();
											 	}
		;
		
		
decl	: (var_decl)+
		;
		
var_decl	: 	type 
				ID 				{	addSymbol();	
									_exprId = _input.LT(-1).getText();
								} 
				(	ATTR 		{ 	_exprContent = "";	
									_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
								}
					expr		{	assignValue();			
									AttrCommand cmd = new AttrCommand(_exprId, _exprContent);	
									commandStack.peek().add(cmd);
								}
				)?
				
				(
					COMMA 
					ID 			{ 	addSymbol(); 			
									_exprId = _input.LT(-1).getText();
								}
					(	
						ATTR 	{ 	_exprContent = "";	
									_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
								}
						expr	{	assignValue();			
									AttrCommand cmd = new AttrCommand(_exprId, _exprContent);
									commandStack.peek().add(cmd);
								}
					)?
				)* SC
			;
							
							
type	:	INT_DECL		{	_type = MussumVariable.INT;		} 
		|	STRING_DECL 	{	_type = MussumVariable.TEXT;	}
		|	DOUBLE_DECL		{	_type = MussumVariable.DOUBLE;	}
		|	BOOLEAN_DECL	{	_type = MussumVariable.BOOLEAN;	}
		|	CHAR_DECL		{	_type = MussumVariable.CHAR;	}
		;
		
block	:	{	currThread = new ArrayList<AbstractCommand>();
				commandStack.push(currThread);
			}
			(cmd|decl)+
		;
			
cmd		: read_cmd
 		| write_cmd
 		| decision_cmd
 		| attr_cmd
 		| forg
 		| whileg
 		| dog
 		| comment
		;

comment		: 	'#COMENTIS' (.)*? '#DESCOMENTIS'
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
										_exprContent = "";
									}
					OPREL 			{	_exprDecision += _input.LT(-1).getText();		}
					expr			{	_exprDecision += _exprContent;					}
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
				
dog	: 	DO		
		L_CURL 			{	currThread = new ArrayList<AbstractCommand>();	
							commandStack.push(currThread);
						}
		(cmd)+
		R_CURL
		WHILE
		L_PAREN 
		ID 				{ 	_exprWhile = _input.LT(-1).getText();
							verifyAssignment();
							_exprContent = "";
						}
		OPREL 			{	_exprWhile += _input.LT(-1).getText();		}
		expr			{	_exprWhile += _exprContent;					}
		R_PAREN			{	
							DoWhileCommand cmd = new DoWhileCommand(_exprWhile, commandStack.pop());
							commandStack.peek().add(cmd);
						}
		';'
		;
		
whileg	: 	WHILE 
			L_PAREN 
			ID 				{ 	_exprWhile = _input.LT(-1).getText();
								verifyAssignment();
								_exprContent = "";
							}
			OPREL 			{	_exprWhile += _input.LT(-1).getText();		}
			expr			{	_exprWhile += _exprContent;					}
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
			ATTR 			{ 	_exprContent = "";	
								_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
							}
			expr 
			SC				{	_exprFor = _exprId + " = " + _exprContent + ";";	
								assignValue();
							}	
			ID 				{	
								if (! _exprId.equals(_input.LT(-1).getText())) {
									throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
								}
								
								_exprFor += _input.LT(-1).getText();
								verifyAssignment();
							}
			OPREL 			{	_exprFor += _input.LT(-1).getText();		
								_exprContent = "";
							}
			expr			{	_exprFor += _exprContent;					}
			SC 				{	_exprFor += _input.LT(-1).getText();		}
			ID 				{	
								if (! _exprId.equals(_input.LT(-1).getText())) {
									throw new MussumSemanticException("Esperavis a variávis " + _exprId + " no paris");
								}
								_exprFor += _input.LT(-1).getText();
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
	
attr_cmd	:  	(
					(type ID)			{ 	addSymbol(); 							} 
					| ID 				{ 	verifyID(); 							}
				)						{	_exprId = _input.LT(-1).getText();		}
				ATTR 					{ 	_exprContent = "";	
											_varType = ((MussumVariable) symbolTable.get(_exprId)).getType();
										}
				expr
				SC						{	
											assignValue();
											AttrCommand cmd = new AttrCommand(_exprId, _exprContent);	
											commandStack.peek().add(cmd);
										}
			;
			
expr		:  	(
					(	
						expr_token ( 
						OP 				{ _exprContent += _input.LT(-1).getText();	}
						expr_token )*
					)
				|
					(
						BOOLEAN_VAL		{	verifyVarType(MussumVariable.BOOLEAN);		
											String booleanInput = _input.LT(-1).getText();
											_exprContent += booleanInput.equals("falsis") ? "false" : "true";
										}
						| CHAR_VAL		{	verifyVarType(MussumVariable.CHAR);			
											_exprContent += _input.LT(-1).getText();
										}
					)
				)
			;
			
expr_token	: 	( 
					ID 					{	verifyID();	
											verifyAssignment();
											int type = ((MussumVariable) symbolTable.get(_input.LT(-1).getText())).getType();
											verifyVarType(type);
										}  
					| INT_VAL			{	verifyVarType(MussumVariable.INT);			}
					| DOUBLE_VAL		{	verifyVarType(MussumVariable.DOUBLE);		}
					| STRING_VAL		{	verifyVarType(MussumVariable.TEXT);			}
				) 						{	_exprContent += _input.LT(-1).getText();	}
			;
			

INT_DECL	: 'inteiris' 
			;

INT_VAL		: [0-9]+
			;
			
DOUBLE_DECL : 'quebradis' 
			;

DOUBLE_VAL	: [0-9]+ ('.' [0-9]+)?
			;
 
STRING_DECL : 'textis' | 'stringuis'
			;

STRING_VAL	: '"' ([a-z]|[A-Z]|[0-9]|' ')* '"'
			;

BOOLEAN_DECL	: 'booleanis'
				;

BOOLEAN_VAL : 'verdadeiris' | 'falsis'
			;

CHAR_DECL 	: 'caractéris' 
			;

CHAR_VAL	: 	'"'
				([a-z]|[A-Z]|[0-9])
				'"'
			;
			
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

DO	:	'facis'
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

		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;