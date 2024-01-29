package src;

import src.Point;

/**
 * Utility class for geometry calculations.
 */
public class GeometryUtils {
  private GeometryUtils() {
    throw new IllegalStateException("Utility class");
  }
  
  /**
   * Calculates the absolute value of the angle between a and c
   * using the middle point b as the vertex of the angle.
   * @param a the first point
   * @param b the second point which is the vertex of the angle
   * @param c the third point
   * @return the absolute value of the angle between a and c using b as the vertex of the angle
   */
  public static double threePointAngle(Point a, Point b, Point c) {
    return Math.abs(a.subtract(b).angle(c.subtract(b)));
  }
}