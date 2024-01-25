package src.tests;

import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_5 {
    @Test
    public void testLIC5True() {
        LaunchParameters params = new LaunchParameters();
        // X[j] - X[i] < 0 => X[j] < X[i]
        Point[] datapoints = {new Point(1,0), new Point(0,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_5();

        Assert.assertTrue(res);
    }

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
