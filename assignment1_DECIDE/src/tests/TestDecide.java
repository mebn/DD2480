package src.tests;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;
import src.Point;

import junit.framework.TestCase;
import src.Operator;

public class TestDecide{

/*
 * Tests that Decide returns true when no LIC is need to be checked 
 * (PUV[i] is false for all i)
 */
  @Test
  public void testDecideTrue0() {
    Point[] points = {
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
          };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 1;
    params.RADIUS1 = 1;
    params.EPSILON = 1;
    params.AREA1 = 1;
    params.Q_PTS = 1;
    params.QUADS = 1;
    params.DIST = 1;
    params.N_PTS = 1;
    params.K_PTS = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    params.G_PTS = 1;
    params.LENGTH2 = 1;
    params.RADIUS2 = 1;
    params.AREA2 = 1;
    Operator[][] lcm = {
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
    };

    boolean[] puv = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertTrue(res);
  }

  /*
   * Tests that operators (CONNECTORS) behave as they should when only PUV[0] is true and
   * only LIC0, LIC1, LIC2, LIC5 are satisfied
   */
  @Test
  public void testDecideTrue1() {
    Point[] points = {
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
      new Point(100,100),
      new Point(1,1),
    };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 1;
    params.RADIUS1 = 1;
    params.EPSILON = 1;
    params.AREA1 = 1;
    params.Q_PTS = 1;
    params.QUADS = 1;
    params.DIST = 1;
    params.N_PTS = 1;
    params.K_PTS = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    params.G_PTS = 1;
    params.LENGTH2 = 1;
    params.RADIUS2 = 1;
    params.AREA2 = 1;
    Operator[][] lcm = {
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ORR,Operator.NOTUSED,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
    };

    boolean[] puv = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertTrue(res);
  }

  /*
  * Tests that when more than one PUV[i] is true and LCM is 
  * setup successfully decide returns true
  * LIC0, LIC1, LIC5, LIC7, LIC8, LIC11 are satisfied
  */
  @Test
  public void testDecideTrue2() {
    Point[] points = {
      new Point(6.0,0),
      new Point(5,1),
      new Point(4,2),
      new Point(3,3),
      new Point(2,4),
      new Point(1,5),
      new Point(0,6),
    };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 1;
    params.RADIUS1 = 1;
    params.EPSILON = 1;
    params.AREA1 = 1;
    params.Q_PTS = 1;
    params.QUADS = 1;
    params.DIST = 1;
    params.N_PTS = 1;
    params.K_PTS = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    params.G_PTS = 1;
    params.LENGTH2 = 1;
    params.RADIUS2 = 1;
    params.AREA2 = 1;
    Operator[][] lcm = {
      {Operator.ANDD, Operator.ANDD, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ANDD,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.NOTUSED}, 
      {Operator.ANDD, Operator.ANDD, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ANDD,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
    };

    boolean[] puv = {true,true,false,false,false,false,false,false,false,false,false,false,false,false,false};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertTrue(res);
  }

  /*
   * Tests that when all LIC's are satisfied, all PUV's are set to true 
   * and lcm is all ANDD decide returns true.
   */
  @Test
  public void testDecideTrue3() {
    Point[] points = {
      new Point(0,0),
      new Point(-1,0),
      new Point(-1,1),
      new Point(-1,1),
      new Point(0,1),
    };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 0;
    params.RADIUS1 = 0;
    params.EPSILON = 0;
    params.AREA1 = 0;
    params.Q_PTS = 2;
    params.QUADS = 1;
    params.DIST = 0;
    params.N_PTS = 3;
    params.K_PTS = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    params.G_PTS = 1;
    params.LENGTH2 = 10;
    params.RADIUS2 = 10;
    params.AREA2 = 100;
    Operator[][] lcm = {
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
    };

    boolean[] puv = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertTrue(res);
  }
  
  /*
  * Tests that when none of the LIC's are satisfied, PUV is all true, 
  * and LCM is all ORR decide returns false
  */
  @Test
  public void testDecideFalse0() {
    Point[] points = {
      new Point(-1,1),
      new Point(-1,0),
      new Point(0,0),
      new Point(0,1),
      new Point(0,1),
    };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 10;
    params.RADIUS1 = 10;
    params.EPSILON = 10;
    params.AREA1 = 10;
    params.Q_PTS = 4;
    params.QUADS = 4;
    params.DIST = 10;
    params.N_PTS = 3;
    params.K_PTS = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    params.G_PTS = 1;
    params.LENGTH2 = 0;
    params.RADIUS2 = 0;
    params.AREA2 = 0;
    Operator[][] lcm = {
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ORR, Operator.ORR, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR,Operator.ORR}, 
    };

    boolean[] puv = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertFalse(res);
  }


/*
     * Example from the specifications
     */

