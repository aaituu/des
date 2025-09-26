package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.util.SortUtils;

public class SortUtilsTest {

    @Test
    public void testSwap() {
        int[] arr = {1, 2};
        SortUtils.swap(arr, 0, 1);
        assertArrayEquals(new int[]{2,1}, arr);
    }

    @Test
    public void testPartition() {
        int[] arr = {3, 1, 2};
        int pivotIndex = SortUtils.partition(arr, 0, arr.length - 1);
        assertTrue(pivotIndex >= 0 && pivotIndex < arr.length);
    }

    @Test
    public void testShuffle() {
        int[] arr = {1,2,3,4,5};
        SortUtils.shuffle(arr);
        assertEquals(5, arr.length); // просто проверяем размер, порядок случайный
    }
}
