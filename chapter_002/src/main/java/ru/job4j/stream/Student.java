package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.job4j.stream.Student.ConvertCollections.convertListToMap;
import static ru.job4j.stream.test.SchoolTest.*;

public class Student {

    private final int score;
    private final String lastName;

    public Student(int score, String lastName) {
        this.score = score;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getScore() {
        return score;
    }

    public static class ConvertCollections {

        public static Map<String, Student> convertListToMap(List<Student> students) {
            return students.stream().distinct().collect(
                    Collectors.toMap(
                            e -> e.lastName,
                            e -> e
                    ));
        }
    }

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student(45, "Ivanov"),
                new Student(55, "Petrov"),
                new Student(90, "Nikolaev"),
                new Student(75, "Orlova"),
                new Student(30, "Titova"),
                new Student(100, "Ko")
        );

        List<Student> classA = sortClass(students, p -> p.getScore() > 70);
        List<Student> classB = sortClass(students, p -> p.getScore() > 50 && p.getScore() < 70);
        List<Student> classC = sortClass(students, p -> p.getScore() > 0 && p.getScore() < 50);

        classA.stream().forEach(System.out::println);
        classB.stream().forEach(System.out::println);
        classC.stream().forEach(System.out::println);

        Map<String, Student> studentsMap = convertListToMap(students);

    }
}
