package ru.job4j;

import org.junit.Test;
import ru.job4j.io.ArgZip;
import lombok.extern.slf4j.Slf4j;
import ru.job4j.io.Search;
import ru.job4j.io.Zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.*;

@Slf4j
public class ArgZipTest {

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = System.getProperty("file.separator");

    private static final String filePath = MAIN_DIR + SEPARATOR + "data";

    @Test
    public void checkZip() throws IOException {
        File fileZip = File.createTempFile("archive", ".zip", new File(filePath));
        ArgZip packer = new ArgZip("-d", filePath, "-e", "*.log", "-o",
                fileZip.getAbsolutePath());
        packer.init();
        Zip zip = new Zip();
        Search search = new Search();
        List<File> searchWithoutList = search.search(packer.directory, search.getPredicateWithoutList(packer.exceptions));
        zip.pack(searchWithoutList, new File(packer.output));
        List<String> fileNames = new ArrayList<>();
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(fileZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                fileNames.add(name);
                zin.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(fileNames.containsAll(List.of(filePath + SEPARATOR + "application.properties",
                filePath + SEPARATOR + "unavailable.csv", filePath + SEPARATOR + "directory" + SEPARATOR + "document.txt")));
    }

}
