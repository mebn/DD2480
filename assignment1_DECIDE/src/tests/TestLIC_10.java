package src.tests;

import src.Point;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_10 {

    /**
     * LIC 10 should return true iff:
     * There exists at least one set of three data points separated by exactly E PTS and F PTS consecutive intervening points, respectively, 
     * that are the vertices of a triangle with area greater than AREA1
     * The condition is not met when NUMPOINTS < 5
     */

    LaunchParameters params = new LaunchParameters();
    double area = 1;

    Point[] smallTriangle = {new Point(2,0), new Point(1,1), new Point(0,0), new Point(1,1), new Point(0, 1)};
    /* area(smallTriangle) = 1 */

    Point[] bigTriangle = {new Point(2,0), new Point(1,1), new Point(0,0), new Point(1,1), new Point(0,2)};
    /* area(bigTriangle) = 2 */

    /**
     * Check that false is returned when there is less than 5 points.
     */
    @Test
    public void testTooFewPoints() {
        params.AREA1 = area;
        params.E_PTS = 1;
        params.F_PTS = 0;
        Point[] points = {new Point(2,0), new Point(0,0), new Point(0,0), new Point(0,2)};

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_10();
        assertFalse(result);
    }

    /**
     * Check that false is returned when there is less than 5 points.
     */
    @Test
    public void testTooFewPoints2() {
        params.AREA1 = area;
        params.E_PTS = 0;
        params.F_PTS = 1;
        Point[] points = {new Point(2,0), new Point(0,0), new Point(0,0), new Point(0,2)};

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_10();
        assertFalse(result);
    }

    /**
     * Check that false is returned when F_PTS is too large
     */
    @Test
    public void testTooLargeF_PTS() {

        params.AREA1 = area;
        params.E_PTS = 1;
        params.F_PTS = 2;

        LaunchInterceptor li = new LaunchInterceptor(5, bigTriangle, params, null, null);
        assertThrows(IllegalArgumentException.class, () -> li.checkLIC_10());

    }

    /**
     * Check that false is returned when E_PTS is too large
     */
    @Test
    public void testTooLargeE_PTS() {
        params.AREA1 = area;
        params.E_PTS = 2;
        params.F_PTS = 1;

        LaunchInterceptor li = new LaunchInterceptor(5, bigTriangle, params, null, null);
        assertThrows(IllegalArgumentException.class, () -> li.checkLIC_10());
    }

    /**
     * Check that false is returned when there is no triangle with area greater than area
     */
    @Test
    public void testLessEqualAREA1() {
        params.AREA1 = area;
        params.E_PTS = 1;
        params.F_PTS = 1;
        LaunchInterceptor li = new LaunchInterceptor(5, smallTriangle, params, null, null);
        li.checkLIC_10();
        boolean result = li.checkLIC_10();
        assertFalse(result);
    }

    /**
     * Check that true is returned when there is a triangle with area greater than area
     */
    @Test
    public void testLargerThanAREA1() {
        params.AREA1 = area;
        params.E_PTS = 1;
        params.F_PTS = 1;
        LaunchInterceptor li = new LaunchInterceptor(5, bigTriangle , params, null, null);
        li.checkLIC_10();
        boolean result = li.checkLIC_10();
        assertTrue(result);
    }
}
