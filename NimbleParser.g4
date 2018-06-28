parser grammar NimbleParser;

options { tokenVocab=NimbleLexer; }

main
    : MAIN constructorDeclaration block EOF
    ;

block
    : LEFT_BRACE statement* RIGHT_BRACE
    ;

statement
    : variableDeclaration
    | ifStatement
    | functionCall
    | whileLoop
    ;

variableDeclaration
    : variableType IDENTIFIER ASSIGN expression SEMICOLON
    ;

ifStatement
     : IF conditionBlock (ELSE IF conditionBlock)* (ELSE block)?
     ;

functionCall
    : IDENTIFIER LEFT_PARENTHESE atom RIGHT_PARENTHESE SEMICOLON
    ;

functionDeclaration
    : modifier variableType

functionType
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

constructorDeclaration
    : LEFT_PARENTHESE constructorParameters? RIGHT_PARENTHESE
    ;

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
    | BOOLEAN                                       #booleanAtom
    | IDENTIFIER                                    #identifierAtom
    | STRING                                        #stringAtom
    | NULL                                          #nullAtom
    ;
