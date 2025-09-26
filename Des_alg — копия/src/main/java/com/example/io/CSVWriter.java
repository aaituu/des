package com.example.io;


import java.io.FileWriter;
import java.io.IOException;


public class CSVWriter {
    private final String filePath;

    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(String algo, int n, long comparisons, long swaps, int maxDepth) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d%n", algo, n, comparisons, swaps, maxDepth));
        } catch (IOException e) {
            throw new RuntimeException("Error writing CSV", e);
        }
    }
}
