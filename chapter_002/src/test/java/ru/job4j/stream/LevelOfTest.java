package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static ru.job4j.stream.LevelOf.levelOf;

class LevelOfTest {

    @Test
    void levelOfTest() {
        Student ko = new Student(100, "Ko");
        List<Student> students = Stream.of(
                new Student(45, "Ivanov"),
                new Student(55, "Petrov"),
                null,
                new Student(90, "Nikolaev"),
                new Student(75, "Orlova"),
                new Student(30, "Titova"),
                ko
        ).collect(Collectors.toList());

        List<Student> list = levelOf(students, 90);
        System.out.println(list.get(0));

        assertEquals(list, List.of(ko));
    }
}