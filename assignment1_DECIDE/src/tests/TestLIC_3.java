package src.tests;

import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_3 {
    @Test
    public void testLIC3True() {
        LaunchParameters params = new LaunchParameters();
        params.AREA1 = 2;
        Point[] datapoints = {new Point(0,0), new Point(4,0), new Point(0,4)}; // 4*4/2=8

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_3();

        Assert.assertTrue(res);
    }

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
