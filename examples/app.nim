class App;

global string someField = "jaaa!";

main {
    int a = 9;
    int b = 3;
    double c = b;
    someField = "een string " + c;
    print((a + b - 6 - 3) < 4);
    print(someField);
    double j = someMethod(3, 3);

    print(j);
    bool someBool = true;
    if(someBool || someBool) {

    }
}

global int someMethod(int a, int b) {
    return a + b;
}