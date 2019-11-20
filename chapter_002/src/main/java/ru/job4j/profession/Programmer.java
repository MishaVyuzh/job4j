package ru.job4j.profession;

public class Programmer extends Engineer {
    private String position;
    private String[] language;
    private String[] tools;

    public boolean fixBugs(Bug bug) {
        return false;
    }

    public String getPosition() {
        return this.position;
    }

    public String[] getLanguage() {
        return this.language;
    }

    public String[] getTools() {
        return this.tools;
    }
}
