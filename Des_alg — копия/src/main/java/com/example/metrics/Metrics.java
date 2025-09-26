package com.example.metrics;

public class Metrics {
    private long comparisons;
    private long swaps;
    private int currentDepth;
    private int maxDepth;
    private long startTime;
    private long endTime;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) maxDepth = currentDepth;
    }

    public void exitRecursion() { currentDepth--; }

    // === methodsc for time ===
    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }
    public long getTime() { return (endTime - startTime) / 1_000_000; } // миллисекунды

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public int getMaxDepth() { return maxDepth; }
    public int getDepth() {
        return getMaxDepth();
    }


    public void reset() {
        comparisons = 0;
        swaps = 0;
        currentDepth = 0;
        maxDepth = 0;
        startTime = 0;
        endTime = 0;
    }
}
