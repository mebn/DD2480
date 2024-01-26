package src;

import java.awt.*;
import java.awt.geom.Point2D;

enum operator {
  ANDD,
  ORR,
  NOTUSED
}

public class LaunchInterceptor {
  private final int NUMPOINTS;
  private final Point2D[] POINTS;
  private final LaunchParameters PARAMETERS;
  private final operator[][] LCM;
  private final boolean[] PUV;

  public LaunchInterceptor(int numpoints, Point2D[] points, LaunchParameters params, operator[][] lcm, boolean[] puv) {
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
    return true;
  }

  private boolean checkLIC_2() {
    for (int i = 0; i < NUMPOINTS - 3; i++) {
      Point2D first = POINTS[i];
      Point2D second = POINTS[i + 1];
      Point2D third = POINTS[i + 2];
      double result = Math.atan2(first.getX() - second.getX(), first.getY() - second.getY())
          - Math.atan2(third.getX() - second.getX(), third.getY() - second.getY());
    }
    return true;
  }

  public boolean checkLIC_3() {
    return true;
  }

  public boolean checkLIC_4() {
    return true;
  }

  public boolean checkLIC_5() {
    return true;
  }

  private boolean checkLIC_6() {
    return true;
  }

  public boolean checkLIC_7() {
    return true;
  }

  private boolean checkLIC_8() {
    return true;
  }

  private boolean checkLIC_9() {
    return true;
  }

  private boolean checkLIC_10() {
    return true;
  }

  public boolean checkLIC_11() {
    return true;
  }

  private boolean checkLIC_12() {
    return true;
  }

  private boolean checkLIC_13() {
    return true;
  }

  private boolean checkLIC_14() {
    return true;
  }

  public static void main(String[] args) {

  }

}
