package src.tests;

import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_2 {

    double pi = 3.1415926535;
    // init epsilon. all vertex angles v must be such that v < pi/2, v > 3pi/2

    @Test
    public void testLIC_2_AngleIsLessThanBoundary() {
        /*
         * Asserts True
         * Vertex angle = pi/4
         */

        LaunchParameters params = new LaunchParameters();
        params.EPSILON = pi/4;
        
        Point[] datapoints = {new Point(0,0), new Point(1,0), new Point(0,1)};

        LaunchInterceptor li = new LaunchInterceptor(3, datapoints, params, null, null);
        boolean result = li.checkLIC_2();

        assertTrue(result);
    }

    @Test
    public void testLIC_2_AngleEqualsBoundary() {
        /*
         * Assert False
         * Vertex angle = 90
         */

        LaunchParameters params = new LaunchParameters();
        params.EPSILON = pi/4;

        Point[] datapoints = {new Point(1,0), new Point(0,0), new Point(0,1)};

        LaunchInterceptor li = new LaunchInterceptor(3, datapoints, params, null, null);
        boolean result = li.checkLIC_2();

        assertFalse(result);
    }

    @Test
    public void testLIC_2_AngleGreaterThanBoundary() {
        /*
         * Assert false
         * Vertex angle = 3/4*pi
         */

        LaunchParameters params = new LaunchParameters();
        params.EPSILON = pi/4;

        Point[] datapoints = {new Point(1,0), new Point(0,0), new Point(1,-1)};

        LaunchInterceptor li = new LaunchInterceptor(3, datapoints, params, null, null);
        boolean result = li.checkLIC_2();

        assertFalse(result);
    }
}