package sort;

import com.example.sort.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testRandomArray() {
        int[] arr = {5, 2, 8, 1, 9};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1,2,5,8,9}, arr);
    }
}
