package ru.job4j.profession;

public class Engineer extends Profession {
    private String qualification;
    private String condition;
    private String requirements;

    public Engineer() {

    }

    public Engineer(String qualification, String condition, String requirements) {
        this.qualification = qualification;
        this.condition = condition;
        this.requirements = requirements;
    }

    public boolean internship(Student student) {
        return false;
    }

    public String getQualification() {
        return this.qualification;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getRequirements() {
        return this.requirements;
    }
}
