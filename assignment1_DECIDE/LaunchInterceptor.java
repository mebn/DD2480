import java.awt.*;

enum operator {
  ANDD,
  ORR,
  NOTUSED
}

public class LaunchInterceptor {
  private int numpoints;
  private Point[] points;
  private LaunchParameters params;
  private operator[][] lcm;
  private boolean[] puv;

  public LaunchInterceptor(int numpoints, Point[] points, LaunchParameters params, operator[][] lcm, boolean[] puv) {
    this.numpoints = numpoints;
    this.points = points;
    this.params = params;
    this.lcm = lcm;
    this.puv = puv;
  }

  public boolean decide() {
    return true;
  }

  private boolean checkLIC_1() {
    return true;
  }

  private boolean checkLIC_2() {
    return true;
  }

  private boolean checkLIC_3() {
    return true;
  }

  private boolean checkLIC_4() {
    return true;
  }

  private boolean checkLIC_5() {
    return true;
  }

  private boolean checkLIC_6() {
    return true;
  }

  private boolean checkLIC_7() {
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

  private boolean checkLIC_11() {
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

  private boolean checkLIC_15() {
    return true;
  }

  public static void main(String[] args) {

  }

}

class LaunchParameters {
  public double LENGTH1; // Length in LICs 0, 7, 12
  public double RADIUS1; // Radius in LICs 1, 8, 13
  public double EPSILON; // Deviation from PI in LICs 2, 9
  public double AREA1; // Area in LICs 3, 10, 14
  public int Q_PTS; // Number of consecutive points in LIC 4
  public int QUADS; // Number of quadrants in LIC 4
  public double DIST; // Distance in LIC 6
  public int N_PTS; // Number of consecutive pts. in LIC 6
  public int K_PTS; // Number of intermediate pts. in LICs 7, 12
  public int A_PTS; // Number of intermediate pts. in LICs 8, 13
  public int B_PTS; // Number of intermediate pts. in LICs 8, 13
  public int C_PTS; // Number of intermediate pts. in LIC 9
  public int D_PTS; // Number of intermediate pts. in LIC 9
  public int E_PTS; // Number of intermediate pts. in LICs 10, 14
  public int F_PTS; // Number of intermediate pts. in LICs 10, 14
  public int G_PTS; // Number of intermediate pts. in LIC 11
  public double LENGTH2; // Maximum length in LIC 12
  public double RADIUS2; // Maximum radius in LIC 13
  public double AREA2; // Maximum area in LIC 14
}