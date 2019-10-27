package ru.job4j.users;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapUsers = new HashMap<>();
        for (User user: list) {
            mapUsers.put(user.getId(), user);
        }
        return mapUsers;
    }
}
