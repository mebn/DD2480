package src;

import java.util.Arrays;

public class LaunchInterceptor {
  private final int NUMPOINTS;
  private final Point[] POINTS;
  private final LaunchParameters PARAMETERS;
  private final Operator[][] LCM;
  private final boolean[] PUV;
  private boolean[] CMV = new boolean[15];
  private boolean[][] PUM = new boolean[15][15];
  private boolean[] FUV = new boolean[15];
  private final double PI = 3.1415926535;

  public LaunchInterceptor(int numpoints, Point[] points, LaunchParameters params, Operator[][] lcm, boolean[] puv) {
    this.NUMPOINTS = numpoints;
    this.POINTS = points;
    this.PARAMETERS = params;
    this.LCM = lcm;
    this.PUV = puv;
  }

  public boolean decide() {
    calculate_CMV();
    calculate_PUM();
    calculate_FUV();

    for(int i = 0; i < 15; i++){
      if(FUV[i] == false) return false;
    }

    return true;
  }

  public void calculate_CMV() {
    CMV[0] = checkLIC_0();
    CMV[1] = checkLIC_1();
    CMV[2] = checkLIC_2();
    CMV[3] = checkLIC_3();
    CMV[4] = checkLIC_4();
    CMV[5] = checkLIC_5();
    CMV[6] = checkLIC_6();
    CMV[7] = checkLIC_7();
    CMV[8] = checkLIC_8();
    CMV[9] = checkLIC_9();
    CMV[10] = checkLIC_10();
    CMV[11] = checkLIC_11();
    CMV[12] = checkLIC_12();
    CMV[13] = checkLIC_13();
    CMV[14] = checkLIC_14();
  }

  public void set_CMV(boolean[] CMV){
    this.CMV = CMV;
  }

  public boolean[] get_CMV(){
    return CMV;
  }

  public void calculate_PUM(){
    /*
     * In the example the diagonal of the matrix is filled with stars.
     * The specifications does not mention to treat the diagonal any different
     * however so we treat [i][i] just as usual.
     */

    for(int i = 0; i < 15; i++){
      for (int j = 0; j < 15; j++) {
        switch (LCM[i][j]) {
          case ANDD:
            PUM[i][j] = CMV[i] && CMV[j];
          break;

          case ORR:
            PUM[i][j] = CMV[i] || CMV[j];
          break;

          case NOTUSED:
            PUM[i][j] = true;
          break;

          default:
            break;
        }
      }
    }
    return;
  }

  public void set_PUM(boolean[][] PUM){
    this.PUM = PUM;
  }

  public boolean[][] get_PUM(){
    return PUM;
  }

  public void calculate_FUV() {
    for (int i = 0; i < 15; i++) {
      if (!PUV[i]) {
        FUV[i] = true;
        continue;
      }
      
      FUV[i] = true;
      for (int j = 0; j < 15; j++) {
        if (!PUM[i][j]) {
          FUV[i] = false;
          break;
        }
      }
    }
  }

  public void set_FUV(boolean[] FUV){
    this.FUV = FUV;
  }

  public boolean[] get_FUV(){
    return FUV;
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

      double r = GeometryUtils.threePointCircleRadius(p1, p2, p3);

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
      if (first.equals(second) || third.equals(second)) continue;

      double angle = GeometryUtils.threePointAngle(first, second, third);

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
      Point p2 = POINTS[i + 1];
      Point p3 = POINTS[i + 2];
      enclosedArea = GeometryUtils.triangleArea(p1, p2, p3);
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
    int N_PTS = PARAMETERS.N_PTS;
    double DIST = PARAMETERS.DIST;

    if(NUMPOINTS < 3) return false;
    if(N_PTS < 3 || N_PTS > NUMPOINTS) return false;
    if(DIST < 0) return false;

    for(int i = 0; i <= NUMPOINTS - N_PTS; i++){
      Point Q1 = POINTS[i];
      Point Q2 = POINTS[i + N_PTS - 1];

      for(int j = i+1; j < i+N_PTS-1; j++){
        Point P = POINTS[j];
        double d;
        if(Q1.equals(Q2)){
          d = Q1.distance(P);
        }
        else{
          /*
          d is the distance between point P, and the line between Q1 and Q2
          The expression is equivalent to ((Q2 - Q1) X (P - Q1)) / ||Q1 - Q2||
          Unfortunately JAVA has no Operator overloading so it can't be written as nicely
          */
          d = Q2.subtract(Q1).crossProduct(P.subtract(Q1)) / Q1.distance(Q2); 
        }

        if(Math.abs(d) > DIST) return true;
      }
    }
    return false;
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

      double r = GeometryUtils.threePointCircleRadius(p1, p2, p3);

      if (r > PARAMETERS.RADIUS1) {
        return true;
      }
    }

