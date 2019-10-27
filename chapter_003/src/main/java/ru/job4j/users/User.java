package ru.job4j.users;

public class User {
    private String name;
    private String city;
    private Integer id;

    public User(String name, String city, Integer id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }
}
