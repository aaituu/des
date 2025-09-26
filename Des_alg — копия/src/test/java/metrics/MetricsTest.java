package metrics;

import com.example.metrics.Metrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetricsTest {

    @Test
    void testComparisonsAndSwaps() {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incComparisons();
        m.incSwaps();
        assertEquals(2, m.getComparisons());
        assertEquals(1, m.getSwaps());
    }

    @Test
    void testRecursionDepth() {
        Metrics m = new Metrics();
        m.enterRecursion();
        m.enterRecursion();
        m.exitRecursion();
        m.exitRecursion();
        assertEquals(2, m.getMaxDepth());
    }
}
