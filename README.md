# Compiler *Nimble*

De programmeertaal Nimble, wat vlug en licht in beweging betekend, moet de ontwikkelaar met minder code kunnen laten
programmeren.

The language name I'm going to use is: Nimble. Nimble means: quick and light in movement.
The file extensions will be .nim. The compiler will be parsed with use the g4 file to define the parser rules.
In java the code will be executed.

The first word inside a file will determin the availability:
* Domain is inside a package
* global is public

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