    return false;
  }

    /**
   * Checks  if there exists at least one set of three data points separated by exactly C_PTS and D_PTS
   * consecutive intervening points, respectively, that form an angle such that:
   * angle < (PI−EPSILON)
   * or
   * angle > (PI+EPSILON)
   * The second point of the set of three points is always the vertex of the angle. If either the first
   * point or the last point (or both) coincide with the vertex, the angle is undefined and the LIC
   * is not satisfied by those three points. When NUMPOINTS < 5, the condition is not met.
   *
   * @return true if the condition is satisfied, false otherwise
   */
  public boolean checkLIC_9() {
    final int C_PTS = PARAMETERS.C_PTS;
    final int D_PTS = PARAMETERS.D_PTS;
    
    if (NUMPOINTS < 5) return false;
    if (C_PTS < 1 || D_PTS < 1 || C_PTS + D_PTS > NUMPOINTS - 3) {
      throw new IllegalArgumentException("In checkLIC_9: C_PTS >= 1 && D_PTS >= 1 && C_PTS + D_PTS <= NUMPOINTS - 3");
    }
    
    for (int i = 0; i < NUMPOINTS - C_PTS - D_PTS - 2; i++) {
      Point first = POINTS[i];
      Point second = POINTS[i + C_PTS + 1];
      Point third = POINTS[i + C_PTS + D_PTS + 2];

      if (!first.equals(second) && !third.equals(second)) {
        double angle = GeometryUtils.threePointAngle(first, second, third);
        if (angle < PI - PARAMETERS.EPSILON || angle > PI + PARAMETERS.EPSILON) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkLIC_10() {
    int E_PTS = PARAMETERS.E_PTS;
    int F_PTS = PARAMETERS.F_PTS;

    if (NUMPOINTS < 5) return false;

    if (E_PTS < 1) throw new IllegalArgumentException("E_PTS must be >=1");
    if (F_PTS < 1) throw new IllegalArgumentException("F_PTS must be >=1");
    if (E_PTS + F_PTS > NUMPOINTS - 3) throw new IllegalArgumentException("E_PTS + F_PTS must be <= NUMPOINTS - 3");

    for (int i = 0; i < NUMPOINTS - 2 - E_PTS - F_PTS; i++) {
      Point p1 = POINTS[i];
      Point p2 = POINTS[i + E_PTS + 1];
      Point p3 = POINTS[i + E_PTS + F_PTS + 2];

      double enclosedArea = GeometryUtils.triangleArea(p1, p2, p3);

      if (enclosedArea > PARAMETERS.AREA1) return true;
    }
    return false;
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
    double LENGTH1 = PARAMETERS.LENGTH1;
    double LENGTH2 = PARAMETERS.LENGTH2;
    int K_PTS = PARAMETERS.K_PTS;

    if(NUMPOINTS < 3) return false;
    if(LENGTH1 < 0){
      throw new IllegalArgumentException("In checkLIC_12: LENGTH1 has to be >= 0");
    }
    if(LENGTH2 < 0){
      throw new IllegalArgumentException("In checkLIC_12: LENGTH2 has to be >= 0");
    }
    boolean condition1 = false;
    boolean condition2 = false;

    for(int i = 0; i < NUMPOINTS-K_PTS-1; i++){
      int j = i + K_PTS + 1;

      if(POINTS[i].distance(POINTS[j]) > LENGTH1) condition1 = true;
      if(POINTS[i].distance(POINTS[j]) < LENGTH2) condition2 = true;
    }

    return condition1 && condition2;
  }
  
  /**
   * Checks if there exists at least one set of three data points, separated by exactly A PTS and B PTS
   * consecutive intervening points, respectively, that cannot be contained within or on a circle of
   * radius RADIUS1. In addition, there exists at least one set of three data points (which can be
   * the same or different from the three data points just mentioned) separated by exactly A PTS
   * and B PTS consecutive intervening points, respectively, that can be contained in or on a
   * circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is
   * not met when NUMPOINTS < 5.
   * 0 ≤ RADIUS2
   *
   * @return true if the condition is satisfied, false otherwise
   */
  public boolean checkLIC_13() {
    if (NUMPOINTS < 5) return false;
    if (PARAMETERS.RADIUS2 < 0) {
      throw new IllegalArgumentException("In checkLIC_13: RADIUS2 has to be >= 0");
    }

    boolean rad1Found = false;
    boolean rad2Found = false;

    for (int i = 0; i < NUMPOINTS - PARAMETERS.A_PTS - PARAMETERS.B_PTS - 2; i++) {
      Point p1 = POINTS[i];
      Point p2 = POINTS[i + PARAMETERS.A_PTS + 1];
      Point p3 = POINTS[i + PARAMETERS.A_PTS + PARAMETERS.B_PTS + 2];

      double r = GeometryUtils.threePointCircleRadius(p1, p2, p3);
      if (r > PARAMETERS.RADIUS1) rad1Found = true;
      if (r <= PARAMETERS.RADIUS2) rad2Found = true;
      if (rad1Found && rad2Found) return true;
    }
    return false;
  }

  public boolean checkLIC_14() {
    boolean req1 = false;
    boolean req2 = false;

    int E_PTS = PARAMETERS.E_PTS;
    int F_PTS = PARAMETERS.F_PTS;

    if (NUMPOINTS < 5) return false;

    if (E_PTS < 1) throw new IllegalArgumentException("E_PTS must be >=1");
    if (F_PTS < 1) throw new IllegalArgumentException("F_PTS must be >=1");
    if (E_PTS + F_PTS > NUMPOINTS - 3) throw new IllegalArgumentException("E_PTS + F_PTS must be <= NUMPOINTS - 3");
  
    for (int i = 0; i < NUMPOINTS - 2 - E_PTS - F_PTS; i++) {
      Point p1 = POINTS[i];
      Point p2 = POINTS[i + E_PTS + 1];
      Point p3 = POINTS[i + E_PTS + F_PTS + 2];
      
      double enclosedArea = GeometryUtils.triangleArea(p1, p2, p3);
  
      if (enclosedArea > PARAMETERS.AREA1) req1 = true;
      if (enclosedArea < PARAMETERS.AREA2) req2 = true;
    }
    return (req1 && req2);
  }

  public static void main(String[] args) {

  }

}
