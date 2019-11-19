package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int scope) {
        this.name = name;
        this.score = scope;
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().
                sorted().
                flatMap(Stream::ofNullable).
                takeWhile(v -> v.getScore() > bound).
                collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        final int result = Integer.compare(o.score, this.score);
        return result != 0 ? result : this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + ", name='" + name + '\'' + '}';
    }
}
