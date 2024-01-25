package src.tests;

import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_11 {
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

    @Test
    public void testLIC11FalseWhenLessThen3Points() {
        LaunchParameters params = new LaunchParameters();
        Point[] datapoints = {new Point(0,0), new Point(1,0), new Point(2,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_11();

        Assert.assertFalse(res);
    }
}
