package main;

import model.JasminHelper;
import model.JavaByteCommand;
import model.ParserData;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NimbleBuild {

    private final String filenameFull,  filenameBase, className;
    private final static String BUILD_DIR = "nim-build";
    private Path outputFile;

    public NimbleBuild(String filePath) {
        filenameFull = FilenameUtils.getName(filePath);
        filenameBase = FilenameUtils.getBaseName(filenameFull);
        className = filenameBase.substring(0, 1).toUpperCase() + filenameBase.substring(1);

        String extension = FilenameUtils.getExtension(filePath);
        if(!extension.equals("nim")) {
            throw new RuntimeException("Nimble only accepts files with .nim extensions");
        }
    }

    public void generate(ParserData parserData) {
        System.out.println("parsing: " + filenameFull);

        // Reset build
        File build = new File(BUILD_DIR);
        deleteDirectory(build);
        if(build.mkdir()) {

            outputFile = Paths.get(BUILD_DIR, filenameBase + ".j");
            try (PrintWriter out = new PrintWriter(outputFile.toString())) {
                out.println(getFileHeader(100, 100));
                for (JavaByteCommand command : parserData.getCode()) {
                    out.println("\t\t" + command.toString());
                }
                out.println(getFileFooter());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void execute() {
        String outputFileName = outputFile.getFileName().toString();
        ProcessBuilder compile = new ProcessBuilder("java", "-jar", "../lib/jasmin.jar",
                outputFileName);
        File buildDir = new File(BUILD_DIR);
        compile.directory(buildDir);
        executeCommand(compile);
        ProcessBuilder run = new ProcessBuilder("java", className);
        run.directory(buildDir);
        executeCommand(run);
    }

    private void executeCommand(ProcessBuilder builder) {
        try {
            builder.redirectErrorStream(true);
            Process process = builder.start();

            Writer wr = new OutputStreamWriter(process.getOutputStream());
            BufferedReader rd = new BufferedReader( new InputStreamReader( process.getInputStream() ) );
            wr.flush();
            String str = rd.readLine();
            while (str != null) {
                System.out.println(str);
                str = rd.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean deleteDirectory(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null!=files){
                for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory())
                        deleteDirectory(files[i]);
                    else
                        files[i].delete();
                }
            }
        }
        return(directory.delete());
    }

    private String getFileFooter() {
        return  "        return\n" +
                "    .end method";
    }

    private String getFileHeader(int stackSize, int varAndParamsCount) {
        if(stackSize == 0)
            stackSize = 99;
        if(varAndParamsCount == 0)
            varAndParamsCount = 99;

        return ".class public " + className + "\n" +
                "    .super java/lang/Object\n\n" +
                "    ; Default constructor (empty constructor)\n" +
                "    .method public <init>()V\n" +
                "        aload_0                                     ; Loads \"this\" on the stack\n" +
                "        invokenonvirtual java/lang/Object/<init>()V ; Call super constructor\n" +
                "        return                                      ; Terminate method\n" +
                "    .end method\n" +
                "    \n" +
                "    ; Method definition for public static void main(String[] args)\n" +
                "    .method public static main([Ljava/lang/String;)V\n" +
                "        .limit stack " + stackSize + "\n" +
                "        .limit locals " + varAndParamsCount + "\n";
    }
}
