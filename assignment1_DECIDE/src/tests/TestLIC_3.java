package src.tests;

import src.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_3 {
    /**
     * LIC 3 should return true iff:
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1.
     */


    /**
     * Tests that LIC 3 returns true if a triangle with area greater than 2 exists.
     */
    @Test
    public void testLIC3True() {
        LaunchParameters params = new LaunchParameters();
        params.AREA1 = 2;
        Point[] datapoints = {new Point(0,0), new Point(4,0), new Point(0,4)}; // 4*4/2=8

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_3();

        Assert.assertTrue(res);
    }

    /**
     * Tests that LIC 3 returns false if a triangle with area greater than 16 doesn't exist.
     */
    @Test
    public void testLIC3False() {
        LaunchParameters params = new LaunchParameters();
        params.AREA1 = 16;
        Point[] datapoints = {new Point(0,0), new Point(4,0), new Point(0,4)}; // 4*4/2=8

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_3();

        Assert.assertFalse(res);
    }
}
