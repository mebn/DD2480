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
   * @param a the first point
   * @param b the second point which is the vertex of the angle
   * @param c the third point
   * @return the absolute value of the angle between the three points
   */
  public static double threePointAngle(Point2D a, Point2D b, Point2D c) {
    double firstAngle = Math.atan2(a.getY() - b.getY(), a.getX() - b.getX());
    double thirdAngle = Math.atan2(c.getY() - b.getY(), c.getX() - b.getX());
    return Math.abs(firstAngle - thirdAngle);
  }
}