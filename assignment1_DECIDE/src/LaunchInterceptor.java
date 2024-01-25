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

  private boolean checkLIC_1() {
    return true;
  }

  
  public boolean checkLIC_2() {
    return true;
  }

  public boolean checkLIC_3() {
    return true;
  }

  public boolean checkLIC_4() {
    return true;
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
