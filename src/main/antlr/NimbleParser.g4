parser grammar NimbleParser;

options { tokenVocab=NimbleLexer; }

// functies en fields mogen boven de main bevinden.
parse: declarations* main declarations* EOF;

declarations
    : field
    | function
    ;

main: MAIN block ;

function
    : modifier returnValue IDENTIFIER constructorDeclaration block
    ;

field
    : modifier variableDeclaration
    ;

constructorDeclaration
    : LEFT_PARENTHESE constructorParameters? RIGHT_PARENTHESE
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


statement
    : variableDeclaration
    | variableAssignment
    | ifStatement
    | functionCall
    | whileLoop
    | printStatement
    ;

ifStatement
     : IF conditionBlock (ELSE IF conditionBlock)* (ELSE block)?
     ;

functionCall
    : IDENTIFIER LEFT_PARENTHESE atom RIGHT_PARENTHESE SEMICOLON
    ;

printStatement
    : PRINT condition SEMICOLON
    ;

returnValue
    : variableType
    | VOID
    ;

whileLoop
    : WHILE conditionBlock
    ;

conditionBlock
    :  condition block
    ;

condition
    : LEFT_PARENTHESE expression RIGHT_PARENTHESE
    ;

modifier: GLOBAL | PACKAGE | INTERNAL ;

variableType: INTEGER_TYPE | STRING_TYPE | BOOLEAN_TYPE ;

constructorParameters
    : variableType IDENTIFIER (',' variableType IDENTIFIER)*
    ;

expression
    : NOT expression                                                                    #notExpression
    | expression (ADD | SUBSTRACT) expression                                        #additiveExpression
    | expression op=(MULTIPLY | DIVIDE | MODULO) expression                             #multiplicationExpression
    | expression op=(LESSER_OR_EQUAL | GREATER_OR_EQUAL | LESSER | GREATER) expression  #relationalExpression
    | expression op=(EQUAL | NOT_EQUAL) expression                                      #equalityExpression
    | expression AND expression                                                         #andExpression
    | expression OR expression                                                          #orExpression
    | atom                                                                              #atomExpression
    ;

atom
    : LEFT_PARENTHESE expression RIGHT_PARENTHESE   #parentheseExpression
    | INTEGER                                       #integerAtom
    | (TRUE | FALSE)                                #booleanAtom
    | IDENTIFIER                                    #identifierAtom
    | STRING                                        #stringAtom
    | NULL                                          #nullAtom
    ;
