package src.tests;

import src.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_11 {
    /**
     * LIC 11 should return true iff:
     * There exists at least one set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by
     * exactly G PTS consecutive intervening points, such that X[j] - X[i] < 0. (where i < j ) 
     * The condition is not met when NUMPOINTS < 3
     */

    /**
     * Tests that true is returned when such points exist
     */
    @Test
    public void testLIC11True() {
        LaunchParameters params = new LaunchParameters();
        
        Point[] datapoints = {new Point(4,0), new Point(3,0), new Point(2,0), new Point(1,0), new Point(0,0)};

        params.G_PTS = 3;

        // X[j] - X[i] < 0 => X[j] < X[i]

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_11();

        Assert.assertTrue(res);
    }

    /**
     * Checks that true is returned when such points exist, and that there is no out of bounds indexing caused by off-by one errors.
     * (there was such an error previously)
     */
    @Test
    public void testLIC11TrueOffByOne() {
        LaunchParameters params = new LaunchParameters();
        
        Point[] datapoints = {new Point(3,0), new Point(2,0), new Point(2,0)};

        params.G_PTS = 1;

        // X[j] - X[i] < 0 => X[j] < X[i]

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_11();

        Assert.assertTrue(res);
    }

    /**
     * Checks that false is returned when no such point exists, and that there is no out of bounds indexing caused by off-by one errors.
     * (there was such an error previously)
     */
    @Test
    public void testLIC11FalseOffByOne() {
        LaunchParameters params = new LaunchParameters();
        
        Point[] datapoints = {new Point(2,0), new Point(1,0), new Point(3,0)};

        params.G_PTS = 1;

        // X[j] - X[i] < 0 => X[j] < X[i]

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_11();

        Assert.assertFalse(res);
    }

    /**
     * Tests that false is returned when no such points exist
     */
    @Test
    public void testLIC11False() {
        LaunchParameters params = new LaunchParameters();
        
        Point[] datapoints = {new Point(0,0), new Point(1,0), new Point(2,0), new Point(3,0), new Point(4,0)};

        params.G_PTS = 3;

        // X[j] - X[i] < 0 => X[j] < X[i]

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_11();

        Assert.assertFalse(res);
    }

    /**
     * Tests that false is returned when there are less than 3 points.
     */
    @Test
    public void testLIC11FalseWhenLessThen3Points() {
        LaunchParameters params = new LaunchParameters();
        Point[] datapoints = {new Point(0,0), new Point(1,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_11();

        Assert.assertFalse(res);
    }
}
