package com.example.bench;

import com.example.metrics.Metrics;
import com.example.sort.MergeSort;
import com.example.sort.QuickSort;
import com.example.select.DeterministicSelect;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class Benchmarks {

    private int[] array;
    private int n = 10000;
    private Random rand = new Random();

    @Setup(Level.Invocation)
    public void setUp() {
        array = rand.ints(n, 0, 100000).toArray();
    }

    @Benchmark
    public void benchMergeSort() {
        int[] copy = array.clone();
        Metrics metrics = new Metrics();
        MergeSort.sort(copy, metrics);
    }

    @Benchmark
    public void benchQuickSort() {
        int[] copy = array.clone();
        Metrics metrics = new Metrics();
        QuickSort.sort(copy, metrics);
    }


    @Benchmark
    public void benchDeterministicSelect() {
        int[] copy = array.clone();
        int k = n / 2;
        DeterministicSelect.select(copy, k);
    }
}
