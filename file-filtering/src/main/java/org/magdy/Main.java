package org.magdy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // Parse command-line arguments
        String outputPath = ".";
        String prefix = "";
        boolean append = false;
        boolean fullStats = false;
        boolean briefStats = false;

        List<File> inputFiles = new ArrayList<>();

        for (String arg : args) {
            int i = 0;
            if (arg.equals("-o")) {
                outputPath = args[++i];
            } else if (arg.equals("-p")) {
                prefix = args[++i];
            } else if (arg.equals("-a")) {
                append = true;
            } else if (arg.equals("-s")) {
                briefStats = true;
            } else if (arg.equals("-f")) {
                fullStats = true;
            } else {
                inputFiles.add(new File(arg));
            }
        }

        DataProcessor processor = new DataProcessor(inputFiles, outputPath, prefix, append);
        processor.processData(briefStats, fullStats);
    }
}
