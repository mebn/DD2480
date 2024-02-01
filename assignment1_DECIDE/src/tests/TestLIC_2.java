package src.tests;

import src.Point;

import static org.junit.Assert.*;
import java.lang.Math;

import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_2 {

    /*
     * LIC 2 should return true iff:
     * There exists at least one set of three consecutive data points which form an angle such that: 
     *      - angle < (PI − EPSILON) or angle > (PI + EPSILON) 
     *      - The second of the three consecutive points is always the vertex of the angle.
     *      - If either the first point or the last point (or both) coincides with the vertex,
     *              the angle is undefined and the LIC is not satisfied by those three points.  (0 ≤ EPSILON < PI)
     * 
     * Test Requirements:
     *      1. angle(x,x,y) = undefined
     *      2. angle(x,y,z) < pi - epsilon
     *      3. pi - epsilon <= angle(x,y,z) =< pi + epsilon
     *      4. angle(x,y,z) > pi + epsilon
     *      5. angle(x,y,z) != angle(y,x,z) 
     */

    LaunchParameters params = new LaunchParameters();

    final double epsilon = Math.PI / 2;
    final Point[] pointsUndefinedAngle = {new Point(0,0), new Point(0,0),  new Point(1,0)};
    final Point[] points45deg = {new Point(1,0), new Point(0, 0), new Point(1,1)};
    final Point[] points90deg = {new Point(0,0), new Point(1,0), new Point(1,1)};
    final Point[] points315deg = {new Point(1,0), new Point(0,0), new Point(1,-1)};

    @Test
    public void testUndefinedAngle() {
        /* TR1 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, pointsUndefinedAngle, params, null, null);
        boolean result = li.checkLIC_2();
        assertFalse(result);
    }

    @Test
    public void testAngleLessThan90deg() {
        /* TR2 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, points45deg, params, null, null);
        boolean result = li.checkLIC_2();
        assertTrue(result);
    }

    @Test
    public void testAngle90deg() {
        /* TR3,TR5 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, points90deg, params, null, null);
        boolean result = li.checkLIC_2();
        assertFalse(result);
    }

    @Test
    public void testAngleMoreThan270deg() {
        /* TR4 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, points315deg, params, null, null);
        boolean result = li.checkLIC_2();
        assertTrue(result);
    }
}
