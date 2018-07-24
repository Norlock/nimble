# Compiler *main.Nimble*

main.Nimble, wat vlug en licht in beweging betekend, is een programmeertaal die is ontwikkeld om vlugger en eenvoudiger code
te kunnen schrijven. 

Er zijn verschillende class modifiers:
* global (ofwel public in Java).
* package (ofwel protected in Java).
* internal (ofwel private in Java).

Deze termen spreken direct tot de verbeelding voor de ontwikkelaar. 


```
main {
  global String name;
  global int trackCount;
  domain String description;
}
```

# Code architectuur
Er is een class Data. 

* Data    
    * ValueData 
        * VariableData (checked)
        * ExpressionData (checked)
    * ParserData (not checked)


