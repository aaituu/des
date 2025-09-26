package com.example.sort;

import com.example.metrics.Metrics;

public class QuickSort {

    public static void sort(int[] array) {
        sort(array, new Metrics());
    }

    public static void sort(int[] arr, Metrics metrics) {
        quicksort(arr, 0, arr.length - 1, metrics);
    }

    private static void quicksort(int[] arr, int low, int high, Metrics metrics) {
        metrics.enterRecursion();
        while (low < high) {
            int pivotIndex = partition(arr, low, high, metrics);
            // recurse on smaller part first
            if (pivotIndex - low < high - pivotIndex) {
                quicksort(arr, low, pivotIndex - 1, metrics);
                low = pivotIndex + 1; // loop on larger part
            } else {
                quicksort(arr, pivotIndex + 1, high, metrics);
                high = pivotIndex - 1; // loop on larger part
            }
        }
        metrics.exitRecursion();
    }

    private static int partition(int[] arr, int low, int high, Metrics metrics) {
        int pivotIndex = low + (int)(Math.random() * (high - low + 1));
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high, metrics);
        int i = low;
        for (int j = low; j < high; j++) {
            metrics.incComparisons();
            if (arr[j] < pivot) swap(arr, i++, j, metrics);
        }
        swap(arr, i, high, metrics);
        return i;
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            metrics.incSwaps();
        }
    }
}
