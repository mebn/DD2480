package src.tests;

import java.awt.geom.Point2D;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_1 {
  @Test

  /**
   * Tests if 3 consecutive points placed on outer rim of circle returns
   * true.
   */
  public void testLIC1TrueOnBorder() {
    LaunchParameters params = new LaunchParameters();
    params.RADIUS1 = 2.5;
    // Look at maybe implementing a point class of our own
    Point2D.Double[] datapoints = {
        new Point2D.Double(0.0, 2.5),
        new Point2D.Double(2.5, 0),
        new Point2D.Double(0.0, -2.5)
    };

    LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);

    Boolean res = li.checkLIC_0();

    Assert.assertTrue(res);
  }

  /**
   * Tests if 3 consecutive points placed just outside radius of circle returns
   * false.
   */
  @Test
  public void testLIC1FalseRightOutside() {
    LaunchParameters params = new LaunchParameters();
    params.RADIUS1 = 2;
    // Look at maybe implementing a point class of our own
    Point2D.Double[] datapoints = {
        new Point2D.Double(0.0, 2.2),
        new Point2D.Double(2.1, 0),
        new Point2D.Double(0.0, -2.2)
    };

    LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);

    Boolean res = li.checkLIC_0();

    Assert.assertFalse(res);
  }

  /**
   * Tests if 3 consecutive points placed well within radius of circle returns
   * true.
   */
  @Test
  public void testLIC1TrueWellInside() {
    LaunchParameters params = new LaunchParameters();
    params.RADIUS1 = 2;
    // Look at maybe implementing a point class of our own
    Point2D.Double[] datapoints = {
        new Point2D.Double(0.0, 0.5),
        new Point2D.Double(0.5, 0),
        new Point2D.Double(0.3, 0.2)
    };

    LaunchInterceptor li = new LaunchInterceptor(2, datapoints, params, null, null);

    Boolean res = li.checkLIC_0();

    Assert.assertTrue(res);
  }
}