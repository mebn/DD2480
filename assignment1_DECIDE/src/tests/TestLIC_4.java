package src.tests;

import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_4 {
    @Test

    /**
     * Test cases for LIC 4
     */
    public void testLIC4True() {
        LaunchParameters params = new LaunchParameters();
        params.Q_PTS = 2;
        params.QUADS = 1;
        Point[] datapoints = {new Point(-1,0), new Point(4,1)};


        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_4();

        Assert.assertTrue(res);
    }

    @Test
    public void testLIC4False() {
        LaunchParameters params = new LaunchParameters();
        params.Q_PTS = 2;
        params.QUADS = 1;
        Point[] datapoints = {new Point(0,0), new Point(1,0)};




        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_4();

        Assert.assertFalse(res);
    }
}