  @Test
  public void testDecideFalse1() {
    Point[] points = {
      new Point(0,1),
      new Point(0,0),
      new Point(1,0),
    };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 10;
    params.RADIUS1 = 0;
    params.EPSILON = 0;
    params.AREA1 = 0;
    params.Q_PTS = 3;
    params.QUADS = 3;
    params.DIST = 10;
    params.N_PTS = 10;
    params.K_PTS = 10;
    params.A_PTS = 10;
    params.B_PTS = 10;
    params.C_PTS = 10;
    params.D_PTS = 10;
    params.E_PTS = 10;
    params.F_PTS = 10;
    params.G_PTS = 10;
    params.LENGTH2 = 10;
    params.RADIUS2 = 10;
    params.AREA2 = 10;
    Operator[][] lcm = {
      {Operator.ANDD, Operator.ANDD, Operator.ORR, Operator.ANDD,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.ANDD, Operator.ANDD, Operator.ORR, Operator.ORR,Operator.NOTUSED,Operator.NOTUSED,Operator.ORR,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.ORR, Operator.ORR, Operator.ANDD, Operator.ANDD,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.ANDD, Operator.ORR, Operator.ANDD, Operator.ANDD,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
      {Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED, Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED,Operator.NOTUSED}, 
    };

    boolean[] puv = {true,false,true,false,true,true,true,true,true,true,true,true,true,true,true};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertFalse(res);
  }

  /*
  * Tests that when LCM is setup with an ANDD between one satisfied LIC and one 
  * unsafisfied LIC it returns false. Everything else is satisfied.
  * LIC0 is satisfied, LIC2 is not. The ANDD operation between them should return false
  */
  @Test
  public void testDecideFalse2() {
    Point[] points = {
      new Point(6.0,0),
      new Point(5,1),
      new Point(4,2),
      new Point(3,3),
      new Point(2,4),
      new Point(1,5),
      new Point(0,6),
    };
    LaunchParameters params = new LaunchParameters();
    params.LENGTH1 = 1;
    params.RADIUS1 = 1;
    params.EPSILON = 1;
    params.AREA1 = 1;
    params.Q_PTS = 1;
    params.QUADS = 1;
    params.DIST = 1;
    params.N_PTS = 1;
    params.K_PTS = 1;
    params.A_PTS = 1;
    params.B_PTS = 1;
    params.C_PTS = 1;
    params.D_PTS = 1;
    params.E_PTS = 1;
    params.F_PTS = 1;
    params.G_PTS = 1;
    params.LENGTH2 = 1;
    params.RADIUS2 = 1;
    params.AREA2 = 1;
    Operator[][] lcm = {
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ANDD,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.NOTUSED}, 
      {Operator.ANDD, Operator.ANDD, Operator.ORR, Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ANDD,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.ANDD,Operator.ORR,Operator.ORR,Operator.ORR}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
      {Operator.ANDD, Operator.ANDD, Operator.ANDD, Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD,Operator.ANDD}, 
    };

    boolean[] puv = {true,true,false,false,false,false,false,false,false,false,false,false,false,false,false};
    LaunchInterceptor li = new LaunchInterceptor(points.length, points, params, lcm, puv);
    boolean res = li.decide();
    Assert.assertFalse(res);
  }

}
