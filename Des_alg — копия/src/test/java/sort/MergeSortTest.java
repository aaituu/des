package sort;

import com.example.metrics.Metrics;
import com.example.sort.MergeSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {

    @Test
    void testRandomArray() {
        int[] array = new Random().ints(1000, 0, 10000).toArray();
        int[] expected = array.clone();
        Arrays.sort(expected);
        MergeSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSmallArray() {
        int[] array = {5, 2, 9, 1, 5};
        int[] expected = {1, 2, 5, 5, 9};
        MergeSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testEmptyArray() {
        int[] array = {};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }
}
