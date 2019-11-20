package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person rs : persons) {
            if (rs.getName().contains(key) || rs.getSurname().contains(key)
                                            || rs.getPhone().contains(key)
                                            || rs.getAddress().contains(key)) {
                result.add(rs);
            }
        }
        return result;
    }
}
