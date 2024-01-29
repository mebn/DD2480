package src;

import src.Point;
import java.awt.*;
import java.lang.Math.*;
import java.util.Arrays;

enum operator {
  ANDD,
  ORR,
  NOTUSED
}

public class LaunchInterceptor {
  private final int NUMPOINTS;
  private final Point[] POINTS;
  private final LaunchParameters PARAMETERS;
  private final operator[][] LCM;
  private final boolean[] PUV;
  private final double PI = 3.1415926535;

  public LaunchInterceptor(int numpoints, Point[] points, LaunchParameters params, operator[][] lcm, boolean[] puv) {
    this.NUMPOINTS = numpoints;
    this.POINTS = points;
    this.PARAMETERS = params;
    this.LCM = lcm;
    this.PUV = puv;
  }

  public boolean decide() {
    return true;
  }

  public boolean checkLIC_0() {
    for (int i = 1; i < POINTS.length; i++) {
      if (POINTS[i].distance(POINTS[i - 1]) > PARAMETERS.LENGTH1)
        return true;
    }
    return false;
  }

  public boolean checkLIC_1() {
    for (int i = 0; i < NUMPOINTS - 2; i++) {
      Point p1 = POINTS[i];
      Point p2 = POINTS[i + 1];
      Point p3 = POINTS[i + 2];

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

      if (r > PARAMETERS.RADIUS1) {
        return true;
      }
    }
    
    return false;
  }

  /**
   * Checks if there exists at least one set of three consecutive data points
   * which form an angle such that:
   * angle < (PI − EPSILON) or angle > (PI + EPSILON)
   * The second of the three consecutive points is always the vertex of the angle.
   * If either the first point or the last point (or both) coincides with the
   * vertex, the angle is undefined
   * and the LIC is not satisfied by those three points.
   * (0 ≤ EPSILON < PI)
   *
   * @return true if the condition is satisfied, false otherwise
   */
  public boolean checkLIC_2() {
    for (int i = 0; i < NUMPOINTS - 2; i++) {
      Point first = POINTS[i];
      Point second = POINTS[i + 1];
      Point third = POINTS[i + 2];
      // If first or third point coincide with second point, angle is undefined
      if (first.equals(second) || third.equals(second))
        continue;
      double firstAngle = Math.atan2(first.getY() - second.getY(), first.getX() - second.getX());
      double thirdAngle = Math.atan2(third.getY() - second.getY(), third.getX() - second.getX());
      // firstAngle = (firstAngle > 0) ? firstAngle : 2 * pi + firstAngle;
      // thirdAngle = (thirdAngle > 0) ? thirdAngle : 2 * pi + thirdAngle;
      double angle = Math.abs(firstAngle - thirdAngle);

      if (angle < PI - PARAMETERS.EPSILON || angle > PI + PARAMETERS.EPSILON) {
        return true;
      }
    }
    return false;
  }

  public boolean checkLIC_3() {
    double enclosedArea;

    for (int i = 0; i < POINTS.length - 2; i++) {
      Point p1 = POINTS[i];
      double x1 = p1.getX();
      double y1 = p1.getY();

      Point p2 = POINTS[i + 1];
      double x2 = p2.getX();
      double y2 = p2.getY();

      Point p3 = POINTS[i + 2];
      double x3 = p3.getX();
      double y3 = p3.getY();

      enclosedArea = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
      if (enclosedArea > PARAMETERS.AREA1) {
        return true;
      }
    }
    return false;
  }

  public boolean checkLIC_4() {
    // There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
    // quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
    // of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
    // is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
    // (0,1) is in quadrant I and the point (1,0) is in quadrant I.

    for (int i = 0; i < POINTS.length - PARAMETERS.Q_PTS + 1; i++) {
      int[] quadrants = new int[4];
      
      for (int j = 0; j < PARAMETERS.Q_PTS; j++) {
        Point p = POINTS[i + j];
        double x = p.getX();
        double y = p.getY();

        if (x >= 0 && y >= 0) {
          quadrants[0] = 1;
        } else if (x < 0 && y >= 0) {
          quadrants[1] = 1;
        } else if (x <= 0 && y < 0) {
          quadrants[2] = 1;
        } else if (x > 0 && y < 0) {
          quadrants[3] = 1;
        }
      }

      int num_quads = Arrays.stream(quadrants).sum();
      if (num_quads > PARAMETERS.QUADS) {
        return true;
      }
    }
    
    return false;
  }

  public boolean checkLIC_5() {
    // There exists at least one set of two consecutive data points,
    // (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
    for (int i = 0; i < POINTS.length - 1; i++) {
      int j = i + 1;
      if (POINTS[j].getX() - POINTS[i].getX() < 0) {
        return true;
      }
    }

    return false;
  }

  public boolean checkLIC_6() {
    return true;
  }

  public boolean checkLIC_7() {
    for (int i = 1 + PARAMETERS.K_PTS; i < POINTS.length; i++) {
      if (POINTS.length < 3)
        return false;

      if (POINTS[i].distance(POINTS[i - PARAMETERS.K_PTS - 1]) > PARAMETERS.LENGTH1)
        return true;
    }
    return false;
  }

  public boolean checkLIC_8() {
    if (NUMPOINTS < 5 || POINTS.length < 5) {
      return false;
    }

    for (int i = 0; i < NUMPOINTS - PARAMETERS.A_PTS - PARAMETERS.B_PTS - 2; i++) {
      Point p1 = POINTS[i];
      Point p2 = POINTS[i + PARAMETERS.A_PTS + 1];
      Point p3 = POINTS[i + PARAMETERS.A_PTS + PARAMETERS.B_PTS + 2];

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

      if (r > PARAMETERS.RADIUS1) {
        return true;
      }
    }

    return false;
  }

  public boolean checkLIC_9() {
    return true;
  }

  public boolean checkLIC_10() {
    return true;
  }

  public boolean checkLIC_11() {
    int G_PTS = PARAMETERS.G_PTS;
    if (NUMPOINTS < 3) return false;
    if (G_PTS < 1 || G_PTS > NUMPOINTS-2) return false;

    for (int i = 0; i < NUMPOINTS - G_PTS - 1; i++){
      if(POINTS[i + G_PTS + 1].getX() < POINTS[i].getX()) return true;
    }

    return false;
  }

  public boolean checkLIC_12() {
    return true;
  }

  public boolean checkLIC_13() {
    return true;
  }

  public boolean checkLIC_14() {
    return true;
  }

  public static void main(String[] args) {

  }

}
