package edu.javaAlishev.junit.less.one;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Vector2DTest2 {
    private final double EPS = 1e-9;
    private static Vector2D v1;

    @Before
    public void createNewVector2D() {
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength() {

        // assertion
        // 1e-9 = 0,000...0001
        Assert.assertEquals(0, v1.length(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroX() {

        Assert.assertEquals(0, v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {

        Assert.assertEquals(0, v1.getY(), EPS);
    }

}
