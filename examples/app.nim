class App;

global string someField = "jaaa!";

main {
    int a = 9;
    int b = 3;
    someField = "nee :(";
    print(a + b - 6 - 3);
    print(b);
    if(a < b) {
        string s = "ss";
        a = 5;
        print(a + s);
        print(someField);
    } else {
        string s = "yes";
    }
}

global int someMethod(int a, int b) {
    return a + b;
}