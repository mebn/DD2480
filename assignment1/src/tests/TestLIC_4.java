package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_4 {
    
    /**
     * LIC 4 should return true iff:
     * There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
     * quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     */

     /**
      * Tests that LIC 4 returns true if such a set of Q PTS exist.
      */
    @Test
    public void testLIC4True() {
        LaunchParameters params = new LaunchParameters();
        params.Q_PTS = 2;
        params.QUADS = 1;
        Point[] datapoints = {new Point(-1,0), new Point(4,1)};

        LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);
        
        Boolean res = li.checkLIC_4();

        Assert.assertTrue(res);
    }
    /**
     * Tests that LIC 4 returns false if such a set doesn't exist.
     */
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
