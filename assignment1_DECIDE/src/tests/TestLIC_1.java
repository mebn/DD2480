package src.tests;

import src.Point;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;

public class TestLIC_1 {
  @Test

  /**
   * Tests if 3 consecutive points placed on outer rim of circle returns
   * false.
   */
  public void testLIC1FalseOnBorder() {
    LaunchParameters params = new LaunchParameters();
    params.RADIUS1 = 2.5;
    // Look at maybe implementing a point class of our own
    Point[] datapoints = {
        new Point(0.0, 2.5),
        new Point(2.5, 0),
        new Point(0.0, -2.5)
    };

    LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

    Boolean res = li.checkLIC_1();

    Assert.assertFalse(res);
  }

  /**
   * Tests if 3 consecutive points placed just outside radius of circle returns
   * true.
   */
  @Test
  public void testLIC1TrueRightOutside() {
    LaunchParameters params = new LaunchParameters();
    params.RADIUS1 = 2;
    // Look at maybe implementing a point class of our own
    Point[] datapoints = {
        new Point(0.0, 2.2),
        new Point(2.1, 0),
        new Point(0.0, -2.2)
    };

    LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

    Boolean res = li.checkLIC_1();

    Assert.assertTrue(res);
  }

  /**
   * Tests if 3 consecutive points placed well within radius of circle returns
   * false.
   */
  @Test
  public void testLIC1FalseWellInside() {
    LaunchParameters params = new LaunchParameters();
    params.RADIUS1 = 2;
    // Look at maybe implementing a point class of our own
    Point[] datapoints = {
        new Point(0.0, 0.5),
        new Point(0.5, 0),
        new Point(0.3, 0.2)
    };

    LaunchInterceptor li = new LaunchInterceptor(datapoints.length, datapoints, params, null, null);

    Boolean res = li.checkLIC_1();

    Assert.assertFalse(res);
  }
}