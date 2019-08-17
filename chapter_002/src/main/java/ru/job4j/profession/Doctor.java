package ru.job4j.profession;

public class Doctor extends Profession {
    private String department;
    private String category;
    private boolean student;

    public Doctor() {
    }

    public Doctor(String department, String category) {
        this.department = department;
        this.category = category;
    }

    public void checkHealth(Patient patient) {

    }

    public boolean checkStudent(int age) {
        this.student = age < 23;
        return this.student;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getCategory() {
        return this.category;
    }

    public boolean getStudent()  {
        return this.student;
    }
}