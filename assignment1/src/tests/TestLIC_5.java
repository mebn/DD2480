package src.tests;

import src.Point;


import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_5 {
    /**
     * LIC 5 should return true iff:
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
     * that X[j] - X[i] < 0. (where i = j-1)
     */

     /**
      * Tests that LIC 5 returns true for two points where x1 = 1 and x2 = 0.
      */
    @Test
    public void testLIC5True() {
        LaunchParameters params = new LaunchParameters();
        // X[j] - X[i] < 0 => X[j] < X[i]
        Point[] datapoints = {new Point(1,0), new Point(0,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_5();

        Assert.assertTrue(res);
    }

    /**
     * Tests that LIC 5 returns false if there exists no two consecutive such points.
     */
    @Test
    public void testLIC5False() {
        LaunchParameters params = new LaunchParameters();
        // X[j] - X[i] < 0 => X[j] < X[i]
        Point[] datapoints = {new Point(0,0), new Point(1,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_5();

        Assert.assertFalse(res);
    }
}
