package src.tests;

import java.awt.Point;
import java.awt.geom.Point2D;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

/**
 * This class contains test cases for LIC_8.
 * LIC_8 checks if there exists at least one set of three data points separated
 * by exactly A PTS and B PTS consecutive intervening points, respectively, that
 * cannot be contained within or on a circle of radius RADIUS1.
 * The condition is not met when NUMPOINTS < 5.
 * 1 ≤ A PTS, 1 ≤ B PTS
 * A PTS + B PTS ≤ (NUMPOINTS − 3)
 */
public class TestLIC_8 {

    /**
     * Tests if 3 points separated by
     * A_PTS=1 and B_PTS=1 consecutive intervening points
     * placed on outer rim of circle returns false.
     */
    @Test
    public void testLIC8FaseOnBorder() {
        LaunchParameters params = new LaunchParameters();
        params.RADIUS1 = 2;
        params.A_PTS = 1;
        params.B_PTS = 1;
        Point2D.Double[] datapoints = {
                new Point2D.Double(0.0, 2.0),
                new Point2D.Double(1.0, 1.0), // A_PTS
                new Point2D.Double(2.0, 0),
                new Point2D.Double(1.0, 1.0), // B_PTS
                new Point2D.Double(0.0, -2.0)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

        Boolean res = li.checkLIC_8();

        Assert.assertFalse(res);
    }

    /**
     * Tests if 3 points separated by
     * A_PTS=1 and B_PTS=1 consecutive intervening points
     * placed just outside of circle returns true.
     */
    @Test
    public void testLIC8TrueJustOutside() {
        LaunchParameters params = new LaunchParameters();
        params.RADIUS1 = 2;
        params.A_PTS = 1;
        params.B_PTS = 1;
        Point2D.Double[] datapoints = {
                new Point2D.Double(0.0, 2.1),
                new Point2D.Double(1.0, 1.0), // A_PTS
                new Point2D.Double(2.1, 0),
                new Point2D.Double(1.0, 1.0), // B_PTS
                new Point2D.Double(0.0, -2.1)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

        Boolean res = li.checkLIC_8();

        Assert.assertTrue(res);
    }

    /**
     * Tests if 3 points separated by
     * A_PTS=1 and B_PTS=1 consecutive intervening points
     * placed just inside of circle returns false.
     */
    @Test
    public void testLIC8FalseJustInside() {
        LaunchParameters params = new LaunchParameters();
        params.RADIUS1 = 2;
        params.A_PTS = 1;
        params.B_PTS = 1;
        Point2D.Double[] datapoints = {
                new Point2D.Double(0.0, 1.9),
                new Point2D.Double(1.0, 1.0), // A_PTS
                new Point2D.Double(1.9, 0),
                new Point2D.Double(1.0, 1.0), // B_PTS
                new Point2D.Double(0.0, -1.9)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

        Boolean res = li.checkLIC_8();

        Assert.assertFalse(res);
    }

    /**
     * Tests if NUMPOINTS < 5 returns false
     */
    @Test
    public void testLIC8FalseNumpointsLessThanFive() {
        LaunchParameters params = new LaunchParameters();
        params.RADIUS1 = 2;
        params.A_PTS = 1;
        params.B_PTS = 1;
        Point2D.Double[] datapoints = {
                new Point2D.Double(0.0, 1.9),
                new Point2D.Double(1.9, 0),
                new Point2D.Double(1.0, 1.0), // B_PTS
                new Point2D.Double(0.0, -1.9)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

        Boolean res = li.checkLIC_8();

        Assert.assertFalse(res);
    }

    /**
     * Tests if A_PTS B_PTS > (NUMPOINTS-3) return false
     * (Maybe not needed as this would only be an issue if the params are set wrong)
     */
    @Test
    public void testLIC8FalseTooManyInterveningPoints() {
        LaunchParameters params = new LaunchParameters();
        params.RADIUS1 = 2;
        params.A_PTS = 2;
        params.B_PTS = 2;
        Point2D.Double[] datapoints = {
                new Point2D.Double(0.0, 1.9),
                new Point2D.Double(1.0, 1.0), // A_PTS
                new Point2D.Double(1.9, 0),
                new Point2D.Double(1.0, 1.0), // B_PTS
                new Point2D.Double(0.0, -1.9)
        };

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

        Boolean res = li.checkLIC_8();

        Assert.assertFalse(res);
    }
}
