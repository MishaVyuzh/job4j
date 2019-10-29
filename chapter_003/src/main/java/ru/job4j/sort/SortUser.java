package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort (List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength (List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields (List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int result = o1.getName().compareTo(o2.getName());
                return result == 0 ? o1.getAge().compareTo(o2.getAge()) : result;
            }
        });
        return users;
    }
}
