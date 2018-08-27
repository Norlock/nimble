# Compiler *Nimble*

# 1. Taal introductie
Nimble, wat vlug en licht in beweging betekend, is een programmeertaal die gebasseerd is op JavaScript, om vlugger
en eenvoudiger code te kunnen schrijven. Alles wordt net als in JavaScript in 1 bestand gedaan. Er zit wat syntactic
sugar in om minder code te hoeven schrijven. Bijvoorbeeld de print() methode roept automatisch system.out.println() op
onderwater. Verder zit er ook een autocast functie ingebakken die automatisch integers naar doubles cast.

```
int a = 3;
double b = a;
```

a Wordt automatisch gecast naar doubles.

```
double b = 3;
int a = b;
```

Zal een exceptie opleveren, dit is gedaan om ervoor te zorgen dat een programmeur niet zonder het door te hebben
komma getallen kan kwijtraken. Methodes onderwater zullen allemaal static zijn, maar deze hoeven niet zo gedeclareerd te
worden. Er zijn een aantal rules opgesteld die nog niet gebruikt worden, maar in de toekomst makkelijk uitgebreid kan
worden, zo worden er bijvoorbeeld de volgende functie wijzigers gebruikt, die onderwater hetzelfde doen:

* global (ofwel public in Java).
* package (ofwel protected in Java).
* internal (ofwel private in Java).

Deze termen spreken direct tot de verbeelding voor de ontwikkelaar. DataTypes hoeven niet geinitialiseerd te worden,
maar krijgen een automatische waarde toegewezen. 

```
main {
  int a;
  print(a)
}
```

zal als output: 0 opleveren. Alles mag direct worden geprint:

```
int a = 6;
string test = "test string"
print a + 3;  // 9
print 3 + a; // 9
print "een " + test; // een test string
print (test + 6); // test string6
```

Deze waarden zullen allemaal uitgeprint worden. 

## 1.1 Bestands indeling
Boven aan het bestand wordt de class declaratie verwacht 

```
class App;
```

Deze klasse declaratie zal ook gebruikt worden om de bestandsnaam van de build toe te wijzen: `App.java`.

Boven aan het bestand 

# Code architectuur
Er is een class Data. 

* Data    
    * ValueData 
        * VariableData (checked)
        * ExpressionData (checked)
    * ParserData (not checked)


