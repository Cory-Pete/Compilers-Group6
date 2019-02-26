/* Lexer Rules */

grammar Little;

id : IDENTIFIER ;

KEYWORD : 'PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'READ' | 'WRITE' | 'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' | 'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT' ;

OPERATOR :  ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' | ';' | ',' | '<=' | '>=' ;

IDENTIFIER : [A-z]([A-z]|[0-9])* ;

INTLITERAL : [0-9]+ ;

STRINGLITERAL : '"'.*?'"'  ;

FLOATLITERAL : [0-9]*'.'[0-9]+ ;

COMMENTS : '--' .*? '\n' -> skip ;

WHITESPACE : [ \t\n] -> skip ;

