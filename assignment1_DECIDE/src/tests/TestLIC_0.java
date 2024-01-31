package src.tests;

import src.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_0 {
    /**
     * Test cases for LIC 0. LIC 0 should be true iff:
     * There exists at least one set of two consecutive data points that are a distance greater than
     * the length, LENGTH1, apart.
     */


    /*
     * Tests that LIC0 is true if there are two consecutive data points that are further apart than 2 units.
     */
    @Test
    public void testLIC0True() {
        LaunchParameters params = new LaunchParameters();
        params.LENGTH1 = 2;
        Point[] datapoints = {new Point(1,1), new Point(4,1)};


        LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_0();

        Assert.assertTrue(res);
    }

    /*
     * Tests that LIC0 returns false if there are no consecutive data points further apart than 4 units.
     */
    @Test
    public void testLIC0False() {
        LaunchParameters params = new LaunchParameters();
        params.LENGTH1 = 4;
        Point[] datapoints = {new Point(1,1), new Point(4,1)};


        LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_0();

        Assert.assertFalse(res);
    }
}
