package ru.job4j.stream.test;

import ru.job4j.stream.Student;

import java.util.List;
import java.util.stream.Collectors;


public class SchoolTest {

    public static List<Student> getClass10A(List<Student> students) {
        return students.stream().filter(p -> p.getScore() > 70).collect(Collectors.toList());
    }

    public static List<Student> getClass10B(List<Student> students) {
        return students.stream().filter(p -> p.getScore() > 50 && p.getScore() < 70).collect(Collectors.toList());
    }

    public static List<Student> getClass10C(List<Student> students) {
        return students.stream().filter(p -> p.getScore() > 0 && p.getScore() < 50).collect(Collectors.toList());
    }

}