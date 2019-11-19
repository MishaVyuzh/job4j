package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void whenAddFiveStudentsThenResultFirstElementScore100() {
        Student student = new Student();
        int bound = 30;
        List<Student> students = List.of(
                new Student("Ivanov Ivan Ivanovich", 10),
                new Student("Square Kubik Rubik", 100),
                new Student("Forest Oak", 25),
                new Student(null, 0),
                new Student("Alekseev Maksim Petrovich", 33)
        );
        String expected = "Student{score=100, name='Square Kubik Rubik'}";
        List<Student> result = student.levelOf(students, bound);
        Assert.assertEquals(result.get(0).toString(), expected);
    }
}
