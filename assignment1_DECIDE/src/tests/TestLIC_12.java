package src.tests;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import src.LaunchInterceptor;
import src.LaunchParameters;
import src.Point;

public class TestLIC_12 {
    /**
     * LIC 12 should return true iff:
     * There exists two points u,v separated by K_PTS such that dist(u,v) > LENGTH1
     *      AND
     * There exists two points w,t (can be u,v) separated by K_PTS such that dist(w,t) < LENGTH2
     * The condition is not met when numpoints < 3
     */

    LaunchParameters params = new LaunchParameters();
    Point[] points = {new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1)};

    /**
     * Tests that false is returned when there are no two points further away than Length1
     */
    @Test
    public void testFalseLessThanLENGTH1() {
        params.LENGTH1 = 2;
        params.LENGTH2 = 2;
        params.K_PTS = 1;
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertFalse(result);
    }

    /**
     * Tests that false is returned when there are no two points closer than Length2
     */
    @Test
    public void testFalseGreaterThanLENGTH2() {
        params.LENGTH1 = 1;
        params.LENGTH2 = 1;
        params.K_PTS = 1;
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertFalse(result);
    }

    /**
     * Tests that true is returned when both requirements are satisfied.
     */
    @Test
    public void testTrueLENGTH1LENGTH2() {
        params.LENGTH1 = 1;
        params.LENGTH2 = 2;
        params.K_PTS = 1;
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertTrue(result);

    }

    /**
     * Tests that false is returned when there are less than 3 points.
     */
    @Test
    public void testFalseNUMPOINTS() {
        params.LENGTH1 = 1;
        params.LENGTH2 = 2;
        params.K_PTS = 1;
        
        Point[] points = {new Point(0,0), new Point(1,0)};
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(2, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertFalse(result);
    }
}
