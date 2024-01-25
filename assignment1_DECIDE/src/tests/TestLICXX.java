package src.tests;

import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLICXX {
    @Test

    /**
     * Test cases for LIC 0
     */
    public void testLIC0True() {
        LaunchParameters params = new LaunchParameters();
        params.LENGTH1 = 2;
        Point[] datapoints = {new Point(1,1), new Point(4,1)};


        LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_0();

        Assert.assertTrue(res);
    }

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
