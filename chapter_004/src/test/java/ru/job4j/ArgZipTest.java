package ru.job4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.ArgZip;
import lombok.extern.slf4j.Slf4j;
import ru.job4j.io.Zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.*;
import static ru.job4j.io.Search.*;

@Slf4j
public class ArgZipTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void checkZip() throws IOException {
        File fileZip = folder.newFile("archive.zip");
        ArgZip packer = new ArgZip("-d", "C:\\projects\\job4j\\data", "-e", "*.log", "-o",
                fileZip.getAbsolutePath());
        packer.init();
        Zip zip = new Zip();
        File path = new File(packer.directory);
        List<File> files = searchAll(path.toPath());
        List<File> searchWithoutList = getListWithoutListException(files, packer.exceptions);
        zip.packFiles(searchWithoutList, new File(packer.output));
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
        assertTrue(fileNames.containsAll(List.of("C:\\projects\\job4j\\data\\application.properties",
                "C:\\projects\\job4j\\data\\unavailable.csv", "C:\\projects\\job4j\\data\\directory\\document.txt")));
    }

}
