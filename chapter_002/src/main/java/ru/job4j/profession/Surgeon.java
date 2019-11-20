package ru.job4j.profession;

public class Surgeon extends Doctor {
    private String specialization;
    private int operation;
    private int accident;

    public boolean hadSurgery(Patient patient) {
        return false;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public int getOperation() {
        return this.operation;
    }

    public int getAccident() {
        return this.accident;
    }
}
