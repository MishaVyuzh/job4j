package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortFourUser() {
        SortUser table = new SortUser();
        List<User> expect = new ArrayList<>();
        expect.add(new User("Mikhail", 23));
        expect.add(new User("Alexei", 34));
        expect.add(new User("Ivan", 10));
        expect.add(new User("Petr", 14));
        table.sort(expect);
        TreeSet<User> result = new TreeSet<>(expect);
        assertThat(result, is(table.sort(expect)));
    }

    @Test
    public void whenSortFourUserByLengthName() {
        SortUser table = new SortUser();
        List<User> expect = new ArrayList<>();
        expect.add(new User("Mikhail", 23));
        expect.add(new User("Alexei", 34));
        expect.add(new User("Ann", 10));
        expect.add(new User("Petr", 14));
        List<User> result = table.sortNameLength(expect);
        assertThat(result.get(0).getName(), is("Ann"));
    }

    @Test
    public void whenSortSixUserByNameAndAge() {
        SortUser table = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Ann", 10));
        users.add(new User("Mikhail", 23));
        users.add(new User("Alexei", 34));
        users.add(new User("Ann", 50));
        users.add(new User("Petr", 34));
        users.add(new User("Petr", 10));
        int expect = users.get(4).getAge();
        List<User> result = table.sortByAllFields(users);
        assertThat(result.get(5).getAge(), is(expect));
    }
}
