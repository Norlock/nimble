class App;

global string test = "jaaa!";

main {
    int a = 0;
    int b = 3;
    test = "nee :(";
    #print(a);
    #print(b);
    if(a < b) {
        string s = "ss";
        bool test = false;
        a = 5;
        #print(a + s);
        print(test);
    } else {
        string s = "yes";
    }
}

