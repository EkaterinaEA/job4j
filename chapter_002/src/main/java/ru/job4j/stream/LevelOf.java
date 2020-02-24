package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelOf {

    static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted(new StudentDescByScore())
                .takeWhile(v -> v.getScore() > bound).collect(Collectors.toList());
    }
}
