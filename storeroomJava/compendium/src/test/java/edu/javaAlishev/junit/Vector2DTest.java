package edu.javaAlishev.junit;

import edu.javaAlishev.junit.less.one.Vector2D;
import org.junit.Assert;
import org.junit.Test;


public class Vector2DTest {

    @Test
    public void newVectorShouldHaveZeroLength() {
        Vector2D v1 = new Vector2D();  //action

        // assertion
        // 1e-9 = 0,000...0001
        Assert.assertEquals(0, v1.length(), 1e-9);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Vector2D v1 = new Vector2D();

        Assert.assertEquals(0, v1.getX(), 1e-9);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Vector2D v1 = new Vector2D();

        Assert.assertEquals(0, v1.getY(), 1e-9);
    }
}