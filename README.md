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

## 1.1 Data types
Nimble maakt gebruik van de volgende vier data types:
* string (in java String)
* bool (in java boolean)
* int
* double

## 1.1 Commentaar
In code commentaar kan via twee manieren worden toegevoegd:
1. `# Dit commentaar geld per regel.`
2. `<# Dit commentaar kan op meerdere regels verspreid worden #>`

## 1.2 Bestands indeling
Development bestanden in Nimble maken gebruik van de volgende extensie: `.nim`.
Wanneer de compiler gerund wordt, zal alles direct gebuild en gecompiled worden. De build bestanden zijn te vinden in
de nim-build folder. Bij elke build zal deze folder verwijderd en opnieuw gecreerd worden. Nimble zal een '*.j' bestand
maken in de build folder. Dit bestand is een Jasmin bestand, die vervolgens met de Jasmin library gecompileerd kan
worden m.b.v. het volgende commando:

```sh
java -jar ../lib/jasmin.jar App.j
```

Nimble zal automatisch het development bestand omzetten naar een Jasmin bestand. Dit Jasmin bestand zal vervolgens
gecompileerd worden naar een Java bestand en worden uitgevoerd. Boven aan het development bestand wordt de klasse gedeclareerd.

```
class App;
```

Deze klasse declaratie zal ook gebruikt worden om de bestandsnaam van de build toe te wijzen: `App.j of App.java`. 
Code begint bij het main blok.

```
class App;

main {
  # Hier begint de code.
}
```

Velden kunnen overal (buiten de main) gedeclareerd worden op de volgende manier:

```
global string test = "test";
```

Functies kunnen op de volgende manier gedeclareerd worden: 

```
global void someMethod(int a, string b) {
	
}
```

# 2. Grammatica regels
De grammatica regels worden in het bestand NimbleParser gedefinieerd. Programmeertalen maken gebruik van een aantal
vaste regels. Deze regels maken het opbouwen van de programmeertaal een stuk eenvoudiger.

## 2.1 Statements
Statements zijn syntaxtische delen van code dat een bepaalde actie definieerd. De volgende statements kunnen in nimble
gebruikt worden:
* variabel declaratie
* variabel implementatie
* if - else blokken
* while loops
* print
* returns
* functie aanroepen
* commentaar

Vaak bevatten statements weer expressies.

## 2.2 Expressies
Expressies zijn een combinatie van constanten, variabelen en operatoren. Zoals in 2.1 al is genoemd kunnen statements
expressies bevatten. Zoals bijvoorbeeld:

```
if(2 < 3) {
  
}
```

Hierboven bevat het if - else statement, de expressie: `2 < 3`. Expressies die gebruikt worden in Nimble zijn:
* Niet expressies
* optel - aftrek expressies
* vermenigvuldig - delen - rest expressies
* relationele vergelijkingen
* gelijkwaardige vergelijkingen
* and, of operatoren
* en atomen

## 2.3 Atomen
Atomen zijn inidivuele onderdelen van expressies. Atomen zijn bijvoorbeeld integers, strings, etc. Maar kunnen ook weer
interne expressies zijn:

```
if((2 < 3) && (3 < 4)) {
  
}
```

atom 1 is de expressie (2 < 3) ofwel true.

# 3. Code architectuur
De visitor klasse van ANTLR retouneerd de klasse: `ParserData`. In het begin heb ik getwijfeld om i.p.v. ParserData een
lijst met Strings (jasmin commando's) te retourneren maar heb hier uiteindelijk niet voor gekozen. Dit komt omdat
commando's niet altijd hetzelfde moet retourneren. Een voorbeeld is een 'of' expressie:

```
if(someBool || someBool) {
  
}
```

Deze if constructie zal de volgende Jasmin code opleveren:

```
iload 6
ifne label4
iload 6
ifeq label5
label4:
goto label3
label5:
label3:
```

De rede dat ik gebruik 

Deze klasse bevat een lijst met JavaByteCommands. 
Er is een class Data. 

* Data    
    * ValueData 
        * VariableData (checked)
        * ExpressionData (checked)
    * ParserData (not checked)


