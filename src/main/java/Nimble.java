import generated.NimbleLexer;
import generated.NimbleParser;
import generated.NimbleParserVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Nimble {
    public static void main(String[]args) {

        ANTLRInputStream inputStream = new ANTLRInputStream("main() { " +
                "int b = 3;" +
                "int a = 2;" +
                "}");

        NimbleLexer nimbleLexer = new NimbleLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(nimbleLexer);

        NimbleParser nimbleParser = new NimbleParser(commonTokenStream);

        NimbleVisitor nimbleVisitor = new NimbleVisitor();

        nimbleVisitor.visit(nimbleParser.main());
    }
}
