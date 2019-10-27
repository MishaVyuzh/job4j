package ru.job4j.users;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenIsListUsersThenConvertIsToMap() {
        UserConvert user = new UserConvert();
        HashMap<Integer, User> result;
        HashMap<Integer, User> exist = new HashMap<>();
        result = user.process(List.of(
                new User("Alex", "Boston", 1),
                new User("Mikhail", "Moscow", 2),
                new User("Anastasia", "Sevastopol", 3)));
        exist.put(1, new User("Alex", "Boston", 1));
        exist.put(2, new User("Mikhail", "Moscow", 2));
        exist.put(3, new User("Anastasia", "Sevastopol", 3));
        boolean fact = false;
        boolean expect = true;
        if (result.containsKey(1) && result.containsKey(2) && result.containsKey(3)) {
            fact = true;
        }
        assertThat(fact, is(expect));
    }
}
