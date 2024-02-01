package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_9 {
    /**
    * LIC 9 should return true iff:
    * There exists at least one set of three data points separated by exactly C PTS and D PTS 
    * consecutive intervening points, respectively, that form an angle such that:
    * angle < (PI − EPSILON) or angle > (PI + EPSILON)
    * The second point of the set of three points is always the vertex of the angle. 
    * If either the first point or the last point (or both) coincide with the vertex, 
    * the angle is undefined and the LIC is not satisfied by those three points. 
    * When NUMPOINTS < 5, the condition is not met.
    */
    
    /**
     * Checks that true is returned for a simple case. 
     */
    @Test
    public void testLIC9True() {
        
        LaunchParameters params = new LaunchParameters();
        
        // angle = 90 degrees
        Point[] datapoints = {new Point(1,0), new Point(1,1), new Point(0,0), new Point(3,3), new Point(0,2)};

        params.EPSILON = Math.PI/3;
        params.C_PTS = 1;
        params.D_PTS = 1;


        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_9();

        Assert.assertTrue(res);
    }

    /**
     * Checks that false is returned when angle is exactly equal. to Pi-Epsilon
     */
    @Test
    public void testLIC9False() {
        LaunchParameters params = new LaunchParameters();
        
        // angle = 90 degrees
        Point[] datapoints = {new Point(1,0), new Point(1,1), new Point(0,0), new Point(3,3), new Point(0,2)};

        params.EPSILON = Math.PI/2;
        params.C_PTS = 1;
        params.D_PTS = 1;


        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_9();

        Assert.assertFalse(res);
    }

    /**
     * Checks that false is returned when epsilon is near 0 and angle is PI
     */
    @Test
    public void testLIC9FalseAnglePiDegrees() {
        LaunchParameters params = new LaunchParameters();
        
        
        Point[] datapoints = {new Point(0,2), new Point(99,99), new Point(0,0), new Point(99,99), new Point(0,-2)};

        params.EPSILON = 0.000001;    // Floating point problems here if you set epsilon = 0. It should still return false but returns true
        params.C_PTS = 1;
        params.D_PTS = 1;
        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_9();

        Assert.assertFalse(res);
    }

    /**
     * Tests that true is returned when the angle is just under PI and epsilon is near 0.
     */
    @Test
    public void testLIC9TrueAngleJustUnderPiDegrees() {
        LaunchParameters params = new LaunchParameters();
        
        
        Point[] datapoints = {new Point(-0.1,2.0), new Point(99,99), new Point(0,0), new Point(99,99), new Point(0,-2)};

        params.EPSILON = 0.000001;
        params.C_PTS = 1;
        params.D_PTS = 1;
        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_9();

        Assert.assertTrue(res);
    }

    /**
     * Tests that false is returned when there is less than 5 points.
     */
    @Test
    public void testLIC9FalseWhenLessThen5Points() {
        LaunchParameters params = new LaunchParameters();
        Point[] datapoints = {new Point(0,0), new Point(1,0), new Point(2,0)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_9();

        Assert.assertFalse(res);
    }
}
