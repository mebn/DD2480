package src.tests;

import src.Point;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_10 {

    /*
     * There exists at least one set of three data points separated by exactly E PTS and F PTS consecutive intervening points, respectively, 
     * that are the vertices of a triangle with area greater than AREA1
     * The condition is not met when NUMPOINTS < 5
     * 1≤E PTS,1≤F PTS E PTS+F PTS ≤ NUMPOINTS−3
     */

    LaunchParameters params = new LaunchParameters();
    double area = 1;

    Point[] smallTriangle = {new Point(2,0), new Point(1,1), new Point(0,0), new Point(1,1), new Point(0, 1)};
    /* area(smallTriangle) = 1 */

    Point[] bigTriangle = {new Point(2,0), new Point(1,1), new Point(0,0), new Point(1,1), new Point(0,2)};
    /* area(bigTriangle) = 2 */

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

    @Test
    public void testTooLargeF_PTS() {

        params.AREA1 = area;
        params.E_PTS = 1;
        params.F_PTS = 2;

        LaunchInterceptor li = new LaunchInterceptor(5, bigTriangle, params, null, null);
        assertThrows(IllegalArgumentException.class, () -> li.checkLIC_10());

    }

    @Test
    public void testTooLargeE_PTS() {
        params.AREA1 = area;
        params.E_PTS = 2;
        params.F_PTS = 1;

        LaunchInterceptor li = new LaunchInterceptor(5, bigTriangle, params, null, null);
        assertThrows(IllegalArgumentException.class, () -> li.checkLIC_10());
    }

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
