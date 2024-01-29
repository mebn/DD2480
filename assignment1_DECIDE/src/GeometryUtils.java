package src;

import java.awt.geom.Point2D;

/**
 * Utility class for geometry calculations.
 */
public class GeometryUtils {
  private GeometryUtils() {
    throw new IllegalStateException("Utility class");
  }
  
  /**
   * Calculates the absolute value of the angle between three points
   * using the middle point as the vertex of the angle.
   * It shouldn't matter that we only return the counter clock-wise angle (read LIC9) right??
   * This can probably be made better with the new Point class. I just didn't look at it fully yet
   * @param a the first point
   * @param b the second point which is the vertex of the angle
   * @param c the third point
   * @return the absolute value of the counter clock-wise angle between the three points
   */
  public static double threePointAngle(Point2D a, Point2D b, Point2D c) {
    // Compute the angle from positive x-axis to point a and b [-pi, pi]
    double firstAngle = Math.atan2(a.getY() - b.getY(), a.getX() - b.getX());
    double thirdAngle = Math.atan2(c.getY() - b.getY(), c.getX() - b.getX());

    // Format both angles to go counter clock-wise [0, 2pi]
    firstAngle = (firstAngle < 0) ? 2 * Math.PI + firstAngle : firstAngle;
    thirdAngle = (thirdAngle < 0) ? 2 * Math.PI + thirdAngle : thirdAngle;
    return Math.abs(firstAngle - thirdAngle);
  }
}