package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ru.job4j.io.PrintFiles.filterByExt;

public class SearchWithFileVisitor {

    public static List<String> search(Path root, String ext) throws IOException {
        Files.walkFileTree(root, new PrintFiles());
        return filterByExt(ext);
    }
}
