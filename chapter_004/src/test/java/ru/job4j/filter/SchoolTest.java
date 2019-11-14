package ru.job4j.filter;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

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

    @Test
    public void changeListStudentToMapWithKeySurname() {
        List<Student> students = List.of(
                new Student(50, "Sidorov"),
                new Student(30, "Ivanov"),
                new Student(40, "Petrov")
        );
        Map<String, Student> expected = Map.of(
                "Ivanov30", new Student(30, "Ivanov"),
                "Petrov40", new Student(40, "Petrov"),
                "Sidorov50", new Student(50, "Sidorov")
        );
        Map<String, Student> result = school.change(students);
        assertThat(result, is(expected));
    }

    @Test
    public void whenHasDoubleIvanovSameScoreChangeListStudentToMapWithKeySurname() {
        List<Student> students = List.of(
                new Student(50, "Sidorov"),
                new Student(30, "Ivanov"),
                new Student(30, "Ivanov"),
                new Student(40, "Petrov")
        );
        Map<String, Student> expected = Map.of(
                "Ivanov30", new Student(30, "Ivanov"),
                "Petrov40", new Student(40, "Petrov"),
                "Sidorov50", new Student(50, "Sidorov")
        );
        Map<String, Student> result = school.change(students);
        assertThat(result, is(expected));
    }

    @Test
    public void whenHasIvanovScore30AndIvanovScore75ChangeListStudentToMapWithKeySurname() {
        List<Student> students = List.of(
                new Student(50, "Sidorov"),
                new Student(75, "Ivanov"),
                new Student(30, "Ivanov"),
                new Student(40, "Petrov")
        );
        Map<String, Student> expected = Map.of(
                "Ivanov30", new Student(30, "Ivanov"),
                "Ivanov75", new Student(75, "Ivanov"),
                "Petrov40", new Student(40, "Petrov"),
                "Sidorov50", new Student(50, "Sidorov")
        );
        Map<String, Student> result = school.change(students);
        assertThat(result, is(expected));
    }
}
