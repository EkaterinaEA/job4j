package ru.job4j.pojo;

import java.util.Date;

public class Student {

    private String fullName;
    private int group;
    private Date entryDate;

    public Student() {
    }

    public Student(String fullName, int group, Date entryDate) {
        this.fullName = fullName;
        this.group = group;
        this.entryDate = entryDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

}
