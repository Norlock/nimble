class App;

global string someField = "jaaa!";

main {
    int a = 9;
    int b = 3;
    someField = "nee :(";
    print((a + b - 6 - 3) < 4);
    print(b);
    int j = someMethod(3, 3);

    print(j);
}

global int someMethod(int a, int b) {
    return a + b;
}