package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static ru.job4j.io.PrintFiles.filterByExt;

public class SearchWithFileVisitor {

    public static List<String> search(Path root, Predicate<String> predict) throws IOException {
        Files.walkFileTree(root, new PrintFiles());
        return filterByExt(predict);
    }
}
