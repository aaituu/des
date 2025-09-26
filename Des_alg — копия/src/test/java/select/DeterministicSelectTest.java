package select;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.select.DeterministicSelect;
import java.util.Arrays;
import java.util.Random;

public class DeterministicSelectTest {

    @Test
    public void testRandomArray() {
        int[] arr = {7, 2, 5, 1, 3, 6, 4};
        for (int k = 0; k < arr.length; k++) {
            int[] sorted = Arrays.copyOf(arr, arr.length);
            Arrays.sort(sorted);
            assertEquals(sorted[k], DeterministicSelect.select(Arrays.copyOf(arr, arr.length), k));
        }
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }
}
