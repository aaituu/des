package com.example.cli;

import com.example.metrics.Metrics;
import com.example.sort.MergeSort;
import com.example.sort.QuickSort;
import com.example.select.DeterministicSelect;
import com.example.closest.ClosestPair;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CLI {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Usage: --algo <algorithm> --size <n> --output <file.csv>");
            return;
        }

        String algo = args[1];
        int size = Integer.parseInt(args[3]);
        String output = args[5];

        Metrics metrics = new Metrics();

        switch (algo.toLowerCase()) {
            case "mergesort": {
                int[] arr = randomArray(size);
                metrics.start();
                MergeSort.sort(arr, metrics);
                metrics.stop();
                break;
            }
            case "quicksort": {
                int[] arr = randomArray(size);
                metrics.start();
                QuickSort.sort(arr, metrics);
                metrics.stop();
                break;
            }
            case "select": {
                int[] arr = randomArray(size);
                int k = size / 2;
                metrics.start();
                DeterministicSelect.select(arr, k);
                metrics.stop();
                break;
            }
            case "closest": {
                Point[] points = randomPoints(size);
                metrics.start();
                ClosestPair.closestPair(points);
                metrics.stop();
                break;
            }
            default:
                System.out.println("Unknown algorithm: " + algo);
                return;
        }

        writeCSV(output, metrics);
    }

    private static int[] randomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(10000);
        return arr;
    }

    private static Point[] randomPoints(int n) {
        Random rand = new Random();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) points[i] = new Point(rand.nextInt(10000), rand.nextInt(10000));
        return points;
    }

    private static void writeCSV(String filename, Metrics metrics) throws IOException {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Time(ms),Depth,Comparisons\n");
            fw.write(metrics.getTime() + "," + metrics.getDepth() + "," + metrics.getComparisons() + "\n");
        }
        System.out.println("Metrics written to " + filename);
    }
}
