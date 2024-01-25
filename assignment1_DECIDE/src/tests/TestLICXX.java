package src.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.LaunchInterceptor;

public class TestLICXX {
    @Test
    public void testLICxx() {
        LaunchInterceptor li = new LaunchInterceptor(0, null, null, null, null);
        Assert.assertTrue(1==1);
    }
}
