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

    public static List<File> search(Path root, String ext) {
        List<File> files = searchAll(root);
        List<File> result = new ArrayList<>();
        files.stream().forEach(file -> {
            if (checkExtension(file, ext)) {
                result.add(file);
            }
        });
        return result;
    }

    public static List<File> searchAll(Path root) {
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
                result.add(file);
            }
        }
        return result;
    }

    private static boolean checkExtension(File file, String ext) {
        return getExtension(file).equals(ext);
    }

    private static String getExtension(File file) {
        String fileName = file.getName();
        String[] arr = fileName.split("\\.");
        return arr[arr.length - 1];
    }

    public static List<File> searchWithoutList(Path rootPath, List<String> exclude) {
        List<File> excludeFiles = new ArrayList<>();
        System.out.println("exclude: " + exclude.toString());
        System.out.println("Just search: " + search(rootPath, exclude.get(0)));
        exclude.stream().forEach(u -> excludeFiles.addAll(search(rootPath, u)));
        System.out.println("excludeFiles: \n" + excludeFiles.toString());
        List<File> allFiles = searchAll(rootPath);
        allFiles.removeAll(excludeFiles);
        return allFiles;
    }

    public static List<File> getListWithoutListException(List<File> source, List<String> exts) {
        List<File> withoutList = new ArrayList<>();
        source.forEach(file -> {
            String name = file.getName();
            for (String suffix : exts) {
                if (name.endsWith(suffix)) {
                    withoutList.add(file);
                }
            }
        });
        source.removeAll(withoutList);
        return source;
    }

}

