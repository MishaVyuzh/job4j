package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point finish) {
        return Math.sqrt(Math.pow((this.x - finish.x), 2) + Math.pow((this.y - finish.y), 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}
