/* Lexer Rules */

grammar Little;

id : IDENTIFIER ;

IDENTIFIER : [a-Z]+ ([a-Z]|[0-9])* ;


INTEGER : '[0-9]+' ;

STRING : '(?<=")[\\S\\s]*(?=")' ;

COMMENTS : '--' .*? '\n' -> skip ;

FLOAT : '[0-9]*'.'[0-9]+' ;

KEYWORDS : 'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSE'|'ENDIF'|'WHILE'|'ENDWHILE'|'CONTINUE'|'BREAK'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT' ; 

OPERATORS :  ':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=' ;


WHITESPACE : ' ' -> skip ;

