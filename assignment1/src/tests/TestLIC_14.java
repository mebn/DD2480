package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_14 {
    
    /**
     * LIC 14 should return true iff:
     * There exists at least one set of three data points, separated by exactly E PTS and F PTS consecutive intervening points, respectively, that are the vertices of a triangle with area greater
     * than AREA1. In addition, there exist three data points (which can be the same or different
     * from the three data points just mentioned) separated by exactly E PTS and F PTS consecutive intervening points, respectively, that are the vertices of a triangle with area less than
     * AREA2. Both parts must be true for the LIC to be true. The condition is not met when
     * NUMPOINTS < 5.
     */

     /**
      * Checks that false is returned when the first condition isn't met because the area is exactly equal
      */
    @Test
    public void testLIC14FalseWhenAreaIsExactlyEqual() {
        LaunchParameters params = new LaunchParameters();
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 1;
        params.AREA2 = 1;
        Point[] datapoints = {
            new Point(-1, 0), 
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1)
        };


        LaunchInterceptor li = new LaunchInterceptor(6, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_14();

        Assert.assertFalse(res);
    }

    /**
     * Tests that false is returned when the first condition isn't met.
     */
    @Test
    public void testLIC14FalseWhenArea1IsGreater() {
        LaunchParameters params = new LaunchParameters();
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 2;
        params.AREA2 = 2;
        Point[] datapoints = {
            new Point(-1, 0), 
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1)
        };


        LaunchInterceptor li = new LaunchInterceptor(6, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_14();

        Assert.assertFalse(res);
    }

    /**
     * Checks that false is returned when the second condition isn't met.
     */
    @Test
    public void testLIC14FalseWhenArea2IsSmaller() {
        LaunchParameters params = new LaunchParameters();
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 0.5;
        params.AREA2 = 0.5;
        Point[] datapoints = {
            new Point(-1, 0), 
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1)
        };


        LaunchInterceptor li = new LaunchInterceptor(6, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_14();

        Assert.assertFalse(res);
    }

    /**
     * Checks that true is returned when both conditions are met.
     */
    @Test
    public void testLIC14True() {
        LaunchParameters params = new LaunchParameters();
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 0.5;
        params.AREA2 = 2;
        Point[] datapoints = {
            new Point(-1, 0), 
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1)
        };


        LaunchInterceptor li = new LaunchInterceptor(6, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_14();

        Assert.assertTrue(res);
    }

    /**
     * Checks that false is returned when NUMPOINTS is less than 5
     */
    @Test
    public void testLIC14FalseWhenNumpointsLessThan5(){
        LaunchParameters params = new LaunchParameters();
        params.E_PTS = 1;
        params.F_PTS = 1;
        Point[] datapoints = {new Point(0,0), new Point(1,1)};
        LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);

        Boolean res = li.checkLIC_14();

        Assert.assertFalse(res);
    }
}
