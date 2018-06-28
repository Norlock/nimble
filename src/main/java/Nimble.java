import generated.NimbleLexer;
import generated.NimbleParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Nimble {
    public static void main(String[]args) {

        ANTLRInputStream inputStream = new ANTLRInputStream("main(){}");
        NimbleLexer nimbleLexer = new NimbleLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(nimbleLexer);

        NimbleParser nimbleParser = new NimbleParser(commonTokenStream);

    }
}
