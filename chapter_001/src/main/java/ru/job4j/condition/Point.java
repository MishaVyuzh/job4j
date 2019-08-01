package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);
        result = distance(1, 5, 2, 0);
        System.out.println("result (1, 5) to (2, 0) " + result);
        result = distance(50, 123, 28, 75);
        System.out.println("result (50, 123) to (28, 75) " + result);
        result = distance(0, 0, 0, 0);
        System.out.println("result (0, 0) to (0, 0) " + result);
        result = distance(12, 0, 17, 0);
        System.out.println("result (12, 0) to (17, 0) " + result);

    }
}
