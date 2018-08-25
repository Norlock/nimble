class App;

global string test = "jaaa!";

main {
    int a = 9;
    int b = 3;
    test = "nee :(";
    print(a + b - 6 - 3);
    #print(b);
    if(a < b) {
        string s = "ss";
        a = 5;
        #print(a + s);
        print(test);
    } else {
        string s = "yes";
    }
}

