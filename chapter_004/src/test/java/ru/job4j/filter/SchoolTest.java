package ru.job4j.filter;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class SchoolTest {
    private School school = new School();
    private List<Student> allStudents = List.of(
            new Student(5),
            new Student(99),
            new Student(10),
            new Student(53),
            new Student(88),
            new Student(76),
            new Student(25),
            new Student(60)
    );

    @Test
    public void studentSelectionClassAFrom70To100() {
        List<Student> expected = List.of(
                new Student(99),
                new Student(88),
                new Student(76)
        );
        List<Student> result = school.collect(allStudents,
                student -> student.getScore() > 69 && student.getScore() < 101);
        assertThat(result, is(expected));
    }

    @Test
    public void studentSelectionClassBFrom50To70() {
        List<Student> expected = List.of(
                new Student(53),
                new Student(60)
        );
        List<Student> result = school.collect(allStudents,
                student -> student.getScore() > 49 && student.getScore() < 70);
        assertThat(result, is(expected));
    }

    @Test
    public void studentSelectionClassCLess50() {
        List<Student> expected = List.of(
                new Student(5),
                new Student(10),
                new Student(25)
        );
        List<Student> result = school.collect(allStudents,
                student -> student.getScore() >= 0 && student.getScore() < 50);
        assertThat(result, is(expected));
    }
}
