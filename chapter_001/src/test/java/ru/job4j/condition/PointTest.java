package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void distanceEqualTwo() {
        Point start = new Point(0, 0);
        Point finish = new Point(2, 0);
        double result = start.distance(finish);
        start.info();
        finish.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(2D));
    }
    @Test
    public void distanceEqualFive() {
        Point start = new Point(1, 5);
        Point finish = new Point(2, 0);
        int result = (int) start.distance(finish);
        assertThat(result, is(5));
    }
    @Test
    public void distanceEqualFiftyThree() {
        Point start = new Point(50, 123);
        Point finish = new Point(28, 75);
        int result = (int) start.distance(finish);
        assertThat(result, is(52));
    }
    @Test
    public void whenCheckItself() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }
    @Test
    public void whenTwelveAndSeventeenThenFive() {
        Point start = new Point(12, 0);
        Point finish = new Point(17, 0);
        double result = start.distance(finish);
        assertThat(result, is(5D));
    }
    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
    }
}
