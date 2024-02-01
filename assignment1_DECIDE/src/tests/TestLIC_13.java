package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_13 {
    /**
     * LIC 13 should return true iff:
     * There exists at least one set of three data points, separated by exactly A PTS and B PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. In addition, there exists at least one set of three data points (which can be
     * the same or different from the three data points just mentioned) separated by exactly A PTS
     * and B PTS consecutive intervening points, respectively, that can be contained in or on a
     * circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is
     * not met when NUMPOINTS < 5.
     */

     /**
      * Checks that false is returned when the points could fit on the border of a circle of RADIUS1
      */
     @Test
     public void testLIC13FalseCondition1Border() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 4;
        params.RADIUS2 = 10;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(0, 0),
            new Point(6, 7),
            new Point(10, -72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertFalse(res);
     }

     /*
      * Checks that false is returned when the points could fit inside the border of a circle with RADIUS1
      */
     @Test
     public void testLIC13FalseCondition1Inside() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 5;
        params.RADIUS2 = 10;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(0, 0),
            new Point(6, 7),
            new Point(10, -72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertFalse(res);
     }

     /**
      * Checks that false is returned when the points cannot fit inside a circle with RADIUS2
      */
     @Test
     public void testLIC13FalseCondition2Outside() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 1;
        params.RADIUS2 = 1;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(0, 0),
            new Point(6, 7),
            new Point(10, -72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertFalse(res);
     }

     /**
      * Checks that ture is returned when condition 1 is met and the points can fit on the border of a circle with RADIUS2
      */
     @Test
     public void testLIC13TrueCondition2Border() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 1;
        params.RADIUS2 = 4;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(0, 0),
            new Point(6, 7),
            new Point(10, -72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertTrue(res);
     }

     /**
      * Checks that true is returned when both conditions are satisfied (and no point is on the border of the circle)
      */
     @Test
     public void testLIC13True() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 1;
        params.RADIUS2 = 10;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(0, 0),
            new Point(6, 7),
            new Point(10, -72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertTrue(res);
     }

     /**
      * Checks that true is returned when both conditions are satisfied even with less margin (and no point is on the border of the circle)
      */
     @Test
     public void testLIC13TrueLessMargin() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 3.9;
        params.RADIUS2 = 4.1;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(0, 0),
            new Point(6, 7),
            new Point(10, -72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertTrue(res);
     }

     /**
      * Checks that false is returned when there are less than 5 points.
      */
     @Test
     public void testLIC13FalseNumpointsLessThanFive() {
        LaunchParameters params = new LaunchParameters();

        params.A_PTS = 2;
        params.B_PTS = 1;
        params.RADIUS1 = 1;
        params.RADIUS2 = 10;

        Point[] datapoints = {
            new Point(2, 3),
            new Point(10, 72),
            new Point(6, -1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_13();

        Assert.assertFalse(res);
     }
}
