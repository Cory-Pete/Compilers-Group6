/* Lexer Rules */

grammar Little;

id : IDENTIFIER ;

IDENTIFIER : [A-z]([A-z]|[0-9])* ;

KEYWORDS : 'PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'READ' | 'WRITE' | 'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' | 'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT' ;

INTLITERAL : [0-9]+ ;

STRINGLITERAL : '"'.*?'"'  ;

FLOATLITERAL : [0-9]*'.'[0-9]+ ;

OPERATORS :  ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' | ';' | ',' | '<=' | '>=' ;

COMMENTS : '--' .*? '\n' -> skip ;

WHITESPACE : [ \t\n] -> skip ;

