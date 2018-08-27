parser grammar NimbleParser;

options { tokenVocab=NimbleLexer; }

parse: classDeclaration component* main component* EOF;

component
    : field
    | function
    | comment
    ;

classDeclaration
    : CLASS IDENTIFIER SEMICOLON ;

comment
    : COMMENT
    | LINE_COMMENT;

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

constructorParameters
    : variableType IDENTIFIER (COMMA variableType IDENTIFIER)*
    ;

functionCall
    : IDENTIFIER LEFT_PARENTHESE functionAssignments? RIGHT_PARENTHESE
    ;

functionAssignments
    : expression (COMMA expression)*
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
    | whileLoop
    | printStatement
    | comment
    | returnStatement
    | functionCall SEMICOLON
    ;


ifStatement
    : IF conditionBlock (ELSE IF conditionBlock)* (ELSE block)?
    ;

printStatement
    : PRINT condition SEMICOLON
    ;

returnStatement
    : RETURN expression? SEMICOLON ;

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

variableType: INTEGER_TYPE | STRING_TYPE | BOOLEAN_TYPE | DOUBLE_TYPE ;

expression
    : NOT expression                                                                    #notExpression
    | expression op=(ADD | SUBSTRACT) expression                                     #additiveExpression
    | expression op=(MULTIPLY | DIVIDE | MODULO) expression                             #multiplicationExpression
    | expression op=(LEFT_LESSER_OR_EQUAL | LEFT_GREATER_OR_EQUAL
        | LEFT_LESSER | LEFT_GREATER) expression                                        #relationalExpression
    | expression op=(EQUAL | NOT_EQUAL) expression                                      #equalityExpression
    | expression op=(AND | OR) expression                                               #bitwiseExpression
    | atom                                                                              #atomExpression
    ;

atom
    : LEFT_PARENTHESE expression RIGHT_PARENTHESE   #parentheseExpression
    | INTEGER                                       #integerAtom
    | (TRUE | FALSE)                                #booleanAtom
    | IDENTIFIER                                    #identifierAtom
    | STRING                                        #stringAtom
    | DOUBLE                                        #doubleAtom
    | functionCall                                  #functionCallAtom
    | NULL                                          #nullAtom
    ;
