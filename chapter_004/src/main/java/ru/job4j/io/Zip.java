package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private String root;

    public void pack(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                String name = file.getPath();
                name = name.replace(root + "\\", "");
                zip.putNextEntry(new ZipEntry(name));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<File> seekBy(String root, List<String> ext) {
        this.root = root;
        Search search = new Search();
        return search.search(root, search.getPredicateWithoutList(ext));
    }
}
