package src.tests;

import src.Point;


import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_7 {
    /**
     * LIC 7 should return true iff:
     * There exists at least one set of two data points separated by exactly K PTS consecutive 
     * intervening points that are a distance greater than the length, LENGTH1, apart. The condition
     * is not met when NUMPOINTS < 3.
     */


    /**
     * Tests that LIC 7 returns true when there exists points separated by 3 other points furhter apart than 5 units.
    */
    @Test
    public void testLIC7True() {

        LaunchParameters params = new LaunchParameters();
        
        // distance between the first and last point is: sqrt(4^2+4^2) = 5.7
        Point[] datapoints = {new Point(0,0), new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4)};

        params.K_PTS = 3;
        params.LENGTH1 = 5;

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_7();

        Assert.assertTrue(res);
    }

    /*
     * Tests that LIC 7 returns false when there exists no 2 points separated by 3 other points that are further apart than
     * 6 units.
     */
    @Test
    public void testLIC7False() {
        LaunchParameters params = new LaunchParameters();
        
        // distance between the first and last point is: sqrt(4^2+4^2) ≈ 5.7
        Point[] datapoints = {new Point(0,0), new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4)};

        params.K_PTS = 3;
        params.LENGTH1 = 6;

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_7();

        Assert.assertFalse(res);
    }

    /**
     * Tests that LIC 7 returns false when there are less than 3 points.
     */
    @Test
    public void testLIC7FalseWhenLessThen3Points() {
        LaunchParameters params = new LaunchParameters();
        Point[] datapoints = {new Point(0,0), new Point(2,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_7();

        Assert.assertFalse(res);
    }
}
