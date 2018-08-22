package main;

import generated.NimbleLexer;
import generated.NimbleParser;
import model.JasminHelper;
import model.JavaByteCommand;
import model.ParserData;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Nimble {
    public static void main(String[]args) {

        if (args.length == 0) {
            args = new String[]{"examples/app.nimble"};
        }

        System.out.println("parsing: " + args[0]);
        File build = new File("nim-build");
        deleteDirectory(build);
        if(build.mkdir()) {
            System.out.println("doet het");
        }

        try {
            NimbleLexer nimbleLexer = new NimbleLexer(new ANTLRFileStream(args[0]));
            NimbleParser nimbleParser = new NimbleParser(new CommonTokenStream(nimbleLexer));
            NimbleVisitor nimbleVisitor = new NimbleVisitor();
            ParseTree tree = nimbleParser.parse();
            ParserData parserData = nimbleVisitor.visit(tree);

            PrintWriter out = new PrintWriter("nim-build/filename.j");
            out.println(JasminHelper.getFileHeader(100,100));
            for(JavaByteCommand command : parserData.getCode()) {
                out.println("\t\t" + command.toString());
            }
            out.println(JasminHelper.getFileFooter());
            out.close();



//            CodeGenerator codeGenerator = new CodeGenerator(Grammar.load(args[0]));
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    public static boolean deleteDirectory(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null!=files){
                for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
                }
            }
        }
        return(directory.delete());
    }
}
