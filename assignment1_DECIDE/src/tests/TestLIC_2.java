package src.tests;

import java.awt.Point;

import static org.junit.Assert.*;
import java.lang.Math;

import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_2 {

    /*
     * There exists at least one set of three consecutive data points which form an angle such that: 
     *      - angle < (PI − EPSILON) or angle > (PI + EPSILON) 
     *      - The second of the three consecutive points is always the vertex of the angle.
     *      - If either the first point or the last point (or both) coincides with the vertex,
     *              the angle is undefined and the LIC is not satisfied by those three points.  (0 ≤ EPSILON < PI)
     * 
     * Tests:
     *      1. angle(x,x,y) = undefined => assertFalse
     *      2. angle(x,y,z) < pi - epsilon => assertTrue
     *      3. pi - epsilon <= angle(x,y,z) =< pi + epsilon => assertFalse
     *      4. angle(x,y,z) > pi + epsilon => assertTrue
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
        /* Test 1 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, pointsUndefinedAngle, params, null, null);
        boolean result = li.checkLIC_2();
        assertFalse(result);
    }

    @Test
    public void testAngleLessThan90deg() {
        /* Test 2 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, points45deg, params, null, null);
        boolean result = li.checkLIC_2();
        assertTrue(result);
    }

    @Test
    public void testAngle90deg() {
        /* Test 3,5 */
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, points90deg, params, null, null);
        boolean result = li.checkLIC_2();

        assertFalse(result);
    }

    @Test
    public void testAngleMoreThan270deg() {
        /* Test 4*/
        params.EPSILON = epsilon;
        LaunchInterceptor li = new LaunchInterceptor(3, points315deg, params, null, null);
        boolean result = li.checkLIC_2();

        assertTrue(result);
    }
}
