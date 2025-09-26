package closest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.closest.ClosestPair;
import java.awt.Point;

public class ClosestPairTest {

    @Test
    public void testSmallSet() {
        Point[] points = {new Point(0,0), new Point(3,4), new Point(1,1)};
        double result = ClosestPair.closestPair(points);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }

    @Test
    public void testTwoPoints() {
        Point[] points = {new Point(0,0), new Point(0,1)};
        double result = ClosestPair.closestPair(points);
        assertEquals(1.0, result, 1e-6);
    }
}
