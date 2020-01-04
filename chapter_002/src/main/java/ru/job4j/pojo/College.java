package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setEntryDate(new Date());
        student.setGroup(505);
        System.out.println("Student info. \nFull name: " + student.getFullName() +
                "\nEntry date: " + student.getEntryDate() + "\nGroup: " + student.getGroup());
    }

}
