package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Objects;

public class Search {

    public List<File> search(Path root, String ext) {
        Queue<File> files;
        List<File> result = new ArrayList<>();
        files = new LinkedList<>();
        File file = root.toFile();
        files.offer(file);
        while (files.size() > 0) {
            file = files.poll();
            if (file == null) {
                continue;
            }
            if (file.isDirectory()) {
                Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(files::offer);
            } else {
                if (checkExtension(file, ext)) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    private boolean checkExtension(File file, String ext) {
        return getExtension(file).equals(ext);
    }

    private String getExtension(File file) {
        String fileName = file.getName();
        String[] arr = fileName.split("\\.");
        return arr[arr.length - 1];
    }

}

