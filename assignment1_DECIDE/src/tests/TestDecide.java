package src.tests;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;
import src.LaunchParameters;
import src.Point;

import junit.framework.TestCase;
import src.Operator;

public class TestDecide{


  @Test
  public void testDecideTrue() {
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
}
