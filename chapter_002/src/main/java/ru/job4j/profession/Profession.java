package ru.job4j.profession;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int age;

    public Profession() {

    }

    public Profession(String name, String surname, String education, int age) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEducation() {
        return this.education;
    }

    public int getAge() {
        return this.age;
    }
}
