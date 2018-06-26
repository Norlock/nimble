lexer grammar NimbleLexer;

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
IS_EQUAL: '==';
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

// Whitespace and comments
WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

// Keywords

IF: 'if';
ELSE: 'else';
GOTO: 'goto';
RETURN: 'return';



fragment DIGIT : [0-9] ;
NUMBER         : DIGIT+ ([.,] DIGIT+)? ;
WHITESPACE : ' ' -> skip ;

