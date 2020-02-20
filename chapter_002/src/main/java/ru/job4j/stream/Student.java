package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.job4j.stream.Student.School.*;
import static ru.job4j.stream.Student.SchoolTest.*;

public class Student {

    private final int score;

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }

    public static class School {

        public static Predicate<Student> is10A() {
            return p -> p.score > 70;
        }

        public static Predicate<Student> is10B() {
            return p -> p.score > 50 && p.score < 70;
        }

        public static Predicate<Student> is10C() {
            return p -> p.score > 0 && p.score < 50;
        }

        public static List<Student> collect(List<Student> students,
                                                      Predicate<Student> predicate)
        {
            return students.stream()
                    .filter(predicate)
                    .collect(Collectors.<Student>toList());
        }
    }

    public static class SchoolTest {

        public static List<Student> getClass10A(List<Student> students) {
            return collect(students, is10A());
        }

        public static List<Student> getClass10B(List<Student> students) {
            return collect(students, is10B());
        }

        public static List<Student> getClass10C(List<Student> students) {
            return collect(students, is10C());
        }

    }

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student(45),
                new Student(55),
                new Student(90),
                new Student(75),
                new Student(30),
                new Student(100)
        );

        List<Student> classA = getClass10A(students);
        List<Student> classB = getClass10B(students);
        List<Student> classC = getClass10C(students);

    }
}
