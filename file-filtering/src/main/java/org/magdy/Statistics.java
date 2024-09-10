package org.magdy;
// Statistics.java
import java.util.Collections;
import java.util.List;

public class Statistics {
    public static String calculateIntegerStatistics(List<Integer> integers) {
        int min = Collections.min(integers);
        int max = Collections.max(integers);
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        double average = sum / (double) integers.size();

        return String.format("elements = %d; min = %d; max = %d; sum = %d; average = %.2f",
                integers.size(), min, max, sum, average);
    }

    public static String calculateFloatStatistics(List<Float> floats) {
        float min = Collections.min(floats);
        float max = Collections.max(floats);
        float sum = (float) floats.stream().mapToDouble(Float::floatValue).sum();
        double average = sum / floats.size();

        return String.format("elements = %d; min = %.2f; max = %.2f; sum = %.2f; average = %.2f",
                floats.size(), min, max, sum, average);
    }

    public static String calculateStringStatistics(List<String> strings) {
        int minLength = strings.stream().mapToInt(String::length).min().orElse(0);
        int maxLength = strings.stream().mapToInt(String::length).max().orElse(0);

        return String.format("elements = %d; min length = %d; max length = %d",
                strings.size(), minLength, maxLength);
    }
}