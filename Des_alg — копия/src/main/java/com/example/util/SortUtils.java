package com.example.util;

import java.util.Random;

public class SortUtils {

    private static final Random rand = new Random();

    // Swap two elements in array
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Partition array [low, high] around pivot
    public static int partition(int[] arr, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high);
        return i;
    }

    // Shuffle array
    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    // Guard for empty or null arrays
    public static void guard(int[] arr) {
        if (arr == null || arr.length <= 1) {
            throw new IllegalArgumentException("Array is null or too small");
        }
    }
}
