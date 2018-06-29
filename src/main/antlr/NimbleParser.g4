parser grammar NimbleParser;

options { tokenVocab=NimbleLexer; }

main
    : MAIN constructorDeclaration block function*  EOF
    ;

block
    : LEFT_BRACE statement* RIGHT_BRACE
    ;

variableDeclaration
    : variableType IDENTIFIER (ASSIGN expression)? SEMICOLON
    ;

variableAssignment
    : IDENTIFIER ASSIGN expression SEMICOLON
    ;

constructorDeclaration
    : LEFT_PARENTHESE constructorParameters? RIGHT_PARENTHESE
    ;

statement
    : variableDeclaration
    | variableAssignment
    | ifStatement
    | functionCall
    | whileLoop
    ;

ifStatement
     : IF conditionBlock (ELSE IF conditionBlock)* (ELSE block)?
     ;

functionCall
    : IDENTIFIER LEFT_PARENTHESE atom RIGHT_PARENTHESE SEMICOLON
    ;

function
    : modifier returnValue IDENTIFIER constructorDeclaration block
    ;

returnValue
    : variableType
    | VOID
    ;

whileLoop
    : WHILE conditionBlock
    ;

conditionBlock
    : LEFT_PARENTHESE expression RIGHT_PARENTHESE block
    ;

modifier: GLOBAL | PACKAGE | INTERNAL ;

variableType: INTEGER_TYPE | STRING_TYPE | BOOLEAN_TYPE ;


constructorParameters
    : variableType IDENTIFIER (',' variableType IDENTIFIER)*
    ;

expression
    : NOT expression                                                                    #notExpression
    | expression op=(ADD | SUBSTRACT) expression                                        #additiveExpression
    | expression op=(MULTIPLY | DIVIDE | MODULO) expression                             #multiplicationExpression
    | expression op=(LESSER_OR_EQUAL | GREATER_OR_EQUAL | LESSER | GREATER) expression  #relationalExpression
    | expression op=(EQUAL | NOT_EQUAL) expression                                      #equalityExpression
    | expression AND expression                                                         #andExpression
    | expression OR expression                                                          #orExpression
    | atom                                                                              #atomExpression
    ;

atom
    : LEFT_PARENTHESE expression RIGHT_PARENTHESE   #parantheseExpression
    | INTEGER                                       #numberAtom
    | type=(TRUE | FALSE)                           #booleanAtom
    | IDENTIFIER                                    #identifierAtom
    | STRING                                        #stringAtom
    | NULL                                          #nullAtom
    ;
