package org.magdy;

import java.io.*;
import java.util.*;

public class DataProcessor {
    private final List<File> inputFiles;
    private final String outputPath;
    private final String prefix;
    private final boolean append;

    public DataProcessor(List<File> inputFiles, String outputPath, String prefix, boolean append) {
        this.inputFiles = inputFiles;
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.append = append;
    }

    public void processData(boolean briefStats, boolean fullStats) {
        List<Integer> integers = new ArrayList<>();
        List<Float> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (File file : inputFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    classifyData(line.trim(), integers, floats, strings);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + file.getName() + " - " + e.getMessage());
            }
        }

        writeOutput(integers, "integers.txt");
        writeOutput(floats, "floats.txt");
        writeOutput(strings, "strings.txt");

        if (briefStats) {
            printStatistics(integers, floats, strings, true);
        } else if (fullStats) {
            printStatistics(integers, floats, strings, false);
        }
    }

    private void classifyData(String data, List<Integer> integers, List<Float> floats, List<String> strings) {
        try {
            if (data.matches("-?\\d+")) {
                integers.add(Integer.parseInt(data));
            } else if (data.matches("-?\\d*\\.\\d+")) {
                floats.add(Float.parseFloat(data));
            } else {
                strings.add(data);
            }
        } catch (NumberFormatException e) {
            strings.add(data);
        }
    }

    private void writeOutput(List<?> dataList, String fileName) {
        if (dataList.isEmpty()) return;

        File outputFile = new File(outputPath, prefix + fileName);
        try (FileWriter writer = new FileWriter(outputFile, append)) {
            for (Object data : dataList) {
                writer.write(data.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFile.getName() + " - " + e.getMessage());
        }
    }

    private void printStatistics(List<Integer> integers, List<Float> floats, List<String> strings, boolean brief) {
        if (brief) {
            System.out.println("Integers: " + integers.size());
            System.out.println("Floats: " + floats.size());
            System.out.println("Strings: " + strings.size());
        } else {
            // Full statistics implementation here
            printFullStatistics(integers, "integers");
            printFullStatistics(floats, "floats");
            printFullStatistics(strings, "strings");
        }
    }

    private void printFullStatistics(List<?> dataList, String type) {
        // Full statistics implementation
        System.out.println(type + ": " + dataList.size());
        // Add min, max, sum, average for numbers and length stats for strings
    }
}