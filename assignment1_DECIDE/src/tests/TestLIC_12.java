package src.tests;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_12 {
    /* 
     * There exists two point u,v separated by K_PTS such that dist(u,v) > LENGTH1
     *      AND
     * There exists two points w,t (can be u,v) separated by K_PTS such that dist(w,t) < LENGTH2
     * NUMPOINTS > 3
     * LENGTH2 >= 0
     */

    LaunchParameters params = new LaunchParameters();
    Point[] points = {new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1)};

    @Test
    public void testFalseLessThanLENGTH1() {
        params.LENGTH1 = 2;
        params.LENGTH2 = 2;
        params.K_PTS = 1;
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertFalse(result);
    }

    @Test
    public void testFalseGreaterThanLENGTH2() {
        params.LENGTH1 = 1;
        params.LENGTH2 = 1;
        params.K_PTS = 1;
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertFalse(result);
    }

    @Test
    public void testTrueLENGTH1LENGTH2() {
        params.LENGTH1 = 1;
        params.LENGTH2 = 2;
        params.K_PTS = 1;
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(4, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertTrue(result);

    }

    @Test
    public void testFalseNUMPOINTS() {
        params.LENGTH1 = 1;
        params.LENGTH2 = 2;
        params.K_PTS = 1;
        
        Point[] points = {new Point(0,0), new Point(1,0), new Point(1,1)};
        /* dist(u,v) = sqrt(2) */

        LaunchInterceptor li = new LaunchInterceptor(3, points, params, null, null);
        boolean result = li.checkLIC_12();
        assertFalse(result);
    }
}
