import generated.NimbleLexer;
import generated.NimbleParser;
import generated.NimbleParserVisitor;
import org.antlr.v4.codegen.CodeGenerator;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;

import java.io.IOException;

public class Nimble {
    public static void main(String[]args) {

        if (args.length == 0) {
            args = new String[]{"examples/app.nimble"};
        }

        System.out.println("parsing: " + args[0]);

        try {
            NimbleLexer nimbleLexer = new NimbleLexer(new ANTLRFileStream(args[0]));
            NimbleParser nimbleParser = new NimbleParser(new CommonTokenStream(nimbleLexer));
            NimbleVisitor nimbleVisitor = new NimbleVisitor();
            ParseTree tree = nimbleParser.parse();
            nimbleVisitor.visit(tree);

//            CodeGenerator codeGenerator = new CodeGenerator(Grammar.load(args[0]));
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
}
