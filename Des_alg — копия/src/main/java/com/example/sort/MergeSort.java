package com.example.sort;

import com.example.metrics.Metrics;

public class MergeSort {

    private static final int CUTOFF = 10; // small-n cutoff for insertion sort

    public static void sort(int[] array) {
        sort(array, new Metrics());
    }

    public static void sort(int[] array, Metrics metrics) {
        int[] aux = new int[array.length]; // reusable buffer
        sort(array, aux, 0, array.length - 1, metrics);
    }

    private static void sort(int[] array, int[] aux, int low, int high, Metrics metrics) {
        metrics.enterRecursion();
        if (high - low + 1 <= CUTOFF) {
            insertionSort(array, low, high, metrics);
            metrics.exitRecursion();
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid, metrics);
        sort(array, aux, mid + 1, high, metrics);
        merge(array, aux, low, mid, high, metrics);
        metrics.exitRecursion();
    }

    private static void merge(int[] array, int[] aux, int low, int mid, int high, Metrics metrics) {
        System.arraycopy(array, low, aux, low, high - low + 1);
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            metrics.incComparisons();
            if (i > mid) array[k] = aux[j++];
            else if (j > high) array[k] = aux[i++];
            else if (aux[i] <= aux[j]) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }

    private static void insertionSort(int[] array, int low, int high, Metrics metrics) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low) {
                metrics.incComparisons();
                if (array[j] <= key) break;
                array[j + 1] = array[j];
                metrics.incSwaps();
                j--;
            }
            array[j + 1] = key;
            metrics.incSwaps();
        }
    }
}
