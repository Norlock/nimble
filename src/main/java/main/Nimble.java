package main;

import generated.NimbleLexer;
import generated.NimbleParser;
import model.FileData;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Nimble {
    public static void main(String[]args) {

        if (args.length == 0) {
            args = new String[]{"examples/app.nim"};
        }

        NimbleBuild nimbleBuild = new NimbleBuild(args[0]);

        try {
            NimbleLexer nimbleLexer = new NimbleLexer(new ANTLRFileStream(args[0]));
            NimbleParser nimbleParser = new NimbleParser(new CommonTokenStream(nimbleLexer));
            NimbleVisitor nimbleVisitor = new NimbleVisitor();
            ParseTree tree = nimbleParser.parse();
            FileData fileData = (FileData) nimbleVisitor.visit(tree);
            nimbleBuild.generate(fileData);
            nimbleBuild.execute();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

}
