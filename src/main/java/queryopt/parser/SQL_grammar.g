grammar SQL_grammar;

options 
{
	output=AST;
	ASTLabelType=CommonTree;
}
tokens
{
	QUERY;
	LITERAL;
}

@header{package queryopt.parser;}
@lexer::header {package queryopt.parser;}

@members {
List<RecognitionException> exceptions = new ArrayList<RecognitionException>();

public  void reportError(RecognitionException e)
{
    exceptions.add(e);
}

public boolean hasError()
{
 return exceptions.size() > 0; 
}

public String getErrorMessage()
{
	if (exceptions.size() > 0)
		return this.getErrorMessage(exceptions.get(0), this.getTokenNames());
	else
		return "No Errors";
}

public String getErrorPosition()
{
	return this.getErrorHeader(exceptions.get(0));
}
}

query
	:	query1 ';'! EOF! ; 
	
query1
	:	select from where? -> ^(QUERY from select where?); 
 	   
select	: 	SELECT^  ( (NAME | aggregate_funct) (','! (NAME | aggregate_funct) )* | STAR)  
	;
aggregate_funct
	:	( COUNT | SUM | AVG | MIN | MAX )^ '('!  NAME ')'!
	;
	
from	:	FROM^ NAME (','! NAME)*
	;
	
where	:	WHERE^ and
	;

and	:	clause ( 'AND'! clause)* 
	;

clause	:	( NAME | literal) op^ ( NAME |  literal ) 
		| (NAME | literal) IN^ '('! query1 ')'!
		;
literal	:	 '\'' name=NAME '\'' -> LITERAL[$name];
		
op	:	( EQ | LS | GT | LS_EQ | GT_EQ)
	;
  
/* Ignore white spaces */	
WS	
	:  (' '|'\r'|'\t'|'\u000C'|'\n')
	{$channel=HIDDEN;}
	;
SELECT	:	'SELECT';	
FROM	:	'FROM';
WHERE	:	'WHERE';
STAR	:	'*';
EQ	:	'=';
DIFF	:	'<>';
GT_EQ	:	'>=';
LS_EQ	:	'<=';
LS	:	'<';
GT	:	'>';
IN	:	'IN';
COUNT	:	'COUNT';
SUM	:	'SUM';
AVG	:	'AVG';
MAX	:	'MAX';
MIN	:	'MIN';
NAME	:	( '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' )+ ; 