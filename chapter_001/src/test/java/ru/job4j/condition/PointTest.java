package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance0() {
        int inx1 = 0;
        int iny1 = 0;
        int inx2 = 2;
        int iny2 = 0;
        int expected = 2;
        int out = (int)Math.round(Point.distance(inx1, iny1, inx2, iny2));
        Assert.assertEquals(expected, out);
    }
    @Test
    public void distance1() {
        int inx1 = 1;
        int iny1 = 5;
        int inx2 = 2;
        int iny2 = 0;
        int expected = 5;
        int out = (int)Math.round(Point.distance(inx1, iny1, inx2, iny2));
        Assert.assertEquals(expected, out);
    }
    @Test
    public void distance3() {
        int inx1 = 50;
        int iny1 = 123;
        int inx2 = 28;
        int iny2 = 75;
        int expected = 53;
        int out = (int)Math.round(Point.distance(inx1, iny1, inx2, iny2));
        Assert.assertEquals(expected, out);
    }
    @Test
    public void distance4() {
        int inx1 = 0;
        int iny1 = 0;
        int inx2 = 0;
        int iny2 = 0;
        int expected = 0;
        int out = (int)Math.round(Point.distance(inx1, iny1, inx2, iny2));
        Assert.assertEquals(expected, out);
    }
    @Test
    public void distance5() {
        int inx1 = 12;
        int iny1 = 0;
        int inx2 = 17;
        int iny2 = 0;
        int expected = 5;
        int out = (int)Math.round(Point.distance(inx1, iny1, inx2, iny2));
        Assert.assertEquals(expected, out);
    }
}
