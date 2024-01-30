package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_13 {
    /**
     * Test cases for LIC 13
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
