# Compiler *main.Nimble*

main.Nimble, wat vlug en licht in beweging betekend, is een programmeertaal die is ontwikkeld om vlugger en eenvoudiger code
te kunnen schrijven. 

Er zijn verschillende class modifiers:
* global (ofwel public in Java).
* package (ofwel protected in Java).
* internal (ofwel private in Java).

Deze termen spreken direct tot de verbeelding voor de ontwikkelaar. 

Er worden twee variabelen gebruikt:
* text (ofwel String in Java).
* number (ofwel integer, double, float, etc in Java of number in JavaScript).

Het type number is muteerbaar, dit houdt in dat het altijd opzoek gaat naar het juiste type onderwater, bijvoorbeeld:
* 3 + 2 == integer
* 3 - 1.5 == float
* 1.5 - 1.5 == integer


```
domain instance CD {
  global String name;
  global int trackCount;
  domain String description;
}
```

The second word is the type it resembles: instance (class) and later maybe interface 

```
// Here ah class can be defined as global, the identifier must be a (unique)string. If you have for instance a class
// MovieStore, this can be called with MovieStore("");
global instance CDStore("FreeRecord") {

}
```



