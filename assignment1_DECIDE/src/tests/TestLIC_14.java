package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_14 {
    
    /**
     * Test cases for LIC 14
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
