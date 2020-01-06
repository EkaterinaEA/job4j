package ru.job4j.oop;

public class College {

    public static void main(String[] args) {

        Freshman freshman = new Freshman();

        // down casting:
        Student student = freshman;
        Object object = freshman;
        Object objectFromStudent = student;

        // Приведение типа при создании объекта:
        Object ofreshman = new Freshman();
        Object ostudent = new Student();
        Student studentFromFreshman = new Freshman();

        // up casting:
        Student studentFromObject = (Student) ofreshman;
        Freshman freshmanFromObject = (Freshman) object;
        Freshman freshmanFromStudent = (Freshman) studentFromObject;

    }
}
