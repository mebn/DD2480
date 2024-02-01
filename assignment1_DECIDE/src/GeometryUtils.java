package src;

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


  /**
   * Calculates the radius of a circle passing through three points.
   * 
   * @param p1 the first point
   * @param p2 the second point
   * @param p3 the third point
   * @return the radius of the circle passing through the three points
   */
  public static double threePointCircleRadius(Point p1, Point p2, Point p3) {
    double x1 = p1.getX();
    double y1 = p1.getY();

    double x2 = p2.getX();
    double y2 = p2.getY();

    double x3 = p3.getX();
    double y3 = p3.getY();

    // calculate circumcenter of triangle
    // https://en.wikipedia.org/wiki/Circumcircle#Cartesian_coordinates_2
    double d = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    double r = 0;

    if (d == 0) {
      r = Math.max(Math.max(p1.distance(p2), p1.distance(p3)), p2.distance(p3)) / 2;
    } else {
      double ux = ((x1 * x1 + y1 * y1) * (y2 - y3) + (x2 * x2 + y2 * y2) * (y3 - y1) + (x3 * x3 + y3 * y3) * (y1 - y2)) / d;
      double uy = ((x1 * x1 + y1 * y1) * (x3 - x2) + (x2 * x2 + y2 * y2) * (x1 - x3) + (x3 * x3 + y3 * y3) * (x2 - x1)) / d;
      r = Math.sqrt((ux - x1) * (ux - x1) + (uy - y1) * (uy - y1));  
    }
    return r;
  }

  public static double triangleArea(Point p1, Point p2, Point p3) {
      double x1 = p1.getX();
      double y1 = p1.getY();

      double x2 = p2.getX();
      double y2 = p2.getY();

      double x3 = p3.getX();
      double y3 = p3.getY();

      return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
  }
}