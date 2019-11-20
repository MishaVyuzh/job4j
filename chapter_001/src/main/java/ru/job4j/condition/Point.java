package ru.job4j.condition;

public class Point {
    private int x;
    private int y;
    private int z;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point finish) {
        return Math.sqrt(Math.pow((this.x - finish.x), 2) + Math.pow((this.y - finish.y), 2));
    }

    public double distance3d(Point finish) {
        return Math.sqrt(Math.pow((this.x - finish.x), 2) + Math.pow((this.y - finish.y), 2) + Math.pow((this.z - finish.z), 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
    public void info3() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }
}
