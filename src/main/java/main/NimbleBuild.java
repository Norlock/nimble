package main;

import model.commands.JavaByteCommand;
import model.ParserData;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.commons.io.FilenameUtils;
import utils.CustomStringBuilder;
import utils.JasminHelper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NimbleBuild {

    private final String filenameFull,  filenameBase;
    private final static String BUILD_DIR = "nim-build";
    private Path outputFile;

    public NimbleBuild(String filePath) {
        filenameFull = FilenameUtils.getName(filePath);
        filenameBase = FilenameUtils.getBaseName(filenameFull);

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
//                out.println(getFileHeader(parserData.getCtx()));
                for (JavaByteCommand command : parserData.getCode()) {
                    out.println("\t" + command.toString());
                }
//                out.println(getFileFooter());
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
        ProcessBuilder run = new ProcessBuilder("java", JasminHelper.className);
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

}
