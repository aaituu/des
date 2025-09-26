package com.example.closest;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double closestPair(Point[] points) {
        if (points == null || points.length < 2) throw new IllegalArgumentException();
        Point[] px = Arrays.copyOf(points, points.length);
        Point[] py = Arrays.copyOf(points, points.length);
        Arrays.sort(px, Comparator.comparingInt(p -> p.x));
        Arrays.sort(py, Comparator.comparingInt(p -> p.y));
        return closest(px, py, 0, points.length - 1);
    }

    private static double closest(Point[] px, Point[] py, int left, int right) {
        if (right - left <= 3) return bruteForce(px, left, right);

        int mid = (left + right) / 2;
        Point midPoint = px[mid];

        double dl = closest(px, py, left, mid);
        double dr = closest(px, py, mid + 1, right);
        double d = Math.min(dl, dr);

        Point[] strip = Arrays.stream(py)
                .filter(p -> Math.abs(p.x - midPoint.x) < d)
                .toArray(Point[]::new);

        return Math.min(d, stripClosest(strip, d));
    }

    private static double stripClosest(Point[] strip, double d) {
        double min = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
                double dist = distance(strip[i], strip[j]);
                if (dist < min) min = dist;
            }
        }
        return min;
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < min) min = dist;
            }
        }
        return min;
    }

    private static double distance(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
