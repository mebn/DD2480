package src.tests;

import src.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_7 {
    @Test
    public void testLIC7True() {
        /*
        There exists at least one set of two data points separated by exactly K PTS consecutive in-
        tervening points that are a distance greater than the length, LENGTH1, apart. The condition
        is not met when NUMPOINTS < 3.
        1 ≤ K PTS ≤ (NUMPOINTS − 2)
        */
        LaunchParameters params = new LaunchParameters();
        
        // distance between the first and last point is: sqrt(4^2+4^2) = 5.7
        Point[] datapoints = {new Point(0,0), new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4)};

        params.K_PTS = 3;
        params.LENGTH1 = 5;

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_7();

        Assert.assertTrue(res);
    }

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

    @Test
    public void testLIC7FalseWhenLessThen3Points() {
        LaunchParameters params = new LaunchParameters();
        Point[] datapoints = {new Point(0,0), new Point(2,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_7();

        Assert.assertFalse(res);
    }
}
