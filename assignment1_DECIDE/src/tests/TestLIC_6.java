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
     * Test cases for LIC 6
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
