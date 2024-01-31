package src.tests;

import src.Point;
import static org.junit.Assert.*;

import org.ietf.jgss.Oid;
import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_6 {
    /**
     * LIC 6 should return true iff:
     * There exists at least one set of N PTS consecutive data points such that at least one of the
     * points lies a distance greater than DIST from the line joining the first and last of these N PTS
     * points. If the first and last points of these N PTS are identical, then the calculated distance
     * to compare with DIST will be the distance from the coincident point to all other points of
     * the N PTS consecutive points. The condition is not met when NUMPOINTS < 3.
     */

    /**
     * Tests that LIC 6 returns true if there is a point to the left of the line between (0, 0) and (4, 0)
     * with distance to the line that is greater than 2
     */
    @Test
    public void testLIC6TrueNormal() {
        LaunchParameters params = new LaunchParameters();
        params.N_PTS = 3;
        params.DIST = 2;
        Point[] datapoints = {new Point(0,0), new Point(1,3), new Point(4,0)};


        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_6();

        Assert.assertTrue(res);
    }

    /**
     * Tests that LIC 6 returns true if there is a point to the right of the line between (0, 0) and (4, 0)
     * with distance to the line that is greater than 2
     */
    @Test
    public void testLIC6TrueNormalOtherSideOfLine() {
        LaunchParameters params = new LaunchParameters();
        params.N_PTS = 3;
        params.DIST = 2;
        Point[] datapoints = {new Point(0,0), new Point(1,-3), new Point(4,0)};


        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_6();

        Assert.assertTrue(res);
    }

    /**
     * Tests that LIC 6 returns true if there if the two points that the line should pass through are identical
     * and there exists a point further away than 3 units.
     */
    @Test
    public void testLIC6TrueSinglePoint() {
        LaunchParameters params = new LaunchParameters();
        params.N_PTS = 3;
        params.DIST = 2;
        Point[] datapoints = {new Point(0,0), new Point(0,3), new Point(0,0)};


        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_6();

        Assert.assertTrue(res);
    }

    /**
     * Tests that LIC 6 returns false when there is no point far enough away from the line
     * between (0, 0) and (4, 0).
     */
    @Test
    public void testLIC6FalseNormal() {
        LaunchParameters params = new LaunchParameters();
        params.N_PTS = 3;
        params.DIST = 1;
        Point[] datapoints = {new Point(0,0), new Point(2,1), new Point(4,0)};




        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_6();

        Assert.assertFalse(res);
    }

    /**
     * Tests that LIC 6 returns false when the first and last point of the intervall is identical
     * and no other point exists that is further away than 5 units.
     */
    @Test
    public void testLIC6FalseSinglePoint() {
        LaunchParameters params = new LaunchParameters();
        params.N_PTS = 3;
        params.DIST = 5;
        Point[] datapoints = {new Point(0,0),new Point(4,3), new Point(0,0)};




        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_6();

        Assert.assertFalse(res);
    }

    /**
     * Checks that LIC 6 returns false when there are less than 3 points.
     */
    @Test
    public void testLIC6FalseMissingPoint() {
        LaunchParameters params = new LaunchParameters();
        params.N_PTS = 2;
        params.DIST = 1;
        Point[] datapoints = {new Point(0,0), new Point(1,0)};




        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_6();

        Assert.assertFalse(res);
    }
}
