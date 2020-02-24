package ru.job4j.stream.test;

import ru.job4j.stream.Student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class SchoolTest {

    public static List<Student> sortClass(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

}