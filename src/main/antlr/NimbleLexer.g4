lexer grammar NimbleLexer;

// TYPES
STRING_TYPE: 'string';
INTEGER_TYPE: 'int';
DOUBLE_TYPE: 'double';
BOOLEAN_TYPE: 'bool';
VOID: 'void';
NULL: 'null';

// ACCESSABILITY
GLOBAL: 'global';
PACKAGE: 'package';
INTERNAL: 'internal';
MAIN: 'main';

// Separators

SEMICOLON: ';';
COMMA: ',';
DOT: '.';
LEFT_PARENTHESE: '(';
RIGHT_PARENTHESE: ')';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_SQUARE_BRACKET: '[';
RIGHT_SQUARE_BRACKET: ']';

// Operators

ASSIGN: '=';
LESSER: '<';
GREATER: '>';
EQUAL: '==';
NOT_EQUAL: '!=';
LESSER_OR_EQUAL: '<=';
GREATER_OR_EQUAL: '>=';
AND: '&&';
OR: '||';
INCREMENT: '++';
DECREMENT: '--';
ADD: '+';
SUBSTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
MODULO: '%';
NOT : '!';

// Keywords

IF: 'if';
ELSE: 'else';
GOTO: 'goto';
RETURN: 'return';
FOR: 'for';
WHILE: 'while';
CLASS: 'class';

BOOLEAN
    : 'true'
    | 'false'
    ;

INTEGER: [0-9]+;

DOUBLE: INTEGER+ ',' INTEGER+;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

IDENTIFIER: [a-zA-Z_] [a-zA-Z_0-9]* ;

// Whitespace and comments
WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

